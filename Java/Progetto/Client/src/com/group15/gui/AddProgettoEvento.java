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
import com.group15.commonclass.Evento;
import com.group15.commonclass.ServizioEsterno;
import com.group15.commonenum.StatoOrdine;
import com.group15.commonenum.TipoProgetto;

//frame per l'aggiunta di un progetto di tipo EVENTO

public class AddProgettoEvento {

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
					AddProgettoEvento window = new AddProgettoEvento(nome,scadenza,prezzo,numeroDipendentiAssegnati,idCliente);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddProgettoEvento(String nome,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		initialize(nome,scadenza,prezzo,numeroDipendentiAssegnati,idCliente);
	}


	private void initialize(String nomeProgetto,String scadenza,float prezzo,int numeroDipendentiAssegnati,int idCliente) {
		Evento ev = new Evento();		
		ev.setNomeProgetto(nomeProgetto);
		ev.setScadenza(scadenza);
		ev.setPrezzo(prezzo);
		ev.setNumeroDipendentiAssegnati(numeroDipendentiAssegnati);
		ev.setIdCliente(idCliente);
		
		ServizioEsterno location = new ServizioEsterno();
		
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
		
		JLabel lblNomeDellaLocation = new JLabel("Nome Location");
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
		
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			location.setNome(textField.getText());
			location.setPrezzo(Float.parseFloat(textField_1.getText()));
			location.setIdProgetto(nomeProgetto);
			
			try {
				Client.addServizioEsterno(textField.getText(),Float.parseFloat(textField_1.getText()),nomeProgetto);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			ev.setTipoProgetto(TipoProgetto.EVENTO);
				ev.setStatoOrdine(StatoOrdine.PREVENTIVATO);
				ev.setTempoImpiegato(0);
				
				try {
					Client.addProgettoEvento(ev);
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
		
		JLabel lblPubblicitaEvento = new JLabel("Evento");
		lblPubblicitaEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblPubblicitaEvento.setFont(new Font("Apple Color Emoji", Font.PLAIN, 20));
		lblPubblicitaEvento.setBounds(0,0, frame.getWidth(),frame.getHeight()*10/100);
		frame.getContentPane().add(lblPubblicitaEvento);
		

		

		
		
	}
}