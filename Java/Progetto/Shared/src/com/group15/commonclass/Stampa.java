package com.group15.commonclass;

public class Stampa extends Progetto implements java.io.Serializable{

	private static final long serialVersionUID = 3990375339958815303L;

	boolean proposta1;
	int quantita1;
	
	boolean proposta2;
	int quantita2;
	
	boolean proposta3;
	int quantita3;
	
	float altezza;
	float larghezza;
	
	
	public boolean getProposta1() {
		return proposta1;
	}
	public void setProposta1(boolean proposta1) {
		this.proposta1 = proposta1;
	}
	public int getQuantita1() {
		return quantita1;
	}
	public void setQuantita1(int quantita1) {
		this.quantita1 = quantita1;
	}
	public boolean getProposta2() {
		return proposta2;
	}
	public void setProposta2(boolean proposta2) {
		this.proposta2 = proposta2;
	}
	public int getQuantita2() {
		return quantita2;
	}
	public void setQuantita2(int quantita2) {
		this.quantita2 = quantita2;
	}
	public boolean getProposta3() {
		return proposta3;
	}
	public void setProposta3(boolean proposta3) {
		this.proposta3 = proposta3;
	}
	public int getQuantita3() {
		return quantita3;
	}
	public void setQuantita3(int quantita3) {
		this.quantita3 = quantita3;
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

	
}
