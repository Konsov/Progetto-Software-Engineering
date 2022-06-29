package com.group15.commonclass;

public class ServizioEsterno implements java.io.Serializable{

	private static final long serialVersionUID = 4496907003911299172L;

	String nome;
	Float prezzo;
	String idProgetto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public String getIdProgetto() {
		return idProgetto;
	}

	public void setIdProgetto(String idProgetto) {
		this.idProgetto = idProgetto;
	}

}
