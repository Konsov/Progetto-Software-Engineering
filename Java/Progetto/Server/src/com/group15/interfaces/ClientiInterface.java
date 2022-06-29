package com.group15.interfaces;

import java.rmi.RemoteException;
import java.util.Vector;

import com.group15.commonclass.Cliente;

public interface ClientiInterface {

	public void addCliente(Cliente c) throws RemoteException;
	public void deleteCliente(String email) throws RemoteException;
	public Vector<Cliente> getClienti() throws RemoteException;
	
}
