package uk.gov.dvla.osg.rpd.common.models;

public class Dimensions {
	private float lengthInMm, heightInMm, WidthInMm, weightInGrams;

	public float getLengthInMm() {
		return lengthInMm;
	}
	public void setLengthInMm(float lengthInMm) {
		this.lengthInMm = lengthInMm;
	}
	public float getHeightInMm() {
		return heightInMm;
	}
	public void setHeightInMm(float heightInMm) {
		this.heightInMm = heightInMm;
	}
	public float getWidthInMm() {
		return WidthInMm;
	}
	public void setWidthInMm(float widthInMm) {
		WidthInMm = widthInMm;
	}
	public float getWeightInGrams() {
		return weightInGrams;
	}
	public void setWeightInGrams(float weightInGrams) {
		this.weightInGrams = weightInGrams;
	}
}
