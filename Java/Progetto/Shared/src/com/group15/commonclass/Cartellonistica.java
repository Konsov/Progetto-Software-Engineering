package com.group15.commonclass;

import com.group15.commonenum.*;

public class Cartellonistica extends Progetto implements java.io.Serializable{

	private static final long serialVersionUID = 7618073571946504377L;
	

	
	TipoCartellonistica tipoCartelloni;
	
	boolean proposta1 ;
	
	int quantita1 ;
	
	float altezza1;
	
	float larghezza1 ;
	
	boolean proposta2 ;
	
	int quantita2 ;
	
	float altezza2;
	
	float larghezza2;
	

	public TipoCartellonistica getTipoCartelloni(){
		return tipoCartelloni;
	}

	public void setTipoCartelloni(TipoCartellonistica tipoCartelloni) {
		this.tipoCartelloni = tipoCartelloni;
	}

	public boolean getProposta1() {
		return proposta1;
	}

	public void setProposta1(boolean proposta1) {
		this.proposta1 = proposta1;
	}

	public float getAltezza1() {
		return altezza1;
	}

	public void setAltezza1(float altezza1) {
		this.altezza1 = altezza1;
	}

	public float getLarghezza1() {
		return larghezza1;
	}

	public void setLarghezza1(float larghezza1) {
		this.larghezza1 = larghezza1;
	}

	public boolean getProposta2() {
		return proposta2;
	}

	public void setProposta2(boolean proposta2) {
		this.proposta2 = proposta2;
	}

	public float getAltezza2() {
		return altezza2;
	}

	public void setAltezza2(float altezza2) {
		this.altezza2 = altezza2;
	}

	public float getLarghezza2() {
		return larghezza2;
	}

	public void setLarghezza2(float larghezza2) {
		this.larghezza2 = larghezza2;
	}


	
	public int getQuantita1() {
		return quantita1;
	}

	public void setQuantita1(int quantita1) {
		this.quantita1 = quantita1;
	}
	
	public int getQuantita2() {
		return quantita2;
	}

	public void setQuantita2(int quantita2) {
		this.quantita2 = quantita2;
	}

}
