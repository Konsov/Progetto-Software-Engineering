package com.group15.interfaces;

import java.rmi.RemoteException;
import java.util.Vector;

import com.group15.commonclass.Cartellonistica;
import com.group15.commonclass.Evento;
import com.group15.commonclass.Fiera;
import com.group15.commonclass.Materiale;
import com.group15.commonclass.Online;
import com.group15.commonclass.ServizioEsterno;
import com.group15.commonclass.Stampa;

public interface ProgettiInterface {
	
	public Vector<Cartellonistica> getProgettiCartellonistica() throws RemoteException;
	public Vector<Evento> getProgettiEvento() throws RemoteException;
	public Vector<Fiera> getProgettiFiera() throws RemoteException;
	public Vector<Online> getProgettiOnline() throws RemoteException;
	public Vector<Stampa> getProgettiStampa() throws RemoteException;
	public Vector<ServizioEsterno> getServiziEsterni() throws RemoteException;
	public Vector<Materiale> getMateriali() throws RemoteException;
	public void addProgettoCartellonistica(Cartellonistica c) throws RemoteException;
	public void addProgettoEvento(Evento e) throws RemoteException;
	public void addProgettoFiera(Fiera f) throws RemoteException;
	public void addProgettoOnline(Online o) throws RemoteException;
	public void addProgettoStampa(Stampa s) throws RemoteException;
	public void deleteProgetto(String nomeProgetto, String tipoProgetto) throws RemoteException;
	
	public void addServzioEsterno(ServizioEsterno se) throws RemoteException;
	public void addMateriale(Materiale m) throws RemoteException;
	public void setStatoProgetto(String nomeProgetto, String tipoProgetto, String statoOrdine) throws RemoteException;
	public void setTempoImpiegato(String nomeProgetto, String tipoProgetto, Float tempoImpiegato) throws RemoteException;
}
