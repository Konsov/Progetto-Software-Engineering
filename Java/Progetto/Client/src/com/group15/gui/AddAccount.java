package com.group15.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


import javax.swing.JLabel;
import javax.swing.JTextField;

import com.group15.client.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import java.awt.event.ActionEvent;

//frame per aggiungere Account 

public class AddAccount {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	private static String nome;
	private static String cognome;
	private static String username;
	private static String password;
	
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount window = new AddAccount();
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
	public AddAccount() {
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
		lblNome.setBounds(frame.getWidth()*5/100, frame.getHeight()*10/100, frame.getWidth()*25/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblNome);

		textField = new JTextField();
		textField.setBounds(frame.getWidth()*30/100, frame.getHeight()*10/100, frame.getWidth()*40/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(frame.getWidth()*5/100, frame.getHeight()*25/100, frame.getWidth()*25/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblCognome);

		textField_1 = new JTextField();
		textField_1.setBounds(frame.getWidth()*30/100, frame.getHeight()*25/100, frame.getWidth()*40/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(frame.getWidth()*5/100, frame.getHeight()*40/100, frame.getWidth()*25/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblUsername);

		textField_2 = new JTextField();
		textField_2.setBounds(frame.getWidth()*30/100, frame.getHeight()*40/100, frame.getWidth()*40/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(frame.getWidth()*5/100, frame.getHeight()*55/100, frame.getWidth()*25/100, frame.getHeight()*10/100);
		frame.getContentPane().add(lblPassword);

		textField_3 = new JTextField();
		textField_3.setBounds(frame.getWidth()*30/100, frame.getHeight()*55/100, frame.getWidth()*40/100, frame.getHeight()*10/100);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);


		JButton btnOk = new JButton("Aggiungi");
		btnOk.setSelected(true);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				nome = textField.getText();
				cognome = textField_1.getText();
				username = textField_2.getText();
				password = textField_3.getText();

				try {
					Client.addAccount(nome, cognome, username, password);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				frame.dispose();
				
				
				HomeMan.frame.setVisible(true);
				HomeMan.attiva();
				HomeMan.refreshTableAccounts();
			}
		});

		btnOk.setBounds(frame.getWidth()*50/100, frame.getHeight()*80/100, frame.getWidth()*40/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnOk);

		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});

		btnCancella.setBounds(frame.getWidth()*15/100, frame.getHeight()*80/100, frame.getWidth()*30/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnCancella);
	}
}
