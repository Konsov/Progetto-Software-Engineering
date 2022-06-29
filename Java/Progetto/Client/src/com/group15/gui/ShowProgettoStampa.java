package com.group15.gui;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.group15.client.Client;
import com.group15.commonclass.Cliente;
import com.group15.commonclass.Materiale;
import com.group15.commonclass.Stampa;

//frame per visualizzare le caratteristiche di un progetto di tipo STAMPA

public class ShowProgettoStampa {
	private Vector<Cliente> listaClienti;
	private JFrame frame;
	private static JTable table_1;
	private static DefaultTableModel model_1;
	private JScrollPane spMateriali = new JScrollPane();
	private static Vector<Materiale> listaMateriali;
	
	private Float costoOrarioDipendenti = (float) 8.0;
	
	public static void open(Stampa s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProgettoStampa window = new ShowProgettoStampa(s);
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
	public ShowProgettoStampa(Stampa s) {
		initialize(s);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Stampa s) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*60/100);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			if(listaClienti.elementAt(i).getIdcliente() == s.getIdCliente()){
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
		JLabel lblNomeProgetto1 = new JLabel(s.getNomeProgetto());
		lblNomeProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*5/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblNomeProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblNomeProgetto1);

		JLabel lblTipoProgetto = new JLabel("Tipo Progetto: ");
		lblTipoProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*15/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTipoProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTipoProgetto);
		JLabel lblTipoProgetto1 = new JLabel(s.getTipoProgetto().toString());
		lblTipoProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*15/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTipoProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTipoProgetto1);

		JLabel lblTempoImpiegato = new JLabel("Tempo Impiegato: ");
		lblTempoImpiegato.setBounds(frame.getWidth()*5/100,frame.getHeight()*20/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTempoImpiegato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTempoImpiegato);
		JLabel lblTempoImpiegato1 = new JLabel(""+s.getTempoImpiegato());
		lblTempoImpiegato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*20/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTempoImpiegato1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTempoImpiegato1);

		JLabel lblPrezzo = new JLabel("Prezzo: ");
		lblPrezzo.setBounds(frame.getWidth()*5/100,frame.getHeight()*25/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblPrezzo.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblPrezzo);
		JLabel lblPrezzo1 = new JLabel(""+s.getPrezzo());
		lblPrezzo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*25/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblPrezzo1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblPrezzo1);

		JLabel lblStatoOrdine = new JLabel("StatoOrdine: ");
		lblStatoOrdine.setBounds(frame.getWidth()*5/100,frame.getHeight()*30/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblStatoOrdine.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblStatoOrdine);
		JLabel lblStatoOrdine1 = new JLabel(s.getStatoOrdine().toString());
		lblStatoOrdine1.setBounds(frame.getWidth()*30/100,frame.getHeight()*30/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblStatoOrdine1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblStatoOrdine1);

		JLabel lblScadenza = new JLabel("Scadenza: ");
		lblScadenza.setBounds(frame.getWidth()*5/100,frame.getHeight()*35/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblScadenza.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblScadenza);
		JLabel lblScadenza1 = new JLabel(s.getScadenza());
		lblScadenza1.setBounds(frame.getWidth()*30/100,frame.getHeight()*35/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblScadenza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblScadenza1);

		JLabel lblDipendentiAssegnati = new JLabel("Dipendenti Assegnati: ");
		lblDipendentiAssegnati.setBounds(frame.getWidth()*5/100,frame.getHeight()*40/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblDipendentiAssegnati);
		JLabel lblDipendentiAssegnati1 = new JLabel(""+s.getNumeroDipendentiAssegnati());
		lblDipendentiAssegnati1.setBounds(frame.getWidth()*30/100,frame.getHeight()*40/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblDipendentiAssegnati1);
		
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});
		btnFine.setBounds(frame.getWidth()*70/100,frame.getHeight()*92/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnFine);
	
		JLabel lblProposta1 = new JLabel("Proposta 1: ");
		lblProposta1.setBounds(frame.getWidth()*5/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblProposta1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblProposta1);
	
		if(s.getProposta1())
		{
			JLabel lblProposta11= new JLabel("SI");
			lblProposta11.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
			lblProposta11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta11);		
			
			JLabel lblQuantita1= new JLabel("Quantita'");
			lblQuantita1.setBounds(frame.getWidth()*50/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita1);	
			
			JLabel lblQuantita11= new JLabel(""+s.getQuantita1());
			lblQuantita11.setBounds(frame.getWidth()*75/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita11);	
		}
		else
		{
			JLabel lblProposta11 = new JLabel("No");
			lblProposta11.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta11);
		}
		
		JLabel lblProposta2 = new JLabel("Proposta 2: ");
		lblProposta2.setBounds(frame.getWidth()*5/100,frame.getHeight()*50/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblProposta2.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblProposta2);
	
		if(s.getProposta2())
		{
			JLabel lblProposta21= new JLabel("SI");
			lblProposta21.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta21.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta21);		
			
			JLabel lblQuantita2= new JLabel("Quantita'");
			lblQuantita2.setBounds(frame.getWidth()*50/100,frame.getHeight()*50/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita2.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita2);	
			
			JLabel lblQuantita22= new JLabel(""+s.getQuantita2());
			lblQuantita22.setBounds(frame.getWidth()*75/100,frame.getHeight()*50/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita22.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita22);	
		}
		else
		{
			JLabel lblProposta21 = new JLabel("No");
			lblProposta21.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta21.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta21);
		}
		
		JLabel lblProposta3 = new JLabel("Proposta 3: ");
		lblProposta3.setBounds(frame.getWidth()*5/100,frame.getHeight()*55/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblProposta3.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblProposta3);
	
		if(s.getProposta3())
		{
			JLabel lblProposta31= new JLabel("SI");
			lblProposta31.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta31.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta31);
			
			JLabel lblQuantita3= new JLabel("Quantita'");
			lblQuantita3.setBounds(frame.getWidth()*50/100,frame.getHeight()*55/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita3.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita3);	
			
			JLabel lblQuantita33= new JLabel(""+s.getQuantita3());
			lblQuantita33.setBounds(frame.getWidth()*75/100,frame.getHeight()*55/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
			lblQuantita33.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblQuantita33);	
		}
		else
		{
			JLabel lblProposta31 = new JLabel("No");
			lblProposta31.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta31.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta31);
		}
		
		JLabel lblAltezza = new JLabel("Altezza:");
		lblAltezza.setBounds(frame.getWidth()*5/100,frame.getHeight()*60/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblAltezza.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblAltezza);
		JLabel lblAltezza1 = new JLabel("" + s.getAltezza());
		lblAltezza1.setBounds(frame.getWidth()*30/100,frame.getHeight()*60/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
		lblAltezza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblAltezza1);	
		
		JLabel lblLarghezza = new JLabel("Larghezza:");
		lblLarghezza.setBounds(frame.getWidth()*40/100,frame.getHeight()*60/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblLarghezza.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblLarghezza);
		JLabel lblLarghezza1 = new JLabel(""+s.getLarghezza());
		lblLarghezza1.setBounds(frame.getWidth()*65/100,frame.getHeight()*60/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
		lblLarghezza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblLarghezza1);
		

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

		refreshTableMateriali(s.getNomeProgetto());
		
		JButton btnAggiungiMateriali = new JButton("Aggiungi Materiali");
		btnAggiungiMateriali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddMateriale.open(s.getNomeProgetto(),s.getTipoProgetto().toString());
			
			}
		});
		btnAggiungiMateriali.setBounds(frame.getWidth()*70/100,frame.getHeight()*85/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnAggiungiMateriali);
		
		
		JLabel lblFatturato = new JLabel("Fatturato: ");
		lblFatturato.setBounds(frame.getWidth()*5/100,frame.getHeight()*90/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblFatturato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato);
		JLabel lblFatturato1 = new JLabel(""+getFatturato(s) + " euro");
		lblFatturato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*90/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblFatturato1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato1);	
		
	}

       public Float getFatturato(Stampa s){
		
		Float speseMateriali = 0F;

		Float costoDipendenti = 0F;
		
		costoDipendenti = s.getNumeroDipendentiAssegnati() * costoOrarioDipendenti * s.getTempoImpiegato();
	
		try {
			listaMateriali = Client.getMateriali();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaMateriali.size(); i++){		
			if(s.getNomeProgetto().equals(listaMateriali.elementAt(i).getNomeProgetto())){
					speseMateriali += listaMateriali.elementAt(i).getPrezzo();
			}
		}
	
		return s.getPrezzo()-costoDipendenti-speseMateriali;
		
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
	
}
