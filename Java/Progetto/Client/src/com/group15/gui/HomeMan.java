package com.group15.gui;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.rmi.RemoteException;

import java.util.Vector;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableModel;

import com.group15.client.*;
import com.group15.commonclass.*;

import junit.framework.Test;

import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//"home page" --> pannello di gestione

public class HomeMan {

	private ImageIcon imgCli = new ImageIcon(Test.class.getResource("/cliente.png"));
	private ImageIcon imgProg = new ImageIcon(Test.class.getResource("/progetti.png"));
	private ImageIcon imgAcc = new ImageIcon(Test.class.getResource("/account.png"));
	private ImageIcon imgLog = new ImageIcon(Test.class.getResource("/logout.png"));
	private ImageIcon imgEsc = new ImageIcon(Test.class.getResource("/exit1.png"));

	private JLabel titolo = new JLabel("Lista Clienti");
	private JLabel titolo2 = new JLabel("Lista Progetti");
	private JLabel titolo3 = new JLabel("Gestione Accounts");


	private JScrollPane spClienti = new JScrollPane();
	private JScrollPane spProgetti = new JScrollPane();
	private JScrollPane spAccounts = new JScrollPane();

	private JButton rimCliente;
	private JButton aggCliente;
	private JButton rimProgetto;
	private JButton aggProgetto;
	private JButton rimAccount;
	private JButton aggAccount;
	private JButton showProgetto;

	private static JTable table;
	private static JTable table_1;
	private static JTable table_2;

	private static DefaultTableModel model;
	private static DefaultTableModel model_1;
	private static DefaultTableModel model_2;

	private static Vector<Cliente> listaClienti = null;
	private static Vector<Cartellonistica> listaProgettiCartellonistica = null;
	private static Vector<Evento> listaProgettiEvento = null;
	private static Vector<Fiera> listaProgettiFiera = null;
	private static Vector<Online> listaProgettiOnline = null;
	private static Vector<Stampa> listaProgettiStampa = null;
	private static Vector<Account>listaAccounts = null;

	private String username;
	private String email;
	private String tipoProgetto;
	private String nomeProgetto;
	private int idCliente;
	static JFrame frame;

	/**
	 * Launch the application.
	 */

