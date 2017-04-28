package uk.gov.dvla.osg.rpd.abstractions;

import java.util.ArrayList;

import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public abstract class AbstractGroup {
	private int pagesInGroup;
	private ArrayList<Document> docs;
	
	public abstract void batch();
	
	public AbstractGroup(){
		docs = new ArrayList<Document>();
	}
	
	public int getPagesInGroup(){
		return pagesInGroup;
	}
	
	public void addDocProp(Document doc){
		docs.add(doc);
		pagesInGroup += Integer.parseInt(doc.getDocProp().getDocOriginalSheets());
	}
	
	public ArrayList<Document> getDocumentProperties(){
		return docs;
	}
	
}
