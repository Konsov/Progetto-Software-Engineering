package com.group15.commonclass;

public class Materiale implements java.io.Serializable {


	private static final long serialVersionUID = -6344166610730044527L;

private String nome;
private Float prezzo;
private String nomeProgetto;

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
public String getNomeProgetto() {
	return nomeProgetto;
}
public void setNomeProgetto(String nomeProgetto) {
	this.nomeProgetto = nomeProgetto;
}
	
	
}
