//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//import java.awt.event.*;
//
//public class TeacherDetails extends JFrame implements ActionListener {
//
//    Choice cEmpId;
//    JTable table;
//    JButton search, print, update, add, cancel;
//    
//    TeacherDetails() {
//        
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        
//        JLabel heading = new JLabel("Search by Employee Id");
//        heading.setBounds(20, 20, 150, 20);
//        add(heading);
//        
//        cEmpId = new Choice();
//        cEmpId.setBounds(180, 20, 150, 20);
//        add(cEmpId);
//        
//        // Populate the Choice component with employee IDs
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select empId from teacher");
//            while (rs.next()) {
//                cEmpId.add(rs.getString("empId"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        table = new JTable();
//        
//        // Display all teacher details initially
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from teacher");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(0, 100, 900, 600);
//        add(jsp);
//        
//        search = new JButton("Search");
//        search.setBounds(20, 70, 80, 20);
//        search.addActionListener(this);
//        add(search);
//        
//        print = new JButton("Print");
//        print.setBounds(120, 70, 80, 20);
//        print.addActionListener(this);
//        add(print);
//        
//        add = new JButton("Add");
//        add.setBounds(220, 70, 80, 20);
//        add.addActionListener(this);
//        add(add);
//        
//        update = new JButton("Update");
//        update.setBounds(320, 70, 80, 20);
//        update.addActionListener(this);
//        add(update);
//        
//        cancel = new JButton("Cancel");
//        cancel.setBounds(420, 70, 80, 20);
//        cancel.addActionListener(this);
//        add(cancel);
//        
//        setSize(900, 700);
//        setLocation(300, 100);
//        setVisible(true);
//    }
//    
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == search) {
//            String selectedEmpId = cEmpId.getSelectedItem();
//            if (selectedEmpId == null || selectedEmpId.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Please select an Employee ID");
//                return;
//            }
//            String query = "select * from teacher where empId = '" + selectedEmpId + "'";
//            try {
//                Conn c = new Conn();
//                ResultSet rs = c.s.executeQuery(query);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == print) {
//            try {
//                table.print();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == add) {
//            setVisible(false);
//            new AddTeacher();
//        } else if (ae.getSource() == update) {
//            setVisible(false);
//            new UpdateTeacher();
//        } else {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new TeacherDetails();
//    }
//}


package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;
    String role;
    String empId;

    // Constructor to initialize with role and empId
    TeacherDetails(String role, String empId) {
        this.role = role;
        this.empId = empId;

        // Check if empId is null or empty and handle appropriately
        if (empId == null && !role.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "Employee ID is not available.");
            System.out.println("empId is null for role: " + role);
            return; // Exit constructor if empId is null for non-admin users
        } else {
            System.out.println("empId: " + empId);
        }

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);

        // Populate the Choice component with employee IDs if the role is Admin
        if (role.equals("Admin")) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select empId from teacher");
                while (rs.next()) {
                    cEmpId.add(rs.getString("empId"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            cEmpId.setVisible(false); // Hide Choice for Faculty
            // No need to populate Choice if role is not Admin
        }

        table = new JTable();

        // Display details based on the role and empId
        try {
            Conn c = new Conn();
            String query = role.equals("Admin") ? "select * from teacher" : "select * from teacher where empId = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            if (!role.equals("Admin")) {
                pst.setString(1, empId);
            }
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        
        // Hide search button for employees
        if (!role.equals("Admin")) {
            search.setVisible(false);  // Hide the search button for non-admin users
            heading.setVisible(false);
        }

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == search) {
                String selectedEmpId = cEmpId.getSelectedItem();
                if (selectedEmpId == null || selectedEmpId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select an Employee ID");
                    return;
                }
                String query = "select * from teacher where empId = '" + selectedEmpId + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
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
                new UpdateTeacher();
            } else {
                setVisible(false);
            }
        }

    public static void main(String[] args) {
        new TeacherDetails("Admin", null); // For testing, can be adjusted
    }
}
