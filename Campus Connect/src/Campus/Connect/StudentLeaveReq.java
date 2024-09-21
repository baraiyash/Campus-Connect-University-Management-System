//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import com.toedter.calendar.JDateChooser;
//import java.awt.event.*;
//
//public class StudentLeaveReq extends JFrame implements ActionListener {
//
//    Choice  ctime;
//    JDateChooser dcdate;
//    JButton submit, cancel;
//    String userRole;
//    String rollno;
//    
//    StudentLeaveReq(String role,String rollno) {
//        
//        this.userRole = role;
//        this.rollno = rollno;
//         initializeUI();
//        
//        setSize(500, 550);
//        setLocation(550, 100);
//        setLayout(null);
//        
//        getContentPane().setBackground(Color.WHITE);
//        
////        JLabel heading = new JLabel("Apply Leave (Student)");
////        heading.setBounds(40, 50, 300, 30);
////        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
////        add(heading);
//        
//        setTitle("Student Leave Application");
//        setSize(400, 300);
//
//        JLabel rollnoLabel = new JLabel("Your Roll Number is: " + rollno);
//        rollnoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
//        rollnoLabel.setBounds(60, 100, 300, 30);
//        add(rollnoLabel);
//        
////        crollno = new Choice();
////        crollno.setBounds(60, 130, 200, 20);
////        add(crollno);
//        
//            // Populate the Choice component with roll numbers if the role is Admin
////          if (userRole.equals("Admin")) {
////              try {
////                  Conn c = new Conn();
////                  ResultSet rs = c.s.executeQuery("select rollno from student");
////                  while (rs.next()) {
////                      crollno.add(rs.getString("rollno"));
////                  }
////              } catch (Exception e) {
////                  e.printStackTrace();
////              }
////          } else {
////              crollno.setVisible(false); // Hide Choice for Student
////          }
//        
//        JLabel lbldate = new JLabel("Date");
//        lbldate.setBounds(60, 180, 200, 20);
//        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(lbldate);
//        
//        dcdate = new JDateChooser();
//        dcdate.setBounds(60, 210, 200, 25);
//        add(dcdate);
//        
//        JLabel lbltime = new JLabel("Time Duration");
//        lbltime.setBounds(60, 260, 200, 20);
//        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(lbltime);
//        
//        ctime = new Choice();
//        ctime.setBounds(60, 290, 200, 20);
//        ctime.add("Full Day");
//        ctime.add("Half Day");
//        add(ctime);
//        
//        submit = new JButton("Submit");
//        submit.setBounds(60, 350, 100, 25);
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(submit);
//        
//        cancel = new JButton("Cancel");
//        cancel.setBounds(200, 350, 100, 25);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(cancel);
//        
//        
//    
////   private void initializeUI() {
////        // Set up the frame
////        setTitle("Student Leave Application");
////        setSize(400, 300);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setLayout(new BorderLayout());
////
////        
////       
////        
////        setVisible(true);
////    }
//
//    
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == submit) {
//            // Handle null rollno appropriately
//            String rollno = rollno;
//            if (rollno == null) {
//                rollno = this.rollno; // Use the rollno passed in the constructor for students
//            }
//            
//            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
//            String duration = ctime.getSelectedItem();
//            
//            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+duration+"')";
//            
//            try {
//                Conn c = new Conn();
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Leave Confirmed");
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
//        new StudentLeaveReq("Admin",null);
//    }
//}


//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import com.toedter.calendar.JDateChooser;
//import java.awt.event.*;
//
//public class StudentLeaveReq extends JFrame implements ActionListener {
//    private JDateChooser dcdate;
//    private Choice ctime;
//    private JButton submit, cancel;
//    private String userRole;
//    private String rollno;
//
//    // Constructor accepting role and rollno
//    StudentLeaveReq(String role, String rollno) {
//        this.userRole = role;
//        this.rollno = rollno;
//        initializeUI();
//        
//         setSize(650, 650);
//        setLocation(350, 100);
//        setLayout(null);
//    }
//
//    // Method to initialize the user interface
//    private void initializeUI() {
//        setTitle("Student Leave Application");
//        setSize(500, 550);
//        setLocation(550, 100);
//        setLayout(null);
//        getContentPane().setBackground(Color.WHITE);
//
//        // Display roll number
//        JLabel rollnoLabel = new JLabel("Your Roll Number is: " + rollno);
//        rollnoLabel.setFont(new Font("Tahoma", Font.BOLD, 30)); // Increased font size
//        rollnoLabel.setBounds(60, 100, 700, 50); // Adjusted bounds for larger font
//        add(rollnoLabel);
//
//        // Date Label and Picker
//        JLabel lbldate = new JLabel("Date");
//        lbldate.setBounds(60, 150, 200, 25); // Adjusted bounds for larger font
//        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 25)); // Increased font size
//        add(lbldate);
//
//        dcdate = new JDateChooser();
//        dcdate.setBounds(60, 180, 300, 35); // Adjusted bounds for larger font
//        add(dcdate);
//
//        // Time Duration Label and Choice
//        JLabel lbltime = new JLabel("Time Duration");
//        lbltime.setBounds(60, 270, 200, 25); // Adjusted bounds for larger font
//        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 25)); // Increased font size
//        add(lbltime);
//
//        ctime = new Choice();
//        ctime.setFont(new Font("Tahoma", Font.BOLD, 25)); // Increased font size
//        ctime.setBounds(60, 300, 300, 35); // Adjusted bounds for larger font
//        ctime.add("Full Day");
//        ctime.add("Half Day");
//        add(ctime);
//
//        // Submit Button
//        submit = new JButton("Submit");
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        submit.setBounds(60, 380, 150, 50); // Adjusted bounds for larger button
//        submit.setFont(new Font("Tahoma", Font.BOLD, 20)); // Increased font size
//        add(submit);
//
//        // Cancel Button
//        cancel = new JButton("Cancel");
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setBounds(280, 380, 150, 50); // Adjusted bounds for larger button
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 20)); // Increased font size
//        add(cancel);
//
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == submit) {
//            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
//            String duration = ctime.getSelectedItem();
//            String query = "insert into studentleave values('" + rollno + "', '" + date + "', '" + duration + "')";
//
//            try {
//                Conn c = new Conn();
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Leave Confirmed");
//                setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == cancel) {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new StudentLeaveReq("Admin", null); // Example with a roll number
//    }
//}


package campus.connect;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class StudentLeaveReq extends JFrame {

    JTextField txtrollno;
    JButton btnSubmit, btnCancel;
    JComboBox<String> cbreason;
    JDateChooser dcfromdate, dctodate;
    String role,rollno;

    public StudentLeaveReq(String userRole,String rollno) {

        this.role = userRole;
        this.rollno = rollno;

        setTitle("Student Leave Request Form");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Label: Student Roll No
        JLabel lblRollNo = new JLabel("Student Roll No:");
        lblRollNo.setBounds(50, 30, 300, 50);
        lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblRollNo);

        // Text field for roll number (non-editable)
        txtrollno = new JTextField(rollno);
        txtrollno.setBounds(270, 30, 300, 40);
        txtrollno.setFont(new Font("Tahoma", Font.BOLD, 25));
        txtrollno.setEditable(false); // Lock the roll number field
        add(txtrollno);

        // Label: Reason
        JLabel lblReason = new JLabel("Reason:");
        lblReason.setBounds(50, 100, 200, 40);
        lblReason.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblReason);

        // ComboBox for selecting reason
        String[] reason = {"Vaccation Leave", "Sick Leave", "Sports Leave","Emergency Leave"};
        cbreason = new JComboBox<>(reason);
        cbreason.setBounds(270, 100, 300, 40);
        cbreason.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(cbreason);

        // Label: From Date
        JLabel lblFromDate = new JLabel("From Date:");
        lblFromDate.setBounds(50, 170, 200, 40);
        lblFromDate.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblFromDate);

        // Date chooser for From Date
        dcfromdate = new JDateChooser();
        dcfromdate.setBounds(270, 170, 300, 40);
        dcfromdate.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(dcfromdate);

        // Label: To Date
        JLabel lblToDate = new JLabel("To Date:");
        lblToDate.setBounds(50, 240, 200, 40);
        lblToDate.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblToDate);

        // Date chooser for To Date
        dctodate = new JDateChooser();
        dctodate.setBounds(270, 240, 300, 40);
        dctodate.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(dctodate);

        // Submit button
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(150, 320, 150, 50);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(btnSubmit);

        // Cancel button
        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(350, 320, 150, 50);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(btnCancel);

        // Button action listeners
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitLeaveRequest();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setLocation(600, 250);
        setVisible(true);
    }

    public void submitLeaveRequest() {
        String rollno = txtrollno.getText();
        String reason = (String) cbreason.getSelectedItem();
        String fromDate = ((JTextField) dcfromdate.getDateEditor().getUiComponent()).getText();
        String toDate = ((JTextField) dctodate.getDateEditor().getUiComponent()).getText();

        try {
            Conn c = new Conn();
            String sql = "INSERT INTO studentleave (rollno, leave_reason, leave_from, leave_to) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(sql);
            pstmt.setString(1, rollno);
            pstmt.setString(2, reason);
            pstmt.setString(3, fromDate);
            pstmt.setString(4, toDate);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Leave Request Submitted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Submit Leave Request");
            }

            c.c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentLeaveReq("Admin",null); // Pass the roll number here
    }
}
