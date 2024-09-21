package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print, update, cancel;
    String userRole; 
    String rollno; 

    
    StudentDetails(String role, String rollno) {
    this.userRole = role; // Correct assignment
    this.rollno = rollno;

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("Search by Roll Number");
    heading.setBounds(20, 20, 150, 20);
    add(heading);

    crollno = new Choice();
    crollno.setBounds(180, 20, 150, 20);
    add(crollno);

    // Populate the Choice component with roll numbers if the role is Admin
    if (userRole.equals("Admin")) {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select rollno from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        crollno.setVisible(false); // Hide Choice for Student
    }

    table = new JTable();
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(0, 100, 900, 600);
    add(jsp);

    search = new JButton("Search");
    search.setBounds(20, 70, 80, 20);
    search.addActionListener(this);
    add(search);

    print = new JButton("Print");
    print.setBounds(120, 70, 80, 20);
    print.addActionListener(this);
    add(print);

    update = new JButton("Update");
    update.setBounds(220, 70, 80, 20);
    update.addActionListener(this);
    add(update);

    cancel = new JButton("Cancel");
    cancel.setBounds(320, 70, 80, 20);
    cancel.addActionListener(this);
    add(cancel);

    // Hide search button for students since they cannot search other students
    if (!userRole.equals("Admin")) {
        search.setVisible(false);
        heading.setVisible(false);
    }

    // Initialize table data based on the role
    updateTable();

    setSize(900, 700);
    setLocation(300, 100);
    setVisible(true);
}


    // Method to update the table based on role and rollno
    private void updateTable() {
    try {
        Conn c = new Conn();
        String query = "select * from student where rollno = ?";
        
        // Check if the role is Admin or Student
        if (userRole.equals("Admin")) {
            query = "select * from student"; // Admin sees all students
        }

        PreparedStatement pst = c.c.prepareStatement(query);
        
        // If role is Student, set the rollno for query
        if (!userRole.equals("Admin")) {
            pst.setString(1, rollno); // For students, display only their own details
        }
        
        ResultSet rs = pst.executeQuery();
        
        // Populate the table with student details
        table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String selectedRollNo = crollno.getSelectedItem();
            if (selectedRollNo == null || selectedRollNo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select a Roll Number");
                return;
            }
            String query = "select * from student where rollno = ?";
            try {
                Conn c = new Conn();
                PreparedStatement pst = c.c.prepareStatement(query);
                pst.setString(1, selectedRollNo);
                ResultSet rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails("Admin", null);
    }
}
