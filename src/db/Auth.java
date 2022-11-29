package db;

import java.sql.SQLException;
public class Auth {
	public User u = new User();
	public Auth() throws ClassNotFoundException, SQLException {
		DBManager.init_connection();
	}
	public boolean signin(String username , String password) {
	
			 try {
				DBManager.rs = DBManager.st.executeQuery(String.format("Select * from user where User_name = '%s' and Password = '%s';",username,password));
				System.out.println("Start sign in");
		         if(DBManager.rs.next()) {
		        	 u.setUser_name(DBManager.rs.getString("User_name"));
		        	 u.setPassword(DBManager.rs.getString("Password"));
		        	 u.setEmail(DBManager.rs.getString("Email"));
		        	 u.setLname(DBManager.rs.getString("Lname"));
		        	 u.setFname(DBManager.rs.getString("Fname"));
		        	 u.setPhone(DBManager.rs.getString("Phone"));
		        	 u.setShAddress(DBManager.rs.getString("ShAddress"));
		        	 boolean manager = (DBManager.rs.getString("Manager").compareTo("1")== 0)? true:false;
		        	 u.setManager(manager);
		        	 
		          	return true;
		          }
		         else {
		        	 return false;
		         }
		 		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

		
		
	}
	public boolean signup(User user) {
		 try {
			 System.out.println(String.format("INSERT INTO user(User_name, Password, Lname, Fname, Email, Phone, ShAddress) VALUES('%s', '%s','%s','%s', '%s','%s','%s');",
					 user.getUser_name(),
					 user.getPassword(),
					 user.getLname(),
					 user.getFname(),
					 user.getEmail(),
					 user.getPhone(),
					 user.getShAddress()
					 ));
			int stat = DBManager.st.executeUpdate(String.format("INSERT INTO user(User_name, Password, Lname, Fname, Email, Phone, ShAddress) VALUES('%s', '%s','%s','%s', '%s','%s','%s');",
					 user.getUser_name(),
					 user.getPassword(),
					 user.getLname(),
					 user.getFname(),
					 user.getEmail(),
					 user.getPhone(),
					 user.getShAddress()
					 ));
			u = user;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Auth a = new Auth();
		DBManager.init_connection();
		//System.out.println(a.signin("Ali Walid", "19331945"));
		User u = new User();
		u.User_name="Ahmed";
		u.Password="256560";
		u.Email="ali@gmail.com";
		u.isManager=true;
		u.Phone="565302";
		u.ShAddress="akdjskd";
		System.out.println(a.signup(u));
	}

}
