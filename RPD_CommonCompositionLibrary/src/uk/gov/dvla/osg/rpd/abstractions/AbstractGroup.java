package uk.gov.dvla.osg.rpd.abstractions;

import java.util.ArrayList;

import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public abstract class AbstractGroup {
	private int pagesInGroup;
	private String groupId;
	private ArrayList<Document> docs;
	
	public abstract void batch();
	
	public AbstractGroup(){
		docs = new ArrayList<Document>();
	}
	
	public int getPagesInGroup(){
		return pagesInGroup;
	}
	
	public void addDocument(Document doc){
		docs.add(doc);
		pagesInGroup += doc.getNoOfSheets();
	}
	
	public ArrayList<Document> getDocuments(){
		return docs;
	}
	public void setGroupId(String groupId){
		this.groupId=groupId;
	}
	public String getGroupId(){
		return groupId;
	}
	
}
