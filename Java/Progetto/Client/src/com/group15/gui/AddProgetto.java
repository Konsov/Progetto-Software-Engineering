package com.group15.gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

//frame per l'aggiunta di un progetto e le relative caratteristiche iniziali

public class AddProgetto {

	private JFrame frame;

	private String[] tipoProgetti;

	private String[] giorno;
	private String[] mese;
	private String[] anno;

	private String nome;
	private String tipoProgetto;
	private String scadenza;
	private float prezzo;
	private int numeroDipendentiAssegnati;
//	private Vector<Cliente> listaClienti;
	
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void open(int idCliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProgetto window = new AddProgetto(idCliente);
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
	public AddProgetto(int idCliente) {
		initialize(idCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int idCliente) {


		//Prendo dimensioni dello schermo
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		frame = new JFrame();
		frame.setSize(width*50/100, height*60/100);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));


		JLabel lblNome = new JLabel("Nome Progetto:");
		lblNome.setBounds(frame.getWidth()*10/100, frame.getHeight()*10/100, frame.getWidth()*20/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblNome);

		textField_3 = new JTextField();
		textField_3.setBounds(frame.getWidth()*35/100, frame.getHeight()*10/100, frame.getWidth()*45/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);


		JLabel lblTipoProgetti = new JLabel("Tipo di Progetto:");
		lblTipoProgetti.setBounds(frame.getWidth()*10/100, frame.getHeight()*25/100, frame.getWidth()*20/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblTipoProgetti);
		
		tipoProgetti = new String[] { "Pubblicita' su Stampa", "Pubblicita' Cartellonistica", "Pubblicita'Online", "Evento", "Fiera" };
		JComboBox combo = new JComboBox(tipoProgetti);
		combo.setBounds(frame.getWidth()*35/100, frame.getHeight()*25/100, frame.getWidth()*45/100, frame.getHeight()*5/100);
		frame.getContentPane().add(combo);

		JLabel lblScadenza = new JLabel("Scadenza");
		lblScadenza.setBounds(frame.getWidth()*10/100, frame.getHeight()*40/100, frame.getWidth()*20/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblScadenza);

		giorno = new String []{"--","1","2", "3","4","5","6","7","8","9","10",
				"11","12", "13","14","15","16","17","18","19","20",
				"21","22", "23","24","25","26","27","28","29","30","31"};

		mese = new String[]{"-------"," Gennaio "," Febbraio "," Marzo "," Aprile "," Maggio "," Giugno ",
				" Luglio "," Agosto "," Settembre "," Ottobre "," Novembre "," Dicembre "};

		anno = new String[]{"----","2017", "2018","2019","2020","2021", "2022", "2023", "2024", "2025"};

		JComboBox comboBox = new JComboBox(giorno);
		comboBox.setBounds(frame.getWidth()*25/100, frame.getHeight()*40/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox(mese);
		comboBox_1.setBounds(frame.getWidth()*43/100, frame.getHeight()*40/100, frame.getWidth()*30/100, frame.getHeight()*5/100);
		frame.getContentPane().add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox(anno);
		comboBox_2.setBounds(frame.getWidth()*77/100, frame.getHeight()*40/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(comboBox_2);


		JLabel lblDipendenti = new JLabel("Dipendenti da assegnare:");
		lblDipendenti.setBounds(frame.getWidth()*10/100, frame.getHeight()*55/100, frame.getWidth()*25/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblDipendenti);

		SpinnerModel sm = new SpinnerNumberModel(0, 0, 20, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(frame.getWidth()*35/100, frame.getHeight()*55/100, frame.getWidth()*25/100, frame.getHeight()*5/100);
		frame.getContentPane().add(spinner);

		
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setBounds(frame.getWidth()*10/100, frame.getHeight()*70/100, frame.getWidth()*25/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblPrezzo);

		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*35/100, frame.getHeight()*70/100, frame.getWidth()*45/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEur = new JLabel("euro");
		lblEur.setBounds(frame.getWidth()*80/100, frame.getHeight()*70/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblEur);


		
		
		JButton btnOk = new JButton("Avanzate >>");
		btnOk.setSelected(true);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

				nome = textField_3.getText();
				tipoProgetto = combo.getSelectedItem().toString();				
				scadenza = comboBox.getSelectedItem().toString() + comboBox_1.getSelectedItem().toString() + comboBox_2.getSelectedItem().toString();
                numeroDipendentiAssegnati = (int) sm.getValue();
				prezzo = Float.parseFloat(textField_1.getText());
     
				frame.dispose();
        	
				HomeMan.frame.setVisible(true);
				
				switch(tipoProgetto){
    			case "Pubblicita' su Stampa":
    				AddProgettoStampa.open(nome, scadenza, prezzo,numeroDipendentiAssegnati, idCliente);
    				break;
    			case "Pubblicita' Cartellonistica":
    				AddProgettoCartellonistica.open(nome, scadenza, prezzo, numeroDipendentiAssegnati, idCliente);
    				break;
    			case "Pubblicita'Online":
    			AddProgettoOnline.open(nome, scadenza, prezzo, numeroDipendentiAssegnati, idCliente);
    				break;
    			case "Evento":
    				AddProgettoEvento.open(nome, scadenza, prezzo, numeroDipendentiAssegnati, idCliente);
    				break;
    			case "Fiera":
    				AddProgettoFiera.open(nome, scadenza, prezzo, numeroDipendentiAssegnati, idCliente);
    				break;
    			default:
    				break;
    			}
        
			}
		});

		btnOk.setBounds(frame.getWidth()*50/100, frame.getHeight()*85/100, frame.getWidth()*35/100, frame.getHeight()*5/100);;
		frame.getContentPane().add(btnOk);

		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});

		btnCancella.setBounds(frame.getWidth()*20/100, frame.getHeight()*85/100, frame.getWidth()*25/100, frame.getHeight()*5/100);
		frame.getContentPane().add(btnCancella);
	}
}
