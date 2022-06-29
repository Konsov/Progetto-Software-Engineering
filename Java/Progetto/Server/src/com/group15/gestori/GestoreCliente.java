package com.group15.gestori;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Vector;

import com.group15.commonclass.Cliente;
import com.group15.data.DatabaseManager;
import com.group15.interfaces.ClientiInterface;

//Classe contenente i metodi di gestione dei clienti

public class GestoreCliente extends UnicastRemoteObject implements ClientiInterface{

	private static final long serialVersionUID = 6102431945702637135L;
	
	public GestoreCliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void addCliente(Cliente c) throws RemoteException {
		try {
			DatabaseManager.getInstance().addCliente(c);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCliente(String email) throws RemoteException {
		try {
			DatabaseManager.getInstance().deleteCliente(email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Vector<Cliente> getClienti() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getClienti();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}



}
