package uk.gov.dvla.osg.rpd.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.SelectorLookup;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger();
	private static final int EXPECTED_NO_OF_ARGS = 5;
	private static ArrayList<DocumentProperty> docProps;
	private static Properties applicationProperties;
	private static String inputFilePath, outputFilePath, propsFilePath, parentJobId, runNo;
	private static SelectorLookup selectorLookup;
	private static SessionParameterInterface params;
	private static Sorter sorter;
	
	public static void main(String[] args) {
		validateArgs(args);
		assignArgs(args);
		
		docProps = DocumentProperty.getDocumentPropertiesFromTabDelimittedFile(inputFilePath);
		applicationProperties = getPropertiesFromPropertiesFile(propsFilePath);
		selectorLookup = loadSelectorLookup();
		params = getParameters();
		new CalculateBatchTypes(params).calculateBatchTypes();
		sorter = new Sorter(params);
		
	}
	
	private static void validateArgs(String[] args) {
		if( args.length != EXPECTED_NO_OF_ARGS ){
			LOGGER.fatal("Incorrect number of arguments parsed. Expected {}, recieved {}", EXPECTED_NO_OF_ARGS, args.length);
			System.exit(1);
		}
		if( !(fileExists(inputFilePath)) ){
			LOGGER.fatal("File '{}' doesn't exist",inputFilePath);
			System.exit(1);
		}
		if( !(fileExists(propsFilePath)) ){
			LOGGER.fatal("File '{}' doesn't exist",propsFilePath);
			System.exit(1);
		}
	}
	
	private static boolean fileExists(String fileToCheck) {
		boolean result = new File(fileToCheck).exists();
		LOGGER.debug("fileExists returned '{}' for file '{}'", result, fileToCheck);
		return result;
	}
	
	private static void assignArgs(String[] args) {
		inputFilePath = args[0];
		outputFilePath = args[1];
		propsFilePath = args[2];
		parentJobId = args[3];
		runNo = args[4];
	}
	
	private static Properties getPropertiesFromPropertiesFile(String filePath) {
		Properties result = new Properties();
		InputStream  input = null;
		try {
			input = new FileInputStream(filePath);
			result.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static SelectorLookup loadSelectorLookup() {
		SelectorLookup result = new SelectorLookup();
		String selectorLookupFile = applicationProperties.getProperty("lookupFile");
		String ref = docProps.get(0).getDocDVLASelectorName();
		if( fileExists(selectorLookupFile) ){
			HashMap<String, SelectorLookup> selectors = SelectorLookup.load(selectorLookupFile);
			result = selectors.get(ref);
		} else {
			LOGGER.fatal("File '{}' doesn't exist",selectorLookupFile);
			System.exit(1);
		}
		return result;
	}
	
	private static void initParameters() {
		String productionConfigurationPath = getProductionConfigPath(applicationProperties, selectorLookup);
		String postageConfigurationPath = getPostageConfigPath(applicationProperties, selectorLookup);
		String presentationPriorityPath = getPresPriorityConfigPath(applicationProperties, selectorLookup);
		params.setProductionConfigurationPath(productionConfigurationPath);
		params.setPostageConfigurationPath(postageConfigurationPath);
		params.setApplicationConfigurationPath(propsFilePath);
		params.setPresentationPriorityPath(presentationPriorityPath);
		params.setDocumentProperties(docProps);
		params.setProductionConfiguration(getPropertiesFromPropertiesFile(productionConfigurationPath));
		params.setPostageConfiguration(getPropertiesFromPropertiesFile(postageConfigurationPath));
		params.setApplicationConfiguration(getPropertiesFromPropertiesFile(propsFilePath));
		params.setPresentationPriority(getPresentationPriorityMap(presentationPriorityPath));
		params.setJobId(parentJobId);
		params.setRunNo(runNo);
		params.setOutputFilePath(outputFilePath);
	}

	private static String getProductionConfigPath(Properties applicationProperties, SelectorLookup selectorLookup) {
		String result = applicationProperties.getProperty("productionConfigPath") +
				selectorLookup.getProductionConfig() +
				applicationProperties.getProperty("productionFileSuffix");
		LOGGER.debug("getProductionConfigPath returned '{}'",result);
		return result;
	}

	private static String getPostageConfigPath(Properties applicationProperties, SelectorLookup selectorLookup) {
		String result = applicationProperties.getProperty("postageConfigPath") + 
				selectorLookup.getPostageConfig() + 
				applicationProperties.getProperty("postageFileSuffix");
		LOGGER.debug("getPostageConfigPath returned '{}'",result);
		return result;
	}
	
	private static String getPresPriorityConfigPath(Properties applicationProperties, SelectorLookup selectorLookup) {
		String result = applicationProperties.getProperty("presentationPriorityConfigPath") +
				selectorLookup.getPresentationConfig() +
				applicationProperties.getProperty("presentationPriorityFileSuffix");
		LOGGER.debug("getPresPriorityConfigPath returned '{}'",result);
		return result;
	}

	private static Map<String,Integer> getPresentationPriorityMap(String filePath){
		Map<String, Integer> results = new HashMap<String, Integer>();
		BufferedReader reader = setupReader(filePath);
		String readLine ="";
		int i = 0;
		try{
			while( (readLine = reader.readLine() ) != null ) {
				results.put(readLine, i);
			}
		} catch (NullPointerException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeReader(reader);
		}
		return results;
	}
	
	private static BufferedReader setupReader(String input) {
        try {
        	File inputFile = new File(input);
			BufferedReader b = new BufferedReader(new FileReader(inputFile));
			return b;
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		return null;
	}
	
	private static void closeReader(BufferedReader reader){
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static SessionParameterInterface getParameters(){
		Injector injector = Guice.createInjector(new ApplicationInjector());
		params = injector.getInstance(SessionParameterInterface.class);
		initParameters();
		return params;
	}
}