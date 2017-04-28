package uk.gov.dvla.osg.rpd.common.models;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public class Document {
	private DocumentProperty docProp;
	private Integer presentationOrder;
	private boolean endOfGroup;
	
	public DocumentProperty getDocProp() {
		return docProp;
	}
	public void setDocProp(DocumentProperty docProp) {
		this.docProp = docProp;
	}
	public Integer getPresentationOrder() {
		return presentationOrder;
	}
	public void setPresentationOrder(Integer presentationOrder) {
		this.presentationOrder = presentationOrder;
	}
	public boolean isEndOfGroup(){
		if( "X".equalsIgnoreCase( this.docProp.getDocDVLAEndOfGroup()) ){
			return true;
		}else{
			return false;
		}
	}
	public void setEndOfGroup(boolean eog){
		this.endOfGroup=eog;
		if( eog ){
			this.docProp.setDocDVLAEndOfGroup("X");
		}else{
			this.docProp.setDocDVLAEndOfGroup("");
		}
	}
}
