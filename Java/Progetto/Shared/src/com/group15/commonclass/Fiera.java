package com.group15.commonclass;

public class Fiera extends Progetto implements java.io.Serializable{

	private static final long serialVersionUID = -8969153980508580317L;


	boolean proposta1;
	
	boolean proposta2;
	
	String descrizione;
	
	
	public boolean getProposta1() {
		return proposta1;
	}

	public void setProposta1(boolean proposta1) {
		this.proposta1 = proposta1;
	}

	public boolean getProposta2() {
		return proposta2;
	}

	public void setProposta2(boolean proposta2) {
		this.proposta2 = proposta2;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
}
