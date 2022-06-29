package com.group15.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;

import com.group15.client.Client;
import com.group15.commonclass.*;
import com.group15.commonenum.*;

import javax.swing.JCheckBox;

//frame per l'aggiunta di un progetto di tipo CARTELLONISTICA

public class AddProgettoCartellonistica {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String[] tipo;
	private JTextField textField_2;
	private JTextField textField_3;
	

	public static void open(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProgettoCartellonistica window = new AddProgettoCartellonistica(nome,scadenza,prezzo,numeroDipendentiAssegnati,idCliente);
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
	public AddProgettoCartellonistica(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		
		initialize(nome,scadenza,prezzo,numeroDipendentiAssegnati,idCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
	
		Cartellonistica c = new Cartellonistica();
		
		c.setNomeProgetto(nome);
		c.setScadenza(scadenza);
		c.setPrezzo(prezzo);
		c.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);
		c.setIdCliente(idCliente);
		
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		frame = new JFrame();
		frame.setSize(width*50/100, height*60/100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(frame.getWidth()*10/100, frame.getHeight()*10/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblTipo);


		tipo = new String[]{"------","INTERNI", "STRADALE"};
		JComboBox comboBox = new JComboBox(tipo);
		comboBox.setBounds(frame.getWidth()*25/100, frame.getHeight()*10/100, frame.getWidth()*20/100, frame.getHeight()*5/100);
		frame.getContentPane().add(comboBox);



		JCheckBox chckbxProposta = new JCheckBox("Proposta1");
		chckbxProposta.setBounds(frame.getWidth()*10/100, frame.getHeight()*20/100, frame.getWidth()*20/100, frame.getHeight()*5/100);
		frame.getContentPane().add(chckbxProposta);


		JLabel lblQuantita1 = new JLabel("Quantita'");
		lblQuantita1.setBounds(frame.getWidth()*5/100, frame.getHeight()*30/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblQuantita1);


		SpinnerModel sm = new SpinnerNumberModel(0, 0, 20, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(frame.getWidth()*15/100, frame.getHeight()*30/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(spinner);

		JLabel lblAltezza1 = new JLabel("Altezza");
		lblAltezza1.setBounds(frame.getWidth()*30/100, frame.getHeight()*30/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblAltezza1);

		textField = new JTextField();
		textField.setBounds(frame.getWidth()*40/100, frame.getHeight()*30/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblLarghezza1 = new JLabel("Larghezza");
		lblLarghezza1.setBounds(frame.getWidth()*60/100, frame.getHeight()*30/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblLarghezza1);

		textField_2 = new JTextField();
		textField_2.setBounds(frame.getWidth()*75/100, frame.getHeight()*30/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);





		JCheckBox chckbxProposta_2 = new JCheckBox("Proposta2");
		chckbxProposta_2.setBounds(frame.getWidth()*10/100, frame.getHeight()*45/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(chckbxProposta_2);


		JLabel lblQuantita2 = new JLabel("Quantita'");
		lblQuantita2.setBounds(frame.getWidth()*5/100, frame.getHeight()*55/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblQuantita2);


		SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 9, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner2 = new JSpinner(sm2);
		spinner2.setBounds(frame.getWidth()*15/100, frame.getHeight()*55/100, frame.getWidth()*10/100, frame.getHeight()*5/100);
		frame.getContentPane().add(spinner2);



		JLabel lblAltezza2 = new JLabel("Altezza");
		lblAltezza2.setBounds(frame.getWidth()*30/100, frame.getHeight()*55/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblAltezza2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*40/100, frame.getHeight()*55/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);	

		JLabel lblLarghezza2= new JLabel("Larghezza");
		lblLarghezza2.setBounds(frame.getWidth()*60/100, frame.getHeight()*55/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(lblLarghezza2);

		textField_3 = new JTextField();
		textField_3.setBounds(frame.getWidth()*75/100, frame.getHeight()*55/100, frame.getWidth()*15/100, frame.getHeight()*5/100);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);





		JLabel lblPubblicitaCartellonistica = new JLabel("Pubblicita' Cartellonistica");
		lblPubblicitaCartellonistica.setHorizontalAlignment(SwingConstants.CENTER);
		lblPubblicitaCartellonistica.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblPubblicitaCartellonistica.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblPubblicitaCartellonistica);

		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					
				switch(comboBox.getSelectedItem().toString()){
				case "INTERNI":
					c.setTipoCartelloni(TipoCartellonistica.INTERNI);
					break;
				case "STRADALE":
					c.setTipoCartelloni(TipoCartellonistica.STRADALE);
					break;
				default:
					break;
				}
				
				if(chckbxProposta.isSelected()){
					c.setProposta1(true);
					c.setQuantita1((Integer)sm.getValue());
					c.setAltezza1(Float.parseFloat(textField.getText()));
					c.setLarghezza1(Float.parseFloat(textField_2.getText()));
				}else{
					c.setProposta1(false);
				}


				if(chckbxProposta_2.isSelected()){
					c.setProposta2(true);
					c.setQuantita2((Integer)sm2.getValue());
					c.setAltezza2(Float.parseFloat(textField_1.getText()));
					c.setLarghezza2(Float.parseFloat(textField_3.getText()));
				}else{
					c.setProposta2(false);
				}
				c.setTipoProgetto(TipoProgetto.CARTELLONISTICA);
				c.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				c.setTempoImpiegato(0);
				
				try {
					Client.addProgettoCartellonistica(c);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frame.dispose();
				
				HomeMan.refreshTableProgetti();
				HomeMan.attiva();
			}
		});

		btnFine.setBounds(frame.getWidth()*70/100,frame.getHeight()*75/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnFine);
		
		

	}
}
