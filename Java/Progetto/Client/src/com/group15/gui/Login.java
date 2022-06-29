package com.group15.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.group15.client.Client;

import javax.swing.ImageIcon;
import java.awt.Cursor;

//schermata di login

public class Login {

	private static JFrame frmMarketingSolution;
	private static JTextField txtUsername;
	private static JPasswordField pwdPassword;
	private JLabel lblLogInTo;
	private static JLabel lblInvalidUsernameOr;

	static String username;
	static String password;
	/**
	 * Launch the application.
	 */
	public static void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmMarketingSolution.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void iconify(JFrame frame) {
		int state = frame.getExtendedState();
		// Set the iconified bit
		state = frame.ICONIFIED;
		// Iconify the frame
		frame.setExtendedState(state);
	}
	
	/**
	 * Create the application.
	 */
	public Login() {
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
		int windowDimensionWidth = width*60/100;
		int windowDimensionHeight = height*80/100;
		
		//Creo il Frame
		frmMarketingSolution = new JFrame();
		frmMarketingSolution.setUndecorated(true); //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		frmMarketingSolution.getContentPane().setBackground(new Color(237,235,237));
		frmMarketingSolution.setSize(windowDimensionWidth, windowDimensionHeight);
		frmMarketingSolution.setLocationRelativeTo(null);
		frmMarketingSolution.setResizable(false);
		frmMarketingSolution.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(237,187,67)));
		frmMarketingSolution.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarketingSolution.getContentPane().setLayout(null);
		
		//Creo il textField dell'username
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsername.setVerifyInputWhenFocusTarget(false);
		txtUsername.setFocusable(false);
		txtUsername.setBorder(BorderFactory.createLineBorder(new Color(168,166,161), 2));
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Username");
		txtUsername.setBounds(windowDimensionWidth*30/100, windowDimensionHeight*45/100, windowDimensionWidth*40/100, windowDimensionHeight*5/100);
		txtUsername.setColumns(10);
		frmMarketingSolution.getContentPane().add(txtUsername);
		
		txtUsername.setBorder(BorderFactory.createCompoundBorder(
		        txtUsername.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
		
		txtUsername.addMouseListener(new MouseAdapter() {

			//Quanto clicco:
			public void mousePressed(MouseEvent e){
				txtUsername.setText("");  //Azzero il campo
				txtUsername.setFocusable(true);  //Focus true
				txtUsername.setForeground(Color.BLACK);  //Scritta nera
				txtUsername.setBorder(BorderFactory.createLineBorder(new Color(237,187,67), 2)); //Gioco di bordi
				pwdPassword.setBorder(BorderFactory.createLineBorder(new Color(168,166,161), 2));
				lblInvalidUsernameOr.setVisible(false);  //Nascondo quello che deve essere nascosto
				pwdPassword.setBorder(BorderFactory.createCompoundBorder(
				        pwdPassword.getBorder(), 
				        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
			}

			public void mouseReleased(MouseEvent e){
				txtUsername.grabFocus();
			}

		});
		
		//Creo il passwordField 
		pwdPassword = new JPasswordField();
		pwdPassword.setFocusable(false);
		pwdPassword.setBorder(BorderFactory.createLineBorder(new Color(168,166,161), 2));
		pwdPassword.setForeground(Color.GRAY);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(windowDimensionWidth*30/100, windowDimensionHeight*51/100, windowDimensionWidth*40/100, windowDimensionHeight*5/100);
		frmMarketingSolution.getContentPane().add(pwdPassword);
		
		pwdPassword.setBorder(BorderFactory.createCompoundBorder(
		        pwdPassword.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
		
		pwdPassword.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e){
				pwdPassword.setText("");
				pwdPassword.setFocusable(true);
				pwdPassword.setForeground(Color.BLACK);
				pwdPassword.setBorder(BorderFactory.createLineBorder(new Color(237,187,67), 2));
				txtUsername.setBorder(BorderFactory.createLineBorder(new Color(168,166,161), 2));
				lblInvalidUsernameOr.setVisible(false);
				txtUsername.setBorder(BorderFactory.createCompoundBorder(
				        txtUsername.getBorder(), 
				        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
			}
			
			public void mouseReleased(MouseEvent e){
				pwdPassword.grabFocus();
			}

		});
		
		//Creo il JButton di Log In
		JButton login = new JButton("Log In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 username = txtUsername.getText();
				 password = pwdPassword.getText();	
				 

				 try {
					Client.checkCredenziali(username, password);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login.setFont(new Font("Arial", Font.PLAIN, 14));
		login.setForeground(Color.WHITE);
		login.setBackground(new Color(85,83,78));
		login.setFocusable(false);
		login.setBorderPainted(false);
		login.setOpaque(true);
		login.setBounds(windowDimensionWidth*30/100, windowDimensionHeight*58/100, windowDimensionWidth*40/100, windowDimensionHeight*5/100);
		frmMarketingSolution.getContentPane().add(login);
		
		//Gioco di colori Log In
		login.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e){
				login.setBackground(new Color(70,80,90));
				login.setFocusable(true);
			}

			//errato Log In ---> errore						HomeMan.main();

			public void mouseExited(MouseEvent e){
				login.setBackground(new Color(85,83,78));
			}

		});
		
		//Creo Label titolo
		JLabel lblNewLabel = new JLabel("Marketing Solution");
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, windowDimensionHeight*15/100, windowDimensionWidth, windowDimensionHeight*10/100);
		lblNewLabel.setForeground(new Color(104,78,50));
		frmMarketingSolution.getContentPane().add(lblNewLabel);
		
		lblLogInTo = new JLabel("Log in to Marketing Solution");
		lblLogInTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInTo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogInTo.setForeground(Color.GRAY);
		lblLogInTo.setBounds(0, windowDimensionHeight*30/100, windowDimensionWidth, windowDimensionHeight*10/100);
		lblLogInTo.setForeground(new Color(168,166,161));
		frmMarketingSolution.getContentPane().add(lblLogInTo);
		
		//Creo JLabel invisibile per errore
		lblInvalidUsernameOr = new JLabel("Invalid username or password");
		lblInvalidUsernameOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidUsernameOr.setFont(new Font("Arial", Font.PLAIN, 16));
		lblInvalidUsernameOr.setForeground(new Color(186,38,38));
		lblInvalidUsernameOr.setVisible(false);
		lblInvalidUsernameOr.setBounds(windowDimensionWidth*30/100, windowDimensionHeight*70/100, windowDimensionWidth*40/100, windowDimensionHeight*5/100);
		frmMarketingSolution.getContentPane().add(lblInvalidUsernameOr);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image img2 = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(windowDimensionWidth*93/100, windowDimensionHeight*2/100, 30,30);
		lblNewLabel_2.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				frmMarketingSolution.dispose();
			}
		});
		frmMarketingSolution.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image img = new ImageIcon(this.getClass().getResource("/underscore.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(windowDimensionWidth*88/100, windowDimensionHeight*2/100, 30, 30);
		lblNewLabel_3.addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e){
				iconify(frmMarketingSolution);
			}
		});
		frmMarketingSolution.getContentPane().add(lblNewLabel_3);
				
	}
	
	public static void loginFallito(){
		pwdPassword.setBorder(BorderFactory.createLineBorder(new Color(186,38,38), 2));
		txtUsername.setBorder(BorderFactory.createLineBorder(new Color(186,38,38), 2));
		txtUsername.setBorder(BorderFactory.createCompoundBorder(
		        txtUsername.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
		pwdPassword.setBorder(BorderFactory.createCompoundBorder(
		        pwdPassword.getBorder(), 
		        BorderFactory.createEmptyBorder(0, 6, 0, 0)));
		lblInvalidUsernameOr.setVisible(true);
	}
	
	public static void loginEseguito(){
		frmMarketingSolution.dispose();
	}
	
}