	public static void attiva(){
		frame.setEnabled(true);
		frame.setVisible(true);
	}

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMan window = new HomeMan();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeMan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//Prendo dimensioni dello schermo
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize(width*90/100, height*90/100);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);


		//PANNELLO_SX
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frame.getWidth()*20/100, frame.getHeight());
		panel.setBackground(new Color(70,80,90));
		frame.getContentPane().add(panel);
		panel.setLayout(null);



		//PANNELLO_DX con FINESTRA PROGETTI		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(frame.getWidth()*20/100, 0, frame.getWidth()*80/100, frame.getHeight());
		panel_2.setBackground(new Color(237,235,237));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);

		//FINESTRA PROGETTI
		titolo2.setFont(new Font("Arial", Font.PLAIN, 40));
		titolo2.setHorizontalAlignment(SwingConstants.CENTER);
		titolo2.setBounds(0, panel_2.getHeight()*5/100, panel_2.getWidth(), panel_2.getHeight()*10/100);
		titolo2.setForeground(new Color(104,78,50));
		panel_2.add(titolo2);

		spProgetti.setBounds(panel_2.getWidth()*5/100, panel_2.getHeight()*20/100, panel_2.getWidth()*90/100, panel_2.getHeight()*50/100);
		spProgetti.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		panel_2.add(spProgetti);

		table_1 = new JTable(new DefaultTableModel(null, new Object[]{"Nome Progetto", "Genere", "Scadenza", "Prezzo","Stato Ordine" }));
		refreshTableProgetti();

		table_1.setAutoCreateColumnsFromModel(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setSelectionForeground(new Color(0, 0, 0));
		table_1.setSelectionBackground(new Color(192, 192, 192));
		table_1.setFont(new Font("Arial", Font.PLAIN, 12));
		table_1.setRowHeight(30);
		spProgetti.setViewportView(table_1);

		table_1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				nomeProgetto =(String) table_1.getModel().getValueAt(table_1.getSelectedRow(), 0);
				tipoProgetto =(String) table_1.getModel().getValueAt(table_1.getSelectedRow(), 1);
			}						
		});


		rimProgetto = new JButton("Rimuovi Progetto");
		rimProgetto.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					Client.deleteProgetto(nomeProgetto, tipoProgetto);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTableProgetti();
			}
		});	
		rimProgetto.setBounds(panel_2.getWidth()*25/100, panel_2.getHeight()*75/100, panel_2.getWidth()*17/100, panel_2.getHeight()*5/100);
		rimProgetto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(rimProgetto);




		showProgetto = new JButton("Mostra Progetto");
		showProgetto.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				showInfoProgetto();

			}
		});	
		showProgetto.setBounds(panel_2.getWidth()*5/100, panel_2.getHeight()*75/100, panel_2.getWidth()*17/100, panel_2.getHeight()*5/100);
		showProgetto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(showProgetto);



		JButton	setStatoProgetto = new JButton("Modifica stato progetto");
		setStatoProgetto.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				frame.setEnabled(false);
				SetStatoProgetto.open(nomeProgetto, tipoProgetto);
			}
		});		
		setStatoProgetto.setBounds(panel_2.getWidth()*68/100,panel_2.getHeight()*75/100, panel_2.getWidth()*20/100,panel_2.getHeight()*5/100);
		panel_2.add(setStatoProgetto);

		JButton	setTempoImpiegato = new JButton("Imposta tempo impiegato");
		setTempoImpiegato.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){
				frame.setEnabled(false);
				SetTempoImpiegato.open(nomeProgetto, tipoProgetto);
			}
		});		
		setTempoImpiegato.setBounds(panel_2.getWidth()*45/100,panel_2.getHeight()*75/100, panel_2.getWidth()*20/100,panel_2.getHeight()*5/100);
		panel_2.add(setTempoImpiegato);





		//PANNELLO_DX con FINESTRA CLIENTI
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(frame.getWidth()*20/100, 0, frame.getWidth()*80/100, frame.getHeight());
		panel_1.setBackground(new Color(237,235,237));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		//FINESTRA CLIENTI
		titolo.setFont(new Font("Arial", Font.PLAIN, 40));
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBounds(0, panel_1.getHeight()*5/100, panel_1.getWidth(), panel_1.getHeight()*10/100);
		titolo.setForeground(new Color(104,78,50));
		panel_1.add(titolo);

		spClienti.setBounds(panel_1.getWidth()*5/100, panel_1.getHeight()*20/100, panel_1.getWidth()*90/100, panel_1.getHeight()*50/100);
		spClienti.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		panel_1.add(spClienti);

		table = new JTable(new DefaultTableModel(null, new Object[]{"Nome", "Cognome", "Email", "Telefono"}));		
		refreshTableClienti();   


		table.setAutoCreateColumnsFromModel(false);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionBackground(new Color(192, 192, 192));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setRowHeight(30);
		spClienti.setViewportView(table);

		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				email = (String) table.getModel().getValueAt(table.getSelectedRow(), 2);	
			}						
		});

		aggCliente = new JButton("Aggiungi Cliente");
		aggCliente.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){
				frame.setEnabled(false);
				AddCliente.open();
			}
		});


		rimCliente = new JButton("Rimuovi Cliente");
		rimCliente.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				deleteCliente();
				refreshTableClienti();
				refreshTableProgetti();

			}

		});
		aggCliente.setBounds(panel_1.getWidth()*5/100, panel_1.getHeight()*75/100, panel_1.getWidth()*15/100, panel_1.getHeight()*5/100);
		aggCliente.setHorizontalAlignment(SwingConstants.CENTER);
		rimCliente.setBounds(panel_1.getWidth()*25/100, panel_1.getHeight()*75/100, panel_1.getWidth()*15/100, panel_1.getHeight()*5/100);
		rimCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(aggCliente);
		panel_1.add(rimCliente);



		aggProgetto = new JButton("Aggiungi Progetto");
		aggProgetto.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){

				try {
					listaClienti = Client.getClienti();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i=0; i<listaClienti.size(); i++){
					if(listaClienti.elementAt(i).getEmail().equals(email)){
						idCliente = listaClienti.elementAt(i).getIdcliente();
					}
				}
				AddProgetto.open(idCliente);			
			}
		});
		aggProgetto.setBounds(panel_2.getWidth()*45/100, panel_2.getHeight()*75/100, panel_2.getWidth()*15/100, panel_2.getHeight()*5/100);
		aggProgetto.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(aggProgetto);

		//PANNELLO DX con ACCOUNT
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(frame.getWidth()*20/100, 0, frame.getWidth()*80/100, frame.getHeight());
		panel_3.setBackground(new Color(237,235,237));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);

		titolo3.setFont(new Font("Arial", Font.PLAIN, 40));
		titolo3.setHorizontalAlignment(SwingConstants.CENTER);
		titolo3.setBounds(0, panel_3.getHeight()*5/100, panel_3.getWidth(), panel_3.getHeight()*10/100);
		titolo3.setForeground(new Color(104,78,50));
		panel_3.add(titolo3);

		spAccounts.setBounds(panel_3.getWidth()*5/100, panel_3.getHeight()*20/100, panel_3.getWidth()*90/100, panel_3.getHeight()*50/100);
		spAccounts.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		panel_3.add(spAccounts);

		table_2 = new JTable(new DefaultTableModel(null, new Object[]{"Nome", "Cognome", "Username",}));		 
		refreshTableAccounts();

		table_2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				username = (String) table_2.getModel().getValueAt(table_2.getSelectedRow(), 2);
			}						
		});
		
		table_2.setAutoCreateColumnsFromModel(false);
		table_2.setDefaultEditor(Object.class, null);
		table_2.setSelectionForeground(new Color(0, 0, 0));
		table_2.setSelectionBackground(new Color(192, 192, 192));
		table_2.setFont(new Font("Arial", Font.PLAIN, 12));
		table_2.setRowHeight(30);
		spAccounts.setViewportView(table_2);

		//ACCOUNT
		aggAccount = new JButton("Aggiungi Account");
		aggAccount.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				AddAccount.open();
				
			}
		});

		aggAccount.setBounds(panel_1.getWidth()*5/100, panel_1.getHeight()*75/100, panel_1.getWidth()*15/100, panel_1.getHeight()*5/100);
		aggAccount.setHorizontalAlignment(SwingConstants.CENTER);

		rimAccount = new JButton("Rimuovi Account");
		rimAccount.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try {
					Client.deleteAccount(username);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				refreshTableAccounts();
			}
		});
		
		rimAccount.setBounds(panel_1.getWidth()*25/100, panel_1.getHeight()*75/100, panel_1.getWidth()*15/100, panel_1.getHeight()*5/100);
		rimAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(aggAccount);
		panel_3.add(rimAccount);


		//CLIENTI
		JLabel lblNewLabel = new JLabel("Clienti");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(70,80,90));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, frame.getHeight()*10/100, panel.getWidth(), frame.getHeight()*10/100);
		lblNewLabel.setForeground(Color.WHITE);

		lblNewLabel.addMouseListener(new MouseAdapter(){

			public void mouseEntered(MouseEvent e){
				lblNewLabel.setBackground(new Color(96,121,146));
				lblNewLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
				lblNewLabel.setIcon(imgCli);
			}

			public void mouseExited(MouseEvent e){
				lblNewLabel.setBackground(new Color(70,80,90));
				lblNewLabel.setBorder(null);
				lblNewLabel.setIcon(null);
			}

			public void mouseClicked(MouseEvent e){
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
			}

		});
		panel.add(lblNewLabel);



		//PROGETTI
		JLabel lblNewLabel_1 = new JLabel("Progetti");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(70,80,90));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, frame.getHeight()*20/100, panel.getWidth(), frame.getHeight()*10/100);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.addMouseListener(new MouseAdapter(){

			public void mouseEntered(MouseEvent e){
				lblNewLabel_1.setBackground(new Color(96,121,146));
				lblNewLabel_1.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
				lblNewLabel_1.setIcon(imgProg);
			}

			public void mouseExited(MouseEvent e){
				lblNewLabel_1.setBackground(new Color(70,80,90));
				lblNewLabel_1.setBorder(null);
				lblNewLabel_1.setIcon(null);
			}

			public void mouseClicked(MouseEvent e){
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
			}
		});
		panel.add(lblNewLabel_1);



		//ACCOUNT
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAccount.setOpaque(true);
		lblAccount.setBounds(0, frame.getHeight()*30/100, panel.getWidth(), frame.getHeight()*10/100);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setBackground(new Color(70,80,90));
		lblAccount.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAccount.setForeground(Color.WHITE);
		lblAccount.addMouseListener(new MouseAdapter(){

			public void mouseEntered(MouseEvent e){
				lblAccount.setBackground(new Color(96,121,146));
				lblAccount.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
				lblAccount.setIcon(imgAcc);
			}

			public void mouseExited(MouseEvent e){
				lblAccount.setBackground(new Color(70,80,90));
				lblAccount.setBorder(null);
				lblAccount.setIcon(null);
			}
			public void mouseClicked(MouseEvent e){
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		panel.add(lblAccount);



		//DISCONNETTI
		JLabel lblLogout = new JLabel("Disconnetti");
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setOpaque(true);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setBounds(0, frame.getHeight()*80/100, panel.getWidth(), frame.getHeight()*10/100);
		lblLogout.setBackground(new Color(70,80,90));
		lblLogout.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogout.setForeground(Color.WHITE);
		lblLogout.addMouseListener(new MouseAdapter(){

			public void mouseEntered(MouseEvent e){
				lblLogout.setBackground(new Color(96,121,146));
				lblLogout.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
				lblLogout.setIcon(imgLog);
			}

			public void mouseExited(MouseEvent e){
				lblLogout.setBackground(new Color(70,80,90));
				lblLogout.setBorder(null);
				lblLogout.setIcon(null);
			}

			public void mouseClicked(MouseEvent e){
				frame.dispose();
				Login.open();
			}
		});
		panel.add(lblLogout);



		//ESCI
		JLabel lblEsci = new JLabel("Esci");
		lblEsci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsci.setOpaque(true);
		lblEsci.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsci.setBounds(0, frame.getHeight()*90/100, panel.getWidth(), frame.getHeight()*10/100);
		lblEsci.setBackground(new Color(70,80,90));
		lblEsci.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEsci.setForeground(Color.WHITE);
		lblEsci.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){
				frame.dispose();
			}

			public void mouseEntered(MouseEvent e){
				lblEsci.setBackground(new Color(96,121,146));
				lblEsci.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
				lblEsci.setIcon(imgEsc);
			}

			public void mouseExited(MouseEvent e){
				lblEsci.setBackground(new Color(70,80,90));
				lblEsci.setBorder(null);
				lblEsci.setIcon(null);
			}

		});
		panel.add(lblEsci);




	}

	public static void refreshTableClienti()
	{

		model = (DefaultTableModel) table.getModel();

		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}

		try {
			listaClienti = Client.getClienti();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaClienti.size(); i++){
			model.addRow(new Object[]{
					listaClienti.elementAt(i).getNome(),
					listaClienti.elementAt(i).getCognome(),
					listaClienti.elementAt(i).getEmail(),
					listaClienti.elementAt(i).getNumero()});
		}
	}

	public static void refreshTableAccounts()
	{

		model_2 = (DefaultTableModel) table_2.getModel();

		if (model_2.getRowCount() > 0) {
			for (int i = model_2.getRowCount() - 1; i > -1; i--) {
				model_2.removeRow(i);
			}
		}

		try {
			listaAccounts = Client.getAccounts();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaAccounts.size(); i++){
			model_2.addRow(new Object[]{
					listaAccounts.elementAt(i).getNome(),
					listaAccounts.elementAt(i).getCognome(),
					listaAccounts.elementAt(i).getUsername()
			});
		}
	}

	public static void refreshTableProgetti()
	{

		model_1 = (DefaultTableModel) table_1.getModel();

		if (model_1.getRowCount() > 0) {
			for (int i = model_1.getRowCount() - 1; i > -1; i--) {
				model_1.removeRow(i);
			}
		}

		try {
			listaProgettiCartellonistica = Client.getProgettiCartellonistica();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaProgettiCartellonistica.size(); i++){
			model_1.addRow(new Object[]{
					listaProgettiCartellonistica.elementAt(i).getNomeProgetto(),
					listaProgettiCartellonistica.elementAt(i).getTipoProgetto().toString(),
					listaProgettiCartellonistica.elementAt(i).getScadenza(),
					listaProgettiCartellonistica.elementAt(i).getPrezzo(),
					listaProgettiCartellonistica.elementAt(i).getStatoOrdine().toString()});
		}

		try {
			listaProgettiEvento = Client.getProgettiEvento();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaProgettiEvento.size(); i++){


			model_1.addRow(new Object[]{
					listaProgettiEvento.elementAt(i).getNomeProgetto(),
					listaProgettiEvento.elementAt(i).getTipoProgetto().toString(),
					listaProgettiEvento.elementAt(i).getScadenza(),
					listaProgettiEvento.elementAt(i).getPrezzo(),
					listaProgettiEvento.elementAt(i).getStatoOrdine().toString()});
		}

		try {
			listaProgettiFiera = Client.getProgettiFiera();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaProgettiFiera.size(); i++){
			model_1.addRow(new Object[]{
					listaProgettiFiera.elementAt(i).getNomeProgetto(),
					listaProgettiFiera.elementAt(i).getTipoProgetto().toString(),
					listaProgettiFiera.elementAt(i).getScadenza(),
					listaProgettiFiera.elementAt(i).getPrezzo(),
					listaProgettiFiera.elementAt(i).getStatoOrdine().toString()});
		}

		try {
			listaProgettiOnline = Client.getProgettiOnline();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaProgettiOnline.size(); i++){
			model_1.addRow(new Object[]{
					listaProgettiOnline.elementAt(i).getNomeProgetto(),
					listaProgettiOnline.elementAt(i).getTipoProgetto().toString(),
					listaProgettiOnline.elementAt(i).getScadenza(),
					listaProgettiOnline.elementAt(i).getPrezzo(),
					listaProgettiOnline.elementAt(i).getStatoOrdine().toString()});
		}

		try {
			listaProgettiStampa = Client.getProgettiStampa();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaProgettiStampa.size(); i++){
			model_1.addRow(new Object[]{
					listaProgettiStampa.elementAt(i).getNomeProgetto(),
					listaProgettiStampa.elementAt(i).getTipoProgetto().toString(),
					listaProgettiStampa.elementAt(i).getScadenza(),
					listaProgettiStampa.elementAt(i).getPrezzo(),
					listaProgettiStampa.elementAt(i).getStatoOrdine().toString()});
		}

	}

	public void showInfoProgetto(){

		if(tipoProgetto.equals("CARTELLONISTICA"))
		{
			try {
				listaProgettiCartellonistica = Client.getProgettiCartellonistica();
			} catch (RemoteException e1) {

				e1.printStackTrace();
			}
			for(int i=0; i<listaProgettiCartellonistica.size(); i++){
				if(nomeProgetto.equals(listaProgettiCartellonistica.elementAt(i).getNomeProgetto())){
					ShowProgettoCartellonistica.open(listaProgettiCartellonistica.elementAt(i));
				}
			}
		}

		if(tipoProgetto.equals("FIERA"))
		{
			try {
				listaProgettiFiera = Client.getProgettiFiera();
			} catch (RemoteException e1) {
			
				e1.printStackTrace();
			}
			for(int i=0; i<listaProgettiFiera.size(); i++){
				if(nomeProgetto.equals(listaProgettiFiera.elementAt(i).getNomeProgetto())){
					ShowProgettoFiera.open(listaProgettiFiera.elementAt(i));
				}
			}
		}

		if(tipoProgetto.equals("EVENTO"))
		{
			try {
				listaProgettiEvento = Client.getProgettiEvento();
			} catch (RemoteException e1) {
			
				e1.printStackTrace();
			}
			for(int i=0; i<listaProgettiEvento.size(); i++){
				if(nomeProgetto.equals(listaProgettiEvento.elementAt(i).getNomeProgetto())){
					ShowProgettoEvento.open(listaProgettiEvento.elementAt(i));
				}
			}
		}

		if(tipoProgetto.equals("ONLINE"))
		{
			try {
				listaProgettiOnline = Client.getProgettiOnline();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0; i<listaProgettiOnline.size(); i++){
				if(nomeProgetto.equals(listaProgettiOnline.elementAt(i).getNomeProgetto())){
					ShowProgettoOnline.open(listaProgettiOnline.elementAt(i));
				}
			}
		}

		if(tipoProgetto.equals("STAMPA"))
		{
			try {
				listaProgettiStampa = Client.getProgettiStampa();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(int i=0; i<listaProgettiStampa.size(); i++){
				if(nomeProgetto.equals(listaProgettiStampa.elementAt(i).getNomeProgetto())){
					ShowProgettoStampa.open(listaProgettiStampa.elementAt(i));
				}
			}
		}


	}
	
	public void deleteCliente(){
		try {
			Client.deleteCliente(email);
			for(int i=0; i<listaClienti.size(); i++){
				if(email.equals(listaClienti.elementAt(i).getEmail())){
					idCliente = listaClienti.elementAt(i).getIdcliente();
				}
			}
			
			for(int i=0; i<listaProgettiEvento.size();i++){
				if(idCliente == listaProgettiEvento.elementAt(i).getIdCliente()){
					Client.deleteProgetto(listaProgettiEvento.elementAt(i).getNomeProgetto(), 
							listaProgettiEvento.elementAt(i).getTipoProgetto().toString());
				}
			}
			
			for(int i=0; i<listaProgettiCartellonistica.size();i++){
				if(idCliente == listaProgettiCartellonistica.elementAt(i).getIdCliente()){
					Client.deleteProgetto(listaProgettiCartellonistica.elementAt(i).getNomeProgetto(), 
							listaProgettiCartellonistica.elementAt(i).getTipoProgetto().toString());
				}
			}
			
			for(int i=0; i<listaProgettiFiera.size();i++){
				if(idCliente == listaProgettiFiera.elementAt(i).getIdCliente()){
					Client.deleteProgetto(listaProgettiFiera.elementAt(i).getNomeProgetto(), 
							listaProgettiFiera.elementAt(i).getTipoProgetto().toString());
				}
			}
			
			for(int i=0; i<listaProgettiStampa.size();i++){
				if(idCliente == listaProgettiStampa.elementAt(i).getIdCliente()){
					Client.deleteProgetto(listaProgettiStampa.elementAt(i).getNomeProgetto(), 
							listaProgettiStampa.elementAt(i).getTipoProgetto().toString());
				}
			}
			
			for(int i=0; i<listaProgettiOnline.size();i++){
				if(idCliente == listaProgettiOnline.elementAt(i).getIdCliente()){
					Client.deleteProgetto(listaProgettiOnline.elementAt(i).getNomeProgetto(), 
							listaProgettiOnline.elementAt(i).getTipoProgetto().toString());
				}
			}

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}