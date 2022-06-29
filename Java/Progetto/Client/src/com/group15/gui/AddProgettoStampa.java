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
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;

import com.group15.client.Client;
import com.group15.commonclass.Stampa;
import com.group15.commonenum.StatoOrdine;
import com.group15.commonenum.TipoProgetto;

import javax.swing.JCheckBox;

//frame per l'aggiunta di un progetto di tipo STAMPA

public class AddProgettoStampa {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void open(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProgettoStampa window = new AddProgettoStampa(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddProgettoStampa(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		initialize(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {

		Stampa s = new Stampa();
		s.setNomeProgetto(nome);
		s.setScadenza(scadenza);
		s.setPrezzo(prezzo);
		s.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);
		s.setIdCliente(idCliente);

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		frame = new JFrame();
		frame.setSize(width*40/100, height*40/100);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.getContentPane().setLayout(null);



		JLabel lblAltezza = new JLabel("Altezza");
		lblAltezza.setBounds(frame.getWidth()*10/100,frame.getHeight()*15/100, frame.getWidth()*15/100,frame.getHeight()*5/100);
		frame.getContentPane().add(lblAltezza);

		JLabel lblLarghezza = new JLabel("Larghezza");
		lblLarghezza.setBounds(frame.getWidth()*50/100,frame.getHeight()*15/100, frame.getWidth()*15/100,frame.getHeight()*5/100);
		frame.getContentPane().add(lblLarghezza);

		textField = new JTextField();
		textField.setBounds(frame.getWidth()*25/100,frame.getHeight()*15/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*65/100,frame.getHeight()*15/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		///
		JCheckBox chckbxProposta = new JCheckBox("Proposta 1");
		chckbxProposta.setBounds(frame.getWidth()*10/100,frame.getHeight()*25/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxProposta);

		JLabel lblQuantita = new JLabel("Quantita'");
		lblQuantita.setBounds(frame.getWidth()*35/100,frame.getHeight()*25/100, frame.getWidth()*15/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblQuantita);

		SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner spinner = new JSpinner(sm);
		spinner.setBounds(frame.getWidth()*50/100,frame.getHeight()*25/100, frame.getWidth()*10/100,frame.getHeight()*10/100);
		frame.getContentPane().add(spinner);
		
		JCheckBox chckbxProposta_2 = new JCheckBox("Proposta2");
		chckbxProposta_2.setBounds(frame.getWidth()*10/100,frame.getHeight()*40/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxProposta_2);

		JLabel lblQuantita2 = new JLabel("Quantita'");
		lblQuantita2.setBounds(frame.getWidth()*35/100,frame.getHeight()*40/100, frame.getWidth()*15/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblQuantita2);

		SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner spinner2 = new JSpinner(sm2);
		spinner2.setBounds(frame.getWidth()*50/100,frame.getHeight()*40/100, frame.getWidth()*10/100,frame.getHeight()*10/100);
		frame.getContentPane().add(spinner2);
		
		JCheckBox chckbxProposta_3 = new JCheckBox("Proposta 3");
		chckbxProposta_3.setBounds(frame.getWidth()*10/100,frame.getHeight()*55/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxProposta_3);

		JLabel lblQuantita3 = new JLabel("Quantita'");
		lblQuantita3.setBounds(frame.getWidth()*35/100,frame.getHeight()*55/100, frame.getWidth()*15/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblQuantita3);


		SpinnerModel sm3 = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner spinner3 = new JSpinner(sm3);
		spinner3.setBounds(frame.getWidth()*50/100,frame.getHeight()*55/100, frame.getWidth()*10/100,frame.getHeight()*10/100);
		frame.getContentPane().add(spinner3);






		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				if(chckbxProposta.isSelected()){
					s.setProposta1(true);
					s.setQuantita1((Integer)sm.getValue());

				}else{
					s.setProposta1(false);
				}


				if(chckbxProposta_2.isSelected()){
					s.setProposta2(true);
					s.setQuantita2((Integer)sm2.getValue());

				}else{
					s.setProposta2(false);
				}

				if(chckbxProposta_3.isSelected()){
					s.setProposta3(true);
					s.setQuantita3((Integer)sm3.getValue());

				}else{
					s.setProposta3(false);
				}


				s.setAltezza(Float.parseFloat(textField.getText()));
				s.setLarghezza(Float.parseFloat(textField_1.getText()));

				s.setTipoProgetto(TipoProgetto.STAMPA);
				s.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				s.setTempoImpiegato(0);

				try {
					Client.addProgettoStampa(s);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frame.dispose();
				HomeMan.refreshTableProgetti();
				HomeMan.attiva();
			}
		});


		btnFine.setBounds(frame.getWidth()*75/100,frame.getHeight()*75/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(btnFine);

		JLabel lblPubblicitaStampa = new JLabel("Pubblicita' Stampa");
		lblPubblicitaStampa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPubblicitaStampa.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblPubblicitaStampa.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblPubblicitaStampa);


	}
}
