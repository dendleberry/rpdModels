package uk.gov.dvla.osg.rpd.common.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

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
	
	public String getBatchType(){
		String result = docProp.getDocDVLABatchType();
		LOGGER.trace("getBatchType() returned '{}'", result);
		return result;
	}
	
	public String getLanguage(){
		String result = docProp.getDocDVLALanguage();
		LOGGER.trace("getLanguage() returned '{}'", result);
		return result;
	}
	
	public Integer getPresentationOrder() {
		return presentationOrder;
	}
	public void setPresentationOrder(Integer presentationOrder) {
		this.presentationOrder = presentationOrder;
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
	
	@Override
	public String toString(){
		return docProp.toString();
	}
}
