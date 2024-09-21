//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class SignUp extends JFrame implements ActionListener{
//
//    JTextField tfId, tfUsername, tfName;
//    JPasswordField tfPassword;
//    JButton create, back;
//    Choice accountType;
//    JLabel lblId;
//
//    SignUp() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        // Label and Choice for Account Type
//        JLabel lblAccountType = new JLabel("Create Account As:");
//        lblAccountType.setBounds(50, 40, 200, 30);
//        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(lblAccountType);
//
//        accountType = new Choice();
//        accountType.setFont(new Font("Tahoma", Font.BOLD, 18));
//        accountType.add("Admin");
//        accountType.add("Faculty");
//        accountType.add("Student");
//        accountType.setBounds(260, 40, 250, 30);
//        accountType.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent ie) {
//                handleAccountTypeChange();
//            }
//        });
//        add(accountType);
//
//        // ID Field (Faculty ID / Student Roll No / Admin ID)
//        lblId = new JLabel("ID:");
//        lblId.setBounds(50, 100, 200, 30);
//        lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(lblId);
//
//        tfId = new JTextField();
//        tfId.setBounds(260, 100, 250, 30);
//        tfId.addFocusListener(new FocusAdapter() {
//            public void focusLost(FocusEvent fe) {
//                handleIdFieldFocusLost();
//            }
//        });
//        add(tfId);
//
//        // Username Field
//        JLabel lblUsername = new JLabel("Username:");
//        lblUsername.setBounds(50, 160, 200, 30);
//        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(lblUsername);
//
//        tfUsername = new JTextField();
//        tfUsername.setBounds(260, 160, 250, 30);
//        add(tfUsername);
//
//        // Name Field (locked for Faculty/Student)
//        JLabel lblName = new JLabel("Name:");
//        lblName.setBounds(50, 220, 200, 30);
//        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(lblName);
//
//        tfName = new JTextField();
//        tfName.setBounds(260, 220, 250, 30);
//        tfName.setEditable(false);
//        add(tfName);
//
//        // Password Field
//        JLabel lblPassword = new JLabel("Password:");
//        lblPassword.setBounds(50, 280, 200, 30);
//        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(lblPassword);
//
//        tfPassword = new JPasswordField();
//        tfPassword.setBounds(260, 280, 250, 30);
//        add(tfPassword);
//        
//        accountType.addItemListener(new ItemListener(){
//            public void itemStateChanged(ItemEvent ie){
//                    String user = accountType.getSelectedItem();
//                    if(user.equals("Admin")){
//                        lblId.setVisible(false);
//                        tfId.setVisible(false);
//                    }
//                    else if(user.equals("Student")){
//                        lblId.setVisible(true);
//                        tfId.setVisible(true);
//                    }
//                    else if(user.equals("Faculty")){
//                        lblId.setVisible(true);
//                        tfId.setVisible(true);
//                    }
//            }
//        });
//
//        // Buttons
//        create = new JButton("Create");
//        create.setBounds(100, 340, 150, 40);
//        create.setBackground(Color.BLACK);
//        create.setForeground(Color.WHITE);
//        create.addActionListener(this);
//        create.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(create);
//
//        back = new JButton("Back");
//        back.setBounds(300, 340, 150, 40);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
//        back.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(back);
//
//        // Frame Settings
//        setSize(600, 450);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    private void handleAccountTypeChange() {
//        String selectedAccountType = accountType.getSelectedItem();
//
//        if (selectedAccountType.equals("Faculty")) {
//            lblId.setText("Faculty ID:");
//        } else if (selectedAccountType.equals("Student")) {
//            lblId.setText("Student Roll No:");
//        } else if (selectedAccountType.equals("Admin")) {
//            lblId.setText("Admin ID:");
//        } else {
//            lblId.setText("ID:");
//        }
//
//        // Clear ID and Name fields when account type changes
//        tfId.setText("");
//        tfName.setText("");
//        tfName.setEditable(false);
//    }
//
//    private void handleIdFieldFocusLost() {
//        String id = tfId.getText();
//        String selectedAccountType = accountType.getSelectedItem();
//
//        String name = null;
//        if (selectedAccountType.equals("Faculty")) {
//            name = fetchNameFromDatabase(id, "Faculty");
//        } else if (selectedAccountType.equals("Student")) {
//            name = fetchNameFromDatabase(id, "Student");
//        } else if (selectedAccountType.equals("Admin")) {
//            name = null; // Admin might not have a pre-existing name in the system
//        }
//
//        // Set the fetched name to the tfName field if applicable
//        if (!selectedAccountType.equals("Admin")) {
//            tfName.setText(name != null ? name : "");
//            tfName.setEditable(false);
//        }
//    }
//
//    // Method to fetch the name based on roll number or employee ID
//    private String fetchNameFromDatabase(String id, String userType) {
//        String name = null;
//        String query = "";
//
//        try {
//            Conn c = new Conn();
//
//            // Construct the query based on userType (Faculty or Student)
//            if (userType.equals("Faculty")) {
//                query = "SELECT name FROM teacher WHERE empId='" + id + "'";
//            } else if (userType.equals("Student")) {
//                query = "SELECT name FROM student WHERE rollno='" + id + "'";
//            }
//
//            ResultSet rs = c.s.executeQuery(query);
//
//            // Check if a record was found and extract the name
//            if (rs.next()) {
//                name = rs.getString("name");
//            } else {
//                JOptionPane.showMessageDialog(null, "ID not found");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return name;
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == create) {
//            String selectedAccountType = accountType.getSelectedItem();
//            String id = tfId.getText();
//            String username = tfUsername.getText();
//            String password = new String(tfPassword.getPassword());
//
//            try {
//                Conn c = new Conn();
//                String query = "";
//
//                if (selectedAccountType.equals("Faculty")) {
//                    query = "INSERT INTO faculty_login (empId, username, password) VALUES ('" + id + "','" + username + "', '" + password + "')";
//                } else if (selectedAccountType.equals("Student")) {
//                    query = "INSERT INTO student_login (rollno, username, password) VALUES ('" + id + "','" + username + "', '" + password + "')";
//                } else if (selectedAccountType.equals("Admin")) {
//                    query = "INSERT INTO login (username, password) VALUES ('" + username + "', '" + password + "')";
//                }
//
//                c.s.executeUpdate(query);
//                JOptionPane.showMessageDialog(null, "Account created successfully!");
//                setVisible(false);
//                new Login();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//            new Login();
//        }
//    }
//
//    public static void main(String[] args) {
//        new SignUp();
//    }
//}




   package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{

    JTextField tfId, tfUsername, tfName;
    JPasswordField tfPassword;
    JButton create, back;
    Choice accountType;
    JLabel lblId;

    SignUp() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Label and Choice for Account Type
        JLabel lblAccountType = new JLabel("Create Account As:");
        lblAccountType.setBounds(50, 40, 200, 30);
        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblAccountType);

        accountType = new Choice();
        accountType.setFont(new Font("Tahoma", Font.BOLD, 18));
        accountType.add("Admin");
        accountType.add("Faculty");
        accountType.add("Student");
        accountType.setBounds(260, 40, 250, 30);
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                handleAccountTypeChange();
            }
        });
        add(accountType);

        // ID Field (Faculty ID / Student Roll No / Admin ID)
        lblId = new JLabel("ID:");
        lblId.setBounds(50, 100, 200, 30);
        lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(260, 100, 250, 30);
        add(tfId);

        // Username Field
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 160, 200, 30);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(260, 160, 250, 30);
        add(tfUsername);

        // Add focus listener to fetch name when username field is clicked
        tfUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                fetchNameFromDatabase();
            }
        });

        // Name Field (locked for Faculty/Student)
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 220, 200, 30);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(260, 220, 250, 30);
        tfName.setEditable(false); // Keep name field locked
        add(tfName);

        // Password Field
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 280, 200, 30);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(260, 280, 250, 30);
        add(tfPassword);

        // Buttons
        create = new JButton("Create");
        create.setBounds(100, 340, 150, 40);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        create.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(create);

        back = new JButton("Back");
        back.setBounds(300, 340, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(back);

        // Set the initial state based on default account type
        handleAccountTypeChange();

        // Frame Settings
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Handle account type change
    private void handleAccountTypeChange() {
        String selectedAccountType = accountType.getSelectedItem();

        if (selectedAccountType.equals("Admin")) {
            lblId.setVisible(false);
            tfId.setVisible(false);
        } else {
            lblId.setVisible(true);
            tfId.setVisible(true);
            if (selectedAccountType.equals("Faculty")) {
                lblId.setText("Faculty ID:");
            } else if (selectedAccountType.equals("Student")) {
                lblId.setText("Student Roll No:");
            }
        }

        // Clear ID and Name fields when account type changes
        tfId.setText("");
        tfName.setText("");
        tfName.setEditable(false);
    }

    // Fetch the name from the database based on the account type and ID
    private void fetchNameFromDatabase() {
        String id = tfId.getText();
        String selectedAccountType = accountType.getSelectedItem();

        if (!id.isEmpty() && (selectedAccountType.equals("Faculty") || selectedAccountType.equals("Student"))) {
            try {
                Conn c = new Conn();
                String query = "";
                if (selectedAccountType.equals("Faculty")) {
                    query = "SELECT name FROM teacher WHERE empId = '" + id + "'";
                } else if (selectedAccountType.equals("Student")) {
                    query = "SELECT name FROM student WHERE rollno = '" + id + "'";
                }

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String name = rs.getString("name");
                    tfName.setText(name); // Populate the name field
                } else {
                    JOptionPane.showMessageDialog(null, "No record found for the given ID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Handle button actions
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String selectedAccountType = accountType.getSelectedItem();
            String id = tfId.getText();
            String username = tfUsername.getText();
            String password = new String(tfPassword.getPassword());

            try {
                Conn c = new Conn();
                String query = "";

                if (selectedAccountType.equals("Faculty")) {
                    query = "INSERT INTO faculty_login (empId, username, password) VALUES ('" + id + "','" + username + "', '" + password + "')";
                } else if (selectedAccountType.equals("Student")) {
                    query = "INSERT INTO student_login (rollno, username, password) VALUES ('" + id + "','" + username + "', '" + password + "')";
                } else if (selectedAccountType.equals("Admin")) {
                    query = "INSERT INTO login (username, password) VALUES ('" + username + "', '" + password + "')";
                }

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                setVisible(false);
                new Login();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
    