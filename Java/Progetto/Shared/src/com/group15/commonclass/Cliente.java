package com.group15.commonclass;


public class Cliente implements java.io.Serializable{
	
	private static final long serialVersionUID = 4580580667497124039L;
	
	private int idcliente;
	private String nome;
	private String cognome;
	private String email;
	private String numero;


	public Cliente(){
		
	}
	
	public Cliente(int idcliente, String nome, String cognome, String email, String numero) {
		this.idcliente = idcliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numero = numero;
	}
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
}
