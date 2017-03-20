package uk.gov.dvla.osg.rpd.common.models;

import java.util.List;

public class Envelope {
	private String envelopeName,envelopeReversion;
	private List<DocumentProperty> documentProperties;
	private List<Item> items;
	private Dimensions envelopeDimensions;
	
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
	public List<DocumentProperty> getDocumentProperties() {
		return documentProperties;
	}
	public void setDocumentProperties(List<DocumentProperty> documentProperties) {
		this.documentProperties = documentProperties;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Dimensions getEnvelopeDimensions() {
		return envelopeDimensions;
	}
	public void setEnvelopeDimensions(Dimensions dimensions) {
		this.envelopeDimensions = dimensions;
	}
}
