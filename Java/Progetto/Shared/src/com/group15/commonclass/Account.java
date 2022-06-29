package com.group15.commonclass;

public class Account implements java.io.Serializable{

	private static final long serialVersionUID = 3622918953765210513L;

	private String nome;
	private String cognome;
	private String password;
	private String username;
	
	public Account(){
		
	}
	
	public Account(String nome, String cognome, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.username = username;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
