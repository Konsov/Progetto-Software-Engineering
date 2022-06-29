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

//frame per aggiungere un materiale di un relativo progetto

public class AddMateriale {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void open(String nomeProgetto, String tipoProgetto) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMateriale window = new AddMateriale(nomeProgetto, tipoProgetto);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddMateriale(String nomeProgetto, String tipoProgetto) {
		initialize(nomeProgetto,tipoProgetto);
	}


	private void initialize(String nomeProgetto,String tipoProgetto) {
	
		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setSize(width*40/100, height*40/100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNomeDellaLocation = new JLabel("Nome materiale");
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


			
			try {
				Client.addMateriale(textField.getText(),Float.parseFloat(textField_1.getText()),nomeProgetto);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
				frame.dispose();
				switch(tipoProgetto){
    			case "STAMPA":
    				ShowProgettoStampa.refreshTableMateriali(nomeProgetto);
    				break;
    			case "CARTELLONISTICA":
    				  ShowProgettoCartellonistica.refreshTableMateriali(nomeProgetto);
    				break;
    			case "EVENTO":
    				ShowProgettoEvento.refreshTableMateriali(nomeProgetto);
    				break;
    			case "FIERA":
    				ShowProgettoFiera.refreshTableMateriali(nomeProgetto);
    				break;
    			default:
    				break;
    			}
	           
				
			}
		});
		
		
		
		btnFine.setBounds(frame.getWidth()*75/100,frame.getHeight()*80/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(btnFine);
		
		JButton btnCancella = new JButton("Annulla");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		btnCancella.setBounds(frame.getWidth()*30/100, frame.getHeight()*80/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnCancella);
		
		JLabel lblServizioEsterno = new JLabel("Nuovo Materiale");
		lblServizioEsterno.setHorizontalAlignment(SwingConstants.CENTER);
		lblServizioEsterno.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblServizioEsterno.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblServizioEsterno);
	
	}
}

