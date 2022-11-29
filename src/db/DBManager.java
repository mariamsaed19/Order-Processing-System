package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	static Connection con = null ;
	static Statement st ;
	static ResultSet rs;
	public DBManager() throws ClassNotFoundException, SQLException{
		init_connection();
	}
	public static void init_connection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store","root","445566");
          st = con.createStatement();

	}
	public void close_connection() throws SQLException {
		con.close();
	}
	
	public static void main(String[] args) {
		try{
			init_connection();
			 rs = st.executeQuery("Select * from user where User_name = 'Ali Walid';");
            while(rs.next()) {
            	System.out.println("***"+rs.getString("User_name")+"***");
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
	}

}