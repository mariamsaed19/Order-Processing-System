package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import db.DBManager;
import db.DBoperation;
import db.User;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Promotion {

	private JFrame frame;
	ArrayList<String> users = new ArrayList<>();
	DBoperation op = new DBoperation();
	public static User u = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promotion window = new Promotion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Promotion() throws ClassNotFoundException, SQLException {
		//DBManager.init_connection();
		users = op.getCustomers();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 20, 1367, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		JLabel lblPromotion = new JLabel("Promotion");
		lblPromotion.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 30));
		lblPromotion.setBounds(10, 10, 206, 52);
		frame.getContentPane().add(lblPromotion);
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search.main(null);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backbtn.setBounds(23, 667, 85, 30);
		backbtn.setCursor(cursor);
		backbtn.setBackground(new Color(128, 0, 128));
		backbtn.setForeground(new Color(255, 250, 250));
		backbtn.setBorderPainted(false);
		backbtn.setFocusPainted(false);
		frame.getContentPane().add(backbtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(users.toArray(new String[0])));
		comboBox.setBackground(new Color(255, 250, 250));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(541, 331, 419, 52);
		AutoCompletion.enable(comboBox);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose Customer To Promote");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(218, 337, 299, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hint :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(541, 284, 56, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type first characters of customer name to autocomplete");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(584, 284, 459, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnPromote = new JButton("Promote");
		btnPromote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user = comboBox.getSelectedIndex();
				op.promoteUser((String) comboBox.getItemAt(user));
				users.remove(user);
				comboBox.setModel(new DefaultComboBoxModel(users.toArray(new String[0])));
				JOptionPane.showMessageDialog(frame,"User has been promoted","Alert",JOptionPane.INFORMATION_MESSAGE);

				frame.repaint();
			}
		});
		btnPromote.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPromote.setBounds(958, 428, 122, 30);
		btnPromote.setCursor(cursor);
		btnPromote.setBackground(new Color(128, 0, 128));
		btnPromote.setForeground(new Color(255, 250, 250));
		btnPromote.setBorderPainted(false);
		btnPromote.setFocusPainted(false);
		frame.getContentPane().add(btnPromote);
		

	}

}
