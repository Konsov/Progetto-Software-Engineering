package com.group15.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Vector;

import com.group15.commonclass.Account;
import com.group15.commonclass.Cartellonistica;
import com.group15.commonclass.Cliente;
import com.group15.commonclass.Evento;
import com.group15.commonclass.Fiera;
import com.group15.commonclass.Materiale;
import com.group15.commonclass.Online;
import com.group15.commonclass.ServizioEsterno;
import com.group15.commonclass.Stampa;
import com.group15.data.*;
import com.group15.gestori.GestoreAccount;
import com.group15.gestori.GestoreCliente;
import com.group15.gestori.GestoreProgetto;
import com.group15.interfaces.*;



public class Server extends UnicastRemoteObject implements ServerInterface {

	private static final long serialVersionUID = 5010029865557803674L;

	private GestoreAccount gestoreAccount;
	private GestoreCliente gestoreCliente;
	private GestoreProgetto gestoreProgetto;

	protected Server() throws RemoteException {
		super();
		gestoreAccount = new GestoreAccount();
		gestoreCliente = new GestoreCliente();
		gestoreProgetto = new GestoreProgetto();

	}

	public static void main(String[] args) {
		//inizializzazione del database e i relativi gestori
		try {
			Server server = new Server();

			Registry r = LocateRegistry.createRegistry(1234);

			r.bind("MsServer", server);

		} catch (AlreadyBoundException | RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Server Ready");

		try { // Connessione al database
			DatabaseManager.getInstance();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//faÇade dei gestori//	
	@Override
	public boolean checkLogin(String username, String password) throws RemoteException {
		
		return gestoreAccount.checkLogin(username, password);
	}

	@Override
	public void addAccount(Account a) throws RemoteException {
		gestoreAccount.addAccount(a);
	}

	@Override
	public void deleteAccount(String username) throws RemoteException {
		gestoreAccount.deleteAccount(username);
	}

	@Override
	public Vector<Account> getAccounts() throws RemoteException {
		return gestoreAccount.getAccounts();
	}

	@Override
	public void addCliente(Cliente c) throws RemoteException {
		gestoreCliente.addCliente(c);
	}

	@Override
	public void deleteCliente(String email) throws RemoteException {
		gestoreCliente.deleteCliente(email);
	}

	@Override
	public Vector<Cliente> getClienti() throws RemoteException {
		return gestoreCliente.getClienti();
	}

	@Override
	public Vector<Cartellonistica> getProgettiCartellonistica() throws RemoteException {
		return gestoreProgetto.getProgettiCartellonistica();
	}

	@Override
	public Vector<Evento> getProgettiEvento() throws RemoteException {

		return gestoreProgetto.getProgettiEvento();
	}

	@Override
	public Vector<Fiera> getProgettiFiera() throws RemoteException {

		return gestoreProgetto.getProgettiFiera();
	}

	@Override
	public Vector<Online> getProgettiOnline() throws RemoteException {

		return gestoreProgetto.getProgettiOnline();
	}

	@Override
	public Vector<Stampa> getProgettiStampa() throws RemoteException {

		return gestoreProgetto.getProgettiStampa();
	}

	@Override
	public Vector<ServizioEsterno> getServiziEsterni() throws RemoteException {

		return gestoreProgetto.getServiziEsterni();
	}

	@Override
	public Vector<Materiale> getMateriali() throws RemoteException {

		return gestoreProgetto.getMateriali();
	}

	@Override
	public void addProgettoCartellonistica(Cartellonistica c) throws RemoteException {
		gestoreProgetto.addProgettoCartellonistica(c);

	}

	@Override
	public void addProgettoEvento(Evento e) throws RemoteException {
		gestoreProgetto.addProgettoEvento(e);
	}

	@Override
	public void addProgettoFiera(Fiera f) throws RemoteException {
		gestoreProgetto.addProgettoFiera(f);

	}

	@Override
	public void addProgettoOnline(Online o) throws RemoteException {
		gestoreProgetto.addProgettoOnline(o);
	}

	@Override
	public void addProgettoStampa(Stampa s) throws RemoteException {
		gestoreProgetto.addProgettoStampa(s);
	}

	@Override
	public void deleteProgetto(String nomeProgetto, String tipoProgetto) throws RemoteException {
		gestoreProgetto.deleteProgetto(nomeProgetto, tipoProgetto);
	}

	@Override
	public void addServzioEsterno(ServizioEsterno se) throws RemoteException {
		gestoreProgetto.addServzioEsterno(se);
	}

	@Override
	public void addMateriale(Materiale m) throws RemoteException {
		gestoreProgetto.addMateriale(m);
	}

	@Override
	public void setStatoProgetto(String nomeProgetto, String tipoProgetto, String statoOrdine) throws RemoteException {
		gestoreProgetto.setStatoProgetto(nomeProgetto, tipoProgetto, statoOrdine);
	}

	@Override
	public void setTempoImpiegato(String nomeProgetto, String tipoProgetto, Float tempoImpiegato)
			throws RemoteException {
		gestoreProgetto.setTempoImpiegato(nomeProgetto, tipoProgetto, tempoImpiegato);
	}

}
