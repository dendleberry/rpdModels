package uk.gov.dvla.osg.rpd.common.models;

import java.util.List;

public class Tray {
	private String trayTicket;
	private List<Envelope> envelopesInTray;
	private int trayVolume;
	private Dimensions dimensions;
	
	public String getTrayTicket() {
		return trayTicket;
	}
	public void setTrayTicket(String trayTicket) {
		this.trayTicket = trayTicket;
	}
	public List<Envelope> getEnvelopesInTray() {
		return envelopesInTray;
	}
	public void setEnvelopesInTray(List<Envelope> envelopesInTray) {
		this.envelopesInTray = envelopesInTray;
	}
	public int getTrayVolume() {
		return trayVolume;
	}
	public void setTrayVolume(int trayVolume) {
		this.trayVolume = trayVolume;
	}
	public Dimensions getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}
}
