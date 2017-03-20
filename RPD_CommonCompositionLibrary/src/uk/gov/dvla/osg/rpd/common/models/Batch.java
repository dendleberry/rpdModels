package uk.gov.dvla.osg.rpd.common.models;

import java.util.List;

public class Batch {
	private String batchId, batchType, stationery, formDef;
	private int batchSequence, noOfPagesInBatch, noOfGroupsInBatch;
	private List<Envelope> envelopes;
	
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchType() {
		return batchType;
	}
	public void setBatchType(String batchType) {
		this.batchType = batchType;
	}
	public String getStationery() {
		return stationery;
	}
	public void setStationery(String stationery) {
		this.stationery = stationery;
	}
	public String getFormDef() {
		return formDef;
	}
	public void setFormDef(String formDef) {
		this.formDef = formDef;
	}
	public int getBatchSequence() {
		return batchSequence;
	}
	public void setBatchSequence(int batchSequence) {
		this.batchSequence = batchSequence;
	}
	public int getNoOfPagesInBatch() {
		return noOfPagesInBatch;
	}
	public void setNoOfPagesInBatch(int noOfPagesInBatch) {
		this.noOfPagesInBatch = noOfPagesInBatch;
	}
	public int getNoOfGroupsInBatch() {
		return noOfGroupsInBatch;
	}
	public void setNoOfGroupsInBatch(int noOfGroupsInBatch) {
		this.noOfGroupsInBatch = noOfGroupsInBatch;
	}
	public List<Envelope> getEnvelopes() {
		return envelopes;
	}
	public void setEnvelopes(List<Envelope> envelopes) {
		this.envelopes = envelopes;
	}
}
