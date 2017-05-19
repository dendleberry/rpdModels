package uk.gov.dvla.osg.rpd.common.processes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class CalculateBatchTypes {
	private static final Logger LOGGER = LogManager.getLogger();
	private SessionParameterInterface params;
	private Set<Document> uniqueNonFleetCustomers, uniqueFleetCustomers, multiCustomers, clericalCustomers;
	private Map<Document,Integer> multiMap, fleetMap;
	private static ArrayList<Document> docs;
	private int groupCounter;
	
	
	public CalculateBatchTypes(ArrayList<Document> docs, SessionParameterInterface params){
		this.docs=docs;
		this.params=params;
		groupCounter = 1;
	}
	
	public void calculateBatchTypes(){
		LOGGER.debug("calculateBatchTypes() running..");
		initSets();
		initMaps();
		findUniqueCustomers();
		createMapOfFleetCustomers();
		createMapOfMultiCustomers();
		calculateClericalCustomers();
		assignBatchTypes();
		assignGroupIds();
	}

	private void initSets() {
		LOGGER.debug("initSets() running..");
		uniqueNonFleetCustomers = new HashSet<Document>();
		uniqueFleetCustomers = new HashSet<Document>();
		multiCustomers = new HashSet<Document>();
		clericalCustomers = new HashSet<Document>();
	}
	private void initMaps() {
		LOGGER.debug("initMaps() running..");
		multiMap = new HashMap<Document,Integer>();
		fleetMap = new HashMap<Document,Integer>();
	}
	private void findUniqueCustomers() {
		LOGGER.debug("findUniqueCustomers() running..");
		for( Document doc : docs ){
			if( doc.isFleet() ){
				uniqueFleetCustomers.add(doc);
			}else{
				if( !(uniqueNonFleetCustomers.add(doc)) ){
					multiCustomers.add(doc);
				}
			}
		}
	}
	
	private void createMapOfFleetCustomers() {
		LOGGER.debug("createMapOfFleetCustomers() running..");
		for(Document fleet : uniqueFleetCustomers){
			fleetMap.put(fleet, groupCounter);
			groupCounter ++;
		}
	}
	
	private void createMapOfMultiCustomers() {
		LOGGER.debug("createMapOfMultiCustomers() running..");
		for(Document multi : multiCustomers){
			multiMap.put(multi, groupCounter);
			groupCounter ++;
		}
	}
	
	private void calculateClericalCustomers() {
		LOGGER.debug("calculateClericalCustomers() running..");
		int occurrences = 0;
		for(Document prop : multiCustomers){
			if( isClericalBatchRequired(prop) ){
				occurrences = Collections.frequency(docs, prop);
				if(occurrences > getMultiMax() ){
					clericalCustomers.add(prop);
				}
			}
		}
	}
	
	private int getMultiMax() {
		int result = 0;
		try{
			Integer.parseInt((String) params.getProperties().get("maxMulti"));
		}catch ( NumberFormatException  e){
			LOGGER.fatal("getMultiMax() failed with NumberFormatException '{}'", e.getMessage());
			System.exit(1);
		}catch ( NullPointerException e){
			LOGGER.fatal("getMultiMax() failed with NullPointerException '{}'", e.getMessage());
			System.exit(1);
		}
		LOGGER.trace("getMultiMax() returned '{}'", result);
		return result;
	}

	private void assignBatchTypes() {
		LOGGER.debug("assignBatchTypes() running..");
		for( Document doc : docs ){
			if( doc.getOriginalBatchType() == null ){
				doc.setBatchType(calculateBatchType(doc));
			}else{
				if( contains(doc.getOriginalBatchType()) ){
					doc.setBatchType(doc.getOriginalBatchType());
				}else{
					LOGGER.fatal("Unknown batch type ({}) set for customer with doc ref '{}'", doc.getOriginalBatchType(), doc.getDocID());
					System.exit(1);
				}
			}
		}
	}

	private BatchTypes calculateBatchType(Document doc) {
		BatchTypes result = BatchTypes.REJECT;
		if( isFleetBatchRequired(doc) && doc.isFleet() ){
			result = BatchTypes.FLEET;
		} else if ( isUnsortedBatchRequired(doc) && doc.isUnsorted() ){
			result = BatchTypes.UNSORTED;
		} else if ( isClericalBatchRequired(doc) && isClerical(doc) ){
			result = BatchTypes.CLERICAL;
		} else if ( isMultiBatchRequired(doc) && isMulti(doc) ){
			result = BatchTypes.MULTI;
		} else if ( isSortedBatchRequired(doc) ){
			result = BatchTypes.SORTED;
		} else {
			result = BatchTypes.UNSORTED;
		}
		LOGGER.trace("calculateBatchType({}) returned '{}'", doc, result);
		return result;
	}
	


	private boolean contains(BatchTypes test) {
		boolean result = false;
	    for (BatchTypes type : BatchTypes.values()) {
	        if (type.name().equals(test)) {
	        	result = true;
	        }
	    }
	    LOGGER.debug("contains({}) returned '{}'", test, result);
	    return result;
	}
	
	private boolean isClericalBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.clerical") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.clerical") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isClericalBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isClerical(Document doc){
		boolean result = clericalCustomers.contains(doc);
		LOGGER.trace("isClerical({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isFleetBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.fleet") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.fleet") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isFleetBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	
	private boolean isUnsortedBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.unsorted") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.unsorted") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isUnsortedBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	
	private boolean isSortedBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.sorted") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.sorted") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isSortedBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isMultiBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if(  !((String) params.getProperties().get("site.english.multi")).contains("X") && 
					!((String) params.getProperties().get("site.english.multi")).contains("x")){
				result = true;
			}
		}else{
			if( !((String) params.getProperties().get("site.welsh.multi")).contains("X") && 
					!((String) params.getProperties().get("site.welsh.multi")).contains("x")){
				result = true;
			}
		}
		LOGGER.trace("isMultiBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isMulti(Document doc){
		boolean result = multiCustomers.contains(doc);
		LOGGER.trace("isMulti({}) returned '{}'", doc, result);
		return result;
	}
	
	
	private boolean isSortingBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.sorting") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.sorting") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isSortingBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isRejectBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.reject") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.reject") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isRejectBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private boolean isReprintBatchRequired(Document doc){
		boolean result = false;
		if( doc.isEnglish() ){
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.english.reprint") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProperties().get("site.welsh.reprint") ) ) ){
				result = true;
			}
		}
		LOGGER.trace("isReprintBatchRequired({}) returned '{}'", doc, result);
		return result;
	}
	
	private void assignGroupIds() {
		LOGGER.debug("assignGroupIds() running..");
		for( Document doc : docs ){
			if( doc.getBatchType().equals(BatchTypes.FLEET) ){
				doc.setGroupId("" + fleetMap.get(doc));
			}else if( doc.getBatchType().equals(BatchTypes.CLERICAL) ){
				doc.setGroupId("" + multiMap.get(doc));
			}else if( doc.getBatchType().equals(BatchTypes.MULTI) ){
				doc.setGroupId("" + multiMap.get(doc));
			}else if( doc.isEnglish() && "X".equalsIgnoreCase((String) params.getProperties().get("site.english.multi")) ){
				doc.setGroupId("" + multiMap.get(doc));
			}else if( doc.isWelsh() && "X".equalsIgnoreCase((String) params.getProperties().get("site.welsh.multi")) ){
				doc.setGroupId("" + multiMap.get(doc));
			}
		}
	}
	
}

