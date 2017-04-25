package uk.gov.dvla.osg.rpd.main;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.abstractions.SessionParameterInterface;
import uk.gov.dvla.osg.rpd.common.models.BatchTypes;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class CalculateBatchTypes {
	private static final Logger LOGGER = LogManager.getLogger();
	private SessionParameterInterface params;
	private Set<DocumentProperty> uniqueNonFleetCustomers, uniqueFleetCustomers, multiCustomers, clericalCustomers;
	private Map<DocumentProperty,Integer> multiMap, fleetMap;
	private int groupCounter;
	
	
	public CalculateBatchTypes(SessionParameterInterface params){
		LOGGER.debug("CalculateBatchTypes constructed with {}", params);
		this.params=params;
		groupCounter = 1;
	}
	
	public void calculateBatchTypes(){
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
		uniqueNonFleetCustomers = new HashSet<DocumentProperty>();
		uniqueFleetCustomers = new HashSet<DocumentProperty>();
		multiCustomers = new HashSet<DocumentProperty>();
		clericalCustomers = new HashSet<DocumentProperty>();
	}
	private void initMaps() {
		LOGGER.debug("initMaps() running..");
		multiMap = new HashMap<DocumentProperty,Integer>();
		fleetMap = new HashMap<DocumentProperty,Integer>();
	}
	private void findUniqueCustomers() {
		LOGGER.debug("findUniqueCustomers() running..");
		for( DocumentProperty prop : params.getDocumentProperties() ){
			if( isFleet(prop) ){
				uniqueFleetCustomers.add(prop);
			}else{
				if( !(uniqueNonFleetCustomers.add(prop)) ){
					multiCustomers.add(prop);
				}
			}
		}
	}
	
	private void createMapOfFleetCustomers() {
		LOGGER.debug("createMapOfFleetCustomers() running..");
		for(DocumentProperty fleet : uniqueFleetCustomers){
			fleetMap.put(fleet, groupCounter);
			groupCounter ++;
		}
	}
	
	private void createMapOfMultiCustomers() {
		LOGGER.debug("createMapOfMultiCustomers() running..");
		for(DocumentProperty prop : multiCustomers){
			multiMap.put(prop, groupCounter);
			groupCounter ++;
		}
	}
	
	private void calculateClericalCustomers() {
		LOGGER.debug("calculateClericalCustomers() running..");
		int occurrences = 0;
		for(DocumentProperty prop : multiCustomers){
			if( isClericalBatchRequired(prop) ){
				occurrences = Collections.frequency(params.getDocumentProperties(), prop);
				if(occurrences > getMultiMax() ){
					clericalCustomers.add(prop);
				}
			}
		}
	}
	
	private int getMultiMax() {
		int result = 0;
		try{
			Integer.parseInt((String) params.getApplicationConfiguration().get("maxMulti"));
		}catch ( NumberFormatException  e){
			LOGGER.fatal("getMultiMax() failed with NumberFormatException '{}'", e.getMessage());
			System.exit(1);
		}catch ( NullPointerException e){
			LOGGER.fatal("getMultiMax() failed with NullPointerException '{}'", e.getMessage());
			System.exit(1);
		}
		LOGGER.debug("getMultiMax() returned '{}'", result);
		return result;
	}

	private void assignBatchTypes() {
		LOGGER.debug("assignBatchTypes() running..");
		for( DocumentProperty prop : params.getDocumentProperties() ){
			if( prop.getDocDVLAOriginalBatchType() == null || prop.getDocDVLAOriginalBatchType().isEmpty() ){
				prop.setDocDVLABatchType(calculateBatchType(prop).toString());
			}else{
				if( contains(prop.getDocDVLAOriginalBatchType()) ){
					prop.setDocDVLABatchType(prop.getDocDVLAOriginalBatchType());
				}else{
					LOGGER.fatal("Unknown batch type ({}) set for customer with doc ref '{}'", prop.getDocDVLAOriginalBatchType(), prop.getDocID());
					System.exit(1);
				}
			}
		}
	}

	private BatchTypes calculateBatchType(DocumentProperty prop) {
		BatchTypes result = BatchTypes.REJECT;
		if( isFleetBatchRequired(prop) && isFleet(prop) ){
			result = BatchTypes.FLEET;
		} else if ( isUnsortedBatchRequired(prop) && isUnsorted(prop) ){
			result = BatchTypes.UNSORTED;
		} else if ( isClericalBatchRequired(prop) && isClerical(prop) ){
			result = BatchTypes.CLERICAL;
		} else if ( isMultiBatchRequired(prop) && isMulti(prop) ){
			result = BatchTypes.MULTI;
		} else if ( isSortedBatchRequired(prop) ){
			result = BatchTypes.SORTED;
		} else {
			result = BatchTypes.UNSORTED;
		}
		LOGGER.debug("calculateBatchType({}) returned '{}'", prop, result);
		return result;
	}
	


	private boolean contains(String test) {
		boolean result = false;
	    for (BatchTypes type : BatchTypes.values()) {
	        if (type.name().equals(test)) {
	        	result = true;
	        }
	    }
	    LOGGER.debug("contains({}) returned '{}'", test, result);
	    return result;
	}

	private boolean isEnglish(DocumentProperty prop){
		boolean result = false;
		if("E".equalsIgnoreCase( prop.getDocDVLALanguage() )){
			result = true;
		}
		LOGGER.debug("isEnglish({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isWelsh(DocumentProperty prop){
		boolean result = false;
		if("W".equalsIgnoreCase( prop.getDocDVLALanguage() )){
			result = true;
		}
		LOGGER.debug("isWelsh({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isClericalBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.clerical") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.clerical") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isClericalBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isClerical(DocumentProperty prop){
		boolean result = clericalCustomers.contains(prop);
		LOGGER.debug("isClerical({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isFleetBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.fleet") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.fleet") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isFleetBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isFleet(DocumentProperty prop) {
		boolean result = true;
		if( prop.getDocDVLAFleetNo() == null || prop.getDocDVLAFleetNo().trim().isEmpty() ){
			result = false;
		}
		LOGGER.debug("isFleet({}) returned '{}'",prop, result);
		return result;
	}
	
	private boolean isUnsortedBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.unsorted") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.unsorted") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isUnsortedBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isUnsorted(DocumentProperty prop){
		boolean result = false;
		if( prop.getDocDVLAMailsortCode() == null || prop.getDocDVLAMailsortCode().trim().isEmpty() ){
			result = true;
		}
		LOGGER.debug("isUnsorted({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isSortedBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.sorted") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.sorted") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isSortedBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isMultiBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if(  !((String) params.getProductionConfiguration().get("site.english.multi")).contains("X") && 
					!((String) params.getProductionConfiguration().get("site.english.multi")).contains("x")){
				result = true;
			}
		}else{
			if( !((String) params.getProductionConfiguration().get("site.welsh.multi")).contains("X") && 
					!((String) params.getProductionConfiguration().get("site.welsh.multi")).contains("x")){
				result = true;
			}
		}
		LOGGER.debug("isMultiBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isMulti(DocumentProperty prop){
		boolean result = multiCustomers.contains(prop);
		LOGGER.debug("isMulti({}) returned '{}'", prop, result);
		return result;
	}
	
	
	private boolean isSortingBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.sorting") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.sorting") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isSortingBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isRejectBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.reject") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.reject") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isRejectBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private boolean isReprintBatchRequired(DocumentProperty prop){
		boolean result = false;
		if( isEnglish(prop) ){
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.english.reprint") ) ) ){
				result = true;
			}
		}else{
			if( !("X".equalsIgnoreCase( (String) params.getProductionConfiguration().get("site.welsh.reprint") ) ) ){
				result = true;
			}
		}
		LOGGER.debug("isReprintBatchRequired({}) returned '{}'", prop, result);
		return result;
	}
	
	private void assignGroupIds() {
		LOGGER.debug("assignGroupIds() running..");
		for( DocumentProperty prop : params.getDocumentProperties() ){
			if( BatchTypes.valueOf(prop.getDocDVLABatchType()).equals(BatchTypes.FLEET) ){
				prop.setDocDVLAGroupId("" + fleetMap.get(prop));
			}else if( BatchTypes.valueOf(prop.getDocDVLABatchType()).equals(BatchTypes.CLERICAL) ){
				prop.setDocDVLABatchType("" + multiMap.get(prop));
			}else if( BatchTypes.valueOf(prop.getDocDVLABatchType()).equals(BatchTypes.MULTI) ){
				prop.setDocDVLABatchType("" + multiMap.get(prop));
			}else if( isEnglish(prop) && "X".equalsIgnoreCase((String) params.getProductionConfiguration().get("site.english.multi")) ){
				prop.setDocDVLABatchType("" + multiMap.get(prop));
			}else if( isWelsh(prop) && "X".equalsIgnoreCase((String) params.getProductionConfiguration().get("site.welsh.multi")) ){
				prop.setDocDVLABatchType("" + multiMap.get(prop));
			}
		}
	}
	
}

