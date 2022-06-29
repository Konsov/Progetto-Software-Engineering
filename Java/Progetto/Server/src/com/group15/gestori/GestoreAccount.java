package com.group15.gestori;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Vector;

import com.group15.commonclass.Account;
import com.group15.data.DatabaseManager;
import com.group15.interfaces.AccountInterface;

//Classe contenente i metodi di gestione degli account

public class GestoreAccount extends UnicastRemoteObject implements AccountInterface{

	private static final long serialVersionUID = -2069854912819423597L;

	public GestoreAccount() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkLogin(String username, String password) throws RemoteException {
		Boolean login = false; 
		try {
			login = DatabaseManager.getInstance().checkLogin(username, password);
		}catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} 
		return login;

	}

	@Override
	public void addAccount(Account a) throws RemoteException {
		try {
			DatabaseManager.getInstance().addAccount(a);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(String username) throws RemoteException {
		try {
			DatabaseManager.getInstance().deleteAccount(username);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Vector<Account> getAccounts() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getAccounts();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


}
