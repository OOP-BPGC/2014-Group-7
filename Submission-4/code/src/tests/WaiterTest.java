package tests;
import Mess.*;

import org.junit.*;
import junit.framework.*;
import java.sql.*;
import java.text.ParseException;
import java.lang.*;
/*
 * Testing Waiter class
 */
public class WaiterTest extends TestCase {
	/*
	 * Test applyForLeave()
	 */
	public void testapplyForLeave() throws SQLException{
		Waiter testObj = new Waiter();
		Date start = new Date(1996,10,8);
		Date end = new Date(1996,11,8);
		String id = new String("11111"); //Add existing employee id
		/*
		 * test #1 - for existing leave status
		 */
		testObj.applyForLeave(start, end, id);
		
		assertEquals(false,testObj.isTestWhile());
		
		/*
		 * test #2 - Checking whether empleave_pending is updated
		 */
		testObj = new Waiter();
		start = new Date(1996,10,8);
		end = new Date(1996,11,8);
		id = new String("11111"); //Add employee id not existing in the database
		testObj.applyForLeave(start, end, id);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
		String query1 = "SELECT * FROM empleave_pending WHERE emp_id = '"+id+"'";
		Statement stmt = conn.createStatement();
		String update;
		ResultSet rs = stmt.executeQuery(query1);
		while(rs.next()){
			
			int leave_applied = rs.getInt("leave_applied");
			assertEquals(1,leave_applied);
			
			Statement stmt3 = conn.createStatement();
			
		}
	}
	/*
	 * Test to check if email is updated in the database 
	 */
	public void testUpdateEmail(){
		Waiter testObj = new Waiter();
		String id = "1111";
		String emailCheck = "f2013006@goa.bits-pilani.ac.in";
		testObj.updateEmail("f2013006@goa.bits-pilani.ac.in", "1111");//test example
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			
			String update = "SELECT email from employee WHERE id = '"+id+"'";
			ResultSet result = stmt.executeQuery(update);
			String test = result.getString("email");
			assertEquals(emailCheck,test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(false);
		}
		
	}
	public void testupdateName(){
		
		Waiter testObj = new Waiter();
		String id = "1234";//test example 
		String nameCheck = "Sumathi";
		testObj.updateName("Sumathi", "1234");//test example
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			
			String update = "SELECT name from employee WHERE id = '"+id+"'";
			ResultSet result = stmt.executeQuery(update);
			String test = result.getString("name");
			assertEquals(nameCheck,test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(false);
		}
		}
	public void testupdateAddress(){
		
		Waiter testObj = new Waiter();
		String id = "1234";//test example 
		String addressCheck = "Abc road goa";
		testObj.updateAddress("Abc road goa", "1234");//test example
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			
			String update = "SELECT address from employee WHERE id = '"+id+"'";
			ResultSet result = stmt.executeQuery(update);
			String test = result.getString("address");
			assertEquals(addressCheck,test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(false);
		}
		}
	public void testupdatePassword(){
		
		Waiter testObj = new Waiter();
		String id = "1234";//test example 
		String passwordCheck = "qwerty";
		testObj.updatePassword("qwerty", "1234");//test example
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			
			String update = "SELECT password from employee WHERE id = '"+id+"'";
			ResultSet result = stmt.executeQuery(update);
			String test = result.getString("password");
			assertEquals(passwordCheck,test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(false);
		}
		}
	public void testupdateMobile(){
		
		Waiter testObj = new Waiter();
		String id = "1234";//test example 
		String mobileCheck = "99999999999";
		testObj.updateMobile("99999999999", "1234");//test example
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
			Statement stmt = conn.createStatement();
			
			String update = "SELECT mobileno from employee WHERE id = '"+id+"'";
			ResultSet result = stmt.executeQuery(update);
			String test = result.getString("mobileno");
			assertEquals(mobileCheck,test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			assertFalse(false);
		}
		}
	
}
