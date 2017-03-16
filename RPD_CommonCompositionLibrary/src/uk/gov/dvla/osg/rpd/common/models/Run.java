package uk.gov.dvla.osg.rpd.common.models;

import java.time.LocalDate;
import java.util.List;

public class Run {
	private Transaction transaction;
	private int runNumber, numberOfRecords;
	private LocalDate runDate;
	private List<Batch> batches;
	
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public int getRunNumber() {
		return runNumber;
	}
	public void setRunNumber(int runNumber) {
		this.runNumber = runNumber;
	}
	public int getNumberOfRecords() {
		return numberOfRecords;
	}
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	public LocalDate getRunDate() {
		return runDate;
	}
	public void setRunDate(LocalDate runDate) {
		this.runDate = runDate;
	}
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
}
