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

import javax.swing.JTextPane;

import javax.swing.SwingConstants;

import com.group15.client.*;
import com.group15.commonclass.*;
import com.group15.commonenum.*;


import javax.swing.JCheckBox;

//frame per l'aggiunta di un progetto di tipo FIERA

public class AddProgettoFiera {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void open(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProgettoFiera window = new AddProgettoFiera(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
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
	public AddProgettoFiera(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		initialize(nome,scadenza,prezzo,numeroDipendentiAssegnati, idCliente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		
		Fiera f = new Fiera();
		

		f.setNomeProgetto(nome);
		f.setScadenza(scadenza);
		f.setPrezzo(prezzo);
		f.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);
		f.setIdCliente(idCliente);
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*40/100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblPubblicitaFiera = new JLabel("Fiera");
		lblPubblicitaFiera.setHorizontalAlignment(SwingConstants.CENTER);
		lblPubblicitaFiera.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblPubblicitaFiera.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblPubblicitaFiera);
		
		
		JLabel lblCaratteristiche = new JLabel("Caratteristiche:");
		lblCaratteristiche.setBounds(frame.getWidth()*10/100,frame.getHeight()*25/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblCaratteristiche);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(frame.getWidth()*10/100,frame.getHeight()*35/100, frame.getWidth()*60/100,frame.getHeight()*50/100);
		frame.getContentPane().add(textPane);
		
		JCheckBox chckbxProposta = new JCheckBox("Proposta1");
		chckbxProposta.setBounds(frame.getWidth()*20/100,frame.getHeight()*15/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxProposta);
		
		JCheckBox chckbxProposta_2 = new JCheckBox("Proposta2");
		chckbxProposta_2.setBounds(frame.getWidth()*55/100,frame.getHeight()*15/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(chckbxProposta_2);
		
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				if(chckbxProposta.isSelected()){
					f.setProposta1(true);
				
				}else{
					f.setProposta1(false);
				}


				if(chckbxProposta_2.isSelected()){
					f.setProposta2(true);
				
				}else{
					f.setProposta2(false);
				}
			
			    f.setDescrizione(textPane.getText());	
				f.setTipoProgetto(TipoProgetto.FIERA);
				f.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				f.setTempoImpiegato(0);
				
				try {
					Client.addProgettoFiera(f);
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

	
	}
}

