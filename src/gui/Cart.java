package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;

import db.User;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cart extends JFrame {
	public static User u = new User();
	private JPanel contentPane;
	private JLabel titleLbl;
	private JScrollPane cartScrollPane;
	private JList<CartItem> cartList;
	private JLabel isbnLbl;
	private JLabel isbn;
	private JLabel bookTitleLbl;
	private JLabel bookTitle;
	private JLabel authorLbl;
	private JLabel author;
	private JLabel publisherLbl;
	private JLabel publisher;
	private JLabel categoryLbl;
	private JLabel category;
	private JLabel priceLbl;
	private JLabel price;
	private JButton btnRemoveThisItem;
	private JButton clearBtn;
	private JLabel totalLbl;
	private JButton checkOutBtn;
	private JButton backBtn;
	private int cartTotal;
	public static DefaultListModel<CartItem> cart  = new DefaultListModel<CartItem>();
	private JLabel quantityLbl;
	private JLabel quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1121, 776);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Your Cart");
		
		titleLbl = new JLabel("Your Cart");
		titleLbl.setToolTipText("");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setForeground(new Color(0, 0, 0));
		titleLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 35));
		titleLbl.setBackground(Color.YELLOW);
		titleLbl.setBounds(0, 0, 250, 103);
		contentPane.add(titleLbl);
		
		cartScrollPane = new JScrollPane();
		cartScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		cartScrollPane.setToolTipText("your cart");
		cartScrollPane.setBounds(62, 179, 504, 407);
		contentPane.add(cartScrollPane);
		
		cartList = new JList<CartItem>();
		cartList.addListSelectionListener(new ListSelectionListener() {  // **********************************  show book info when list item is selected ************************
			public void valueChanged(ListSelectionEvent e) {
				try {
					CartItem c = cartList.getSelectedValue();
					isbn.setText(String.valueOf(c.getIsbn()));
					bookTitle.setText(c.getTitle());
					bookTitle.setToolTipText(c.getTitle());
					author.setText(c.getAuthor());
					publisher.setText(c.getPublisher());
					price.setText(c.getPrice() + " L.E.");
					category.setText(c.getCategory());
					quantity.setText(String.valueOf(c.getQuantityInCart()));
				}catch(NullPointerException ex) {
					isbn.setText("_________");
					bookTitle.setText("_________");
					bookTitle.setToolTipText("_________");
					author.setText("_________");
					publisher.setText("_________");
					price.setText("_________");
					category.setText("_________");
					quantity.setText("_________");
				}
			}
		});
		//cart = new DefaultListModel<CartItem>();
		
		//cart = Main.getSearchResult();  //TODO here cart
		cartList.setModel(cart);
		cartScrollPane.setViewportView(cartList);
		cartList.setVisibleRowCount(10);
		cartList.setToolTipText("select an item to add to cart");
		cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cartList.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		cartList.setBorder(new LineBorder(new Color(238, 130, 238)));
		cartList.setBackground(new Color(255, 192, 203));
		
		isbnLbl = new JLabel("ISBN number : ");
		isbnLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		isbnLbl.setForeground(new Color(0, 0, 0));
		isbnLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		isbnLbl.setBounds(615, 180, 156, 27);
		contentPane.add(isbnLbl);
		
		isbn = new JLabel("_________");
		isbn.setHorizontalAlignment(SwingConstants.CENTER);
		isbn.setForeground(new Color(0, 0, 0));
		isbn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		isbn.setBounds(801, 180, 156, 27);
		contentPane.add(isbn);
		
		bookTitleLbl = new JLabel("Book Title : ");
		bookTitleLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		bookTitleLbl.setForeground(new Color(0, 0, 0));
		bookTitleLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		bookTitleLbl.setBounds(615, 230, 156, 27);
		contentPane.add(bookTitleLbl);
		
		bookTitle = new JLabel("_________");
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitle.setForeground(new Color(0, 0, 0));
		bookTitle.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		bookTitle.setBounds(801, 230, 156, 27);
		contentPane.add(bookTitle);
		
		authorLbl = new JLabel("Author : ");
		authorLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLbl.setForeground(new Color(0, 0, 0));
		authorLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		authorLbl.setBounds(615, 280, 156, 27);
		contentPane.add(authorLbl);
		
		author = new JLabel("_________");
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setForeground(new Color(0, 0, 0));
		author.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		author.setBounds(801, 280, 156, 27);
		contentPane.add(author);
		
		publisherLbl = new JLabel("Publisher : ");
		publisherLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		publisherLbl.setForeground(new Color(0, 0, 0));
		publisherLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		publisherLbl.setBounds(615, 330, 156, 27);
		contentPane.add(publisherLbl);
		
		publisher = new JLabel("_________");
		publisher.setHorizontalAlignment(SwingConstants.CENTER);
		publisher.setForeground(new Color(0, 0, 0));
		publisher.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		publisher.setBounds(801, 330, 156, 27);
		contentPane.add(publisher);
		
		categoryLbl = new JLabel("Category : ");
		categoryLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		categoryLbl.setForeground(new Color(0, 0, 0));
		categoryLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		categoryLbl.setBounds(615, 380, 156, 27);
		contentPane.add(categoryLbl);
		
		category = new JLabel("_________");
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(new Color(0, 0, 0));
		category.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		category.setBounds(801, 380, 156, 27);
		contentPane.add(category);
		
		priceLbl = new JLabel("Price : ");
		priceLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLbl.setForeground(new Color(0, 0, 0));
		priceLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		priceLbl.setBounds(615, 430, 156, 27);
		contentPane.add(priceLbl);
		
		price = new JLabel("_________");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(new Color(0, 0, 0));
		price.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		price.setBounds(801, 430, 156, 27);
		contentPane.add(price);
		
		btnRemoveThisItem = new JButton("Remove this item");
		btnRemoveThisItem.addActionListener(new ActionListener() {		 //***********************************************   clear cart list   *****************************************
			public void actionPerformed(ActionEvent e) {
				try {
					int index = cartList.getSelectedIndex();
					if(index<0) {
						JOptionPane.showMessageDialog(contentPane,"You haven't select any item","Alert",JOptionPane.WARNING_MESSAGE);

					}
					else {
						CartItem c = cartList.getSelectedValue();
						cartTotal -= c.getPrice()*c.getQuantityInCart();
						cart.removeElementAt(index);
						totalLbl.setText("Cart  :  " + cartTotal + "  L.E.");
					}
				}catch(NullPointerException ex) {
					
				}
				
			}
		});
		btnRemoveThisItem.setToolTipText("click to remove selected items from the cart");
		btnRemoveThisItem.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		btnRemoveThisItem.setBackground(new Color(128, 0, 128));
		btnRemoveThisItem.setForeground(new Color(255, 250, 250));
		btnRemoveThisItem.setBorderPainted(false);
		btnRemoveThisItem.setFocusPainted(false);
		btnRemoveThisItem.setBounds(748, 550, 181, 40);
		contentPane.add(btnRemoveThisItem);
		
		clearBtn = new JButton("Clear cart");
		clearBtn.addActionListener(new ActionListener() {		//***********************************************   clear cart list   *****************************************
			public void actionPerformed(ActionEvent e) {
				cart.removeAllElements();
				cartTotal = 0;
				totalLbl.setText("Total  :  " + cartTotal + "  L.E.");
			}
		});
		clearBtn.setToolTipText("click to clear all items in the cart");
		clearBtn.setForeground(new Color(0, 0, 102));
		clearBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		clearBtn.setBackground(new Color(128, 0, 128));
		clearBtn.setForeground(new Color(255, 250, 250));
		clearBtn.setBorderPainted(false);
		clearBtn.setFocusPainted(false);
		clearBtn.setBounds(245, 613, 139, 40);
		contentPane.add(clearBtn);
		
		for(int i=0;i<cart.size();i++) {
			CartItem c = cart.get(i);
			cartTotal+=c.getQuantityInCart()*c.getPrice();
		}
		totalLbl = new JLabel("Total  :  "+cartTotal+"  L.E.");
		totalLbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalLbl.setForeground(new Color(0, 0, 0));
		totalLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 25));
		totalLbl.setBounds(202, 117, 231, 52);
		contentPane.add(totalLbl);
		
		checkOutBtn = new JButton("Check out");
		checkOutBtn.addActionListener(new ActionListener() {	//******************************* go to check out page ***********************
			public void actionPerformed(ActionEvent e) {
				CheckOut.cart = cart;
				CheckOut checkoutPage = new CheckOut();
				cart = new DefaultListModel<CartItem>();
				checkoutPage.setVisible(true);
			}
		});
		checkOutBtn.setToolTipText("check out");

		checkOutBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		checkOutBtn.setBounds(910, 37, 139, 40);
		checkOutBtn.setBackground(new Color(128, 0, 128));
		checkOutBtn.setForeground(new Color(255, 250, 250));
		checkOutBtn.setBorderPainted(false);
		checkOutBtn.setFocusPainted(false);
		contentPane.add(checkOutBtn);
		
		backBtn = new JButton("Back");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Search.u=u;
				Search.main(null);
			}
		});

		backBtn.setToolTipText("back to search page");
		backBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		backBtn.setBackground(new Color(128, 0, 128));
		backBtn.setForeground(new Color(255, 250, 250));
		backBtn.setBorderPainted(false);
		backBtn.setFocusPainted(false);
		backBtn.setBounds(10, 689, 139, 40);
		contentPane.add(backBtn);
		
		quantityLbl = new JLabel("Quantity in cart : ");
		quantityLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		quantityLbl.setForeground(new Color(0, 0, 0));
		quantityLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		quantityLbl.setBounds(604, 467, 181, 27);
		contentPane.add(quantityLbl);
		
		quantity = new JLabel("_________");
		quantity.setHorizontalAlignment(SwingConstants.CENTER);
		quantity.setForeground(new Color(0, 0, 0));
		quantity.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		quantity.setBounds(801, 467, 156, 27);
		contentPane.add(quantity);
	}
}
