package com.group15.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.SwingConstants;

import com.group15.client.Client;
import com.group15.commonclass.*;
import com.group15.commonenum.StatoOrdine;
import com.group15.commonenum.TipoProgetto;

import javax.swing.JCheckBox;

//frame per l'aggiunta di un progetto di tipo ONLINE

public class AddProgettoOnline {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	/**
	 * Launch the application.
	 */
	public static void open(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProgettoOnline window = new AddProgettoOnline(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
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
	public AddProgettoOnline(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		initialize(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		
		Online o = new Online();
		o.setNomeProgetto(nome);
		o.setScadenza(scadenza);
		o.setPrezzo(prezzo);
		o.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);
		o.setIdCliente(idCliente);
		
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*40/100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);

		
		JCheckBox chckbxBanner = new JCheckBox("BANNER");
		chckbxBanner.setBounds(frame.getWidth()*10/100,frame.getHeight()*15/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxBanner);
		
		JCheckBox chckbxSfondo = new JCheckBox("SFONDO");
		chckbxSfondo.setBounds(frame.getWidth()*10/100,frame.getHeight()*25/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxSfondo);
		
		JCheckBox chckbxInserzione = new JCheckBox("INSERZIONE RETTANGOLARE");
		chckbxInserzione.setBounds(frame.getWidth()*10/100,frame.getHeight()*35/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxInserzione);
	
		JCheckBox chckbxInserzione_1 = new JCheckBox("INSERZIONE QUADRATA");
		chckbxInserzione_1.setBounds(frame.getWidth()*10/100,frame.getHeight()*65/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxInserzione_1);
		
		JLabel lblAltezza = new JLabel("Altezza");
		lblAltezza.setBounds(frame.getWidth()*10/100,frame.getHeight()*45/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblAltezza);
		
		JLabel lblLarghezza = new JLabel("Larghezza");
		lblLarghezza.setBounds(frame.getWidth()*10/100,frame.getHeight()*55/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblLarghezza);
		
		JLabel lblLato = new JLabel("Lato");
		lblLato.setBounds(frame.getWidth()*10/100,frame.getHeight()*75/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblLato);
		
		textField = new JTextField();
		textField.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(frame.getWidth()*30/100,frame.getHeight()*75/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				if(chckbxBanner.isSelected()){
					o.setBanner(true);
				
				}else{
					o.setBanner(false);
				}


				if(chckbxSfondo.isSelected()){
					o.setSfondo(true);
				
				}else{
					o.setSfondo(false);
				}
			
				if(chckbxInserzione.isSelected()){
					o.setInserzioneRettangolare(true);
					o.setAltezza(Float.parseFloat(textField.getText()));
					o.setLarghezza(Float.parseFloat(textField_1.getText()));
				}else{
					o.setInserzioneRettangolare(false);
				}
				
				if(chckbxInserzione_1.isSelected()){
			o.setInserzioneQuadrata(true);
			o.setLato(Float.parseFloat(textField_2.getText()));
				}else{
					o.setInserzioneQuadrata(false);
				}
				
				
				o.setTipoProgetto(TipoProgetto.ONLINE);
				o.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				o.setTempoImpiegato(0);
				
				try {
					Client.addProgettoOnline(o);
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
		
		JLabel lblPubblicitaOnline = new JLabel("Pubblicita' Online");
		lblPubblicitaOnline.setHorizontalAlignment(SwingConstants.CENTER);
		lblPubblicitaOnline.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblPubblicitaOnline.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblPubblicitaOnline);

	}
}
