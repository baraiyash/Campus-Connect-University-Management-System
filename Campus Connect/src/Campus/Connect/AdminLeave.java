package campus.connect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLeave extends JFrame implements ActionListener {
    private JTextField txtLeaveId;
    private JButton btnApprove, btnReject, btnViewRequests;
    private JTextArea txtLeaveDetails;
    JButton btnBack;
    JMenuItem menuFaculty, menuStudent;
    String leaveTable; // This will store the table name (studentleave or facultyleave)

    public AdminLeave() {
        setTitle("View Leave Requests");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu leaveApprovalMenu = new JMenu("View Leave Requests");
        
        // Menu Items
        menuFaculty = new JMenuItem("Faculty");
        menuStudent = new JMenuItem("Student");
        
        leaveApprovalMenu.add(menuFaculty);
        leaveApprovalMenu.add(menuStudent);
        menuBar.add(leaveApprovalMenu);
        
        setJMenuBar(menuBar);
        
        // Menu item actions
        menuFaculty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leaveTable = "facultyleave"; // Connect to faculty leave table
                txtLeaveDetails.setText("Faculty Leave Requests");
                viewLeaveRequests(); // Show faculty leave requests
            }

            private void AdminLeave() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        menuStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                leaveTable = "studentleave"; // Connect to student leave table
                txtLeaveDetails.setText("Student Leave Requests");
                viewLeaveRequests(); // Show student leave requests
            }
        });

        JLabel lblLeaveId = new JLabel("Leave ID:");
        lblLeaveId.setBounds(20, 20, 100, 25);
        add(lblLeaveId);

        txtLeaveId = new JTextField();
        txtLeaveId.setBounds(150, 20, 200, 25);
        add(txtLeaveId);

        btnViewRequests = new JButton("View Leave Requests");
        btnViewRequests.setBounds(20, 60, 200, 30);
        add(btnViewRequests);

        btnApprove = new JButton("Approve");
        btnApprove.setBounds(150, 100, 100, 30);
        add(btnApprove);

        btnReject = new JButton("Reject");
        btnReject.setBounds(270, 100, 100, 30);
        add(btnReject);

        btnBack = new JButton("Back");
        btnBack.setBounds(390, 100, 80, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        txtLeaveDetails = new JTextArea();
        txtLeaveDetails.setBounds(20, 150, 440, 200);
        add(txtLeaveDetails);

        // Button actions
        btnViewRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewLeaveRequests();
            }
        });

        btnApprove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLeaveStatus("Approved");
            }
        });

        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateLeaveStatus("Rejected");
            }
        });

        setLocation(760, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBack) {
            setVisible(false);
        }
    }

    private void viewLeaveRequests() {
        try {
            Conn c = new Conn();
            Statement st = c.c.createStatement();
            String sql = "SELECT * FROM " + leaveTable + " WHERE status = 'Pending'";
            ResultSet rs = st.executeQuery(sql);

            StringBuilder leaveDetails = new StringBuilder();
            while (rs.next()) {
                leaveDetails.append("Leave ID: ").append(rs.getInt("leave_id"))
                            .append(", ID: ").append(leaveTable.equals("studentleave") ? rs.getInt("rollno") : rs.getInt("emp_id"))
                            .append(", Reason: ").append(rs.getString("leave_reason"))
                            .append(", From: ").append(rs.getString("leave_from"))
                            .append(", To: ").append(rs.getString("leave_to"))
                            .append("\n");
            }

            txtLeaveDetails.setText(leaveDetails.toString());
            c.c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateLeaveStatus(String status) {
        String leaveId = txtLeaveId.getText();

        try {
            Conn c = new Conn();
            String sql = "UPDATE " + leaveTable + " SET status = ? WHERE leave_id = ?";
            PreparedStatement pstmt = c.c.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setInt(2, Integer.parseInt(leaveId));

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
        new AdminLeave();
    }
}
