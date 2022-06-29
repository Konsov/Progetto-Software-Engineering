package com.group15.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.group15.client.Client;
import com.group15.commonclass.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//frame per visualizzare le caratteristiche di un progetto di tipo EVENTO

public class ShowProgettoEvento {

	private static JTable table;
	private static DefaultTableModel model;
	private static JTable table_1;
	private static DefaultTableModel model_1;
	private JFrame frame;
	private JScrollPane spServiziEsterni = new JScrollPane();
	private JScrollPane spMateriali = new JScrollPane();

	private Vector<Cliente> listaClienti= null;
	private static Vector<ServizioEsterno> listaServizi = null;
	private static Vector<Materiale> listaMateriali = null;

private Float costoOrarioDipendenti = 8.0F;

	public static void open(Evento ev) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProgettoEvento window = new ShowProgettoEvento(ev);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws RemoteException 
	 */
	public ShowProgettoEvento(Evento ev) {
		initialize(ev);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws RemoteException 
	 */
	private void initialize(Evento ev){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*60/100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);

		JLabel lblNomeCliente = new JLabel("Nome Cliente: ");
		lblNomeCliente.setBounds(frame.getWidth()*5/100,frame.getHeight()*10/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblNomeCliente.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblNomeCliente);

		try {
			listaClienti = Client.getClienti();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(int i=0; i<listaClienti.size(); i++){
			if(listaClienti.elementAt(i).getIdcliente() == ev.getIdCliente()){
				JLabel lblNomeCliente1 = new JLabel(listaClienti.elementAt(i).getNome() + " " + listaClienti.elementAt(i).getCognome());
				lblNomeCliente1.setBounds(frame.getWidth()*30/100,frame.getHeight()*10/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
				lblNomeCliente1.setFont(new Font("arial", Font.BOLD, 13));
				frame.getContentPane().add(lblNomeCliente1);
			}
		}


		JLabel lblNomeProgetto = new JLabel("Nome Progetto: ");
		lblNomeProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*5/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblNomeProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblNomeProgetto);
		JLabel lblNomeProgetto1 = new JLabel(ev.getNomeProgetto());
		lblNomeProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*5/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblNomeProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblNomeProgetto1);

		JLabel lblTipoProgetto = new JLabel("Tipo Progetto: ");
		lblTipoProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*15/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTipoProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTipoProgetto);
		JLabel lblTipoProgetto1 = new JLabel(ev.getTipoProgetto().toString());
		lblTipoProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*15/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTipoProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTipoProgetto1);

		JLabel lblTempoImpiegato = new JLabel("Tempo Impiegato: ");
		lblTempoImpiegato.setBounds(frame.getWidth()*5/100,frame.getHeight()*20/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTempoImpiegato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTempoImpiegato);
		JLabel lblTempoImpiegato1 = new JLabel(""+ev.getTempoImpiegato());
		lblTempoImpiegato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*20/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTempoImpiegato1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTempoImpiegato1);

		JLabel lblPrezzo = new JLabel("Prezzo: ");
		lblPrezzo.setBounds(frame.getWidth()*5/100,frame.getHeight()*25/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblPrezzo.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblPrezzo);
		JLabel lblPrezzo1 = new JLabel(""+ev.getPrezzo());
		lblPrezzo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*25/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblPrezzo1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblPrezzo1);

		JLabel lblStatoOrdine = new JLabel("StatoOrdine: ");
		lblStatoOrdine.setBounds(frame.getWidth()*5/100,frame.getHeight()*30/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblStatoOrdine.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblStatoOrdine);
		JLabel lblStatoOrdine1 = new JLabel(ev.getStatoOrdine().toString());
		lblStatoOrdine1.setBounds(frame.getWidth()*30/100,frame.getHeight()*30/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblStatoOrdine1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblStatoOrdine1);

		JLabel lblScadenza = new JLabel("Scadenza: ");
		lblScadenza.setBounds(frame.getWidth()*5/100,frame.getHeight()*35/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblScadenza.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblScadenza);
		JLabel lblScadenza1 = new JLabel(ev.getScadenza());
		lblScadenza1.setBounds(frame.getWidth()*30/100,frame.getHeight()*35/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblScadenza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblScadenza1);

		JLabel lblDipendentiAssegnati = new JLabel("Dipendenti Assegnati: ");
		lblDipendentiAssegnati.setBounds(frame.getWidth()*5/100,frame.getHeight()*40/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblDipendentiAssegnati);
		JLabel lblDipendentiAssegnati1 = new JLabel(""+ev.getNumeroDipendentiAssegnati());
		lblDipendentiAssegnati1.setBounds(frame.getWidth()*30/100,frame.getHeight()*40/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblDipendentiAssegnati1);

		JLabel lblServiziEsterno = new JLabel("Servizi Esterni: ");
		lblServiziEsterno.setBounds(frame.getWidth()*5/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblServiziEsterno.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblServiziEsterno);

		table = new JTable(new DefaultTableModel(null, new Object[]{"Tipo Servizio", "Prezzo" }));
		spServiziEsterni.setBounds(frame.getWidth()*5/100,frame.getHeight()*50/100, frame.getWidth()*90/100,frame.getHeight()*15/100);
		spServiziEsterni.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		frame.getContentPane().add(spServiziEsterni);
		table.setAutoCreateColumnsFromModel(false);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionBackground(new Color(192, 192, 192));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setRowHeight(30);
		spServiziEsterni.setViewportView(table);
		
		refreshTableServizi(ev.getNomeProgetto());
		
		JButton btnAggiungiServizi = new JButton("Servizi e Personale");
		btnAggiungiServizi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddServizioEsterno.open(ev.getNomeProgetto());
			}
		});
		btnAggiungiServizi.setBounds(frame.getWidth()*70/100,frame.getHeight()*65/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnAggiungiServizi);
	


		JLabel lblMateriali = new JLabel("Materiali: ");
		lblMateriali.setBounds(frame.getWidth()*5/100,frame.getHeight()*65/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblMateriali.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblMateriali);


		table_1 = new JTable(new DefaultTableModel(null, new Object[]{"Tipo Materiale", "Prezzo" }));
		spMateriali.setBounds(frame.getWidth()*5/100,frame.getHeight()*70/100, frame.getWidth()*90/100,frame.getHeight()*15/100);
		spMateriali.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		frame.getContentPane().add(spMateriali);
		table_1.setAutoCreateColumnsFromModel(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setSelectionForeground(new Color(0, 0, 0));
		table_1.setSelectionBackground(new Color(192, 192, 192));
		table_1.setFont(new Font("Arial", Font.PLAIN, 12));
		table_1.setRowHeight(30);
		spMateriali.setViewportView(table_1);

		refreshTableMateriali(ev.getNomeProgetto());
		
		JButton btnAggiungiMateriali = new JButton("Aggiungi Materiali");
		btnAggiungiMateriali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddMateriale.open(ev.getNomeProgetto(),ev.getTipoProgetto().toString());
			}
		});
		btnAggiungiMateriali.setBounds(frame.getWidth()*70/100,frame.getHeight()*85/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnAggiungiMateriali);
		
		
		JLabel lblFatturato = new JLabel("Fatturato: ");
		lblFatturato.setBounds(frame.getWidth()*5/100,frame.getHeight()*90/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblFatturato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato);
		JLabel lblFatturato1 = new JLabel(""+getFatturato(ev) + " euro");
		lblFatturato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*90/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblFatturato1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato1);	

		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});
		btnFine.setBounds(frame.getWidth()*70/100,frame.getHeight()*92/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnFine);
	}
	
	
