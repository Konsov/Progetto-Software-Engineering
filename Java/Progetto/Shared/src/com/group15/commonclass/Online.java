package com.group15.commonclass;

public class Online extends Progetto implements java.io.Serializable{

	private static final long serialVersionUID = 1433225160485149147L;

	boolean banner;
	boolean sfondo;
	boolean inserzioneRettangolare;
	float altezza;
	float larghezza;
	boolean inserzioneQuadrata;
	float lato;
	
	public boolean getBanner() {
		return banner;
	}
	public void setBanner(boolean banner) {
		this.banner = banner;
	}
	public boolean getSfondo() {
		return sfondo;
	}
	public void setSfondo(boolean sfondo) {
		this.sfondo = sfondo;
	}
	public boolean getInserzioneRettangolare() {
		return inserzioneRettangolare;
	}
	public void setInserzioneRettangolare(boolean inserzioneRettangolare) {
		this.inserzioneRettangolare = inserzioneRettangolare;
	}
	public float getAltezza() {
		return altezza;
	}
	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(float larghezza) {
		this.larghezza = larghezza;
	}
	public boolean getInserzioneQuadrata() {
		return inserzioneQuadrata;
	}
	public void setInserzioneQuadrata(boolean inserzioneQuadrata) {
		this.inserzioneQuadrata = inserzioneQuadrata;
	}
	
	public float getLato() {
		return lato;
	}
	public void setLato(float lato) {
		this.lato = lato;
	}
}
