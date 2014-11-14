package Mess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeLogin {

	static Connection conn = null;
	
	
public static boolean validateLogin(String idnumber,String password){
		
		boolean flag = false;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			
			String query = "SELECT * FROM employee WHERE emp_id ='"+idnumber+"' AND password ='"+ password + "'" ;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
				
			while(rs.next()){
				flag = true;
				System.out.println("Name: "+rs.getString("name")+" ID: "+rs.getString("emp_id") + " Designation: "+rs.getString("designation"));
				EmployeeClient.designation = rs.getString("designation");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
	
	public static void main(String[] args) {
		
		
		

	}

}
