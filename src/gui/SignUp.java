package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextPane;

import db.Auth;
import db.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class SignUp {
	

	private JFrame frame;
	private JPasswordField passwordField;
	public static User u = new User();
	public  Auth auth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
					window.auth= new Auth();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 997, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernamelbl = new JLabel("user name");
		usernamelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		usernamelbl.setBackground(new Color(240, 240, 240));
		usernamelbl.setForeground(new Color(218, 112, 214));
		usernamelbl.setBounds(100, 160, 203, 37);
		frame.getContentPane().add(usernamelbl);
		
		JLabel passwordlbl = new JLabel("password");
		passwordlbl.setForeground(new Color(218, 112, 214));
		passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		passwordlbl.setBackground(SystemColor.menu);
		passwordlbl.setBounds(100, 225, 203, 37);
		frame.getContentPane().add(passwordlbl);
		
		JLabel emailnamelbl = new JLabel("e-mail address");
		emailnamelbl.setForeground(new Color(218, 112, 214));
		emailnamelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		emailnamelbl.setBackground(SystemColor.menu);
		emailnamelbl.setBounds(100, 420, 317, 34);
		frame.getContentPane().add(emailnamelbl);
		
		JLabel firstnamelbl = new JLabel("first name");
		firstnamelbl.setForeground(new Color(218, 112, 214));
		firstnamelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		firstnamelbl.setBackground(SystemColor.menu);
		firstnamelbl.setBounds(94, 355, 226, 37);
		frame.getContentPane().add(firstnamelbl);
		
		JLabel lastnamelbl = new JLabel("last name");
		lastnamelbl.setForeground(new Color(218, 112, 214));
		lastnamelbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		lastnamelbl.setBackground(SystemColor.menu);
		lastnamelbl.setBounds(100, 290, 203, 37);
		frame.getContentPane().add(lastnamelbl);
		
		JLabel shippinglbl = new JLabel("shipping address");
		shippinglbl.setForeground(new Color(218, 112, 214));
		shippinglbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		shippinglbl.setBackground(SystemColor.menu);
		shippinglbl.setBounds(100, 550, 362, 37);
		frame.getContentPane().add(shippinglbl);
		
		JLabel phonenumlbl = new JLabel("phone number");
		phonenumlbl.setForeground(new Color(218, 112, 214));
		phonenumlbl.setFont(new Font("Tahoma", Font.BOLD, 35));
		phonenumlbl.setBackground(SystemColor.menu);
		phonenumlbl.setBounds(100, 485, 271, 37);
		frame.getContentPane().add(phonenumlbl);
		
		JLabel signuptitlelbl = new JLabel("Sign Up");
		signuptitlelbl.setForeground(new Color(128, 0, 128));
		signuptitlelbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		signuptitlelbl.setBackground(SystemColor.menu);
		signuptitlelbl.setBounds(24, 48, 246, 75);
		frame.getContentPane().add(signuptitlelbl);
		
		JTextPane text_username = new JTextPane();
		text_username.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_username.setToolTipText("");
		text_username.setForeground(new Color(128, 0, 128));
		text_username.setBounds(500, 160, 287, 37);
		frame.getContentPane().add(text_username);
		
		JTextPane text_lname = new JTextPane();
		text_lname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_lname.setToolTipText("");
		text_lname.setForeground(new Color(128, 0, 128));
		text_lname.setBounds(500, 290, 287, 37);
		frame.getContentPane().add(text_lname);
		
		JTextPane text_fname = new JTextPane();
		text_fname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_fname.setToolTipText("");
		text_fname.setForeground(new Color(128, 0, 128));
		text_fname.setBounds(500, 355, 287, 37);
		frame.getContentPane().add(text_fname);
		
		JTextPane text_email = new JTextPane();
		text_email.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_email.setToolTipText("");
		text_email.setForeground(new Color(128, 0, 128));
		text_email.setBounds(500, 420, 287, 37);
		frame.getContentPane().add(text_email);
		
		JTextPane text_phonenum = new JTextPane();
		text_phonenum.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_phonenum.setToolTipText("");
		text_phonenum.setForeground(new Color(128, 0, 128));
		text_phonenum.setBounds(500, 485, 287, 37);
		frame.getContentPane().add(text_phonenum);
		
		JTextPane text_shipping = new JTextPane();
		text_shipping.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_shipping.setToolTipText("");
		text_shipping.setForeground(new Color(128, 0, 128));
		text_shipping.setBounds(500, 550, 287, 37);
		frame.getContentPane().add(text_shipping);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(128, 0, 128));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(500, 225, 287, 37);
		frame.getContentPane().add(passwordField);
		
		JButton signup_btn = new JButton("sign up");
		signup_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signup_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				u.setUser_name(text_username.getText());
				if(passwordField.getText().length() <8) {
				JOptionPane.showMessageDialog(frame,"Password mismatch","Alert",JOptionPane.WARNING_MESSAGE);
				}else {
					u.setPassword(passwordField.getText());
				}
				u.setFname(text_fname.getText());
				u.setLname(text_lname.getText());
				u.setEmail(text_email.getText());
				u.setPhone(text_phonenum.getText());
				u.setShAddress(text_shipping.getText());
				u.setManager(false);
				boolean stat = auth.signup(u);
				if(stat) {
					frame.dispose();
					Search.u=u;
					Search.main(null);
				}
				else {
					System.out.println("Wrong signup");
					JOptionPane.showMessageDialog(frame,"Some information are wrong","Alert",JOptionPane.WARNING_MESSAGE);

				}
			}
		});
		signup_btn.setBackground(new Color(128, 0, 128));
		signup_btn.setForeground(new Color(255, 250, 250));
		signup_btn.setBorderPainted(false);
		signup_btn.setFocusPainted(false);

		signup_btn.setBounds(852, 606, 104, 41);
		frame.getContentPane().add(signup_btn);
		
		
	}
}
