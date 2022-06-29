package com.group15.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import com.group15.commonclass.Account;
import com.group15.commonclass.Cliente;
import com.group15.commonclass.Evento;
import com.group15.commonenum.StatoOrdine;
import com.group15.commonenum.TipoProgetto;

//metodi per effettuare i test di alcuni metodi principali 

public class ServerTest {
	DatabaseManagerTest database = null;
	Vector <Cliente> listaClienti = null;
	Vector <Account> listaAccounts = null;
	Vector <Evento> listaProgettiEvento = null;
	
	@Before
	public void setUp() throws Exception {
	database = DatabaseManagerTest.getInstance();
	}

	@Test
	public void testGestoreCliente() throws SQLException {
		Cliente cliente = new Cliente(1, "Mario", "Rossi", "mariorossi@hotmail.it", "3331874207");
		
		//addCliente
		database.addCliente(cliente);
		
		listaClienti = database.getClienti();
		assertEquals(listaClienti.elementAt(0).getNome(),"Mario");
		assertEquals(listaClienti.elementAt(0).getCognome(),"Rossi");
		assertEquals(listaClienti.elementAt(0).getEmail(),"mariorossi@hotmail.it");
		assertEquals(listaClienti.elementAt(0).getNumero(),"3331874207");
		
		database.deleteCliente("mariorossi@hotmail.it");
	}
	
	@Test
	public void testGestoreAccount() throws SQLException{
		Account account = new Account("Mario", "Rossi", "mariored", "qwerty");
		
		database.addAccount(account);
		listaAccounts = database.getAccounts();
		
		assertEquals(listaAccounts.elementAt(0).getNome(), "Mario");
		assertEquals(listaAccounts.elementAt(0).getCognome(), "Rossi");
		assertEquals(listaAccounts.elementAt(0).getUsername(), "mariored");
		assertEquals(listaAccounts.elementAt(0).getPassword(), "qwerty");
		
		database.deleteAccount("mariored");
	}
	
	@Test
	public void testGestoreProgetti() throws SQLException{
		Evento evento = new Evento();
		evento.setNomeProgetto("EventoTest");
		evento.setTipoProgetto(TipoProgetto.EVENTO);
		evento.setNumeroDipendentiAssegnati(3);
		evento.setPrezzo(200);
		evento.setScadenza("21 Febbraio 2021");
		evento.setStatoOrdine(StatoOrdine.ACCETTATO);
		evento.setTempoImpiegato(10);
		evento.setIdCliente(1);
		
		database.addProgettoEvento(evento);
		
		listaProgettiEvento = database.getProgettiEvento();
		
		assertEquals(listaProgettiEvento.elementAt(0).getNomeProgetto(), "EventoTest");
		assertEquals(listaProgettiEvento.elementAt(0).getTipoProgetto(), TipoProgetto.EVENTO);
		assertEquals(listaProgettiEvento.elementAt(0).getNumeroDipendentiAssegnati(), 3);
		assertEquals(listaProgettiEvento.elementAt(0).getPrezzo(), 200, 0.0f);
		assertEquals(listaProgettiEvento.elementAt(0).getScadenza(), "21 Febbraio 2021");
		assertEquals(listaProgettiEvento.elementAt(0).getStatoOrdine(), StatoOrdine.ACCETTATO);
		assertEquals(listaProgettiEvento.elementAt(0).getTempoImpiegato(), 10, 0.0f);
		assertEquals(listaProgettiEvento.elementAt(0).getIdCliente(), 1);
		
		database.deleteProgetto("EventoTest", "EVENTO");
		
	}

}
