package uk.gov.dvla.osg.rpd.common.models;

import java.util.List;

public class Content {
	private List<Insert> inserts;
	private List<Document> documents;
	private String soapFileEntry;
	
	public List<Insert> getInserts() {
		return inserts;
	}
	public void setInserts(List<Insert> inserts) {
		this.inserts = inserts;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public String getSoapFileEntry(){
		return soapFileEntry;
	}
	public void setSoapFileEntry(String soapFileEntry){
		this.soapFileEntry = soapFileEntry;
	}
}
