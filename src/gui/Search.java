package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import db.Book;
import db.DBManager;
import db.DBoperation;
import db.User;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class Search {
	public static User u = new User();
	ArrayList<Book> books = new ArrayList<>();
	private JFrame frame;
	private JTextField searchTextField;
	private JLabel title;
	private JComboBox<String> searchByComboBox;
	private JLabel searchByLbl;
	private JLabel searchForLbl;
	private JScrollPane searchResultScrollPane;
	private JList<CartItem> searchResultList;
	private JLabel searchResultLbl;
	private JButton addToCartBtn;
	private DefaultListModel<CartItem> cart;
	private JButton viewCartBtn;
	private JButton searchBtn;
	private JLabel isbnLbl;
	private JLabel bookTitleLbl;
	private JLabel authorLbl;
	private JLabel publisherLbl;
	private JLabel categoryLbl;
	private JLabel priceLbl;
	private JLabel isbn;
	private JLabel bookTitle;
	private JLabel author;
	private JLabel publisher;
	private JLabel category;
	private JLabel price;
	private JLabel quantityLbl;
	private JButton viewProfileBtn;
	private JButton orderBtn;
	private JButton promotionBtn;
	private JButton modifyBook;
	static DefaultListModel<CartItem> searchResults = new DefaultListModel<CartItem>();
	static DefaultListModel<CartItem> shoppingcart = new DefaultListModel<CartItem>();
	//private int cartTotal = 0;  //TODO

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() throws ClassNotFoundException, SQLException {
		DBManager.init_connection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.getContentPane().setLayout(null);
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setBounds(100, 100, 1121, 776);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Home page");
		
		title = new JLabel("Search For Books");
		title.setForeground(new Color(0, 0, 0));
		title.setBackground(Color.YELLOW);
		title.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setToolTipText("user's shopping cart");
		title.setBounds(0, 0, 391, 78);
		frame.getContentPane().add(title);
		
		searchByComboBox = new JComboBox<String>();
		searchByComboBox.setBackground(new Color(255, 250, 250));
		searchByComboBox.setToolTipText("search by");
		searchByComboBox.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 15));
		DefaultComboBoxModel<String> searchBy = new DefaultComboBoxModel<String>(new String[] {"ISBN", "Title", "Author", "Publisher", "Category"});   //TODO
		searchByComboBox.setModel(searchBy);
		searchByComboBox.setBounds(117, 154, 315, 40);
		frame.getContentPane().add(searchByComboBox);
		
		searchByLbl = new JLabel("Search by");
		searchByLbl.setForeground(new Color(0, 0, 0));
		searchByLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchByLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 15));
		searchByLbl.setLabelFor(searchByComboBox);
		searchByLbl.setBounds(10, 154, 97, 40);
		frame.getContentPane().add(searchByLbl);
		
		searchTextField = new JTextField();
		searchTextField.setToolTipText("Enter something to search for");
		searchTextField.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 15));
		searchTextField.setBackground(new Color(255, 250, 250));
		searchTextField.setBounds(117, 105, 315, 40);
		frame.getContentPane().add(searchTextField);
		searchTextField.setColumns(10);
		
		searchForLbl = new JLabel("Search for");
		searchForLbl.setLabelFor(searchTextField);
		searchForLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchForLbl.setForeground(new Color(0, 0, 0));
		searchForLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 15));
		searchForLbl.setBounds(10, 104, 97, 40);
		frame.getContentPane().add(searchForLbl);
		
		searchResultScrollPane = new JScrollPane();
		searchResultScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		searchResultScrollPane.setToolTipText("select one or more items to add to cart");
		searchResultScrollPane.setBounds(117, 236, 456, 363);
		frame.getContentPane().add(searchResultScrollPane);
		
		searchResultList = new JList<CartItem>();
		searchResultList.addListSelectionListener(new ListSelectionListener() {		// **********************************  show book info when list item is selected ************************
			public void valueChanged(ListSelectionEvent e) {
				CartItem c = searchResultList.getSelectedValue();
				isbn.setText(String.valueOf(c.getIsbn()));
				bookTitle.setText(c.getTitle());
				bookTitle.setToolTipText(c.getTitle());
				author.setText(c.getAuthor());
				publisher.setText(c.getPublisher());
				price.setText(c.getPrice() + " L.E.");
				category.setText(c.getCategory());
			}
		});
		searchResultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchResultList.setVisibleRowCount(10);
		searchResultScrollPane.setViewportView(searchResultList);
		searchResultList.setToolTipText("select an item to add to cart");
		searchResultList.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 18));
		searchResultList.setBorder(new LineBorder(new Color(255, 0, 255)));
		searchResultList.setBackground(new Color(255, 192, 203));
		
		//TODO here books
		
		searchResultList.setModel(searchResults);
		//DefaultListModel<CartItem> searchResults = new DefaultListModel<CartItem>();  //TODO
		//searchResults.addElement(new CartItem(1, "journy to the center of the earth", 50, "J.K.", "Person", "Science"));

		searchResultLbl = new JLabel("Results");
		searchResultLbl.setLabelFor(searchResultScrollPane);
		searchResultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchResultLbl.setForeground(new Color(0, 0, 0));
		searchResultLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 15));
		searchResultLbl.setBounds(10, 236, 97, 40);
		frame.getContentPane().add(searchResultLbl);
		JSpinner spinner = new JSpinner();
		spinner.setBackground(new Color(255, 250, 250));
		spinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
		spinner.setBounds(856, 572, 97, 27);
		frame.getContentPane().add(spinner);
		
		addToCartBtn = new JButton("Add to cart");
		addToCartBtn.addActionListener(new ActionListener() {  //*************************************** add to cart ***************************************************
			public void actionPerformed(ActionEvent e) {
					int idx = searchResultList.getSelectedIndex();
					boolean flag = true;
					if(idx>=0) {
						CartItem c = searchResultList.getSelectedValue();
						for(int i =0;i<shoppingcart.size();i++) {
							if(c.getIsbn().compareTo(shoppingcart.get(i).getIsbn())==0) {
								CartItem item =shoppingcart.get(i);
								item.setQuantityInCart(item.getQuantityInCart() +(int) spinner.getValue());
								flag = false;
							}
						}
						if(flag) {
							c.setQuantityInCart((int) spinner.getValue());
							shoppingcart.addElement(c);
							JOptionPane.showMessageDialog(frame,"Item has been added to cart","Alert",JOptionPane.INFORMATION_MESSAGE);

						}
					}
					else {
						JOptionPane.showMessageDialog(frame,"Select a book from list","Alert",JOptionPane.WARNING_MESSAGE);

					}
			}
		});
		addToCartBtn.setBackground(new Color(128, 0, 128));
		addToCartBtn.setForeground(new Color(255, 250, 250));
		addToCartBtn.setBorderPainted(false);
		addToCartBtn.setFocusPainted(false);
		addToCartBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		addToCartBtn.setToolTipText("click to add selected items to the cart");
		addToCartBtn.setBounds(725, 633, 139, 40);
		frame.getContentPane().add(addToCartBtn);
		cart = new DefaultListModel<CartItem>();
		
		viewCartBtn = new JButton("View Cart");
		viewCartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Cart.u= u;
				Cart.cart= shoppingcart;
				Cart.main(null);
			}
		});
		viewCartBtn.setToolTipText("go to cart");
		viewCartBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		viewCartBtn.setBackground(new Color(128, 0, 128));
		viewCartBtn.setForeground(new Color(255, 250, 250));
		viewCartBtn.setBorderPainted(false);
		viewCartBtn.setFocusPainted(false);
		viewCartBtn.setBounds(910, 37, 139, 40);
		frame.getContentPane().add(viewCartBtn);
		
		searchBtn = new JButton("search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type =  searchByComboBox.getItemAt(searchByComboBox.getSelectedIndex());
				String key = searchTextField.getText() ;
				if(type==""|| type==null) {
					JOptionPane.showMessageDialog(frame,"Select item from box","Alert",JOptionPane.WARNING_MESSAGE);

				}
				else if(key == "" || key == null) {
					JOptionPane.showMessageDialog(frame,"Enter a few letters for search","Alert",JOptionPane.WARNING_MESSAGE);

				}
				else {
					DBoperation op = new DBoperation();
				    books = op.searchBooks(key, type);
				    searchResults = new DefaultListModel<CartItem>();
					searchResultList.setModel(searchResults);
				   // int isbn, String title, int price, String author, String publisher, String category
				    for(int i=0;i<books.size();i++) {
				    	Book b = books.get(i);
				    	CartItem c =new CartItem(b.getISBN(), b.getTitle(), b.getSellingPrice(),b.getAuthor(),b.getPublisher(),b.getCategory());
				    	c.setYear(b.getPublicationYear());
				    	c.setThreshold(b.getThreshold());
				    	searchResults.addElement(c);
				    }
				    if(searchResults.size()==0) {
						JOptionPane.showMessageDialog(frame,"There's no results","Alert",JOptionPane.WARNING_MESSAGE);

				    }
				}
			    frame.repaint();
				
			}
		});
		searchBtn.setToolTipText("search");
		searchBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		searchBtn.setBackground(new Color(128, 0, 128));
		searchBtn.setForeground(new Color(255, 250, 250));
		searchBtn.setBorderPainted(false);
		searchBtn.setFocusPainted(false);
		searchBtn.setBounds(476, 153, 97, 40);
		frame.getContentPane().add(searchBtn);
		
		isbnLbl = new JLabel("ISBN number : ");
		isbnLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		isbnLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		isbnLbl.setForeground(new Color(0, 0, 0));
		isbnLbl.setBounds(644, 230, 156, 27);
		frame.getContentPane().add(isbnLbl);
		
		bookTitleLbl = new JLabel("Book Title : ");
		bookTitleLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		bookTitleLbl.setForeground(new Color(0, 0, 0));
		bookTitleLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		bookTitleLbl.setBounds(644, 280, 156, 27);
		frame.getContentPane().add(bookTitleLbl);
		
		authorLbl = new JLabel("Author : ");
		authorLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLbl.setForeground(new Color(0, 0, 0));
		authorLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		authorLbl.setBounds(644, 330, 156, 27);
		frame.getContentPane().add(authorLbl);
		
		publisherLbl = new JLabel("Publisher : ");
		publisherLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		publisherLbl.setForeground(new Color(0, 0, 0));
		publisherLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		publisherLbl.setBounds(644, 380, 156, 27);
		frame.getContentPane().add(publisherLbl);
		
		categoryLbl = new JLabel("Category : ");
		categoryLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		categoryLbl.setForeground(new Color(0, 0, 0));
		categoryLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		categoryLbl.setBounds(644, 430, 156, 27);
		frame.getContentPane().add(categoryLbl);
		
		priceLbl = new JLabel("Price : ");
		priceLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		priceLbl.setForeground(new Color(0, 0, 0));
		priceLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		priceLbl.setBounds(644, 480, 156, 27);
		frame.getContentPane().add(priceLbl);
		
		isbn = new JLabel("_________");
		isbn.setHorizontalAlignment(SwingConstants.CENTER);
		isbn.setForeground(new Color(0, 0, 0));
		isbn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		isbn.setBounds(830, 230, 156, 27);
		frame.getContentPane().add(isbn);
		
		bookTitle = new JLabel("_________");
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitle.setForeground(new Color(0, 0, 0));
		bookTitle.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		bookTitle.setBounds(830, 280, 156, 27);
		frame.getContentPane().add(bookTitle);
		
		author = new JLabel("_________");
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setForeground(new Color(0, 0, 0));
		author.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		author.setBounds(830, 330, 156, 27);
		frame.getContentPane().add(author);
		
		publisher = new JLabel("_________");
		publisher.setHorizontalAlignment(SwingConstants.CENTER);
		publisher.setForeground(new Color(0, 0, 0));
		publisher.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		publisher.setBounds(830, 380, 156, 27);
		frame.getContentPane().add(publisher);
		
		category = new JLabel("_________");
		category.setHorizontalAlignment(SwingConstants.CENTER);
		category.setForeground(new Color(0, 0, 0));
		category.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		category.setBounds(830, 430, 156, 27);
		frame.getContentPane().add(category);
		
		price = new JLabel("_________");
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setForeground(new Color(0, 0, 0));
		price.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		price.setBounds(830, 480, 156, 27);
		frame.getContentPane().add(price);
		
		quantityLbl = new JLabel("specify quantity");
		quantityLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		quantityLbl.setForeground(new Color(0, 0, 0));
		quantityLbl.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 20));
		quantityLbl.setBounds(644, 572, 156, 27);
		frame.getContentPane().add(quantityLbl);
		
		
		
		JButton logOutBtn = new JButton("Log out");
		logOutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				SignIn.u=null;
				Cart.cart = new DefaultListModel<CartItem>();
				shoppingcart= new DefaultListModel<CartItem>();
				searchResultList.setModel( new DefaultListModel<CartItem>());
				searchResults = new DefaultListModel<CartItem>();
				
				SignIn.main(null);
			}
		});
		logOutBtn.setToolTipText("log out");
		logOutBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		logOutBtn.setBackground(new Color(128, 0, 128));
		logOutBtn.setForeground(new Color(255, 250, 250));
		logOutBtn.setBorderPainted(false);
		logOutBtn.setFocusPainted(false);
		logOutBtn.setBounds(10, 689, 139, 40);
		frame.getContentPane().add(logOutBtn);
		
		viewProfileBtn = new JButton("View Profile");
		viewProfileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Profile.u=u;
				Profile.main(null);
			}
		});

		viewProfileBtn.setToolTipText("go to cart");
		viewProfileBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		viewProfileBtn.setBackground(new Color(128, 0, 128));
		viewProfileBtn.setForeground(new Color(255, 250, 250));
		viewProfileBtn.setBorderPainted(false);
		viewProfileBtn.setFocusPainted(false);
		viewProfileBtn.setBounds(744, 38, 139, 40);
		frame.getContentPane().add(viewProfileBtn);
		
		orderBtn = new JButton("Order");
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Orders.u=u;
				Orders.main(null);
			}
		});

		orderBtn.setToolTipText("go to cart");
		orderBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		orderBtn.setBackground(new Color(128, 0, 128));
		orderBtn.setForeground(new Color(255, 250, 250));
		orderBtn.setBorderPainted(false);
		orderBtn.setFocusPainted(false);
		orderBtn.setBounds(744, 106, 139, 40);
		frame.getContentPane().add(orderBtn);
		
		promotionBtn = new JButton("Promotion");
		promotionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Promotion.u =u;
				Promotion.main(null);
			}
		});
		promotionBtn.setToolTipText("go to cart");

		promotionBtn.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		promotionBtn.setBackground(new Color(128, 0, 128));
		promotionBtn.setForeground(new Color(255, 250, 250));
		promotionBtn.setBorderPainted(false);
		promotionBtn.setFocusPainted(false);

		promotionBtn.setBounds(910, 105, 139, 40);
		frame.getContentPane().add(promotionBtn);
		
		modifyBook = new JButton("Modify book");
		modifyBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CartItem c = searchResultList.getSelectedValue();
				if(c == null) {
					JOptionPane.showMessageDialog(frame,"Select a book from list","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else {
					AddBook a = new AddBook("Modify", "Modify Book");
					a.book=c;
					a.setinfo();
				}
			}
		});
		modifyBook.setToolTipText("click to add selected items to the cart");
		modifyBook.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 18));
		modifyBook.setBackground(new Color(128, 0, 128));
		modifyBook.setForeground(new Color(255, 250, 250));
		modifyBook.setBorderPainted(false);
		modifyBook.setFocusPainted(false);
		modifyBook.setBounds(274, 633, 158, 40);
		frame.getContentPane().add(modifyBook);
		if(!u.isManager()) {
			modifyBook.setVisible(false);
			promotionBtn.setVisible(false);
			orderBtn.setVisible(false);
			
		}
		
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
