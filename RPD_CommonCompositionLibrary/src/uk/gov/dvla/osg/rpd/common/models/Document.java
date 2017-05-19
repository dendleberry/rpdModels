package uk.gov.dvla.osg.rpd.common.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;
import uk.gov.dvla.osg.rpd.main.Main;

public class Document {
	private static final Logger LOGGER = LogManager.getLogger();
	private DocumentProperty docProp;
	private Integer presentationOrder;
	private Dimensions dimensions;
	
	public DocumentProperty getlDocProp() {
		return docProp;
	}
	public void setDocProp(DocumentProperty docProp) {
		this.docProp = docProp;
	}
	
	public int getNoOfSheets(){
		int result = 0;
		try{
			result = Integer.parseInt(docProp.getDocOriginalSheets());
		} catch (NumberFormatException e){
			LOGGER.trace("getNoOfSheets() returned '{}'", result);
			System.exit(1);
		}
		return result;
	}
	
	public String getGroupId(){
		String result = docProp.getDocDVLAGroupId();
		LOGGER.trace("getGroupId() returned '{}'", result);
		return result;
	}
	
	public void setGroupId(String groupId){
		docProp.setDocDVLAGroupId(groupId);
	}
	
	public BatchTypes getBatchType(){
		BatchTypes result = BatchTypes.valueOf(docProp.getDocDVLABatchType());
		LOGGER.trace("getBatchType() returned '{}'", result);
		return result;
	}
	
	public void setBatchType(BatchTypes bt){
		docProp.setDocDVLABatchType(bt.name());
		presentationOrder = Main.getPresentationPriority(this);
	}
	
	public String getSubBatchType(){
		String result = docProp.getDocDVLASubBatchType();
		LOGGER.trace("getSubBatchType() returned '{}'", result);
		return result;
	}
	
	public void setSubBatchType(String bt){
		docProp.setDocDVLASubBatchType(bt);
	}
	
	public BatchTypes getOriginalBatchType(){
		BatchTypes result = BatchTypes.valueOf(docProp.getDocDVLAOriginalBatchType());
		LOGGER.trace("getOriginalBatchType() returned '{}'", result);
		return result;
	}
	
	public Languages getLanguage(){
		Languages result = null;
		
		if( "E".equalsIgnoreCase(docProp.getDocDVLALanguage()) ){
			result = Languages.ENGLISH;
		}else{
			result = Languages.WELSH;
		}
		
		LOGGER.trace("getLanguage() returned '{}'", result);
		return result;
	}
	
	public Integer getPresentationOrder() {
		return presentationOrder;
	}

	
	public boolean isEndOfGroup(){
		boolean result = true;
		if( "X".equalsIgnoreCase( this.docProp.getDocDVLAEndOfGroup()) ){
			result = true;
		}else{
			result = false;
		}
		LOGGER.trace("isEndOfGroup() returned '{}'", result);
		return result;
	}
	
	public void setEndOfGroup(boolean eog){
		if( eog ){
			this.docProp.setDocDVLAEndOfGroup("X");
		}else{
			this.docProp.setDocDVLAEndOfGroup("");
		}
	}
	
	public boolean isFleet(){
		boolean result = true;
		if( docProp.getDocDVLAFleetNo() == null || docProp.getDocDVLAFleetNo().trim().isEmpty() ){
			result = false;
		}
		LOGGER.trace("isFleet() returned '{}'", result);
		return result;
	}
	
	public boolean isEnglish(){
		boolean result = false;
		if("E".equalsIgnoreCase( docProp.getDocDVLALanguage() )){
			result = true;
		}
		LOGGER.trace("isEnglish() returned '{}'", result);
		return result;
	}
	
	public boolean isWelsh(){
		boolean result = false;
		if("W".equalsIgnoreCase( docProp.getDocDVLALanguage() )){
			result = true;
		}
		LOGGER.trace("isWelsh() returned '{}'", result);
		return result;
	}
	
	public boolean isUnsorted(){
		boolean result = false;
		if( docProp.getDocDVLAMailsortCode() == null || docProp.getDocDVLAMailsortCode().trim().isEmpty() ){
			result = true;
		}
		LOGGER.trace("isUnsorted() returned '{}'", result);
		return result;
	}
	
	public String getDocID() {
		
		return docProp.getDocID();
	}
	
	@Override
	public boolean equals(Object obj) {
		return docProp.equals(obj);
	}
	
	@Override
	public String toString(){
		return docProp.toString();
	}
	
	@Override
	public int hashCode(){
		return docProp.hashCode();
	}

}