public Float getFatturato(Evento e){
		
		Float speseMateriali = 0F;

		Float costoDipendenti = 0F;
		
		Float speseServiziEsterni = 0F;
		
		costoDipendenti = e.getNumeroDipendentiAssegnati() * costoOrarioDipendenti * e.getTempoImpiegato();
	
		try {
			listaServizi = Client.getServiziEsterni();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaServizi.size(); i++){		
			if(e.getNomeProgetto().equals(listaServizi.elementAt(i).getIdProgetto())){
				speseServiziEsterni += listaServizi.elementAt(i).getPrezzo();
			}
		}
		
		try {
			listaMateriali = Client.getMateriali();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaMateriali.size(); i++){		
			if(e.getNomeProgetto().equals(listaMateriali.elementAt(i).getNomeProgetto())){
					speseMateriali += listaMateriali.elementAt(i).getPrezzo();
			}
		}
	
		
		return e.getPrezzo()-costoDipendenti-speseMateriali - speseServiziEsterni;
		
	}

public static void refreshTableMateriali(String nomeProgetto){
	model_1 = (DefaultTableModel) table_1.getModel();
	
	if (model_1.getRowCount() > 0) {
		for (int i = model_1.getRowCount() - 1; i > -1; i--) {
			model_1.removeRow(i);
		}
	}

	try {
		listaMateriali = Client.getMateriali();
	} catch (RemoteException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for(int i=0; i<listaMateriali.size(); i++){		
		if(nomeProgetto.equals(listaMateriali.elementAt(i).getNomeProgetto())){
			model_1.addRow(new Object[]{
					listaMateriali.elementAt(i).getNome(),
					listaMateriali.elementAt(i).getPrezzo()});
		}
	}

}

public static void refreshTableServizi(String nomeProgetto){
	model = (DefaultTableModel) table.getModel();
	
	if (model.getRowCount() > 0) {
		for (int i = model.getRowCount() - 1; i > -1; i--) {
			model.removeRow(i);
		}
	}

	try {
		listaServizi = Client.getServiziEsterni();
	} catch (RemoteException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	for(int i=0; i<listaServizi.size(); i++){		
		if(nomeProgetto.equals(listaServizi.elementAt(i).getIdProgetto())){
			model.addRow(new Object[]{
					listaServizi.elementAt(i).getNome(),
					listaServizi.elementAt(i).getPrezzo()
					});
		}
	}
}
}
