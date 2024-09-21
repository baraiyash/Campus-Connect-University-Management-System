package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FeeStructure extends JFrame {
    
    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(350, 10, 400, 30); // Center the heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        // Panel to display the results in the center
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(100, 100, 800, 500); // Adjust position and size
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new GridLayout(0, 1, 10, 10)); // One column layout
        add(contentPanel);
        
        try {
            Conn c = new Conn();
            String query = "SELECT f.fees, s.semester_name FROM fees_tbl f JOIN semester_tbl s ON f.semester_id = s.id";
            ResultSet rs = c.s.executeQuery(query);
            
            while (rs.next()) {
                String semesterName = rs.getString("semester_name");
                String fees = rs.getString("fees");

                // Display each row with semester name and fees
                JLabel label = new JLabel(semesterName + " Fees: " + fees);
                label.setFont(new Font("Tahoma", Font.PLAIN, 24)); // Set large font
                label.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
                contentPanel.add(label);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
