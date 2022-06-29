package com.group15.gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.group15.client.*;
import com.group15.commonclass.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;
import java.awt.event.ActionEvent;

//frame per aggiungere un cliente

public class AddCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	private static String nome;
	private static String cognome;
	private static String email;
	private static String telefono;
	private int idCliente;
	private Vector<Cliente> listaClienti;
	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCliente window = new AddCliente();
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
	public AddCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		//Prendo dimensioni dello schermo
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		frame = new JFrame();
		frame.setSize(width*30/100, height*40/100);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(frame.getWidth()*10/100, frame.getHeight()*10/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblNome);

		textField = new JTextField();
		textField.setBounds(frame.getWidth()*30/100, frame.getHeight()*10/100, frame.getWidth()*50/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(frame.getWidth()*10/100, frame.getHeight()*25/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblCognome);

		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*30/100, frame.getHeight()*25/100, frame.getWidth()*50/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(frame.getWidth()*10/100, frame.getHeight()*40/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblEmail);

		textField_2 = new JTextField();
		textField_2.setBounds(frame.getWidth()*30/100, frame.getHeight()*40/100, frame.getWidth()*50/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(frame.getWidth()*10/100, frame.getHeight()*55/100, frame.getWidth()*20/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblTelefono);

		textField_3 = new JTextField();
		textField_3.setBounds(frame.getWidth()*30/100, frame.getHeight()*55/100, frame.getWidth()*50/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);


		JButton btnOk = new JButton("Inserisci Progetto >>");
		btnOk.setSelected(true);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				nome = textField.getText();
				cognome = textField_1.getText();
				email = textField_2.getText();
				telefono = textField_3.getText();

				try {
					Client.aggiungiCliente(nome, cognome, email, telefono);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frame.dispose();
				
				HomeMan.refreshTableClienti();
				
				HomeMan.frame.setVisible(true);
				
				try {
					listaClienti = Client.getClienti();
					idCliente = listaClienti.elementAt(listaClienti.size()-1).getIdcliente();

				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			    AddProgetto.open(idCliente);
			}
		});

		btnOk.setBounds(frame.getWidth()*45/100, frame.getHeight()*80/100, frame.getWidth()*45/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnOk);

		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});

		btnCancella.setBounds(frame.getWidth()*10/100, frame.getHeight()*80/100, frame.getWidth()*30/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnCancella);
	}
}
