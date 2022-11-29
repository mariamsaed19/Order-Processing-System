package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import db.Auth;
import db.DBManager;
import db.User;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;


public class SignIn {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	public static User u;
	private Auth auth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn window = new SignIn();
					window.auth = new Auth();

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
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 869, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titlelbl = new JLabel("Sign In");
		titlelbl.setForeground(new Color(128, 0, 128));
		titlelbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		titlelbl.setBounds(51, 35, 264, 85);
		frame.getContentPane().add(titlelbl);
		
		JLabel usernamelbl = new JLabel("User name");
		usernamelbl.setForeground(new Color(218, 112, 214));
		usernamelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		usernamelbl.setBounds(123, 183, 206, 37);
		frame.getContentPane().add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setForeground(new Color(218, 112, 214));
		passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		passwordlbl.setBounds(123, 258, 189, 37);
		frame.getContentPane().add(passwordlbl);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameField.setBounds(409, 183, 286, 37);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(409, 266, 286, 37);
		frame.getContentPane().add(passwordField);
		
		JButton signinbtn = new JButton("Sign In");
		signinbtn.setForeground(new Color(255, 255, 255));
		signinbtn.setBackground(new Color(128, 0, 128));
		signinbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				boolean enter = auth.signin(username, password);
				User u = auth.u;
				if(enter) {
					frame.dispose();
					Search.u = u;
					Search.main(null);
				}
				else {
				    JOptionPane.showMessageDialog(frame,"Wrong username or password");  
					System.out.println("Wrong information");
				}
				
			}
		});
		signinbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signinbtn.setCursor(cursor);
		signinbtn.setBounds(568, 412, 104, 41);
		signinbtn.setBorderPainted(false);
		signinbtn.setFocusPainted(false);
		frame.getContentPane().add(signinbtn);
		
		JLabel lblNewLabel = new JLabel("Don't have an account ?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(249, 524, 163, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel registerlbl = new JLabel("Register now !");
		registerlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignUp.main(null);
			}
		});

        registerlbl.setCursor(cursor);
		registerlbl.setForeground(Color.RED);
		registerlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		registerlbl.setBounds(422, 524, 181, 21);
		frame.getContentPane().add(registerlbl);
		

	}
}
