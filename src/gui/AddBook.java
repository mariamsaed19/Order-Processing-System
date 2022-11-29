package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.Book;
import db.DBManager;
import db.DBoperation;
import gui.CartItem;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBook {

	private JFrame frame;
	private JTextField isbnField;
	private JTextField titleField;
	private JTextField authField;
	private JTextField publisherField;
	private JTextField priceField;
	private JTextField yearField;
	private JSpinner spinner = new JSpinner();
	private JComboBox comboBox = new JComboBox();
	private String[] data = new String[] {"Science", "Art", "Religion", "History", "Geography"};

	
	DBoperation op = new DBoperation();
	String btnname = "Add Book" ;
	static CartItem book;
	private String pgTitle = "Add New Book";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
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
	public AddBook() throws ClassNotFoundException, SQLException {
		DBManager.init_connection();
		initialize();
	}
	public AddBook(String x , String y) {
		this.btnname =new String(x);
		this.pgTitle= y;
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 1367, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titlelbl = new JLabel(pgTitle);
		titlelbl.setForeground(new Color(128, 0, 128));
		titlelbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 55));
		titlelbl.setBounds(31, 22, 416, 60);
		frame.getContentPane().add(titlelbl);
		
		JButton backbtn = new JButton("Back");
		backbtn.setBackground(new Color(128, 0, 128));
		backbtn.setForeground(new Color(255, 255, 255));
		backbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		backbtn.setBounds(34, 650, 85, 47);
		frame.getContentPane().add(backbtn);
		
		JLabel lblNewLabel = new JLabel("ISBN number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(218, 112, 214));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(101, 160, 269, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(218, 112, 214));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(101, 248, 255, 37);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setForeground(new Color(218, 112, 214));
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAuthor.setBounds(101, 330, 255, 37);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublisher.setForeground(new Color(218, 112, 214));
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPublisher.setBounds(766, 248, 182, 37);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblPublicationYear = new JLabel("Publication year");
		lblPublicationYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublicationYear.setForeground(new Color(218, 112, 214));
		lblPublicationYear.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPublicationYear.setBounds(101, 422, 255, 37);
		frame.getContentPane().add(lblPublicationYear);
		
		JLabel lblSellingPrice = new JLabel("Selling price");
		lblSellingPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellingPrice.setForeground(new Color(218, 112, 214));
		lblSellingPrice.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSellingPrice.setBounds(101, 505, 255, 37);
		frame.getContentPane().add(lblSellingPrice);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setForeground(new Color(218, 112, 214));
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCategory.setBounds(766, 338, 182, 37);
		frame.getContentPane().add(lblCategory);
		
		isbnField = new JTextField();
		isbnField.setForeground(new Color(128, 0, 128));
		isbnField.setHorizontalAlignment(SwingConstants.LEFT);
		isbnField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		isbnField.setBounds(402, 166, 266, 37);
		frame.getContentPane().add(isbnField);
		isbnField.setColumns(10);
		
		titleField = new JTextField();
		titleField.setForeground(new Color(128, 0, 128));
		titleField.setHorizontalAlignment(SwingConstants.LEFT);
		titleField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titleField.setColumns(10);
		titleField.setBounds(402, 254, 266, 37);
		frame.getContentPane().add(titleField);
		
		authField = new JTextField();
		authField.setForeground(new Color(128, 0, 128));
		authField.setHorizontalAlignment(SwingConstants.LEFT);
		authField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		authField.setColumns(10);
		authField.setBounds(402, 338, 266, 37);
		frame.getContentPane().add(authField);
		
		publisherField = new JTextField();
		publisherField.setForeground(new Color(128, 0, 128));
		publisherField.setHorizontalAlignment(SwingConstants.LEFT);
		publisherField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		publisherField.setColumns(10);
		publisherField.setBounds(1010, 260, 266, 37);
		frame.getContentPane().add(publisherField);
		
		priceField = new JTextField();
		priceField.setForeground(new Color(128, 0, 128));
		priceField.setHorizontalAlignment(SwingConstants.LEFT);
		priceField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceField.setColumns(10);
		priceField.setBounds(402, 511, 266, 37);
		frame.getContentPane().add(priceField);
		
		yearField = new JTextField();
		yearField.setForeground(new Color(128, 0, 128));
		yearField.setHorizontalAlignment(SwingConstants.LEFT);
		yearField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearField.setColumns(10);
		yearField.setBounds(402, 428, 266, 37);
		frame.getContentPane().add(yearField);
		comboBox.setForeground(new Color(128, 0, 128));
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(data));

		comboBox.setBounds(1010, 334, 266, 37);
		frame.getContentPane().add(comboBox);
		
		JLabel lblMinimumQuantity = new JLabel("Minimum quantity");
		lblMinimumQuantity.setForeground(new Color(218, 112, 214));
		lblMinimumQuantity.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMinimumQuantity.setBounds(712, 428, 278, 37);
		frame.getContentPane().add(lblMinimumQuantity);
		spinner.setForeground(new Color(128, 0, 128));
		
		
		spinner.setAlignmentX(Component.LEFT_ALIGNMENT);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(1021, 435, 101, 30);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton(this.btnname);
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book b = new Book();
				b.setISBN(isbnField.getText());
				b.setTitle(titleField.getText());
				b.setAuthor(authField.getText());
				b.setPublisher(publisherField.getText());
				b.setSellingPrice(Double.parseDouble(priceField.getText()));
				b.setPublicationYear(yearField.getText());
				int idx =comboBox.getSelectedIndex();
				b.setCategory((String) comboBox.getItemAt(idx));
				b.setThreshold((int) spinner.getValue());
				b.setQuantity((int) spinner.getValue());
				if(btnname.compareTo("Add New Book")==0) {
					if(op.addBook(b)) {
					    JOptionPane.showMessageDialog(frame,"Book has been added successfully ");  
	
					}
					else {
					    JOptionPane.showMessageDialog(frame,"You provided wrong information ");  
	
					}
				}
				else {
					if(op.modifyBook(b)) {
					    JOptionPane.showMessageDialog(frame,"Book has been modified successfully ");  
	
					}
					else {
					    JOptionPane.showMessageDialog(frame,"You provided wrong information ");  
	
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1178, 568, 122, 47);
		frame.getContentPane().add(btnNewButton);
	}
	public void setinfo() {
		//isbnField.setText(book.getIsbn());
		titleField.setText(book.getTitle());
		authField.setText(book.getAuthor());
		publisherField.setText(book.getPublisher());
		priceField.setText(Double.toString(book.getPrice()));
		//yearField.setText(book.getYear());
	//	spinner.setValue(book.getThreshold());
		int idx=0;
		for(int i=0;i<data.length;i++) {
			if(book.getCategory().compareTo(data[i])==0) {
				idx=i;
			}
		}
		if(btnname.compareTo("Add New Book")!=0) {
			comboBox.setSelectedIndex(idx);
		}
		
		
		
	}
}
