package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DBoperation {
	public ArrayList<String[]> getOrders() {
		ArrayList<String[]> order = new ArrayList<String[]>();
		try {
			DBManager.rs = DBManager.st.executeQuery(String.format("Select * from book_order;"));
			System.out.println("Start get orders");
	         while(DBManager.rs.next()) {
	        	String[] info = new String[] {DBManager.rs.getString("ISBN"),
	        			DBManager.rs.getString("DateOut"),
	        			DBManager.rs.getString("No_Of_Copies"),
	        			DBManager.rs.getString("OrderId")};
	        	order.add(info);
	          	
	          }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
 		
	}
	public boolean placeOrder(String ISBN , int copies) {
		   Date d = new Date();  
		   Locale lcl = Locale.CHINA;  
		   // getting the instance by invoking the getDateInstance(int, Locale) method  
		   DateFormat dFormat = DateFormat.getDateInstance(DateFormat.SHORT, lcl);  
		  
		   	String str = dFormat.format(d);  
		   	System.out.println(str);  
		   try {
				int stat = DBManager.st.executeUpdate(String.format("INSERT INTO book_order(ISBN, DateOut, No_Of_Copies) VALUES('%s', '%s','%d');",
						ISBN,
						str,
						copies

						 ));
				if(stat>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {

				return false;
			}
	}
	public boolean confirmOrder(int id) {
		//DELETE FROM `book_store`.`book` WHERE (`ISBN` = '671728687');
		  try {
				int stat = DBManager.st.executeUpdate(String.format("DELETE FROM `book_store`.`book_order` WHERE (`OrderId` = '%d');",id));
				if(stat>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean updateUser(User u , String oldname) {
		//UPDATE `book_store`.`book_order` SET `No_Of_Copies` = '5' WHERE (`OrderId` = '2');
		System.out.println(String.format("UPDATE user SET User_name ='%s' ,Password = '%s',Lname = '%s',Fname = '%s',Email = '%s',Phone = '%s' ,ShAddress = '%s', Manager = %s WHERE (User_name = '%s');",
				u.getUser_name(),
				u.getPassword(),
				u.getLname(),
				u.getFname(),
				u.getEmail(),
				u.getPhone(),
				u.getShAddress(),
				u.isManager(),
				oldname));
		 try {
				int stat = DBManager.st.executeUpdate(String.format("UPDATE user SET User_name ='%s' ,Password = '%s',Lname = '%s',Fname = '%s',Email = '%s',Phone = '%s' ,ShAddress = '%s', Manager = %s WHERE (User_name = '%s');",
						u.getUser_name(),
						u.getPassword(),
						u.getLname(),
						u.getFname(),
						u.getEmail(),
						u.getPhone(),
						u.getShAddress(),
						u.isManager(),
						oldname));
				if(stat>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public boolean Updatepass(String old , String newpass , String username) {
		 try {
				int stat = DBManager.st.executeUpdate(String.format("UPDATE user SET User_name ='%s' ,Password = '%s' WHERE (User_name = '%s' and Password = '%s');",
							username,
							newpass,
							username,
							old));
				if(stat>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	public ArrayList<String> getCustomers(){
		ArrayList<String> users = new ArrayList<>();
		 try {
			DBManager.rs = DBManager.st.executeQuery(String.format("Select User_name from user WHERE Manager = 0;"));
			System.out.println("Start Fetching customers");
	         while(DBManager.rs.next()) {
	        	 users.add(DBManager.rs.getString("User_name"));
	          }

	 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			DBManager.rs = DBManager.st.executeQuery(String.format("SELECT * FROM book;"));
			System.out.println("Start get books");
	         while(DBManager.rs.next()) {
	        	 Book b = new Book();
	        	 b.setISBN(DBManager.rs.getString("ISBN"));
	        	 b.setTitle(DBManager.rs.getString("title"));
	        	// b.setAuthor(DBManager.rs.getString("Author"));
	        	 Statement s = DBManager.con.createStatement() ;
	        	 ResultSet r =s.executeQuery(String.format("SELECT Author FROM authors WHERE ISBN='%s';",b.getISBN()));
	        	 String auth="";
	        	 while(r.next()) {
	        		 auth= auth + r.getString("Author")+",";
	        	 }
	        	 b.setAuthor(auth);
	        	 b.setPublisher(DBManager.rs.getString("Publisher"));
	        	 b.setPublicationYear(DBManager.rs.getString("PublicationYear"));
	        	 b.setSellingPrice(Double.parseDouble(DBManager.rs.getString("SellingPrice")));
	        	 b.setCategory(DBManager.rs.getString("Category"));
	        	 b.setThreshold(Integer.parseInt(DBManager.rs.getString("Threshold")));
	        	 b.setQuantity(Integer.parseInt(DBManager.rs.getString("Quantity")));
	        	books.add(b);	          	
	          }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	public ArrayList<Book> searchBooks(String key , String type) {
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			DBManager.rs = DBManager.st.executeQuery("SELECT * FROM book_store.book WHERE "+type+" like '%"+key+"%';");
			System.out.println("Start get books");
	         while(DBManager.rs.next()) {
	        	 Book b = new Book();
	        	 b.setISBN(DBManager.rs.getString("ISBN"));
	        	 b.setTitle(DBManager.rs.getString("title"));
	        	// b.setAuthor(DBManager.rs.getString("Author"));
	        	 Statement s = DBManager.con.createStatement() ;
	        	 ResultSet r =s.executeQuery(String.format("SELECT Author FROM authors WHERE ISBN='%s';",b.getISBN()));
	        	 String auth="";
	        	 while(r.next()) {
	        		 auth= auth + r.getString("Author")+",";
	        	 }
	        	 b.setAuthor(auth);
	        	 b.setPublisher(DBManager.rs.getString("Publisher"));
	        	 b.setPublicationYear(DBManager.rs.getString("PublicationYear"));
	        	 b.setSellingPrice(Double.parseDouble(DBManager.rs.getString("SellingPrice")));
	        	 b.setCategory(DBManager.rs.getString("Category"));
	        	 b.setThreshold(Integer.parseInt(DBManager.rs.getString("Threshold")));
	        	 b.setQuantity(Integer.parseInt(DBManager.rs.getString("Quantity")));
	        	books.add(b);	          	
	          }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	public boolean addBook(Book b) {
		 try {
				int stat = DBManager.st.executeUpdate(String.format("INSERT INTO book(ISBN, title, Publisher, PublicationYear, SellingPrice, Category, Threshold,Quantity) VALUES('%s', '%s','%s','%s', '%s','%f','%s','%d','%d');",
						b.getISBN(),
						b.getTitle(),
						b.getPublisher(),
						b.getPublicationYear(),
						b.getSellingPrice(),
						b.getCategory(),
						b.getThreshold(),
						b.getQuantity()
						 ));
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}


		
	}
	public boolean modifyBook(Book b) {
		 try {
				int stat = DBManager.st.executeUpdate(String.format("UPDATE book SET "
						+ "ISBN = '%s',"
						+ " title = '%s',"
						+ "Publisher='%s',"
						+ " PublicationYear= %s, "
						+ "SellingPrice= %f, "
						+ "Category = '%s', "
						+ "Threshold = %d,"
						+ "Quantity= %d WHERE ISBN = '%s';",
						b.getISBN(),
						b.getTitle(),
						b.getPublisher(),
						b.getPublicationYear(),
						b.getSellingPrice(),
						b.getCategory(),
						b.getThreshold(),
						b.getQuantity(),
						b.getISBN()
						 ));
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

	}
	public boolean promoteUser(String username) {
		 try {
				int stat = DBManager.st.executeUpdate(String.format("UPDATE user SET Manager = 1 WHERE User_name = '%s';",username ));
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

	}
	public boolean checkout(ArrayList<String> order){
		// ISBN quantity
		 try {
			 	DBManager.con.setAutoCommit(false);
			 	for(int i = 0;i<order.size();i++) {
			 		String[] info = order.get(i).split(" ");
			 		System.out.println(String.format("UPDATE book SET Quantity = Quantity - %s WHERE ISBN = '%s';",info[1],info[0] ));
			 		DBManager.st.executeUpdate(String.format("UPDATE book SET Quantity = Quantity - %s WHERE ISBN = '%s';",info[1],info[0] ));
			 	}
			 	DBManager.con.commit();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}


	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DBManager.init_connection();
		DBoperation op = new DBoperation();
		/*ArrayList<String> order=op.getOrders();
		for(int i=0;i<order.size();i++) {
			System.out.println(order.get(i));
		}*/
		//System.out.println(op.placeOrder("671728687", 10));
		//System.out.println(op.confirmOrder(1));
		User u = new User();
		u.User_name="Mariam";
		u.Password="888888";
		u.Email="mariamzaho@gmail.com";
		u.isManager=true;
		u.Phone="565302";
		u.ShAddress="akdjskd";
		//System.out.println(op.updateUser(u, "Mariam"));
		//ArrayList<Book> b = op.searchBooks("80", "ISBN");
		//System.out.println(b.size());
		//System.out.println(Arrays.toString(b.toArray()));
		 Book b = new Book();
    	 b.setISBN("5055656");
    	 b.setTitle("Test22");
    	 b.setAuthor("Tset");
    	 b.setPublisher("Arktos Media");
    	 b.setPublicationYear("2022");
    	 b.setSellingPrice(1000.5);
    	 b.setCategory("Science");
    	 b.setThreshold(5);
    	 b.setQuantity(20);
    	 //System.out.println(op.promoteUser("Ali"));
    	 ArrayList<String> o = new ArrayList<>();
    	 o.add("1180134001 5");
    	 o.add("5055656 5");
    	 System.out.println(op.getCustomers().size());
	}
}
