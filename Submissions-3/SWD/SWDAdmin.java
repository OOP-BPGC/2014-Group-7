package SWD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SWDAdmin {
	
	static Connection conn = null;
	
	//public boolean updateMessOption();
	//public boolean doFloppyPosting();
	
public static void approveLeave(Date start,Date end,String id){
	
	java.sql.Date sqlStartDate = new java.sql.Date(start.getTime());
	java.sql.Date sqlEndDate = new java.sql.Date(end.getTime());
		
	try {
		
		String query = "SELECT * FROM onleave WHERE id = '"+id+"'"; 
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			System.out.println("Already applied for leave with leaveID: "+rs.getString("leave_id"));
			return;
		}
		
		//System.out.println("util start"+start+"util end" + end);
		//System.out.println("sql start"+sqlStartDate+"sql end" + sqlEndDate);
		
		String update1 = "INSERT INTO onleave (start_date,end_date,ID) VALUES ('"+sqlStartDate+"','"+sqlEndDate+"','"+id+"')"; 
		int rows = stmt.executeUpdate(update1);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}	
	
public static void updateName(String name,String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		String update = "UPDATE test SET name = '"+name+"' WHERE id = '"+id+"'";
		int rows = stmt.executeUpdate(update);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

public static void sendBill(String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		
		String query = "SELECT * FROM test WHERE id ='"+id+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
			
		while(rs.next()){

			System.out.println("Name: "+rs.getString("name")+" | ID: "+rs.getString("id")+" | Total Bill: "+rs.getInt("bill"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}


public static void updateMobile(String mob,String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		String update = "UPDATE test SET mobileno = '"+mob+"' WHERE id = '"+id+"'";
		int rows = stmt.executeUpdate(update);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
public static void updateAddress(String address,String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		String update = "UPDATE test SET address = '"+address+"' WHERE id = '"+id+"'";
		int rows = stmt.executeUpdate(update);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public static void updatePassword(String password,String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		String update = "UPDATE test SET pwd = '"+password+"' WHERE id = '"+id+"'";
		int rows = stmt.executeUpdate(update);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public static void updateEmail(String email,String id){
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		Statement stmt = conn.createStatement();
		
		String update = "UPDATE test SET email = '"+email+"' WHERE id = '"+id+"'";
		int rows = stmt.executeUpdate(update);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

public static boolean find(String tobefound, int t){
		
		boolean flag = false;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			if(t==1){
				String query1 = "SELECT * FROM test WHERE id ='"+ tobefound + "'";
				ResultSet rs1 = stmt.executeQuery(query1);
				while(rs1.next()){
					flag = true;
					System.out.println("Student found.");
					System.out.println("Name: "+rs1.getString("name")+" ID: "+rs1.getString("id"));
				}
			}
					
			if(t==2){
				String query2 = "SELECT * FROM test WHERE name ='"+ tobefound + "'";
				ResultSet rs2 = stmt.executeQuery(query2);
				while(rs2.next()){
					flag = true;
					System.out.println("Student found.");
					System.out.println("Name: "+rs2.getString("name")+" ID: "+rs2.getString("id"));
				}
			
			} 
			if(flag==false)
				System.out.println("Student not found. Try again.");
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}


public static void viewDetails(String id){
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		
		String query = "SELECT * FROM test WHERE id ='"+id+"'" ;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			System.out.println("Name: "+rs.getString("name"));
			System.out.println("ID: "+rs.getString("id"));
			System.out.println("Bill: "+rs.getString("bill"));
			System.out.println("Mobile No.: "+rs.getString("mobileno"));
			System.out.println("Address: "+rs.getString("address"));
			System.out.println("Email ID: "+rs.getString("email"));

		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
	
public static boolean validateLogin(String idnumber,String password){
		
		boolean flag = false;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			
			String query = "SELECT * FROM test WHERE id ='"+idnumber+"' AND pwd ='"+ password + "'" ;
			//PreparedStatement pre = conn.prepareStatement(query);
			Statement stmt = conn.createStatement();
			//pre.setString(1, idnumber);
			//pre.setString(2, password);
			ResultSet rs = stmt.executeQuery(query);
			//ResultSet rs = pre.executeQuery(query);
				
			while(rs.next()){
				flag = true;
				System.out.println("Name: "+rs.getString("name")+" ID: "+rs.getString("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
public static void main(String args[]) throws ParseException{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date1 = sdf.parse("2009-12-31");
	Date date2 = sdf.parse("2010-01-31");
	
	
	SWDAdmin.approveLeave(date1, date2, "2011");
	
}
}

