package uk.gov.dvla.osg.rpd.common.models;

import java.time.LocalDate;

public class Transaction {
	private String transactionName;
	private int transactionRunNumber;
	private LocalDate transactionDate;
	
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public int getTransactionRunNumber() {
		return transactionRunNumber;
	}
	public void setTransactionRunNumber(int transactionRunNumber) {
		this.transactionRunNumber = transactionRunNumber;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
}
