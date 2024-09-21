//package campus.connect;
//
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class StudentLeaveDetails extends JFrame implements ActionListener {
//    private JComboBox<String> leaveIdComboBox;
//    private JButton btnApprove, btnReject, btnBack;
//    private JTextArea txtLeaveDetails;
//
//    public StudentLeaveDetails() {
//        setTitle("Leave Approval Form");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(null);
//
//        JLabel lblLeaveId = new JLabel("Leave ID:");
//        lblLeaveId.setBounds(20, 20, 100, 25);
//        add(lblLeaveId);
//
//        leaveIdComboBox = new JComboBox<>();
//        leaveIdComboBox.setBounds(150, 20, 200, 25);
//        add(leaveIdComboBox);
//
//        btnApprove = new JButton("Approve");
//        btnApprove.setBounds(150, 60, 100, 30);
//        add(btnApprove);
//
//        btnReject = new JButton("Reject");
//        btnReject.setBounds(270, 60, 100, 30);
//        add(btnReject);
//
//        btnBack = new JButton("Back");
//        btnBack.setBounds(390, 60, 80, 30);
//        btnBack.addActionListener(this);
//        add(btnBack);
//
//        txtLeaveDetails = new JTextArea();
//        txtLeaveDetails.setBounds(20, 100, 440, 250);
//        add(txtLeaveDetails);
//
//        // Load Leave IDs into the ComboBox
//        loadLeaveIds();
//
//        // Add ItemListener to ComboBox to detect changes in selection
//        leaveIdComboBox.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    String selectedLeaveId = (String) leaveIdComboBox.getSelectedItem();
//                    fetchLeaveDetails(selectedLeaveId);
//                }
//            }
//        });
//
//        // Approve button action
//        btnApprove.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                updateLeaveStatus("Approved");
//            }
//        });
//
//        // Reject button action
//        btnReject.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                updateLeaveStatus("Rejected");
//            }
//        });
//
//        setLocation(760, 350);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == btnBack) {
//            setVisible(false);
//        }
//    }
//
//    // Load Leave IDs into ComboBox
//   // Load Leave IDs into ComboBox
//private void loadLeaveIds() {
//    try {
//        Conn c = new Conn();
//        String sql = "SELECT id FROM studentleave WHERE status = 'Pending'";
//        Statement st = c.c.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//
//        if (rs.next()) {
//            String firstLeaveId = rs.getString("id");
//            leaveIdComboBox.addItem(firstLeaveId);
//            
//            // Fetch details for the first Leave ID by default
//            fetchLeaveDetails(firstLeaveId);
//
//            // Continue populating other Leave IDs if available
//            while (rs.next()) {
//                leaveIdComboBox.addItem(rs.getString("id"));
//            }
//        }
//
//        c.c.close();
//    } catch (Exception ex) {
//        ex.printStackTrace();
//    }
//}
//
//
//    // Fetch leave details based on selected Leave ID
//    private void fetchLeaveDetails(String leaveId) {
//        try {
//            Conn c = new Conn();
//            String sql = "SELECT * FROM studentleave WHERE id = ?";
//            PreparedStatement pstmt = c.c.prepareStatement(sql);
//            pstmt.setString(1, leaveId);
//            ResultSet rs = pstmt.executeQuery();
//
//            StringBuilder leaveDetails = new StringBuilder();
//            if (rs.next()) {
//                leaveDetails.append("Leave ID: ").append(rs.getInt("id"))
//                            .append(", Student Roll No: ").append(rs.getInt("rollno"))
//                            .append(", Reason: ").append(rs.getString("leave_reason"))
//                            .append(", From: ").append(rs.getString("leave_from"))
//                            .append(", To: ").append(rs.getString("leave_to"))
//                            .append(", Status: ").append(rs.getString("status"))
//                            .append("\n");
//            }
//
//            txtLeaveDetails.setText(leaveDetails.toString());
//            c.c.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    // Update leave status based on approval or rejection
//    private void updateLeaveStatus(String status) {
//        String leaveId = (String) leaveIdComboBox.getSelectedItem();  // Get the selected leave ID
//        
//        try {
//            Conn c = new Conn();
//            String sql = "UPDATE studentleave SET status = ? WHERE id = ?";
//            PreparedStatement pstmt = c.c.prepareStatement(sql);
//            pstmt.setString(1, status);
//            pstmt.setString(2, leaveId);
//
//            int result = pstmt.executeUpdate();
//            if (result > 0) {
//                JOptionPane.showMessageDialog(null, "Leave " + status + " Successfully");
//            } else {
//                JOptionPane.showMessageDialog(null, "Failed to Update Leave Status");
//            }
//
//            c.c.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        new StudentLeaveDetails();
//    }
//}



package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    private JComboBox<String> leaveIdComboBox;
    private JButton btnApprove, btnReject, btnBack;
    private JTextArea txtLeaveDetails;

    public TeacherLeaveDetails() {
        setTitle("Leave Approval Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Label for Leave ID
        JLabel lblLeaveId = new JLabel("Leave ID:");
        lblLeaveId.setBounds(50, 30, 300, 40); 
        lblLeaveId.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        add(lblLeaveId);

        // ComboBox to select Leave ID
        leaveIdComboBox = new JComboBox<>();
        leaveIdComboBox.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        leaveIdComboBox.setBounds(150, 20, 200, 25);
        add(leaveIdComboBox);

        // Approve button
        btnApprove = new JButton("Approve");
        btnApprove.setBounds(150, 60, 100, 30);
        btnApprove.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        add(btnApprove);

        // Reject button
        btnReject = new JButton("Reject");
        btnReject.setBounds(270, 60, 100, 30);
        btnReject.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        add(btnReject);

        // Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(390, 60, 80, 30);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 25)); 
        add(btnBack);

        // Text area to display leave details
        txtLeaveDetails = new JTextArea();
        txtLeaveDetails.setBounds(20, 150, 300, 300);
        add(txtLeaveDetails);

        // Load Leave IDs into the ComboBox
        loadLeaveIds();

        // Add ItemListener to ComboBox to detect changes in selection
        leaveIdComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedLeaveId = (String) leaveIdComboBox.getSelectedItem();
                    fetchLeaveDetails(selectedLeaveId);
                }
            }
        });

        // Approve button action
        btnApprove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLeaveStatus("Approved");
            }
        });

        // Reject button action
        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLeaveStatus("Rejected");
            }
        });

        // Back button action
        btnBack.addActionListener(this);

        setLocation(760, 350);
        setVisible(true);
    }

    // Back button action handling
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBack) {
            setVisible(false); // Hide the current frame
        }
    }

    // Load Leave IDs into ComboBox
    private void loadLeaveIds() {
        try {
            Conn c = new Conn();
            String sql = "SELECT id FROM teacherleave WHERE status = 'Pending'";
            Statement st = c.c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String firstLeaveId = rs.getString("id");
                leaveIdComboBox.addItem(firstLeaveId);
                
                // Fetch details for the first Leave ID by default
                fetchLeaveDetails(firstLeaveId);

                // Continue populating other Leave IDs if available
                while (rs.next()) {
                    leaveIdComboBox.addItem(rs.getString("id"));
                }
            }

            c.c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Fetch leave details based on selected Leave ID
    // Fetch leave details based on selected Leave ID
    private void fetchLeaveDetails(String leaveId) {
        try {
            Conn c = new Conn();
            String sql = "SELECT * FROM studentleave WHERE id = ?";
            PreparedStatement pstmt = c.c.prepareStatement(sql);
            pstmt.setString(1, leaveId);
            ResultSet rs = pstmt.executeQuery();

            StringBuilder leaveDetails = new StringBuilder();
            if (rs.next()) {
                leaveDetails.append("Leave ID - ").append(rs.getInt("id")).append("\n")
                            .append("Student Roll No - ").append(rs.getInt("rollno")).append("\n")
                            .append("Reason - ").append(rs.getString("leave_reason")).append("\n")
                            .append("From - ").append(rs.getString("leave_from")).append("\n")
                            .append("To - ").append(rs.getString("leave_to")).append("\n")
                            .append("Status - ").append(rs.getString("status")).append("\n");
            }

            txtLeaveDetails.setText(leaveDetails.toString());
            c.c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }

    // Update leave status based on approval or rejection
    private void updateLeaveStatus(String status) {
        String leaveId = (String) leaveIdComboBox.getSelectedItem();  // Get the selected leave ID
        
        try {
            Conn c = new Conn();
            String sql = "UPDATE studentleave SET status = ? WHERE id = ?";
            PreparedStatement pstmt = c.c.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setString(2, leaveId);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Leave " + status + " Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Update Leave Status");
            }

            c.c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();  // Corrected class instantiation
    }
}
