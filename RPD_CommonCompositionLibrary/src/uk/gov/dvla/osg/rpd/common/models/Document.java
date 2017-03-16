package uk.gov.dvla.osg.rpd.common.models;

public class Document {
	private Address address;
	private ProductionMark productionMarks;
	private String documentArtwork, documentId;
	private boolean documentIsLastInGroup, documentIsFirstInTray, documentIsDuplex;
	private int numberOfPagesInDocument;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ProductionMark getProductionMark() {
		return productionMarks;
	}
	public void setProductionMark(ProductionMark productionMarks) {
		this.productionMarks = productionMarks;
	}
	public String getDocumentArtwork() {
		return documentArtwork;
	}
	public void setDocumentArtwork(String documentArtwork) {
		this.documentArtwork = documentArtwork;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public boolean isDocumentIsLastInGroup() {
		return documentIsLastInGroup;
	}
	public void setDocumentIsLastInGroup(boolean documentIsLastInGroup) {
		this.documentIsLastInGroup = documentIsLastInGroup;
	}
	public boolean isDocumentIsFirstInTray() {
		return documentIsFirstInTray;
	}
	public void setDocumentIsFirstInTray(boolean documentIsFirstInTray) {
		this.documentIsFirstInTray = documentIsFirstInTray;
	}
	public boolean isDocumentIsDuplex() {
		return documentIsDuplex;
	}
	public void setDocumentIsDuplex(boolean documentIsDuplex) {
		this.documentIsDuplex = documentIsDuplex;
	}
	public int getNumberOfPagesInDocument() {
		return numberOfPagesInDocument;
	}
	public void setNumberOfPagesInDocument(int numberOfPagesInDocument) {
		this.numberOfPagesInDocument = numberOfPagesInDocument;
	}
}
