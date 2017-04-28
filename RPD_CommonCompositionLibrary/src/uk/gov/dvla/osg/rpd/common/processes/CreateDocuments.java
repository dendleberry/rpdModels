package uk.gov.dvla.osg.rpd.common.processes;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class CreateDocuments {
	private static final Logger LOGGER = LogManager.getLogger();
	private static SessionParameterInterface params;
	private static ArrayList<DocumentProperty> docProps;
	
	public CreateDocuments(ArrayList<DocumentProperty> docProps, SessionParameterInterface params){
		this.params=params;
		this.docProps=docProps;
	}
	
	public ArrayList<Document> createDocs() {
		ArrayList<Document> result = new ArrayList<Document>();
		for( DocumentProperty dp : docProps ){
			Document doc = getDocument(dp);
			result.add(doc);
		}
		LOGGER.debug("createDocs() returned '{}' objects", result.size());
		return result;
	}
	
	private static Document getDocument(DocumentProperty dp){
		Document result = new Document();
		result.setDocProp(dp);
		result.setPresentationOrder(getPresentationOrder(dp));
		LOGGER.trace("getDocument({}) returned '{}' ",dp , result);
		return result;
	}
	
	private static int getPresentationOrder(DocumentProperty dp){
		int result = params.getPresentationPriority().get(dp.getDocDVLABatchType());
		LOGGER.trace("getPresentationOrder({}) returned '{}' ",dp , result);
		return result;
		
	}
}
