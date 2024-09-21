//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.*;
//import java.awt.event.*;
//
//public class AddStudent extends JFrame implements ActionListener{
//    
//    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
//    JLabel labelrollno,dcdob;
//    JComboBox cbcourse, cbbranch;
//    JButton submit, cancel;
//    
//    Random ran = new Random();
//    long first4 = Math.abs((ran.nextLong() % 3L) + 1L);
//    
//    AddStudent() {
//        
//        setSize(900, 700);
//        setLocation(350, 50);
//        
//        setLayout(null);
//        
//        JLabel heading = new JLabel("New Student Details");
//        heading.setBounds(310, 30, 500, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 30));
//        add(heading);
//        
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(50, 150, 100, 30);
//        lblname.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblname);
//        
//        tfname = new JTextField();
//        tfname.setBounds(200, 150, 150, 30);
//        add(tfname);
//        
//        JLabel lblfname = new JLabel("Father's Name");
//        lblfname.setBounds(400, 150, 200, 30);
//        lblfname.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblfname);
//        
//        tffname = new JTextField();
//        tffname.setBounds(600, 150, 150, 30);
//        add(tffname);
//        
//        JLabel lblrollno = new JLabel("Roll Number");
//        lblrollno.setBounds(50, 200, 200, 30);
//        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblrollno);
//        
//        labelrollno = new JLabel("1533"+first4);
//        labelrollno.setBounds(200, 200, 200, 30);
//        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
//        add(labelrollno);
//        
//        JLabel lbldob = new JLabel("Date of Birth");
//        lbldob.setBounds(400, 200, 200, 30);
//        lbldob.setFont(new Font("serif", Font.BOLD, 20));
//        add(lbldob);
//        
//        dcdob = new JLabel();
//        dcdob.setBounds(600, 200, 150, 30);
//        add(dcdob);
//        
//        JLabel lbladdress = new JLabel("Address");
//        lbladdress.setBounds(50, 250, 200, 30);
//        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
//        add(lbladdress);
//        
//        tfaddress = new JTextField();
//        tfaddress.setBounds(200, 250, 150, 30);
//        add(tfaddress);
//        
//        JLabel lblphone = new JLabel("Phone");
//        lblphone.setBounds(400, 250, 200, 30);
//        lblphone.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblphone);
//        
//        tfphone = new JTextField();
//        tfphone.setBounds(600, 250, 150, 30);
//        add(tfphone);
//        
//        JLabel lblemail = new JLabel("Email Id");
//        lblemail.setBounds(50, 300, 200, 30);
//        lblemail.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblemail);
//        
//        tfemail = new JTextField();
//        tfemail.setBounds(200, 300, 150, 30);
//        add(tfemail);
//        
//        JLabel lblx = new JLabel("Class X (%)");
//        lblx.setBounds(400, 300, 200, 30);
//        lblx.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblx);
//        
//        tfx = new JTextField();
//        tfx.setBounds(600, 300, 150, 30);
//        add(tfx);
//        
//        JLabel lblxii = new JLabel("Class XII (%)");
//        lblxii.setBounds(50, 350, 200, 30);
//        lblxii.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblxii);
//        
//        tfxii = new JTextField();
//        tfxii.setBounds(200, 350, 150, 30);
//        add(tfxii);
//        
//        JLabel lblaadhar = new JLabel("Aadhar Number");
//        lblaadhar.setBounds(400, 350, 200, 30);
//        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblaadhar);
//        
//        tfaadhar = new JTextField();
//        tfaadhar.setBounds(600, 350, 150, 30);
//        add(tfaadhar);
//        
//        JLabel lblcourse = new JLabel("Course");
//        lblcourse.setBounds(50, 400, 200, 30);
//        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblcourse);
//        
//        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
//        cbcourse = new JComboBox(course);
//        cbcourse.setBounds(200, 400, 150, 30);
//        cbcourse.setBackground(Color.WHITE);
//        add(cbcourse);
//        
//        JLabel lblbranch = new JLabel("Branch");
//        lblbranch.setBounds(400, 400, 200, 30);
//        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblbranch);
//        
//        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
//        cbbranch = new JComboBox(branch);
//        cbbranch.setBounds(600, 400, 150, 30);
//        cbbranch.setBackground(Color.WHITE);
//        add(cbbranch);
//        
//        submit = new JButton("Submit");
//        submit.setBounds(250, 550, 120, 30);
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
//        add(submit);
//        
//        cancel = new JButton("Cancel");
//        cancel.setBounds(450, 550, 120, 30);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
//        add(cancel);
//        
//        setVisible(true);
//    }
//    
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == submit) {
//            String name = tfname.getText();
//            String fname = tffname.getText();
//            String rollno = labelrollno.getText();
//            String dob = dcdob.getText();
//            String address = tfaddress.getText();
//            String phone = tfphone.getText();
//            String email = tfemail.getText();
//            String x = tfx.getText();
//            String xii = tfxii.getText();
//            String aadhar = tfaadhar.getText();
//            String course = (String) cbcourse.getSelectedItem();
//            String branch = (String) cbbranch.getSelectedItem();
//            
//            try {
//                String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
//
//                Conn con = new Conn();
//                con.s.executeUpdate(query);
//                
//                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
//                setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            setVisible(false);
//        }
//    }
//    
//    public static void main(String[] args) {
//        new AddStudent();
//    }
//}


package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton submit, cancel;
    
        Random ran = new Random();
        long first4 = Math.abs((ran.nextLong() % 5L) + 6L);
    
    AddStudent() {
        
       
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(400, 40, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 150, 200, 30);
        tfname.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(500, 150, 250, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(750, 150, 200, 30);
        tffname.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblrollno);
        
        labelrollno = new JLabel(generateUniqueRollNumber());
        labelrollno.setBounds(250, 200, 250, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(500, 200, 250, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(750, 200, 200, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250, 250, 200, 30);
        tfaddress.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(750, 250, 200, 30);
        tfphone.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(250, 300, 200, 30);
        tfemail.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfemail);
        
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(500, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(750, 300, 200, 30);
        tfx.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfx);
        
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 250, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(250, 350, 200, 30);
        tfxii.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfxii);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(500, 350, 250, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(750, 350, 200, 30);
        tfaadhar.setFont(new Font("serif", Font.PLAIN, 25)); // Increased Font Size for Text
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 25)); // Reduced Font Size
        add(lblcourse);
        
        String[] course = {"BCA","BCOM","BBA","MCA","MCOM","MBA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(250, 400, 200, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
 
        
        submit = new JButton("Submit");
        submit.setBounds(250, 500, 150, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 25)); // Reduced Font Size
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(500, 500, 150, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 25)); // Reduced Font Size
        cancel.addActionListener(this);
        add(cancel);
        
        setTitle("Add Student");
        setSize(1000, 650);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }
    
     // Method to generate a unique roll number
    private String generateUniqueRollNumber() {
        String rollno = null;
        boolean isUnique = false;
        
        try {
            Conn con = new Conn();
            while (!isUnique) {
                Random ran = new Random();
                long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); // Generate a 4-digit random number
                rollno = "111" + first4; // Concatenate with fixed part "155"
                
                // Query to check if the roll number exists
                String query = "SELECT rollno FROM student WHERE rollno = '" + rollno + "'";
                ResultSet rs = con.s.executeQuery(query);
                
                if (!rs.next()) {
                    // If the result set is empty, the roll number is unique
                    isUnique = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rollno;
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
//            String branch = (String) cbbranch.getSelectedItem();
            
            try {
                String query = "insert into student values('" + name + "', '" + fname + "', '" + rollno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}
