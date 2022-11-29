package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import db.DBManager;
import db.DBoperation;
import db.User;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Orders {

	private static JFrame frame;
	private JList list;
	private JTable table;
	static DBoperation op = new DBoperation();
	static ArrayList<String[]> orders = new ArrayList<>();
	public static User u = new User();
	static DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders window = new Orders();
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
	public Orders() throws ClassNotFoundException, SQLException {
		DBManager.init_connection();
		orders = op.getOrders();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 10, 1367, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		JLabel lblPlaceOrder = new JLabel("Orders");
		lblPlaceOrder.setBounds(25, 23, 206, 52);
		lblPlaceOrder.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 30));
		frame.getContentPane().add(lblPlaceOrder);
		
		String data[][]={};    
		String column[]={"Book ISBN","Copies","Date"};
		JScrollPane sp=new JScrollPane();
		sp.setBounds(109, 118, 1162, 500);
		frame.getContentPane().add(sp);   
		
		table = new JTable() ;
		table.setBackground(new Color(250, 235, 215));
		table.setFillsViewportHeight(true);
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		table.setVerifyInputWhenFocusTarget(false);
		table.setUpdateSelectionOnSort(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
				data,
			column
		) {
			
		});
		model = (DefaultTableModel) table.getModel();
		for(int i=0;i<orders.size();i++) {
			String[] info = orders.get(i);
			model.addRow(new Object[]{info[0], info[2], info[1]});
		}
		
		
		
		table.setAlignmentX(SwingConstants.CENTER);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 25));
		header.setOpaque(false);
		table.setRowHeight(40);
		sp.setViewportView(table);
		
		JButton confirmbtn = new JButton("Confirm Order");
		confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if(idx<0) {
					JOptionPane.showMessageDialog(frame,"You haven't selected any order","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else {
					String[] info = orders.get(idx);
					op.confirmOrder(Integer.parseInt(info[3]));
					orders.remove(idx);
					model.removeRow(idx);
					frame.repaint();
				}
			}
		});
		confirmbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmbtn.setBackground(new Color(128, 0, 128));
		confirmbtn.setForeground(new Color(255, 250, 250));
		confirmbtn.setBorderPainted(false);
		confirmbtn.setFocusPainted(false);		confirmbtn.setBounds(1107, 659, 169, 50);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        confirmbtn.setCursor(cursor);
		frame.getContentPane().add(confirmbtn);
		
		JButton backbtn = new JButton("Back");
		backbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Search.main(null);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backbtn.setBounds(31, 667, 85, 30);
		backbtn.setBackground(new Color(128, 0, 128));
		backbtn.setForeground(new Color(255, 250, 250));
		backbtn.setBorderPainted(false);
		backbtn.setFocusPainted(false);
		backbtn.setCursor(cursor);
		frame.getContentPane().add(backbtn);
		
		JButton neworderbtn = new JButton("Place new order");
		neworderbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlaceOrder.main(null);
			}
		});
		neworderbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		neworderbtn.setFocusPainted(false);
		neworderbtn.setBounds(1102, 48, 169, 50);
		neworderbtn.setBackground(new Color(128, 0, 128));
		neworderbtn.setForeground(new Color(255, 250, 250));
		neworderbtn.setBorderPainted(false);
		neworderbtn.setFocusPainted(false);
		neworderbtn.setCursor(cursor);
		frame.getContentPane().add(neworderbtn);
		
		JButton btnAddNewBook = new JButton("Add new book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddBook.main(null);
			}
		});
		btnAddNewBook.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddNewBook.setFocusPainted(false);
		btnAddNewBook.setBackground(new Color(128, 0, 128));
		btnAddNewBook.setForeground(new Color(255, 250, 250));
		btnAddNewBook.setBorderPainted(false);
		btnAddNewBook.setFocusPainted(false);
		btnAddNewBook.setBounds(871, 48, 169, 50);
		frame.getContentPane().add(btnAddNewBook);
	}
	
	public static void updateOrders() {
		orders = op.getOrders();
		String[] info = orders.get(orders.size()-1); 
		model.addRow(new Object[]{info[0], info[2], info[1]});
		frame.repaint();
	}
}
