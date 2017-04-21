package uk.gov.dvla.osg.rpd.common.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SelectorLookup {
	private String ref, productionConfig, postageConfig, presentationConfig;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getProductionConfig() {
		return productionConfig;
	}

	public void setProductionConfig(String productionConfig) {
		this.productionConfig = productionConfig;
	}

	public String getPostageConfig() {
		return postageConfig;
	}

	public void setPostageConfig(String postageConfig) {
		this.postageConfig = postageConfig;
	}

	public String getPresentationConfig() {
		return presentationConfig;
	}

	public void setPresentationConfig(String presentationConfig) {
		this.presentationConfig = presentationConfig;
	}

	public static HashMap<String, SelectorLookup> load(String selectorLookupFile) {
		BufferedReader reader = setupReader(selectorLookupFile);
		HashMap<String, SelectorLookup> results = new HashMap<String, SelectorLookup>();
		String readLine;
		String delim ="\\|";
		boolean firstLine = true;
		try {
			while( (readLine = reader.readLine() ) != null ) {
				String[] split = readLine.split(delim);
				if( firstLine ){
					firstLine=false;
				} else { 
					SelectorLookup sl = new SelectorLookup();
					sl.setRef(split[0]);
					sl.setProductionConfig(split[1]);
					sl.setPostageConfig(split[2]);
					sl.setPresentationConfig(split[3]);
					results.put(split[0], sl);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
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
	
}
