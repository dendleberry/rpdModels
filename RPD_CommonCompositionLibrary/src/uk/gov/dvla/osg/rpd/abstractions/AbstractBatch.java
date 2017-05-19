package uk.gov.dvla.osg.rpd.abstractions;

import java.util.ArrayList;

import uk.gov.dvla.osg.rpd.common.models.BatchTypes;
import uk.gov.dvla.osg.rpd.common.models.Document;
import uk.gov.dvla.osg.rpd.common.models.Languages;
import uk.gov.dvla.osg.rpd.document.properties.DocumentProperty;

public abstract class AbstractBatch {
	private ArrayList<Document> docs;
	private BatchTypes batchType;
	private Languages language;
	private Integer batchCapacity, numberOfDocsInBatch;
	
	public abstract void batch();
	
	public AbstractBatch(BatchTypes batchType, int batchCapacity){
		docs = new ArrayList<Document>();
		numberOfDocsInBatch = 0;
		this.batchType=batchType;
		this.batchCapacity=batchCapacity;
	}
	
	public void addDocument(Document doc){
		docs.add(doc);
		numberOfDocsInBatch+=doc.getNoOfSheets();
	}
	
	public ArrayList<Document> getDocuments(){
		return docs;
	}
	
	public BatchTypes getBatchType(){
		return batchType;
	}
	
	public boolean isFull(){
		boolean result = numberOfDocsInBatch >= batchCapacity;
		return result;
	}
	public boolean isDocSuitableForBatch(Document doc){
		boolean result = true;
		if( !(doc.getBatchType().equals(this.batchType)) ){
			result = false;
		} else if( !(doc.getLanguage().equals(this.language)) ){
			result = false;
		} else if( numberOfDocsInBatch + doc.getNoOfSheets() > batchCapacity){
			result = false;
		}
		return result;
	}
	
	public Languages getLanguage(){
		return this.language;
	}
	
	public String getBatchKey(){
		return this.batchType + "." + this.language;
	}
}
