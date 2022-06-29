package com.group15.gestori;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Vector;

import com.group15.commonclass.Cartellonistica;
import com.group15.commonclass.Evento;
import com.group15.commonclass.Fiera;
import com.group15.commonclass.Materiale;
import com.group15.commonclass.Online;
import com.group15.commonclass.ServizioEsterno;
import com.group15.commonclass.Stampa;
import com.group15.data.DatabaseManager;
import com.group15.interfaces.ProgettiInterface;

//Classe contenente i metodi di gestione dei progetti

public class GestoreProgetto extends UnicastRemoteObject implements ProgettiInterface {

	
	private static final long serialVersionUID = -3879868998561633108L;

	public GestoreProgetto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Vector<Cartellonistica> getProgettiCartellonistica() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getProgettiCartellonistica();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vector<Evento> getProgettiEvento() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getProgettiEvento();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vector<Fiera> getProgettiFiera() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getProgettiFiera();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vector<Online> getProgettiOnline() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getProgettiOnline();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vector<Stampa> getProgettiStampa() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getProgettiStampa();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void addProgettoCartellonistica(Cartellonistica c) throws RemoteException {
		try {
			DatabaseManager.getInstance().addProgettoCartellonistica(c);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProgettoEvento(Evento e) throws RemoteException {
		try {
			DatabaseManager.getInstance().addProgettoEvento(e);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void addProgettoFiera(Fiera f) throws RemoteException {
		try {
			DatabaseManager.getInstance().addProgettoFiera(f);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProgettoOnline(Online o) throws RemoteException {
		try {
			DatabaseManager.getInstance().addProgettoOnline(o);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addProgettoStampa(Stampa s) throws RemoteException {
		try {
			DatabaseManager.getInstance().addProgettoStampa(s);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void deleteProgetto(String nomeProgetto, String tipoProgetto) throws RemoteException {
		try {
			DatabaseManager.getInstance().deleteProgetto(nomeProgetto,tipoProgetto);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

	@Override
	public void addServzioEsterno(ServizioEsterno se) throws RemoteException {
		try {
			DatabaseManager.getInstance().addServizioEsterno(se);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Vector<ServizioEsterno> getServiziEsterni() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getServiziEsterni();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public void addMateriale(Materiale m) throws RemoteException {
		try {
			DatabaseManager.getInstance().addMateriale(m);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public Vector<Materiale> getMateriali() throws RemoteException {
		try {
			return DatabaseManager.getInstance().getMateriali();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	@Override
	public void setStatoProgetto(String nomeProgetto, String tipoProgetto, String statoOrdine) throws RemoteException {
		try {
			DatabaseManager.getInstance().setStatoProgetto(nomeProgetto, tipoProgetto,statoOrdine);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void setTempoImpiegato(String nomeProgetto, String tipoProgetto, Float tempoImpiegato) throws RemoteException {
		try {
			DatabaseManager.getInstance().setTempoImpiegato(nomeProgetto, tipoProgetto, tempoImpiegato);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}

}
