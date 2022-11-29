package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.DBoperation;
import db.User;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	public User u = new User();
	public static DefaultListModel<CartItem> cart  = new DefaultListModel<CartItem>();
	static DBoperation op = new DBoperation();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckOut() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 20, 702, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(250, 240, 230));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setTitle("Check Out");
		
		JTextField cardNoTextField = new JTextField();
		cardNoTextField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 15));
		cardNoTextField.setBounds(273, 57, 330, 42);
		cardNoTextField.setColumns(10);
		contentPane.add(cardNoTextField);
		
		JLabel cardNoLbl = new JLabel("Credit card number");
		cardNoLbl.setLabelFor(cardNoTextField);
		cardNoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cardNoLbl.setForeground(new Color(0, 0, 0));
		cardNoLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		cardNoLbl.setBounds(43, 57, 187, 42);
		contentPane.add(cardNoLbl);
		
		JLabel lblCreditCardExpiry = new JLabel("Credit card expiry date");
		lblCreditCardExpiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditCardExpiry.setForeground(new Color(0, 0, 0));
		lblCreditCardExpiry.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		lblCreditCardExpiry.setBounds(43, 140, 187, 42);
		contentPane.add(lblCreditCardExpiry);
		
		JComboBox<String> year = new JComboBox<String>();
		year.setToolTipText("select a year");
		year.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		year.setModel(new DefaultComboBoxModel<String>(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		year.setBounds(519, 140, 84, 42);
		contentPane.add(year);
		
		JComboBox<String> month = new JComboBox<String>();
		month.setToolTipText("select a month");
		month.setModel(new DefaultComboBoxModel<String>(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		month.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		month.setBounds(348, 140, 84, 42);
		contentPane.add(month);
		
		JLabel monthLbl = new JLabel("Month");
		monthLbl.setForeground(new Color(0, 0, 0));
		monthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		monthLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		monthLbl.setLabelFor(month);
		monthLbl.setBounds(272, 140, 66, 42);
		contentPane.add(monthLbl);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setForeground(new Color(0, 0, 0));
		lblYear.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		lblYear.setBounds(443, 140, 66, 42);
		contentPane.add(lblYear);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {	//******************************* confirm order *******************
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> check = new ArrayList<>();
				for(int i=0;i<cart.size();i++) {
					CartItem x = cart.get(i);
					System.out.println(x.getIsbn()+" "+x.getQuantityInCart());
					check.add(x.getIsbn()+" "+x.getQuantityInCart());
				}
				dispose();
				if(op.checkout(check)) {
					JOptionPane.showMessageDialog(contentPane,"Purchased Successfully","Alert",JOptionPane.WARNING_MESSAGE);

				}
				else {
					JOptionPane.showMessageDialog(contentPane,"Something went wrong try again later","Alert",JOptionPane.WARNING_MESSAGE);

				}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		btnNewButton.setBounds(290, 243, 111, 42);
		contentPane.add(btnNewButton);
	}

}
