package com.group15.interfaces;

import java.rmi.RemoteException;
import java.util.Vector;

import com.group15.commonclass.Account;

public interface AccountInterface {

	public boolean checkLogin(String username, String password) throws RemoteException;
	public void addAccount(Account a) throws RemoteException;
	public void deleteAccount(String username) throws RemoteException;
	public Vector<Account> getAccounts() throws RemoteException;
	
}
