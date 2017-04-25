package uk.gov.dvla.osg.rpd.abstractions;

import java.util.ArrayList;

import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public abstract class AbstractGroup {
	private int pagesInGroup;
	private ArrayList<DocumentProperty> documentProps;
	
	public abstract void batch();
	
	public AbstractGroup(){
		documentProps = new ArrayList<DocumentProperty>();
	}
	
	public int getPagesInGroup(){
		return pagesInGroup;
	}
	
	public void addDocProp(DocumentProperty docProp){
		documentProps.add(docProp);
		pagesInGroup += Integer.parseInt(docProp.getDocOriginalSheets());
	}
	
	public ArrayList<DocumentProperty> getDocumentProperties(){
		return documentProps;
	}
	
}
