package com.group15.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.group15.commonclass.*;
import com.group15.commonenum.StatoOrdine;
import com.group15.commonenum.TipoCartellonistica;
import com.group15.commonenum.TipoProgetto;

//Classe di interfaccia diretta al database

public class DatabaseManager {

	private static final String URL = "jdbc:mysql://localhost:3306/marketing_solution?autoReconnect=true&useSSL=false";
	private static final String user = "MsAdmin";
	private static final String password = "MsAdmin";

	private static DatabaseManager instance;
	private Connection connection;

	private DatabaseManager() throws SQLException, ClassNotFoundException{             //Connessione al database
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(URL, user, password);
		System.out.println("Connesso al database");				
	}

	public static DatabaseManager getInstance() throws SQLException, ClassNotFoundException{   //Creazione dell'instance
		if(instance == null)
			instance = new DatabaseManager();
		return instance;
	}


	public boolean checkLogin(String username, String password) throws SQLException {

		String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?;";		// Query da mandare la database
		PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if(rs.next()){                                                               //verifica del login
			rs.close();
			stmt.close();
			System.out.println("Login Riuscito");
			return true;                                                            // il login � riuscito
		}else{
			rs.close();
			stmt.close();
			System.out.println("Login  NON RIuscito");
			return false;	                                                           // il login non � riuscito
		}                                                                     	
	}

	public void addAccount(Account a) throws SQLException {

		String sql = "INSERT INTO accounts(nome,cognome,username,password) VALUES(?,?,?,?);";   //Query da mandare al database
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement
		stmt.setString(1, a.getNome()); 
		stmt.setString(2, a.getCognome());
		stmt.setString(3, a.getUsername());
		stmt.setString(4, a.getPassword());
		stmt.execute();
		stmt.close();		

	}

	public void addCliente(Cliente c) throws SQLException {

		String sql = "INSERT INTO clients(nome,cognome,email,telefono) VALUES(?,?,?,?);";   //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, c.getNome()); 
		stmt.setString(2, c.getCognome());
		stmt.setString(3, c.getEmail());
		stmt.setString(4, c.getNumero());

		stmt.execute();
		stmt.close();		

	}

	public void deleteCliente(String email) throws SQLException{

		String sql = "DELETE FROM clients WHERE email = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);                     
		stmt.setString(1, email);	
		stmt.execute();
		stmt.close();

	}

