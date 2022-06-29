package com.group15.commonclass;


import com.group15.commonenum.*;

public class Progetto implements java.io.Serializable{


	private static final long serialVersionUID = -875973953980689847L;

	protected String nomeProgetto;
	protected TipoProgetto tipoProgetto;
	protected int numeroDipendentiAssegnati;
	protected float prezzo;
	protected String scadenza;
	protected float tempoImpiegato;
	protected StatoOrdine statoOrdine;
	protected int idcliente;

	public Progetto(){
		
	}

	public TipoProgetto getTipoProgetto() {
		return tipoProgetto;
	}

	public void setTipoProgetto(TipoProgetto progetto) {
		this.tipoProgetto = progetto;
	}

	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public float getTempoImpiegato() {
		return tempoImpiegato;
	}

	public void setTempoImpiegato(float tempoImpiegato) {
		this.tempoImpiegato = tempoImpiegato;
	}

	
	public StatoOrdine getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}


	public String getNomeProgetto() {
		return nomeProgetto;
	}

	public void setNomeProgetto(String codProgetto) {
		this.nomeProgetto = codProgetto;
	}

	public int getIdCliente() {
		return idcliente;
	}

	public void setIdCliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public int getNumeroDipendentiAssegnati() {
		return numeroDipendentiAssegnati;
	}

	public void setNumeroDipendentiAssegnati(int numeroDipendentiAssegnati) {
		this.numeroDipendentiAssegnati = numeroDipendentiAssegnati;
	}
}
