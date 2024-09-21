package campus.connect;

import java.sql.*;

public class Conn {
    
   public Connection c;
   public  Statement s;

    // Constructor to establish the connection
    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/campusconnect", "root", "");
            s = c.createStatement();
            System.out.println("Connection Successful!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
            
        new Conn();
    }
}