	public Vector<Cliente> getClienti() throws SQLException{


		Vector<Cliente> listaClienti = new Vector<Cliente>();

		String sql = "SELECT * FROM clients"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			int id = resultSet.getInt("idclients");
			String nome = resultSet.getString("nome"); 
			String cognome = resultSet.getString("cognome"); 
			String email = resultSet.getString("email");
			String telefono = resultSet.getString("telefono");

			Cliente cliente = new Cliente();
			cliente.setIdcliente(id);
			cliente.setNome(nome);
			cliente.setCognome(cognome);
			cliente.setEmail(email);
			cliente.setNumero(telefono);

			listaClienti.add(cliente); 
		}
		statement.close();
		return listaClienti;

	}



	public Vector<Cartellonistica> getProgettiCartellonistica() throws SQLException{

		Vector<Cartellonistica>  listaProgetti= new Vector<Cartellonistica>();

		String sql = "SELECT * FROM progetticartellonistica"; 

		PreparedStatement statement = connection.prepareStatement(sql); 
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			String  nomeProgetto = resultSet.getString("nome"); 

			String tipoProgetto = resultSet.getString("tipoprogetto"); 

			float prezzo = resultSet.getFloat("prezzo");

			float tempoImpiegato = resultSet.getFloat("tempoimpiegato");

			String statoProgetto = resultSet.getString("statoordine");

			int idCliente = resultSet.getInt("idcliente");

			int numeroDipendentiAssegnati = resultSet.getInt("ndipendentiassegnati");

			String tipoCartelloni = resultSet.getString("tipocartelloni");



			int proposta1 = resultSet.getInt("proposta1");
			int quantita1 = resultSet.getInt("quantita1");
			float altezza1 = resultSet.getFloat("altezza1");

			float larghezza1 = resultSet.getFloat("larghezza1");

			int proposta2 = resultSet.getInt("proposta2");
			int quantita2 = resultSet.getInt("quantita2");
			float altezza2= resultSet.getFloat("altezza2");

			float larghezza2 = resultSet.getFloat("larghezza2");

			String scadenza = resultSet.getString("scadenza");



			Cartellonistica c = new Cartellonistica();

			c.setNomeProgetto(nomeProgetto);

			switch(tipoProgetto){
			case "CARTELLONISTICA":
				c.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				break;
			case "EVENTO":
				c.setTipoProgetto(TipoProgetto.EVENTO);
				break;
			case "FIERA":
				c.setTipoProgetto(TipoProgetto.FIERA);
				break;
			case "ONLINE":
				c.setTipoProgetto(TipoProgetto.ONLINE);
				break;
			case "STAMPA":
				c.setTipoProgetto(TipoProgetto.STAMPA);
				break;
			default:
				break;
			}


			c.setPrezzo(prezzo);

			c.setTempoImpiegato(tempoImpiegato);

			switch(statoProgetto){
			case "PREVENTIVATO":
				c.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				break;
			case "NEGOZIAZIONE":
				c.setStatoOrdine(StatoOrdine.NEGOZIAZIONE);
				break;
			case "ACCETTATO":
				c.setStatoOrdine(StatoOrdine.ACCETTATO);
				break;
			case "FATTURATO":
				c.setStatoOrdine(StatoOrdine.FATTURATO);
				break;
			case "PAGATO":
				c.setStatoOrdine(StatoOrdine.PAGATO);
				break;
			default:
				break;
			}


			c.setIdCliente(idCliente);
			c.setScadenza(scadenza);
			c.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);

			switch(tipoCartelloni){
			case "STRADALE":
				c.setTipoCartelloni(TipoCartellonistica.STRADALE);
				break;
			case "INTERNI":
				c.setTipoCartelloni(TipoCartellonistica.INTERNI);
				break;
			default:
				break;
			}



			if(proposta1 == 1){
				c.setProposta1(true);
				c.setQuantita1(quantita1);
				c.setAltezza1(altezza1);
				c.setLarghezza1(larghezza1);

			}else{
				c.setProposta1(false);
			}

			if(proposta2== 1){
				c.setProposta2(true);
				c.setQuantita2(quantita2);
				c.setAltezza2(altezza2);
				c.setLarghezza2(larghezza2);

			}else{
				c.setProposta2(false);
			}




			listaProgetti.add(c); 
		}
		statement.close();
		return listaProgetti;
	}


	public Vector<Evento> getProgettiEvento() throws SQLException{


		Vector<Evento>  listaProgettiEvento= new Vector<Evento>();

		String sql = "SELECT * FROM progettievento"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			String  nomeProgetto = resultSet.getString("nome"); 
			String tipoProgetto = resultSet.getString("tipoprogetto"); 
			String statoProgetto = resultSet.getString("statoordine");
			float prezzo = resultSet.getFloat("prezzo");		
			int idCliente = resultSet.getInt("idcliente");
			String scadenza = resultSet.getString("scadenza");
			int numeroDipendentiAssegnati = resultSet.getInt("ndipendentiassegnati");
			float tempoImpiegato = resultSet.getFloat("tempoImpiegato");

			Evento e = new Evento();

			e.setNomeProgetto(nomeProgetto);

			switch(tipoProgetto){
			case "CARTELLONISTICA":
				e.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				break;
			case "EVENTO":
				e.setTipoProgetto(TipoProgetto.EVENTO);
				break;
			case "FIERA":
				e.setTipoProgetto(TipoProgetto.FIERA);
				break;
			case "ONLINE":
				e.setTipoProgetto(TipoProgetto.ONLINE);
				break;
			case "STAMPA":
				e.setTipoProgetto(TipoProgetto.STAMPA);
				break;
			default:
				break;
			}


			switch(statoProgetto){
			case "PREVENTIVATO":
				e.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				break;
			case "NEGOZIAZIONE":
				e.setStatoOrdine(StatoOrdine.NEGOZIAZIONE);
				break;
			case "ACCETTATO":
				e.setStatoOrdine(StatoOrdine.ACCETTATO);
				break;
			case "FATTURATO":
				e.setStatoOrdine(StatoOrdine.FATTURATO);
				break;
			case "PAGATO":
				e.setStatoOrdine(StatoOrdine.PAGATO);
				break;
			default:
				break;
			}

			e.setPrezzo(prezzo);
			e.setScadenza(scadenza);
			e.setIdCliente(idCliente);
			e.setTempoImpiegato(tempoImpiegato);
			e.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);

			listaProgettiEvento.add(e); 
		}
		statement.close();
		return listaProgettiEvento;
	}

	public Vector<Fiera> getProgettiFiera() throws SQLException{

		Vector<Fiera>  listaProgetti= new Vector<Fiera>();

		String sql = "SELECT * FROM progettifiera"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			String  nomeProgetto = resultSet.getString("nome"); 

			String tipoProgetto = resultSet.getString("tipoprogetto"); 

			float prezzo = resultSet.getFloat("prezzo");

			float tempoImpiegato = resultSet.getFloat("tempoimpiegato");

			String statoProgetto = resultSet.getString("statoordine");

			int idCliente = resultSet.getInt("idcliente");

			int proposta1 = resultSet.getInt("proposta1");

			int proposta2 = resultSet.getInt("proposta2");

			String descrizione = resultSet.getString("descrizione");

			String scadenza = resultSet.getString("scadenza");
			int numeroDipendentiAssegnati = resultSet.getInt("ndipendentiassegnati");


			Fiera f = new Fiera();

			f.setNomeProgetto(nomeProgetto);

			switch(tipoProgetto){
			case "CARTELLONISTICA":
				f.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				break;
			case "EVENTO":
				f.setTipoProgetto(TipoProgetto.EVENTO);
				break;
			case "FIERA":
				f.setTipoProgetto(TipoProgetto.FIERA);
				break;
			case "ONLINE":
				f.setTipoProgetto(TipoProgetto.ONLINE);
				break;
			case "STAMPA":
				f.setTipoProgetto(TipoProgetto.STAMPA);
				break;
			default:
				break;
			}


			f.setPrezzo(prezzo);

			f.setTempoImpiegato(tempoImpiegato);

			switch(statoProgetto){
			case "PREVENTIVATO":
				f.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				break;
			case "NEGOZIAZIONE":
				f.setStatoOrdine(StatoOrdine.NEGOZIAZIONE);
				break;
			case "ACCETTATO":
				f.setStatoOrdine(StatoOrdine.ACCETTATO);
				break;
			case "FATTURATO":
				f.setStatoOrdine(StatoOrdine.FATTURATO);
				break;
			case "PAGATO":
				f.setStatoOrdine(StatoOrdine.PAGATO);
				break;
			default:
				break;
			}


			f.setIdCliente(idCliente);
			f.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);

			if(proposta1 == 1){
				f.setProposta1(true);


			}else{
				f.setProposta1(false);
			}

			if(proposta2== 1){
				f.setProposta2(true);


			}else{
				f.setProposta2(false);
			}



			f.setDescrizione(descrizione);


			f.setScadenza(scadenza);


			listaProgetti.add(f); 
		}
		statement.close();
		return listaProgetti;
	}

	public Vector<Online> getProgettiOnline() throws SQLException{

		Vector<Online>  listaProgetti= new Vector<Online>();

		String sql = "SELECT * FROM progettionline"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			String  nomeProgetto = resultSet.getString("nome"); 

			String tipoProgetto = resultSet.getString("tipoprogetto"); 

			float prezzo = resultSet.getFloat("prezzo");

			float tempoImpiegato = resultSet.getFloat("tempoimpiegato");

			String statoProgetto = resultSet.getString("statoordine");

			int idCliente = resultSet.getInt("idcliente");

			String scadenza = resultSet.getString("scadenza");

			int numeroDipendentiAssegnati = resultSet.getInt("ndipendentiassegnati");


			int banner = resultSet.getInt("banner");

			int sfondo = resultSet.getInt("sfondo");

			int inserzioneRettangolare = resultSet.getInt("inserzionerettangolare");

			float altezza = resultSet.getFloat("altezza");

			float larghezza = resultSet.getFloat("larghezza");

			int inserzioneQuadrata = resultSet.getInt("inserzionequadrata");

			float lato = resultSet.getFloat("lato");





			Online o = new Online();

			o.setNomeProgetto(nomeProgetto);

			switch(tipoProgetto){
			case "CARTELLONISTICA":
				o.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				break;
			case "EVENTO":
				o.setTipoProgetto(TipoProgetto.EVENTO);
				break;
			case "FIERA":
				o.setTipoProgetto(TipoProgetto.FIERA);
				break;
			case "ONLINE":
				o.setTipoProgetto(TipoProgetto.ONLINE);
				break;
			case "STAMPA":
				o.setTipoProgetto(TipoProgetto.STAMPA);
				break;
			default:
				break;
			}


			o.setPrezzo(prezzo);

			o.setTempoImpiegato(tempoImpiegato);

			switch(statoProgetto){
			case "PREVENTIVATO":
				o.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				break;
			case "NEGOZIAZIONE":
				o.setStatoOrdine(StatoOrdine.NEGOZIAZIONE);
				break;
			case "ACCETTATO":
				o.setStatoOrdine(StatoOrdine.ACCETTATO);
				break;
			case "FATTURATO":
				o.setStatoOrdine(StatoOrdine.FATTURATO);
				break;
			case "PAGATO":
				o.setStatoOrdine(StatoOrdine.PAGATO);
				break;
			default:
				break;
			}


			o.setIdCliente(idCliente);
			o.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);

			if(banner== 1){
				o.setBanner(true);

			}else{
				o.setBanner(false);
			}

			if(sfondo == 1){
				o.setSfondo(true);

			}else{
				o.setSfondo(false);
			}


			if(inserzioneRettangolare == 1){
				o.setInserzioneRettangolare(true);
				o.setAltezza(altezza);
				o.setLarghezza(larghezza);

			}else{
				o.setInserzioneRettangolare(false);
			}

			if(inserzioneQuadrata == 1){
				o.setInserzioneQuadrata(true);
				o.setLato(lato);


			}else{
				o.setInserzioneQuadrata(false);
			}

			o.setScadenza(scadenza);


			listaProgetti.add(o); 
		}
		statement.close();
		return listaProgetti;
	}


	public Vector<Stampa> getProgettiStampa() throws SQLException{

		Vector<Stampa>  listaProgetti= new Vector<Stampa>();

		String sql = "SELECT * FROM progettistampa"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 

			String  nomeProgetto = resultSet.getString("nome"); 

			String tipoProgetto = resultSet.getString("tipoprogetto"); 

			float prezzo = resultSet.getFloat("prezzo");

			float tempoImpiegato = resultSet.getFloat("tempoimpiegato");

			String statoProgetto = resultSet.getString("statoordine");

			int idCliente = resultSet.getInt("idcliente");

			String scadenza = resultSet.getString("scadenza");

			int numeroDipendentiAssegnati = resultSet.getInt("ndipendentiassegnati");

			int proposta1 = resultSet.getInt("proposta1");
			int quantita1 = resultSet.getInt("quantita1");


			int proposta2 = resultSet.getInt("proposta2");
			int quantita2 = resultSet.getInt("quantita2");

			int proposta3 = resultSet.getInt("proposta3");
			int quantita3= resultSet.getInt("quantita3");

			float altezza = resultSet.getFloat("altezza");
			float larghezza = resultSet.getFloat("larghezza");




			Stampa s = new Stampa();

			s.setNomeProgetto(nomeProgetto);

			switch(tipoProgetto){
			case "CARTELLONISTICA":
				s.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				break;
			case "EVENTO":
				s.setTipoProgetto(TipoProgetto.EVENTO);
				break;
			case "FIERA":
				s.setTipoProgetto(TipoProgetto.FIERA);
				break;
			case "ONLINE":
				s.setTipoProgetto(TipoProgetto.ONLINE);
				break;
			case "STAMPA":
				s.setTipoProgetto(TipoProgetto.STAMPA);
				break;
			default:
				break;
			}


			s.setPrezzo(prezzo);

			s.setTempoImpiegato(tempoImpiegato);

			switch(statoProgetto){
			case "PREVENTIVATO":
				s.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				break;
			case "NEGOZIAZIONE":
				s.setStatoOrdine(StatoOrdine.NEGOZIAZIONE);
				break;
			case "ACCETTATO":
				s.setStatoOrdine(StatoOrdine.ACCETTATO);
				break;
			case "FATTURATO":
				s.setStatoOrdine(StatoOrdine.FATTURATO);
				break;
			case "PAGATO":
				s.setStatoOrdine(StatoOrdine.PAGATO);
				break;
			default:
				break;
			}


			s.setIdCliente(idCliente);
			s.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);

			s.setQuantita1(quantita1);

			if(proposta1 == 1){
				s.setProposta1(true);
				s.setQuantita1(quantita1);
			}else{
				s.setProposta1(false);
			}

			if(proposta2== 1){
				s.setProposta2(true);
				s.setQuantita2(quantita2);
			}else{
				s.setProposta2(false);
			}

			if(proposta3== 1){
				s.setProposta3(true);
				s.setQuantita3(quantita3);
			}else{
				s.setProposta3(false);
			}

			s.setAltezza(altezza);
			s.setLarghezza(larghezza);
			s.setScadenza(scadenza);


			listaProgetti.add(s); 
		}
		statement.close();
		return listaProgetti;
	}



	public void addProgettoCartellonistica(Cartellonistica c) throws SQLException {

		String sql = "INSERT INTO progetticartellonistica(nome,tipoprogetto,prezzo,tempoimpiegato,statoordine,idcliente,scadenza,ndipendentiassegnati,tipocartelloni,proposta1,quantita1,altezza1,larghezza1,proposta2,quantita2,altezza2,larghezza2) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";   //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, c.getNomeProgetto()); 
		stmt.setString(2, c.getTipoProgetto().toString());
		stmt.setFloat(3, c.getPrezzo());
		stmt.setFloat(4, c.getTempoImpiegato());
		stmt.setString(5, c.getStatoOrdine().toString());
		stmt.setInt(6, c.getIdCliente()); 
		stmt.setString(7, c.getScadenza());
		stmt.setInt(8, c.getNumeroDipendentiAssegnati());

		stmt.setString(9, c.getTipoCartelloni().toString());

		if(c.getProposta1()){
			stmt.setInt(10, 1);
			stmt.setInt(11, c.getQuantita1());
			stmt.setFloat(12, c.getAltezza1());
			stmt.setFloat(13, c.getLarghezza1());
		}else{
			stmt.setInt(10, 0);	
			stmt.setInt(11, 0);
			stmt.setFloat(12, 0);
			stmt.setFloat(13, 0);
		}


		if(c.getProposta2()){
			stmt.setInt(14, 1);
			stmt.setInt(15, c.getQuantita2());
			stmt.setFloat(16, c.getAltezza2());
			stmt.setFloat(17, c.getLarghezza2());
		}else{
			stmt.setInt(14, 0);	
			stmt.setInt(15, 0);
			stmt.setFloat(16,0);
			stmt.setFloat(17, 0);
		}

		stmt.execute();
		stmt.close();		

	}


	public void addProgettoEvento(Evento e) throws SQLException {

		String sql = "INSERT INTO progettievento(nome,tipoprogetto,prezzo,tempoimpiegato,statoordine,idcliente,scadenza,ndipendentiassegnati) VALUES(?,?,?,?,?,?,?,?)"; //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, e.getNomeProgetto()); 
		stmt.setString(2, e.getTipoProgetto().toString());
		stmt.setFloat(3, e.getPrezzo());
		stmt.setFloat(4, e.getTempoImpiegato());
		stmt.setString(5, e.getStatoOrdine().toString());
		stmt.setInt(6, e.getIdCliente()); 
		stmt.setString(7, e.getScadenza());
		stmt.setInt(8, e.getNumeroDipendentiAssegnati());


		stmt.execute();
		stmt.close();		

	}

	public void addProgettoFiera(Fiera f) throws SQLException {

		String sql = "INSERT INTO progettifiera(nome,tipoprogetto,prezzo,tempoimpiegato,statoordine,idcliente,scadenza,ndipendentiassegnati,proposta1,proposta2,descrizione) VALUES(?,?,?,?,?,?,?,?,?,?,?)"; //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, f.getNomeProgetto()); 
		stmt.setString(2, f.getTipoProgetto().toString());
		stmt.setFloat(3, f.getPrezzo());
		stmt.setFloat(4, f.getTempoImpiegato());
		stmt.setString(5, f.getStatoOrdine().toString());
		stmt.setInt(6, f.getIdCliente()); 
		stmt.setString(7, f.getScadenza());
		stmt.setInt(8, f.getNumeroDipendentiAssegnati());

		if(f.getProposta1()){
			stmt.setInt(9, 1);

		}else{
			stmt.setInt(9, 0);	
		}


		if(f.getProposta2()){
			stmt.setInt(10, 1);

		}else{
			stmt.setInt(10, 0);	
		}


		stmt.setString(11, f.getDescrizione());

		stmt.execute();
		stmt.close();		
	}


	public void addProgettoOnline(Online o) throws SQLException {

		String sql = "INSERT INTO progettionline(nome,tipoprogetto,prezzo,tempoimpiegato,statoordine,idcliente,scadenza,ndipendentiassegnati,banner,sfondo,inserzionerettangolare,altezza,larghezza,inserzionequadrata,lato) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, o.getNomeProgetto()); 
		stmt.setString(2, o.getTipoProgetto().toString());
		stmt.setFloat(3, o.getPrezzo());
		stmt.setFloat(4, o.getTempoImpiegato());
		stmt.setString(5, o.getStatoOrdine().toString());
		stmt.setInt(6, o.getIdCliente()); 
		stmt.setString(7, o.getScadenza());
		stmt.setInt(8, o.getNumeroDipendentiAssegnati());

		if(o.getBanner()){
			stmt.setInt(9, 1);
		}else{
			stmt.setInt(9, 0);	
		}


		if(o.getSfondo()){
			stmt.setInt(10, 1);
		}else{
			stmt.setInt(10, 0);	
		}


		if(o.getInserzioneRettangolare()){
			stmt.setInt(11, 1);
			stmt.setFloat(12, o.getAltezza());
			stmt.setFloat(13, o.getLarghezza());
		}else{
			stmt.setInt(11, 0);	
			stmt.setFloat(12, 0);
			stmt.setFloat(13, 0);
		}

		if(o.getInserzioneQuadrata()){
			stmt.setInt(14, 1);
			stmt.setFloat(15, o.getLato());
		}else{
			stmt.setInt(14, 0);	
			stmt.setFloat(15, 0);
		}

		stmt.execute();
		stmt.close();		
	}

	public void addProgettoStampa(Stampa s) throws SQLException {

		String sql = "INSERT INTO progettistampa(nome,tipoprogetto,prezzo,tempoimpiegato,statoordine,idcliente,scadenza,ndipendentiassegnati,proposta1,quantita1,proposta2,quantita2,proposta3,quantita3,altezza,larghezza) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, s.getNomeProgetto()); 
		stmt.setString(2, s.getTipoProgetto().toString());
		stmt.setFloat(3, s.getPrezzo());
		stmt.setFloat(4, s.getTempoImpiegato());
		stmt.setString(5, s.getStatoOrdine().toString());
		stmt.setInt(6, s.getIdCliente()); 
		stmt.setString(7, s.getScadenza());
		stmt.setInt(8, s.getNumeroDipendentiAssegnati());

		if(s.getProposta1()){
			stmt.setInt(9, 1);
			stmt.setInt(10, s.getQuantita1());

		}else{
			stmt.setInt(9, 0);	
			stmt.setInt(10, 0);
		}


		if(s.getProposta2()){
			stmt.setInt(11, 1);
			stmt.setInt(12, s.getQuantita2());

		}else{
			stmt.setInt(11, 0);	
			stmt.setInt(12, 0);
		}


		if(s.getProposta3()){
			stmt.setInt(13, 1);
			stmt.setInt(14, s.getQuantita3());

		}else{
			stmt.setInt(13, 0);	
			stmt.setInt(14, 0);
		}

		stmt.setFloat(15, s.getAltezza());
		stmt.setFloat(16, s.getLarghezza());

		stmt.execute();
		stmt.close();		
	}


	public void addServizioEsterno(ServizioEsterno se) throws SQLException{

		String sql = "INSERT INTO serviziesterni(nome,prezzo,nomeprogetto) VALUES(?,?,?);";   //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, se.getNome()); 
		stmt.setFloat(2, se.getPrezzo());
		stmt.setString(3, se.getIdProgetto());

		stmt.execute();
		stmt.close();	
	}

	public void setStatoProgetto(String nomeProgetto, String tipoProgetto, String statoOrdine) throws SQLException{

		if(tipoProgetto.equals("STAMPA")){
			String sql = "UPDATE marketing_solution.progettistampa SET statoordine=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, statoOrdine);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("ONLINE")){
			String sql = "UPDATE marketing_solution.progettionline SET statoordine=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, statoOrdine);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("EVENTO")){
			String sql = "UPDATE marketing_solution.progettievento SET statoordine=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, statoOrdine);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("FIERA")){
			String sql = "UPDATE marketing_solution.progettifiera SET statoordine=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, statoOrdine);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("CARTELLONISTICA")){
			String sql = "UPDATE marketing_solution.progetticartellonistica SET statoordine=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setString(1, statoOrdine);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
	}


	public void setTempoImpiegato(String nomeProgetto, String tipoProgetto, Float tempoImpiegato) throws SQLException{
		if(tipoProgetto.equals("STAMPA")){
			String sql = "UPDATE marketing_solution.progettistampa SET tempoimpiegato=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setFloat(1, tempoImpiegato);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("ONLINE")){
			String sql = "UPDATE marketing_solution.progettionline SET tempoimpiegato=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setFloat(1,tempoImpiegato);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("EVENTO")){
			String sql = "UPDATE marketing_solution.progettievento SET tempoimpiegato=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setFloat(1, tempoImpiegato);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("FIERA")){
			String sql = "UPDATE marketing_solution.progettifiera SET tempoimpiegato=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setFloat(1, tempoImpiegato);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
		if(tipoProgetto.equals("CARTELLONISTICA")){
			String sql = "UPDATE marketing_solution.progetticartellonistica SET tempoimpiegato=? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(sql); 
			statement.setFloat(1, tempoImpiegato);
			statement.setString(2, nomeProgetto);
			statement.execute();
			statement.close();
		}
	}

	public void deleteProgetto(String nomeProgetto,String tipoProgetto) throws SQLException{

		if(tipoProgetto.equals("STAMPA")){
			String sql = "DELETE FROM progettistampa WHERE nome = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
			stmt.setString(1, nomeProgetto);	
			stmt.execute();
			stmt.close();
		}
		if(tipoProgetto.equals("ONLINE")){
			String sql = "DELETE FROM progettionline WHERE nome = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
			stmt.setString(1, nomeProgetto);	
			stmt.execute();
			stmt.close();
		}
		if(tipoProgetto.equals("EVENTO")){
			String sql = "DELETE FROM progettievento WHERE nome = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
			stmt.setString(1, nomeProgetto);	
			stmt.execute();
			stmt.close();
			
			
			String sql2 = "DELETE FROM serviziesterni WHERE nomeprogetto = ?";
			PreparedStatement stmt2 = connection.prepareStatement(sql2);                     //  Creazione dello statement
			stmt2.setString(1, nomeProgetto);	
			stmt2.execute();
			stmt2.close();
		}
		if(tipoProgetto.equals("FIERA")){
			String sql = "DELETE FROM progettifiera WHERE nome = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
			stmt.setString(1, nomeProgetto);	
			stmt.execute();
			stmt.close();
		}
		if(tipoProgetto.equals("CARTELLONISTICA")){
			String sql = "DELETE FROM progetticartellonistica WHERE nome = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
			stmt.setString(1, nomeProgetto);	
			stmt.execute();
			stmt.close();
		}
		
		
		String sql = "DELETE FROM materiali WHERE nomeprogetto = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
		stmt.setString(1, nomeProgetto);	
		stmt.execute();
		stmt.close();
		
		
		

	}





	public Vector<ServizioEsterno> getServiziEsterni() throws SQLException{
		Vector<ServizioEsterno> listaServizi = new Vector<ServizioEsterno>();

		String sql = "SELECT * FROM serviziesterni"; 
		PreparedStatement statement = connection.prepareStatement(sql); 
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 
			String nomeServizio = resultSet.getString("nome");
			Float prezzo = resultSet.getFloat("prezzo");
			String idProgetto = resultSet.getString("nomeprogetto");
			ServizioEsterno se = new ServizioEsterno();
			se.setNome(nomeServizio);
			se.setPrezzo(prezzo);
			se.setIdProgetto(idProgetto);
			listaServizi.add(se);
		}
		statement.close();
		return listaServizi;
	}

	public Vector<Materiale> getMateriali() throws SQLException {
		Vector<Materiale> listaServizi = new Vector<Materiale>();

		String sql = "SELECT * FROM materiali"; 
		PreparedStatement statement = connection.prepareStatement(sql); 
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 
			String nomeServizio = resultSet.getString("nome");
			Float prezzo = resultSet.getFloat("prezzo");
			String idProgetto = resultSet.getString("nomeprogetto");
			Materiale m = new Materiale();
			m.setNome(nomeServizio);
			m.setPrezzo(prezzo);
			m.setNomeProgetto(idProgetto);
			listaServizi.add(m);
		}
		statement.close();
		return listaServizi;
	}

	public Vector<Account> getAccounts() throws SQLException {
		Vector<Account> listaAccounts = new Vector<Account>();

		String sql = "SELECT * FROM accounts"; 
		PreparedStatement statement = connection.prepareStatement(sql); 

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) { 


			String nome = resultSet.getString("nome"); 
			String cognome = resultSet.getString("cognome"); 
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");

			Account a = new Account();
			a.setNome(nome);
			a.setCognome(cognome);
			a.setUsername(username);
			a.setPassword(password);
			listaAccounts.add(a); 
		}
		statement.close();
		return listaAccounts;
	}

	public void deleteAccount(String username) throws SQLException {
		String sql = "DELETE FROM accounts WHERE username = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);                     //  Creazione dello statement
		stmt.setString(1, username);	
		stmt.execute();
		stmt.close();
	}

	public void addMateriale(Materiale m) throws SQLException {
		String sql = "INSERT INTO materiali(nome,prezzo,nomeprogetto) VALUES(?,?,?);";   //Query da mandare al database		
		PreparedStatement stmt = connection.prepareStatement(sql);                             //Creazione dello statement

		stmt.setString(1, m.getNome()); 
		stmt.setFloat(2, m.getPrezzo());
		stmt.setString(3, m.getNomeProgetto());

		stmt.execute();
		stmt.close();
		
	}

}
