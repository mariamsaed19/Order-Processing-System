package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import db.DBoperation;
import db.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profile {

	public static User u;
	private JFrame frame;
	DBoperation op = new DBoperation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1110, 592);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setForeground(new Color(128, 0, 128));
		editorPane.setEditable(false);
		editorPane.setEnabled(true);
		editorPane.setBackground(Color.WHITE);
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane.setBounds(436, 106, 312, 37);
		editorPane.setText(u.getFname());
		frame.getContentPane().add(editorPane);
		

		
		JLabel FirstnameLabel = new JLabel("First name");
		FirstnameLabel.setForeground(new Color(218, 112, 214));
		FirstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		FirstnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FirstnameLabel.setBounds(133, 106, 211, 37);
		frame.getContentPane().add(FirstnameLabel);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setForeground(new Color(128, 0, 128));
		editorPane_1.setEnabled(true);
		editorPane_1.setEditable(false);
		editorPane_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_1.setBounds(436, 193, 312, 37);
		editorPane_1.setText(u.getLname());
		frame.getContentPane().add(editorPane_1);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setForeground(new Color(128, 0, 128));
		editorPane_2.setEnabled(true);
		editorPane_2.setEditable(false);
		editorPane_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_2.setBounds(436, 276, 312, 37);
		editorPane_2.setText(u.getEmail());
		frame.getContentPane().add(editorPane_2);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setForeground(new Color(128, 0, 128));
		editorPane_3.setEnabled(true);
		editorPane_3.setEditable(false);
		editorPane_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_3.setBounds(436, 356, 312, 37);
		editorPane_3.setText(u.getPhone());
		frame.getContentPane().add(editorPane_3);
		
		JLabel LastnameLabel = new JLabel("Last name");
		LastnameLabel.setForeground(new Color(218, 112, 214));
		LastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		LastnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LastnameLabel.setBounds(133, 193, 211, 37);
		frame.getContentPane().add(LastnameLabel);
		
		JLabel mailLabel = new JLabel("E-mail");
		mailLabel.setForeground(new Color(218, 112, 214));
		mailLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		mailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mailLabel.setBounds(133, 276, 211, 37);
		frame.getContentPane().add(mailLabel);
		
		JLabel PhoneLabel = new JLabel("Phone");
		PhoneLabel.setForeground(new Color(218, 112, 214));
		PhoneLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setBounds(133, 361, 211, 32);
		frame.getContentPane().add(PhoneLabel);
		
		JEditorPane dtrpnUserName = new JEditorPane();
		dtrpnUserName.setForeground(new Color(128, 0, 128));
		dtrpnUserName.setEditable(false);
		dtrpnUserName.setFont(new Font("Tahoma", Font.PLAIN, 28));
		dtrpnUserName.setText(u.getUser_name());
		dtrpnUserName.setBounds(21, 28, 222, 37);
		frame.getContentPane().add(dtrpnUserName);
		
		JEditorPane editorPane_5 = new JEditorPane();
		editorPane_5.setForeground(new Color(128, 0, 128));
		editorPane_5.setEnabled(true);
		editorPane_5.setEditable(false);
		editorPane_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editorPane_5.setBounds(436, 437, 312, 37);
		editorPane_5.setText(u.getShAddress());
		frame.getContentPane().add(editorPane_5);
		
		JLabel ShippingLabel = new JLabel("Shipping address");
		ShippingLabel.setForeground(new Color(218, 112, 214));
		ShippingLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		ShippingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ShippingLabel.setBounds(111, 421, 304, 53);
		frame.getContentPane().add(ShippingLabel);
		

		
		JEditorPane oldpassword = new JEditorPane();
		oldpassword.setForeground(new Color(128, 0, 128));
		oldpassword.setEnabled(false);
		oldpassword.setEditable(false);
		oldpassword.setBounds(830, 315, 197, 38);
		oldpassword.setVisible(false);
		frame.getContentPane().add(oldpassword);
		
		JEditorPane newpassword = new JEditorPane();
		newpassword.setForeground(new Color(128, 0, 128));
		newpassword.setEnabled(false);
		newpassword.setEditable(false);
		newpassword.setBounds(830, 394, 196, 38);
		newpassword.setVisible(false);
		frame.getContentPane().add(newpassword);
		
		JLabel lblOldPassword = new JLabel("Old password");
		lblOldPassword.setForeground(new Color(205, 133, 63));
		lblOldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOldPassword.setBounds(864, 276, 123, 32);
		lblOldPassword.setVisible(false);
		frame.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setForeground(new Color(205, 133, 63));
		lblNewPassword.setVisible(false);
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(850, 356, 164, 32);
		frame.getContentPane().add(lblNewPassword);
		
		JButton changePasswordButton = new JButton("Change password");
		changePasswordButton.setForeground(new Color(255, 255, 255));
		changePasswordButton.setBackground(new Color(139, 0, 139));
		changePasswordButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val =changePasswordButton.getText();
				if(val.compareTo("Change password")==0) {
					changePasswordButton.setText("Save password");
					lblOldPassword.setVisible(true);
					oldpassword.setEnabled(true);
					oldpassword.setEditable(true);
					oldpassword.setVisible(true);
					
					lblNewPassword.setVisible(true);
					newpassword.setEnabled(true);
					newpassword.setEditable(true);
					newpassword.setVisible(true);
				}
				else {
					changePasswordButton.setText("Change password");
					lblOldPassword.setVisible(false);
					oldpassword.setEnabled(false);
					oldpassword.setEditable(false);
					oldpassword.setVisible(false);
					
					lblNewPassword.setVisible(false);
					newpassword.setEnabled(false);
					newpassword.setEditable(false);
					newpassword.setVisible(false);
					String old = oldpassword.getText();
					String newpass = newpassword.getText();
					boolean stat = op.Updatepass(old, newpass, u.getUser_name());
					if(stat) {
						System.out.println("ok");
					}
					else {
					    JOptionPane.showMessageDialog(frame,"Old password is wrong !\nInformation hasn't been saved");  
						System.out.println("wrong");
					}
					
					
				}
			}
		});
		changePasswordButton.setBounds(830, 181, 197, 47);
		frame.getContentPane().add(changePasswordButton);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Search.u=u;
				Search.main(null);
			}
		});
		
		JButton EditProfileButton = new JButton("Edit Profile");
		EditProfileButton.setBackground(new Color(139, 0, 139));
		EditProfileButton.setForeground(new Color(255, 255, 255));
		EditProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val = EditProfileButton.getText();
				if(val.compareTo("Save")==0) {
					String old = u.getUser_name();
					EditProfileButton.setText("Edit Profile");
					
					dtrpnUserName.setEditable(false);
					u.setUser_name(dtrpnUserName.getText());
					editorPane.setEditable(false);
					u.setFname(editorPane.getText());
					editorPane_1.setEditable(false);
					u.setLname(editorPane_1.getText());
					
					editorPane_2.setEditable(false);
					u.setEmail(editorPane_2.getText());
					
					editorPane_3.setEditable(false);
					u.setPhone(editorPane_3.getText());
					
					editorPane_5.setEditable(false);
					u.setShAddress(editorPane_5.getText());
					
					op.updateUser(u, old);
					frame.repaint();
					
					
					
					
				}
				else {
					EditProfileButton.setText("Save");
					dtrpnUserName.setEditable(true);
					
					editorPane.setEditable(true);
					
					editorPane_1.setEditable(true);
					
					editorPane_2.setEditable(true);
					
					editorPane_3.setEditable(true);
					
					editorPane_5.setEditable(true);
				}
			}
		});
		EditProfileButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EditProfileButton.setBounds(830, 96, 197, 47);
		frame.getContentPane().add(EditProfileButton);
		

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(17, 500, 104, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Profile");
		lblNewLabel_6.setForeground(new Color(128, 0, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(395, 10, 272, 58);
		frame.getContentPane().add(lblNewLabel_6);
		

	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
