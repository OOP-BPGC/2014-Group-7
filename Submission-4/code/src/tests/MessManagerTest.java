import static org.junit.Assert.*;

package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class MessManagerTest {

    @Test
    public void testValidateLogin() {
   
       
        assertEquals(MessManager.validateLogin("yash","pass"), true); //right ID
        assertEquals(MessManager.validateLogin("yash","1234"), false); //right ID wrong password
        assertEquals(MessManager.validateLogin("yash123","pass"), false); //wrong ID right password
       
    }



    @Test
    public void testUpdateName() {
       
        String id = "1111";
        String nameCheck = "";
        MessManager.updateName("sanath", "1111");//test example
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
            Statement stmt = conn.createStatement();
           
            String update = "SELECT name from manager WHERE id = '"+id+"'";
            ResultSet result = stmt.executeQuery(update);
            String test = result.getString("name");
            assertEquals(nameCheck,test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            assertFalse(false);
        }
    }

    @Test
    public void testUpdateMobile() {

        String id = "1111";//test example
        String mobileCheck = "99999999999";
        MessManager.updateMobile("99999999999", "1111");//test example
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
            Statement stmt = conn.createStatement();
           
            String update = "SELECT mobileno from manager WHERE id = '"+id+"'";
            ResultSet result = stmt.executeQuery(update);
            String test = result.getString("mobileno");
            assertEquals(mobileCheck,test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            assertFalse(false);
        }
    }

    @Test
    public void testUpdateAddress() {
        String id = "1111";//test example
        String addressCheck = "Abc road goa";
        MessManager.updateAddress("Abc road goa", "1111");//test example
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
            Statement stmt = conn.createStatement();
           
            String update = "SELECT address from manager WHERE id = '"+id+"'";
            ResultSet result = stmt.executeQuery(update);
            String test = result.getString("address");
            assertEquals(addressCheck,test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            assertFalse(false);
        }
    }

    @Test
    public void testUpdatePassword()
    {String id = "1234";//test example
    String passwordCheck = "qwerty";
    MessManager.updatePassword("qwerty", "1234");//test example
    Connection conn;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
        Statement stmt = conn.createStatement();
       
        String update = "SELECT password from manager WHERE id = '"+id+"'";
        ResultSet result = stmt.executeQuery(update);
        String test = result.getString("password");
        assertEquals(passwordCheck,test);
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        assertFalse(false);
    }
    }

    @Test
    public void testUpdateEmail() {
        String id = "1111";
        String emailCheck = "f2013006@goa.bits-pilani.ac.in";
        MessManager.updateEmail("f2013006@goa.bits-pilani.ac.in", "1111");//test example
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
            Statement stmt = conn.createStatement();
           
            String update = "SELECT email from manager WHERE id = '"+id+"'";
            ResultSet result = stmt.executeQuery(update);
            String test = result.getString("email");
            assertEquals(emailCheck,test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            assertFalse(false);
        }
    }

   

    @Test
    //Change return type to boolean flag
    public void testPendingLeaveRecords() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdatePrice() {
        String mealCheck = "1234";//test example
        int priceCheck = 300;
        MessManager.updatePrice("Lunch", 300);//test example
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hello", "root", "");
            Statement stmt = conn.createStatement();
           
            String update = "SELECT price from rates WHERE meal = '"+mealCheck+"'";
            ResultSet result = stmt.executeQuery(update);
            String test = result.getString("price");
            assertEquals(priceCheck,test);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            assertFalse(false);
        }
    }

}