package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import db.Book;
import db.DBManager;
import db.DBoperation;
import gui.AutoCompletion;
import gui.Orders;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PlaceOrder {
	ArrayList<Book> books = new ArrayList<>();
	DBoperation op = new DBoperation();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrder window = new PlaceOrder();
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
	public PlaceOrder() throws ClassNotFoundException, SQLException {
		DBManager.init_connection();
		books = op.getBooks();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 965, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		JComboBox comboBox = new JComboBox();
		for(int i=0;i<books.size();i++) {
			comboBox.addItem(books.get(i).getISBN());
		}

		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(438, 212, 402, 37);
		AutoCompletion.enable(comboBox);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseBook = new JLabel("Choose Book");
		lblChooseBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseBook.setForeground(new Color(218, 112, 214));
		lblChooseBook.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblChooseBook.setBounds(77, 212, 297, 37);
		frame.getContentPane().add(lblChooseBook);
		
		JLabel lblPlaceNewOrder = new JLabel("Place new Order");
		lblPlaceNewOrder.setForeground(new Color(128, 0, 128));
		lblPlaceNewOrder.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		lblPlaceNewOrder.setBounds(35, 22, 480, 52);
		frame.getContentPane().add(lblPlaceNewOrder);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type first characters of book name to autocomplete");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(368, 137, 472, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hint :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(302, 137, 56, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblChooseQuantity = new JLabel("Choose Quantity");
		lblChooseQuantity.setForeground(new Color(218, 112, 214));
		lblChooseQuantity.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblChooseQuantity.setBounds(77, 303, 297, 45);
		frame.getContentPane().add(lblChooseQuantity);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(438, 303, 134, 37);
		frame.getContentPane().add(spinner);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBackground(new Color(128, 0, 128));
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = comboBox.getSelectedIndex();
				int val = (int) spinner.getValue();
				String isbn = books.get(idx).getISBN();
				if(val > 0) {
					op.placeOrder(isbn, val);
					Orders.updateOrders();
				    JOptionPane.showMessageDialog(frame,"Order is successful");  

				}
				else {
				    JOptionPane.showMessageDialog(frame,"Can't order quantity 0");  
					System.out.println("zero order");
				}
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOrder.setFocusPainted(false);
		btnOrder.setBounds(781, 375, 122, 47);
		btnOrder.setCursor(cursor);
		btnOrder.setFocusPainted(false);
		frame.getContentPane().add(btnOrder);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
