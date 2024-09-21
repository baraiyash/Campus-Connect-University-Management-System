//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import com.toedter.calendar.JDateChooser;
//import java.awt.event.*;
//
//public class TeacherLeaveReq extends JFrame implements ActionListener {
//
//    Choice cEmpId, ctime;
//    JDateChooser dcdate;
//    JButton submit, cancel;
//    
//    TeacherLeaveReq() {
//        
//        setSize(500, 550);
//        setLocation(550, 100);
//        setLayout(null);
//        
//        getContentPane().setBackground(Color.WHITE);
//        
//        JLabel heading = new JLabel("Apply Leave (Teacher)");
//        heading.setBounds(40, 50, 300, 30);
//        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(heading);
//        
//        JLabel lblrollno = new JLabel("Search by Employee Id");
//        lblrollno.setBounds(60, 100, 200, 20);
//        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(lblrollno);
//        
//        cEmpId = new Choice();
//        cEmpId.setBounds(60, 130, 200, 20);
//        add(cEmpId);
//        
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from teacher");
//            while(rs.next()) {
//                cEmpId.add(rs.getString("empId"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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
//        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
//        add(submit);
//        
//        cancel = new JButton("Cancel");
//        cancel.setBounds(200, 350, 100, 25);
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
//            String rollno = cEmpId.getSelectedItem();
//            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
//            String duration = ctime.getSelectedItem();
//            
//            String query = "insert into teacherleave values('"+rollno+"', '"+date+"', '"+duration+"')";
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
//        new TeacherLeaveReq();
//    }
//}

package campus.connect;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class TeacherLeaveReq extends JFrame {

    JTextField txtempid;
    JButton btnSubmit, btnCancel;
    JComboBox<String> cbreason;
    JDateChooser dcfromdate, dctodate;
    String role,empId;
    
    public TeacherLeaveReq(String userRole, String empId) {
       this.role = userRole;
       this.empId = empId;
       
        setTitle("Teacher Leave Request Form");
        setSize(700, 450); // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE); // Set background color to white

        // Label: Employee ID
        JLabel lblEmployeeId = new JLabel("Employee ID:");
        lblEmployeeId.setBounds(50, 30, 300, 40); // Increased height for spacing
        lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(lblEmployeeId);

        // Text field for roll number
        txtempid = new JTextField();
        txtempid.setBounds(270, 30, 300, 40); // Adjusted size and position for better alignment
        txtempid.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        txtempid.setEditable(false); 
        txtempid.setText(empId); 
        add(txtempid);

        // Label: Reason
        JLabel lblReason = new JLabel("Reason:");
        lblReason.setBounds(50, 100, 200, 40); // Increased height for spacing
        lblReason.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(lblReason);

        // ComboBox for selecting reason
        String[] reason = {"Casual Leave", "Sick Leave", "Marriage Leave", "Maternity Leave", "Study Leave"};
        cbreason = new JComboBox<>(reason);
        cbreason.setBackground(Color.WHITE);
        cbreason.setBounds(270, 100, 300, 40); // Adjusted size for better alignment
        cbreason.setFont(new Font("Tahoma", Font.BOLD, 18)); // Set font to Tahoma
        add(cbreason);

        // Label: From Date
        JLabel lblFromDate = new JLabel("From Date:");
        lblFromDate.setBounds(50, 170, 200, 40); // Increased height for spacing
        lblFromDate.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(lblFromDate);

        // Date chooser for From Date
        dcfromdate = new JDateChooser();
        dcfromdate.setBounds(270, 170, 300, 40); // Adjusted size for better alignment
        dcfromdate.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(dcfromdate);

        // Label: To Date
        JLabel lblToDate = new JLabel("To Date:");
        lblToDate.setBounds(50, 240, 200, 40); // Increased height for spacing
        lblToDate.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(lblToDate);

        // Date chooser for To Date
        dctodate = new JDateChooser();
        dctodate.setBounds(270, 240, 300, 40); // Adjusted size for better alignment
        dctodate.setFont(new Font("Tahoma", Font.BOLD, 25)); // Set font to Tahoma
        add(dctodate);

        // Submit button
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBounds(150, 320, 150, 50); // Adjusted size for better visibility
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20)); // Set bold Tahoma font
        add(btnSubmit);

        // Cancel button
        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(350, 320, 150, 50); // Adjusted size for better visibility
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20)); // Set bold Tahoma font
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

        setLocation(600, 250); // Adjusted position of the window
        setVisible(true);
    }

    public void submitLeaveRequest() {
        String empId = txtempid.getText();
        String reason = (String) cbreason.getSelectedItem();
        String fromDate = ((JTextField) dcfromdate.getDateEditor().getUiComponent()).getText();
        String toDate = ((JTextField) dctodate.getDateEditor().getUiComponent()).getText();

        try {
            Conn c = new Conn();
            String sql = "INSERT INTO teacherleave (empId, leave_reason, leave_from, leave_to) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = c.c.prepareStatement(sql);
            pstmt.setString(1, empId);
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
        new TeacherLeaveReq("Admin",null);
    }
}
