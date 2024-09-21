//package campus.connect;
//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//import java.awt.event.*;
//
//public class ExaminationDetails extends JFrame implements ActionListener {
//
//    JTextField search;
//    JButton submit, cancel;
//    JTable table;
//    String rollno;
//    Choice result;
//    
//    ExaminationDetails(String rollno) {
//        this.rollno = rollno;
//               
//        setTitle("View Result");
//        setSize(1000, 475);
//        setLocation(300, 100);
//        setLayout(null);
//        
//        getContentPane().setBackground(Color.WHITE);
//        
//        
//        JLabel rollnoLabel = new JLabel("Your Roll Number is: " + rollno);
//        rollnoLabel.setFont(new Font("Tahoma", Font.BOLD, 25)); // Increased font size
//        rollnoLabel.setBounds(30, 30, 700, 50); // Adjusted bounds for larger font
//        add(rollnoLabel);
//        
//        JLabel semViseResult = new JLabel("View Sem Vise Result");
//        semViseResult.setFont(new Font("Tahoma", Font.BOLD, 25)); // Increased font size
//        semViseResult.setBounds(550, 30, 700, 50); // Adjusted bounds for larger font
//        add(semViseResult);
//        
//         result = new Choice();
//        result.setFont(new Font("Tahoma", Font.BOLD, 16));
//        result.add("Semester 1");
//        result.add("Semester 2");
//        result.add("Semester 3");
//        result.add("Semester 4");
//        result.add("Semester 5");
//        result.add("Semester 6");
//        result.setBounds(450, 40, 250, 30);
//        add(result);
//        
//        
//        
//       table = new JTable();
//       table.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        
//        JScrollPane jsp = new JScrollPane(table);
//       jsp.setBounds(0, 130, 1000, 310);
//       add(jsp);
//       
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from marks");
//             table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        table.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//                int row = table.getSelectedRow();
//                search.setText(table.getModel().getValueAt(row, 2).toString());
//            }
//        });
//        
//        setVisible(true);
//    }
//    
//    
//    public void actionPerformed(ActionEvent ae) {
//        
//    }
//
//    public static void main(String[] args) {
//        new ExaminationDetails("");
//    }
//}


package campus.connect;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ExaminationDetails extends JFrame implements ItemListener {

    Choice result, rollnoChoice;
    JTextPane displayArea;
    String rollno;
    String role;

    ExaminationDetails(String userRole, String rollno) {
        this.rollno = rollno;
        this.role = userRole;

        setTitle("View Result");
        setSize(1100, 600);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel rollnoLabel;
        if (role.equals("Admin")) {
            rollnoLabel = new JLabel("Select Student Roll Number: ");
            rollnoLabel.setBounds(30, 30, 300, 50);

            rollnoChoice = new Choice();
            rollnoChoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
            rollnoChoice.setBounds(350, 40, 200, 30);
            populateRollnoChoice();  
            rollnoChoice.addItemListener(this);
            add(rollnoChoice);
        } else {
            rollnoLabel = new JLabel("Your Roll Number is: " + rollno);
            rollnoLabel.setBounds(30, 30, 500, 50);
        }
        rollnoLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(rollnoLabel);

        JLabel semViseResult = new JLabel("Choose Semester");
        semViseResult.setFont(new Font("Tahoma", Font.BOLD, 25));
        semViseResult.setBounds(30, 100, 300, 30);
        add(semViseResult);

        result = new Choice();
        result.setFont(new Font("Tahoma", Font.PLAIN, 18));
        result.add("Semester 1");
        result.add("Semester 2");
        result.add("Semester 3");
        result.add("Semester 4");
        result.add("Semester 5");
        result.add("Semester 6");
        result.setBounds(350, 100, 200, 30);
        result.addItemListener(this);
        add(result);

        // Replace JTextArea with JTextPane for better formatting
        displayArea = new JTextPane();
        displayArea.setEditable(false);
        displayArea.setBounds(30, 150, 1000, 400);
        displayArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(displayArea);

        // Trigger the default semester display when the frame opens
        if (role.equals("Admin")) {
            displayResultForSemester(rollnoChoice.getSelectedItem(), result.getSelectedItem());
        } else {
            displayResultForSemester(rollno, result.getSelectedItem());
        }

        setVisible(true);
    }

    private void displayResultForSemester(String rollno, String semester) {
        try {
            Conn c = new Conn();

            String query = "SELECT s.subject1, s.subject2, s.subject3, s.subject4, s.subject5, " +
                           "m.marks1, m.marks2, m.marks3, m.marks4, m.marks5 " +
                           "FROM marks m " +
                           "JOIN subject s ON TRIM(m.rollno) = TRIM(s.rollno) AND TRIM(m.semester) = TRIM(s.semester) " +
                           "WHERE TRIM(m.rollno) = '" + rollno + "' AND TRIM(m.semester) = '" + semester + "'";

            ResultSet rs = c.s.executeQuery(query);

            // Get document from JTextPane
            StyledDocument doc = displayArea.getStyledDocument();
            doc.remove(0, doc.getLength()); // Clear previous content

            // Create a center-aligned text style
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            StyleConstants.setBold(center, true);
            StyleConstants.setFontSize(center, 16);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);

            // Insert Header and Columns
            doc.insertString(doc.getLength(), semester + " Result\n\n", center);
            doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", "Subject", "Marks"), center);
            doc.insertString(doc.getLength(), "---------------------------------\n", center);

            // Check if results exist and insert marks
            if (rs.next()) {
                doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", rs.getString("subject1"), rs.getString("marks1")), center);
                doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", rs.getString("subject2"), rs.getString("marks2")), center);
                doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", rs.getString("subject3"), rs.getString("marks3")), center);
                doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", rs.getString("subject4"), rs.getString("marks4")), center);
                doc.insertString(doc.getLength(), String.format("%-20s%-10s\n", rs.getString("subject5"), rs.getString("marks5")), center);
            } else {
                doc.insertString(doc.getLength(), "No records found for this roll number and semester.", center);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Populate rollnoChoice for admin
    private void populateRollnoChoice() {
        try {
            Conn c = new Conn();
            String query = "SELECT rollno FROM student";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                rollnoChoice.add(rs.getString("rollno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        String selectedSemester = result.getSelectedItem();
        String selectedRollno = role.equals("Admin") ? rollnoChoice.getSelectedItem() : rollno;
        displayResultForSemester(selectedRollno, selectedSemester);
    }

    public static void main(String[] args) {
        new ExaminationDetails("Admin", "null");
    }
}
