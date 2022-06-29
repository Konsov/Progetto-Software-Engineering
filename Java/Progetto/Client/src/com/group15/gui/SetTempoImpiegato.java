package com.group15.gui;

import java.awt.Color;
import java.awt.EventQueue;
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

//frame per settare il tempo impiegato per portare a termine un progetto

public class SetTempoImpiegato {
	private JTextField textField;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void open(String nomeProgetto,String tipoProgetto) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetTempoImpiegato window = new SetTempoImpiegato(nomeProgetto,tipoProgetto);
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
	public SetTempoImpiegato(String nomeProgetto,String tipoProgetto) {
		initialize(nomeProgetto,tipoProgetto);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nomeProgetto,String tipoProgetto) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*40/100);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		JLabel lbl = new JLabel("Imposta tempo impiegato");
		lbl.setBounds(frame.getWidth()*5/100,frame.getHeight()*10/100, frame.getWidth()*90/100,frame.getHeight()*10/100);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl);
		
		textField = new JTextField("0");
		textField.setBounds(frame.getWidth()*30/100,frame.getHeight()*25/100, frame.getWidth()*40/100,frame.getHeight()*10/100);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOre = new JLabel("ore");
		lblOre.setBounds(frame.getWidth()*70/100,frame.getHeight()*25/100, frame.getWidth()*10/100,frame.getHeight()*10/100);
		lblOre.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblOre);
		
		
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Client.setTempoImpiegato(nomeProgetto, tipoProgetto, Float.parseFloat(textField.getText()));
				} catch (NumberFormatException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
				HomeMan.attiva();
				}
			});
		btnFine.setBounds(frame.getWidth()*75/100,frame.getHeight()*75/100, frame.getWidth()*20/100,frame.getHeight()*10/100);
		frame.getContentPane().add(btnFine);
		
		JButton btnCancella = new JButton("Annulla");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});

		btnCancella.setBounds(frame.getWidth()*10/100, frame.getHeight()*75/100, frame.getWidth()*25/100, frame.getHeight()*10/100);
		frame.getContentPane().add(btnCancella);
	}

}
