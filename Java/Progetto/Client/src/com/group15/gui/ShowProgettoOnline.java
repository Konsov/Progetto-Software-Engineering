package com.group15.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.group15.client.Client;
import com.group15.commonclass.Cliente;
import com.group15.commonclass.Online;

//frame per visualizzare le caratteristiche di un progetto di tipo ONLINE

public class ShowProgettoOnline {
	
	private Vector<Cliente> listaClienti;
	private JFrame frame;
	
	private Float costoOrarioDipendenti = (float) 8.0;
	
	public static void open(Online o) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProgettoOnline window = new ShowProgettoOnline(o);
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
	public ShowProgettoOnline(Online o) {
		initialize(o);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Online o) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		frame = new JFrame();
		frame.setSize(width*40/100, height*60/100);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);

		JLabel lblNomeCliente = new JLabel("Nome Cliente: ");
		lblNomeCliente.setBounds(frame.getWidth()*5/100,frame.getHeight()*10/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblNomeCliente.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblNomeCliente);

		try {
			listaClienti = Client.getClienti();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(int i=0; i<listaClienti.size(); i++){
			if(listaClienti.elementAt(i).getIdcliente() == o.getIdCliente()){
				JLabel lblNomeCliente1 = new JLabel(listaClienti.elementAt(i).getNome() + " " + listaClienti.elementAt(i).getCognome());
				lblNomeCliente1.setBounds(frame.getWidth()*30/100,frame.getHeight()*10/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
				lblNomeCliente1.setFont(new Font("arial", Font.BOLD, 13));
				frame.getContentPane().add(lblNomeCliente1);
			}
		}


		JLabel lblNomeProgetto = new JLabel("Nome Progetto: ");
		lblNomeProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*5/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblNomeProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblNomeProgetto);
		JLabel lblNomeProgetto1 = new JLabel(o.getNomeProgetto());
		lblNomeProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*5/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblNomeProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblNomeProgetto1);

		JLabel lblTipoProgetto = new JLabel("Tipo Progetto: ");
		lblTipoProgetto.setBounds(frame.getWidth()*5/100,frame.getHeight()*15/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTipoProgetto.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTipoProgetto);
		JLabel lblTipoProgetto1 = new JLabel(o.getTipoProgetto().toString());
		lblTipoProgetto1.setBounds(frame.getWidth()*30/100,frame.getHeight()*15/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTipoProgetto1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTipoProgetto1);

		JLabel lblTempoImpiegato = new JLabel("Tempo Impiegato: ");
		lblTempoImpiegato.setBounds(frame.getWidth()*5/100,frame.getHeight()*20/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblTempoImpiegato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblTempoImpiegato);
		JLabel lblTempoImpiegato1 = new JLabel(""+o.getTempoImpiegato());
		lblTempoImpiegato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*20/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblTempoImpiegato1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblTempoImpiegato1);

		JLabel lblPrezzo = new JLabel("Prezzo: ");
		lblPrezzo.setBounds(frame.getWidth()*5/100,frame.getHeight()*25/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblPrezzo.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblPrezzo);
		JLabel lblPrezzo1 = new JLabel(""+o.getPrezzo());
		lblPrezzo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*25/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblPrezzo1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblPrezzo1);

		JLabel lblStatoOrdine = new JLabel("StatoOrdine: ");
		lblStatoOrdine.setBounds(frame.getWidth()*5/100,frame.getHeight()*30/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblStatoOrdine.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblStatoOrdine);
		JLabel lblStatoOrdine1 = new JLabel(o.getStatoOrdine().toString());
		lblStatoOrdine1.setBounds(frame.getWidth()*30/100,frame.getHeight()*30/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblStatoOrdine1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblStatoOrdine1);

		JLabel lblScadenza = new JLabel("Scadenza: ");
		lblScadenza.setBounds(frame.getWidth()*5/100,frame.getHeight()*35/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblScadenza.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblScadenza);
		JLabel lblScadenza1 = new JLabel(o.getScadenza());
		lblScadenza1.setBounds(frame.getWidth()*30/100,frame.getHeight()*35/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblScadenza1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblScadenza1);

		JLabel lblDipendentiAssegnati = new JLabel("Dipendenti Assegnati: ");
		lblDipendentiAssegnati.setBounds(frame.getWidth()*5/100,frame.getHeight()*40/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblDipendentiAssegnati);
		JLabel lblDipendentiAssegnati1 = new JLabel(""+o.getNumeroDipendentiAssegnati());
		lblDipendentiAssegnati1.setBounds(frame.getWidth()*30/100,frame.getHeight()*40/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblDipendentiAssegnati1.setFont(new Font("arial", Font.PLAIN, 13));
		frame.getContentPane().add(lblDipendentiAssegnati1);
		
		JLabel lblBanner= new JLabel("Banner: ");
		lblBanner.setBounds(frame.getWidth()*5/100,frame.getHeight()*45/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblBanner.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblBanner);
	
		if(o.getBanner())
		{
			JLabel lblBanner1 = new JLabel("SI");
			lblBanner1.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblBanner1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblBanner1);					
		}
		else
		{
			JLabel lblBanner1 = new JLabel("No");
			lblBanner1.setBounds(frame.getWidth()*30/100,frame.getHeight()*45/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblBanner1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblBanner1);
		}
		
		JLabel lblSfondo= new JLabel("Sfondo: ");
		lblSfondo.setBounds(frame.getWidth()*5/100,frame.getHeight()*50/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblSfondo.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblSfondo);
		
		if(o.getSfondo())
		{
			JLabel lblSfondo1 = new JLabel("SI");
			lblSfondo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblSfondo1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblSfondo1);					
		}
		else
		{
			JLabel lblSfondo1 = new JLabel("No");
			lblSfondo1.setBounds(frame.getWidth()*30/100,frame.getHeight()*50/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblSfondo1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblSfondo1);
		}

		
		JLabel lblInserzioneRettangolare = new JLabel("Inserzione Rettang.: ");
		lblInserzioneRettangolare.setBounds(frame.getWidth()*5/100,frame.getHeight()*55/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblInserzioneRettangolare.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblInserzioneRettangolare);

		if(o.getInserzioneRettangolare())
		{
			JLabel lblInserzioneRettangolare1 = new JLabel("SI");
			lblInserzioneRettangolare1.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
			lblInserzioneRettangolare1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblInserzioneRettangolare1);		
		
			JLabel lblAltezza1 = new JLabel("Altezza:");
			lblAltezza1.setBounds(frame.getWidth()*40/100,frame.getHeight()*55/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
			lblAltezza1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblAltezza1);
			
			JLabel lblAltezza11 = new JLabel("" + o.getAltezza());
			lblAltezza11.setBounds(frame.getWidth()*60/100,frame.getHeight()*55/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
			lblAltezza11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblAltezza11);	
			
			JLabel lblLarghezza1 = new JLabel("Larghezza:");
			lblLarghezza1.setBounds(frame.getWidth()*70/100,frame.getHeight()*55/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
			lblLarghezza1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblLarghezza1);
			JLabel lblLarghezza11 = new JLabel(""+o.getLarghezza());
			lblLarghezza11.setBounds(frame.getWidth()*90/100,frame.getHeight()*55/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
			lblLarghezza11.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblLarghezza11);
			
			
		}
		else
		{
			JLabel lblInserzioneRettangolare1 = new JLabel("No");
			lblInserzioneRettangolare1.setBounds(frame.getWidth()*30/100,frame.getHeight()*55/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblInserzioneRettangolare1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblInserzioneRettangolare1);
		}
		
		JLabel lblInserzioneQuadrata = new JLabel("Inserzione Quadrata: ");
		lblInserzioneQuadrata.setBounds(frame.getWidth()*5/100,frame.getHeight()*60/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblInserzioneQuadrata.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblInserzioneQuadrata);

		if(o.getInserzioneQuadrata())
		{
			JLabel lblInserzioneQuadrata1 = new JLabel("SI");
			lblInserzioneQuadrata1.setBounds(frame.getWidth()*30/100,frame.getHeight()*60/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
			lblInserzioneQuadrata1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblInserzioneQuadrata1);		
		
			JLabel lblLato = new JLabel("Lato:");
			lblLato.setBounds(frame.getWidth()*40/100,frame.getHeight()*60/100, frame.getWidth()*20/100,frame.getHeight()*5/100);
			lblLato.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblLato);
			
			JLabel lblLato1 = new JLabel("" + o.getLato());
			lblLato1.setBounds(frame.getWidth()*60/100,frame.getHeight()*60/100, frame.getWidth()*10/100,frame.getHeight()*5/100);
			lblLato1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblLato1);	
	
			
		}
		else
		{
			JLabel lblInserzioneQuadrata1 = new JLabel("No");
			lblInserzioneQuadrata1.setBounds(frame.getWidth()*30/100,frame.getHeight()*60/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
			lblInserzioneQuadrata1.setFont(new Font("arial", Font.PLAIN, 13));
			frame.getContentPane().add(lblInserzioneQuadrata1);
		}
		
		
		JLabel lblFatturato = new JLabel("Fatturato: ");
		lblFatturato.setBounds(frame.getWidth()*5/100,frame.getHeight()*65/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		lblFatturato.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato);
		JLabel lblFatturato1 = new JLabel(""+getFatturato(o) + " euro");
		lblFatturato1.setBounds(frame.getWidth()*30/100,frame.getHeight()*65/100, frame.getWidth()*40/100,frame.getHeight()*5/100);
		lblFatturato1.setFont(new Font("arial", Font.BOLD, 13));
		frame.getContentPane().add(lblFatturato1);	
		
		JButton btnFine = new JButton("Fine");
		btnFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomeMan.attiva();
			}
		});
		
		btnFine.setBounds(frame.getWidth()*70/100,frame.getHeight()*90/100, frame.getWidth()*25/100,frame.getHeight()*5/100);
		frame.getContentPane().add(btnFine);
	
	}
	
public Float getFatturato(Online o){
		

		Float costoDipendenti = 0F;
		
		costoDipendenti = o.getNumeroDipendentiAssegnati() * costoOrarioDipendenti * o.getTempoImpiegato();
	
		
	
		return o.getPrezzo()-costoDipendenti;
		
	}

}
