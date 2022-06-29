package com.group15.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JTextField;

import javax.swing.SwingConstants;

import com.group15.client.Client;
import com.group15.commonclass.ServizioEsterno;

//frame per l'aggiunta di un servzio esterno all'azienda

public class AddServizioEsterno {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void open(String nomeProgetto) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddServizioEsterno window = new AddServizioEsterno(nomeProgetto);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddServizioEsterno(String nomeProgetto) {
		initialize(nomeProgetto);
	}


	private void initialize(String nomeProgetto) {
	
		ServizioEsterno se = new ServizioEsterno();
		se.setIdProgetto(nomeProgetto);
		
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
		
		JLabel lblNomeDellaLocation = new JLabel("Tipo di servizio");
		lblNomeDellaLocation.setBounds(frame.getWidth()*10/100,frame.getHeight()*15/100, frame.getWidth()*45/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblNomeDellaLocation);
		
		JLabel lblVia = new JLabel("Prezzo");
		lblVia.setBounds(frame.getWidth()*10/100,frame.getHeight()*25/100, frame.getWidth()*30/100,frame.getHeight()*10/100);
		frame.getContentPane().add(lblVia);
		
		
		
		textField = new JTextField();
		textField.setBounds(frame.getWidth()*35/100,frame.getHeight()*15/100, frame.getWidth()*40/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*35/100,frame.getHeight()*25/100, frame.getWidth()*30/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	
	
		
		JButton btnFine = new JButton("Aggiungi");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			se.setNome(textField.getText());
			se.setPrezzo(Float.parseFloat(textField_1.getText()));
			
			
			try {
				Client.addServizioEsterno(textField.getText(),Float.parseFloat(textField_1.getText()),nomeProgetto);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			ShowProgettoEvento.refreshTableServizi(nomeProgetto);
			frame.dispose();
				
			}
		});
		
		
		
		btnFine.setBounds(frame.getWidth()*75/100,frame.getHeight()*75/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(btnFine);
		
		JButton btnCancella = new JButton("Annulla");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		btnCancella.setBounds(frame.getWidth()*30/100, frame.getHeight()*75/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnCancella);
		
		JLabel lblServizioEsterno = new JLabel("Servizio Esterno");
		lblServizioEsterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblServizioEsterno.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblServizioEsterno.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblServizioEsterno);
	
	}
}

