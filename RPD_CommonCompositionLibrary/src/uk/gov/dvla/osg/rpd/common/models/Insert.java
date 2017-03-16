package uk.gov.dvla.osg.rpd.common.models;

public class Insert {
	private String insertName, insertReversion;
	private Dimensions dimensions;
	
	public String getInsertName() {
		return insertName;
	}
	public void setInsertName(String insertName) {
		this.insertName = insertName;
	}
	public String getInsertReversion() {
		return insertReversion;
	}
	public void setInsertReversion(String insertReversion) {
		this.insertReversion = insertReversion;
	}
	public Dimensions getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}
}
