package tests;
import Mess.*;
import SWD.*;

import org.junit.*;
import junit.framework.*;
import java.sql.*;
import java.text.ParseException;
import java.lang.*;
/*
 * Testing SWDAdmin class
 */
public class SWDAdminTest extends TestCase {
	/*
	 * Test ValidateLogin()
	 */
	public void testValidateLogin(){
		SWDAdmin testObj = new SWDAdmin();
		String id="5555";
		String pass="aaaa";
		assertEquals(true,testObj.validateLogin(id,pass ));
	}
	/*
	 * Testing Find()
	 */
	public void testFind(){
			SWDAdmin testObj = new SWDAdmin();
			String tbf="5555";
			String name="bhaargav";
			assertEquals(true,testObj.find(tbf, 1));
			assertEquals(true,testObj.find(name, 2));
		}
	/*
	 * Test to check if email is updated in the database 
	 */
	public void testUpdateEmail(){
		SWDAdmin testObj = new SWDAdmin();
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
		
		SWDAdmin testObj = new SWDAdmin();
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
		
		SWDAdmin testObj = new SWDAdmin();
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
		
		SWDAdmin testObj = new SWDAdmin();
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
		
		SWDAdmin testObj = new SWDAdmin();
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
