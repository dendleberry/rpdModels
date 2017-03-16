package uk.gov.dvla.osg.rpd.common.models;

import java.util.List;

public class Envelope {
	private String envelopeName,envelopeReversion;
	private List<Content> contents;
	private Dimensions dimensions;
	
	public String getEnvelopeName() {
		return envelopeName;
	}
	public void setEnvelopeName(String envelopeName) {
		this.envelopeName = envelopeName;
	}
	public String getEnvelopeReversion() {
		return envelopeReversion;
	}
	public void setEnvelopeReversion(String envelopeReversion) {
		this.envelopeReversion = envelopeReversion;
	}
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	public Dimensions getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}
}
