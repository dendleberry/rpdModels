package uk.gov.dvla.osg.rpd.common.models;

public class Item {
	private int itemSequence;
	private Document document;
	
	public int getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(int itemSequence) {
		this.itemSequence = itemSequence;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
}
