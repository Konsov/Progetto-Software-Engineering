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
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.group15.client.Client;
import com.group15.commonclass.Cliente;
import com.group15.commonclass.Fiera;
import com.group15.commonclass.Materiale;

//frame per visualizzare le caratteristiche di un progetto di tipo FIERA

public class ShowProgettoFiera {
	
	private static JTable table_1;
	private static DefaultTableModel model_1;
	private static Vector<Materiale> listaMateriali;
	private Vector<Cliente> listaClienti;
	private JFrame frame;
	private JScrollPane spMateriali = new JScrollPane();


	private Float costoOrarioDipendenti = (float) 8.0;
	
	public static void open(Fiera f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProgettoFiera window = new ShowProgettoFiera(f);
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
	public ShowProgettoFiera(Fiera f) {
		initialize(f);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Fiera f) {
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
			if(listaClienti.elementAt(i).getIdcliente() == f.getIdCliente()){
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
		JLabel lblNomeProgetto1 = new JLabel(f.getNomeProgetto());
		lblNomeProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*5/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblNomeProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblNomeProgetto1);

		JLabel lblTipoProgetto = new JLabel("Tipo Progetto: ");
		lblTipoProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*15/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTipoProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTipoProgetto);
		JLabel lblTipoProgetto1 = new JLabel(f.getTipoProgetto().toString());
		lblTipoProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*15/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTipoProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTipoProgetto1);

		JLabel lblTempoImpiegato = new JLabel("Tempo Impiegato: ");
		lblTempoImpiegato.setBounds(frame.getWidth()*5/100,frame.getHeight()*20/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTempoImpiegato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTempoImpiegato);
		JLabel lblTempoImpiegato1 = new JLabel(""+f.getTempoImpiegato());
		lblTempoImpiegato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*20/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTempoImpiegato1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTempoImpiegato1);

		JLabel lblPrezzo = new JLabel("Prezzo: ");
		lblPrezzo.setBounds(frame.getWidth()*5/100,frame.getHeight()*25/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblPrezzo.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblPrezzo);
		JLabel lblPrezzo1 = new JLabel(""+f.getPrezzo());
		lblPrezzo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*25/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblPrezzo1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblPrezzo1);

		JLabel lblStatoOrdine = new JLabel("StatoOrdine: ");
		lblStatoOrdine.setBounds(frame.getWidth()*5/100,frame.getHeight()*30/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblStatoOrdine.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblStatoOrdine);
		JLabel lblStatoOrdine1 = new JLabel(f.getStatoOrdine().toString());
		lblStatoOrdine1.setBounds(frame.getWidth()*30/100,frame.getHeight()*30/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblStatoOrdine1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblStatoOrdine1);

		JLabel lblScadenza = new JLabel("Scadenza: ");
		lblScadenza.setBounds(frame.getWidth()*5/100,frame.getHeight()*35/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblScadenza.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblScadenza);
		JLabel lblScadenza1 = new JLabel(f.getScadenza());
		lblScadenza1.setBounds(frame.getWidth()*30/100,frame.getHeight()*35/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblScadenza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblScadenza1);

		JLabel lblDipendentiAssegnati = new JLabel("Dipendenti Assegnati: ");
		lblDipendentiAssegnati.setBounds(frame.getWidth()*5/100,frame.getHeight()*40/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblDipendentiAssegnati);
		JLabel lblDipendentiAssegnati1 = new JLabel(""+f.getNumeroDipendentiAssegnati());
		lblDipendentiAssegnati1.setBounds(frame.getWidth()*30/100,frame.getHeight()*40/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblDipendentiAssegnati1);
		
		JLabel lblProposta1 = new JLabel("Proposta 1: ");
		lblProposta1.setBounds(frame.getWidth()*5/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblProposta1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblProposta1);
	
		if(f.getProposta1())
		{
			JLabel lblProposta11 = new JLabel("SI");
			lblProposta11.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta11);					
		}
		else
		{
			JLabel lblProposta11 = new JLabel("No");
			lblProposta11.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta11);
		}
		
		
		JLabel lblProposta2 = new JLabel("Proposta 2: ");
		lblProposta2.setBounds(frame.getWidth()*5/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblProposta2.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblProposta2);
		
		if(f.getProposta2())
		{
			JLabel lblProposta21 = new JLabel("SI");
			lblProposta21.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta21.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta21);		
			
		}
		else
		{
			JLabel lblProposta11 = new JLabel("No");
			lblProposta11.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblProposta11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblProposta11);
		}
		

		JLabel lblDescrizione = new JLabel("Descrizione: ");
		lblDescrizione.setBounds(frame.getWidth()*5/100,frame.getHeight()*55/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblDescrizione.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblDescrizione);
		JTextArea lblDescrizione1 = new JTextArea(f.getDescrizione());
		lblDescrizione1.setLineWrap(true);
		lblDescrizione1.setEditable(false);
		lblDescrizione1.setBackground(new Color(237,235,237));
		lblDescrizione1.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*65/100,frame.getHeight()*10/100);
		lblDescrizione1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblDescrizione1);
		
		
		JLabel lblMateriali = new JLabel("Materiali: ");
		lblMateriali.setBounds(frame.getWidth()*5/100,frame.getHeight()*60/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblMateriali.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblMateriali);


		table_1 = new JTable(new DefaultTableModel(null, new Object[]{"Tipo Materiale", "Prezzo" }));
		spMateriali.setBounds(frame.getWidth()*5/100,frame.getHeight()*65/100, frame.getWidth()*90/100,frame.getHeight()*15/100);
		spMateriali.setBorder((BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67))));
		frame.getContentPane().add(spMateriali);
		table_1.setAutoCreateColumnsFromModel(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setSelectionForeground(new Color(0, 0, 0));
		table_1.setSelectionBackground(new Color(192, 192, 192));
		table_1.setFont(new Font("Arial", Font.PLAIN, 12));
		table_1.setRowHeight(30);
		spMateriali.setViewportView(table_1);

		refreshTableMateriali(f.getNomeProgetto());
		
		JButton btnAggiungiMateriali = new JButton("Aggiungi Materiali");
		btnAggiungiMateriali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddMateriale.open(f.getNomeProgetto(),f.getTipoProgetto().toString());
			}
		});
		btnAggiungiMateriali.setBounds(frame.getWidth()*70/100,frame.getHeight()*80/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnAggiungiMateriali);
		

		JLabel lblFatturato = new JLabel("Fatturato: ");
		lblFatturato.setBounds(frame.getWidth()*5/100,frame.getHeight()*85/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblFatturato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato);
		JLabel lblFatturato1 = new JLabel(""+getFatturato(f) + " euro");
		lblFatturato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*85/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblFatturato1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato1);	
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});
		btnFine.setBounds(frame.getWidth()*70/100,frame.getHeight()*90/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnFine);
	
	
	
	}

public Float getFatturato(Fiera f){
		
		Float speseMateriali = 0F;

		Float costoDipendenti = 0F;
		
		costoDipendenti = f.getNumeroDipendentiAssegnati() * costoOrarioDipendenti * f.getTempoImpiegato();
	
		try {
			listaMateriali = Client.getMateriali();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0; i<listaMateriali.size(); i++){		
			if(f.getNomeProgetto().equals(listaMateriali.elementAt(i).getNomeProgetto())){
					speseMateriali += listaMateriali.elementAt(i).getPrezzo();
			}
		}
	
		return f.getPrezzo()-costoDipendenti-speseMateriali;
		
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
