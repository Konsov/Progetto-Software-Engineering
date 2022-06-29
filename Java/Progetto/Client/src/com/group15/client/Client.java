package com.group15.client;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import com.group15.commonclass.*;
import com.group15.gui.*;
import com.group15.interfaces.*;

public class Client {

	private static ServerInterface server;



	public static void main(String[] args) throws RemoteException {

		try {

			Registry r = LocateRegistry.getRegistry("localhost",1234);  // Try per la connessione al server e alla sua interfaccia
			server = (ServerInterface) r.lookup("MsServer");				
			System.out.println("Client connesso al server");

		} catch (RemoteException | NotBoundException e) {              //Catch per la mancata connessione al server

			System.err.println("Impossibile connettersi al server!");
			e.printStackTrace();
		} 


		Login.open();  // Apertura della schermata di login, avvio della grafica


	}


	public static void checkCredenziali (String User, String Pass) throws RemoteException{

		if(server.checkLogin(User, Pass))
		{
			System.out.println("Login Eseguito Correttamente");
			HomeMan.main();
			Login.loginEseguito();
		}else{
			System.out.println("Login Fallito");
			Login.loginFallito();
		}


	}


	public static Vector<Account> getAccounts() throws RemoteException{

		return server.getAccounts();
	}

	public static Vector<Cliente> getClienti() throws RemoteException{

		return server.getClienti();
	}

	public static void addAccount (String nome, String cognome, String username, String password) throws RemoteException
	{
		Account a = new Account();
		a.setNome(nome);
		a.setCognome(cognome);
		a.setUsername(username);
		a.setPassword(password);
		server.addAccount(a);
	}

	public static void aggiungiCliente (String nome, String cognome, String email, String numeroTelefonico) throws RemoteException
	{
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);
		c.setNumero(numeroTelefonico);
		server.addCliente(c);
	}

	public static void deleteAccount(String username) throws RemoteException
	{

		server.deleteAccount(username);
	}

	
	public static void deleteCliente(String email) throws RemoteException
	{

		server.deleteCliente(email);
	}

	public static Vector<Materiale> getMateriali() throws RemoteException{

		return server.getMateriali();
	}

	public static Vector<ServizioEsterno> getServiziEsterni() throws RemoteException{

		return server.getServiziEsterni();
	}

	public static Vector<Cartellonistica> getProgettiCartellonistica() throws RemoteException{

		return server.getProgettiCartellonistica();
	}

	public static Vector<Evento> getProgettiEvento() throws RemoteException{

		return server.getProgettiEvento();
	}

	public static Vector<Fiera> getProgettiFiera() throws RemoteException{

		return server.getProgettiFiera();
	}

	public static Vector<Online> getProgettiOnline() throws RemoteException{
		return server.getProgettiOnline();
	}

	public static Vector<Stampa> getProgettiStampa() throws RemoteException{
		return server.getProgettiStampa();
	}

	public static void addProgettoCartellonistica(Cartellonistica c) throws RemoteException{
		server.addProgettoCartellonistica(c);
	}


	public static void addProgettoFiera(Fiera f) throws RemoteException{
		server.addProgettoFiera(f);
	}

	public static void addProgettoOnline(Online o) throws RemoteException{
		server.addProgettoOnline(o);
	}

	public static void addProgettoStampa(Stampa s) throws RemoteException{
		server.addProgettoStampa(s);
	}

	public static void addProgettoEvento(Evento e) throws RemoteException{
		server.addProgettoEvento(e);
	}

	public static void addServizioEsterno(String nome, Float prezzo, String nomeProgetto) throws RemoteException{
	ServizioEsterno se = new ServizioEsterno();
	se.setNome(nome);
	se.setPrezzo(prezzo);
	se.setIdProgetto(nomeProgetto);	
	server.addServzioEsterno(se);
	}

	public static void addMateriale(String nome, Float prezzo, String nomeProgetto) throws RemoteException{
		Materiale m = new Materiale();
		m.setNome(nome);
		m.setPrezzo(prezzo);
		m.setNomeProgetto(nomeProgetto);
		server.addMateriale(m);
	}
	
	public static void setStatoProgetto(String nomeProgetto,String tipoProgetto, String statoOrdine) throws RemoteException{
		server.setStatoProgetto(nomeProgetto,tipoProgetto,statoOrdine);
	}

	public static void setTempoImpiegato(String nomeProgetto,String tipoProgetto,Float tempoImpiegato) throws RemoteException{
		server.setTempoImpiegato(nomeProgetto,tipoProgetto,tempoImpiegato);
	}
	public static void deleteProgetto(String nomeProgetto, String tipoProgetto) throws RemoteException{
		server.deleteProgetto(nomeProgetto,tipoProgetto);
	}
}

