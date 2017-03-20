package uk.gov.dvla.osg.rpd.common.models;

public class Item {
	private String itemName;
	private Dimensions itemDimensions;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Dimensions getItemDimensions() {
		return itemDimensions;
	}
	public void setItemDimensions(Dimensions dimensions) {
		this.itemDimensions = dimensions;
	}
}
