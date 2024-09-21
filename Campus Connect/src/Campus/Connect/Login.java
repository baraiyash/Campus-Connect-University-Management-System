//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener {
//
//    JTextField tfUsername;
//    JPasswordField tfPassword;
//    JButton login, back;
//    Choice accountType;
//
//    Login() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        // Label and Choice for Account Type
//        JLabel lblAccountType = new JLabel("Login As:");
//        lblAccountType.setBounds(50, 40, 160, 30);
//        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblAccountType);
//
//        accountType = new Choice();
//        accountType.setFont(new Font("Tahoma", Font.BOLD, 16));
//        accountType.add("Admin");
//        accountType.add("Faculty");
//        accountType.add("Student");
//        accountType.setBounds(230, 40, 250, 30);
//        add(accountType);
//
//        // Username Field
//        JLabel lblUsername = new JLabel("Username:");
//        lblUsername.setBounds(50, 100, 150, 30);
//        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblUsername);
//
//        tfUsername = new JTextField();
//        tfUsername.setBounds(230, 100, 250, 30);
//        add(tfUsername);
//
//        // Password Field
//        JLabel lblPassword = new JLabel("Password:");
//        lblPassword.setBounds(50, 160, 150, 30);
//        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblPassword);
//
//        tfPassword = new JPasswordField();
//        tfPassword.setBounds(230, 160, 250, 30);
//        add(tfPassword);
//
//        // Buttons
//        login = new JButton("Login");
//        login.setBounds(80, 220, 150, 40);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        login.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(login);
//
//        back = new JButton("Back");
//        back.setBounds(270, 220, 150, 40);
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.addActionListener(this);
//        back.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(back);
//
//        // Frame Settings
//        setSize(550, 350);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == login) {
//            String username = tfUsername.getText();
//            String password = String.valueOf(tfPassword.getPassword());
//            String selectedAccountType = accountType.getSelectedItem();
//
//            boolean isAuthenticated = false;
//
//            if (selectedAccountType.equals("Admin")) {
//                isAuthenticated = authenticateUser(username, password, "login", "username");
//            } else if (selectedAccountType.equals("Faculty")) {
//                isAuthenticated = authenticateUser(username, password, "faculty_login", "empId");
//            } else if (selectedAccountType.equals("Student")) {
//                isAuthenticated = authenticateUser(username, password, "student_login", "rollno");
//            }
//
//            if (isAuthenticated) {
//                JOptionPane.showMessageDialog(null, "Login successful!");
//                // Proceed to the next screen or dashboard
//            } else {
//                JOptionPane.showMessageDialog(null, "Invalid username or password");
//            }
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//            new SignUp();  // Or whichever screen you want to go back to
//        }
//    }
//
//    private boolean authenticateUser(String username, String password, String tableName, String idColumn) {
//        boolean isAuthenticated = false;
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ? AND password = ?";
//            PreparedStatement pst = c.s.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return isAuthenticated;
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}



//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener, ItemListener {
//
//    JTextField tfUsername;
//    JPasswordField tfPassword;
//    JButton login, cancel, signup;
//    Choice accountType;
//
//    Login() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        
//        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/admin2.png"));
//        Image in = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//        ImageIcon ig = new ImageIcon(in);
//        JLabel jimage = new JLabel(ig);
//        jimage.setBounds(35,50,220,200);
//        add(jimage);
//        
//        
//        JLabel lblAccountType = new JLabel("Login As:");
//        lblAccountType.setBounds(270, 40, 160, 30);
//        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblAccountType);
//
//        accountType = new Choice();
//        accountType.setFont(new Font("Tahoma", Font.BOLD, 16));
//        accountType.add("Admin");
//        accountType.add("Faculty");
//        accountType.add("Student");
//        accountType.setBounds(450, 40, 250, 30);
//        accountType.addItemListener(this); // Add ItemListener
//        add(accountType);
//
//        JLabel lblUsername = new JLabel("Username:");
//        lblUsername.setBounds(270, 100, 150, 30);
//        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblUsername);
//
//        tfUsername = new JTextField();
//        tfUsername.setBounds(450, 100, 250, 30);
//        tfUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(tfUsername);
//
//        JLabel lblPassword = new JLabel("Password:");
//        lblPassword.setBounds(270, 160, 150, 30);
//        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblPassword);
//
//        tfPassword = new JPasswordField();
//        tfPassword.setBounds(450, 160, 250, 30);
//        tfPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(tfPassword);
//
//        login = new JButton("Login");
//        login.setBounds(290, 220, 150, 40);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        login.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(login);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(480, 220, 150, 40);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(cancel);
//
//        signup = new JButton("Sign Up");
//        signup.setBounds(380, 280, 150, 40);
//        signup.setBackground(Color.BLACK);
//        signup.setForeground(Color.WHITE);
//        signup.addActionListener(this);
//        signup.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(signup);
//
//        setSize(800, 400);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    // Method to fetch empId for Faculty
//    private String getEmpIdForFaculty(String username, String password) {
//        String empId = null;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT empId FROM faculty_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                empId = rs.getString("empId");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return empId;
//    }
//
//    // Method to fetch roll number for Student
//    private String getRollNoForStudent(String username, String password) {
//        String rollno = null;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT rollno FROM student_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                rollno = rs.getString("rollno");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rollno;
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == login) {
//            String username = tfUsername.getText();
//            String password = String.valueOf(tfPassword.getPassword());
//            String selectedAccountType = accountType.getSelectedItem();
//
//            boolean isAuthenticated = false;
//            String empId = null;
//            String rollno = null;
//
//            if (selectedAccountType.equals("Admin")) {
//                isAuthenticated = authenticateAdmin(username, password);
//                if (isAuthenticated) {
//                    new Project(selectedAccountType, null , null); // Pass role to Project
//                    setVisible(false); // Close Login window
//                }
//            } else if (selectedAccountType.equals("Faculty")) {
//                isAuthenticated = authenticateFaculty(username, password);
//                if (isAuthenticated) {
//                    empId = getEmpIdForFaculty(username, password);
//                    new Project(selectedAccountType, empId , null); // Pass role and empId to Project
//                    setVisible(false); // Close Login window
//                }
//            } else if (selectedAccountType.equals("Student")) {
//                isAuthenticated = authenticateStudent(username, password);
//                if (isAuthenticated) {
//                    rollno = getRollNoForStudent(username, password); // Fetch roll number for student
//                    new Project(selectedAccountType, null, rollno); // Pass role and rollNo to Project
//                    setVisible(false); // Close Login window
//                }
//            }
//
//            if (!isAuthenticated) {
//                JOptionPane.showMessageDialog(null, "Invalid username or password");
//            }
//        } else if (ae.getSource() == cancel) {
//            setVisible(false);
//            tfUsername.setText("");
//            tfPassword.setText("");
//        } else if (ae.getSource() == signup) {
//            setVisible(false);
//            new SignUp();
//        }
//    }
//
//    private boolean authenticateAdmin(String username, String password) {
//        boolean isAuthenticated = false;
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return isAuthenticated;
//    }
//
//    private boolean authenticateFaculty(String username, String password) {
//        boolean isAuthenticated = false;
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM faculty_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return isAuthenticated;
//    }
//
//    private boolean authenticateStudent(String username, String password) {
//        boolean isAuthenticated = false;
//
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM student_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return isAuthenticated;
//    }
//
//    @Override
//    public void itemStateChanged(ItemEvent ie) {
//        tfUsername.setText("");
//        tfPassword.setText("");
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}
    


//package campus.connect;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener, ItemListener {
//
//    JTextField tfUsername;
//    JPasswordField tfPassword;
//    JButton login, cancel, signup;
//    Choice accountType;
//
//    Login() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//        
//        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/admin2.png"));
//        Image in = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
//        ImageIcon ig = new ImageIcon(in);
//        JLabel jimage = new JLabel(ig);
//        jimage.setBounds(35,50,220,200);
//        add(jimage);
//        
//        JLabel lblAccountType = new JLabel("Login As:");
//        lblAccountType.setBounds(270, 40, 160, 30);
//        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblAccountType);
//
//        accountType = new Choice();
//        accountType.setFont(new Font("Tahoma", Font.BOLD, 16));
//        accountType.add("Admin");
//        accountType.add("Faculty");
//        accountType.add("Student");
//        accountType.setBounds(450, 40, 250, 30);
//        accountType.addItemListener(this);
//        add(accountType);
//
//        JLabel lblUsername = new JLabel("Username:");
//        lblUsername.setBounds(270, 100, 150, 30);
//        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblUsername);
//
//        tfUsername = new JTextField();
//        tfUsername.setBounds(450, 100, 250, 30);
//        tfUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(tfUsername);
//
//        JLabel lblPassword = new JLabel("Password:");
//        lblPassword.setBounds(270, 160, 150, 30);
//        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(lblPassword);
//
//        tfPassword = new JPasswordField();
//        tfPassword.setBounds(450, 160, 250, 30);
//        tfPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
//        add(tfPassword);
//
//        login = new JButton("Login");
//        login.setBounds(290, 220, 150, 40);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.WHITE);
//        login.addActionListener(this);
//        login.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(login);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(480, 220, 150, 40);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(cancel);
//
//        signup = new JButton("Sign Up");
//        signup.setBounds(380, 280, 150, 40);
//        signup.setBackground(Color.BLACK);
//        signup.setForeground(Color.WHITE);
//        signup.addActionListener(this);
//        signup.setFont(new Font("Tahoma", Font.BOLD, 16));
//        add(signup);
//
//        setSize(800, 400);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == login) {
//            String username = tfUsername.getText();
//            String password = String.valueOf(tfPassword.getPassword());
//            String selectedAccountType = accountType.getSelectedItem();
//
//            boolean isAuthenticated = false;
//            String empId = null;
//            String rollno = null;
//
//            if (selectedAccountType.equals("Admin")) {
//                isAuthenticated = authenticateAdmin(username, password);
//                if (isAuthenticated) {
//                    new Project(selectedAccountType, null , null);
//                    setVisible(false);
//                }
//            } else if (selectedAccountType.equals("Faculty")) {
//                isAuthenticated = authenticateFaculty(username, password);
//                if (isAuthenticated) {
//                    empId = getEmpIdForFaculty(username, password);
//                    new Project(selectedAccountType, empId , null);
//                    showNotification(empId,"Faculty");
//                    dispose();
//                    return;
//                }
//            } else if (selectedAccountType.equals("Student")) {
//                isAuthenticated = authenticateStudent(username, password);
//                if (isAuthenticated) {
//                    rollno = getRollNoForStudent(username, password);
//                    new Project(selectedAccountType, null, rollno);
//                    dispose();
//                    showNotification(rollno,"Student");
//                    dispose();
//                    return;
//                    
//                }
//            }
//
//            if (!isAuthenticated) {
//                JOptionPane.showMessageDialog(null, "Invalid username or password");
//            } else {
//                showNotification(username, selectedAccountType); // Show notification for the user
//            }
//        } else if (ae.getSource() == cancel) {
//            setVisible(false);
//            tfUsername.setText("");
//            tfPassword.setText("");
//        } else if (ae.getSource() == signup) {
//            setVisible(false);
//            new SignUp();
//        }
//    }
//
//     // Check notifications for both students and faculty based on userType
//        private void showNotification(String userId, String userType) {
//            
//            String tableName = "";
//            String columnName = "";
//
//            if (userType.equals("Student")) {
//                tableName = "studentleave";
//                columnName = "rollno";
//            } else if (userType.equals("Faculty")) {
//                tableName = "facultyleave";
//                columnName = "empId";
//            }
//
//            try {
//                Conn c = new Conn();
//                String query = "SELECT status FROM " + tableName + " WHERE " + columnName + " = ? AND status != 'Pending'";
//                PreparedStatement pst = c.c.prepareStatement(query);
//                pst.setString(1, userId);
//                ResultSet rs = pst.executeQuery();
//
//                if (rs.next()) {
//                    String status = rs.getString("status");
//                    if (status.equals("Approved") || status.equals("Rejected")) {
//                        JOptionPane.showMessageDialog(null, "Your leave is " + status);
//                        return; // Prevent further execution to avoid the second popup
//                    }
//                }
//
//                // If no matching result is found
//                JOptionPane.showMessageDialog(null, "No information available");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    private boolean authenticateAdmin(String username, String password) {
//        boolean isAuthenticated = false;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//            c.c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isAuthenticated;
//    }
//
//    private boolean authenticateFaculty(String username, String password) {
//        boolean isAuthenticated = false;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM faculty_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//            c.c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isAuthenticated;
//    }
//
//    private boolean authenticateStudent(String username, String password) {
//        boolean isAuthenticated = false;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM student_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                isAuthenticated = true;
//            }
//            c.c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isAuthenticated;
//    }
//
//    private String getEmpIdForFaculty(String username, String password) {
//        String empId = null;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT empId FROM faculty_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                empId = rs.getString("empId");
//            }
//            c.c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return empId;
//    }
//
//    private String getRollNoForStudent(String username, String password) {
//        String rollno = null;
//        try {
//            Conn c = new Conn();
//            String query = "SELECT rollno FROM student_login WHERE username = ? AND password = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                rollno = rs.getString("rollno");
//            }
//            c.c.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return rollno;
//    }
//
//    @Override
//    public void itemStateChanged(ItemEvent ie) {
//        tfUsername.setText("");
//        tfPassword.setText("");
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}



package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.Timer;

public class Login extends JFrame implements ActionListener, ItemListener {

    JTextField tfUsername;
    JPasswordField tfPassword;
    JButton login, cancel, signup;
    Choice accountType;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/admin2.png"));
        Image in = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon ig = new ImageIcon(in);
        JLabel jimage = new JLabel(ig);
        jimage.setBounds(35,50,220,200);
        add(jimage);
        
        JLabel lblAccountType = new JLabel("Login As:");
        lblAccountType.setBounds(270, 40, 160, 30);
        lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblAccountType);

        accountType = new Choice();
        accountType.setFont(new Font("Tahoma", Font.BOLD, 16));
        accountType.add("Admin");
        accountType.add("Faculty");
        accountType.add("Student");
        accountType.setBounds(450, 40, 250, 30);
        accountType.addItemListener(this);
        add(accountType);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(270, 100, 150, 30);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(450, 100, 250, 30);
        tfUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(270, 160, 150, 30);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(450, 160, 250, 30);
        tfPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(tfPassword);

        login = new JButton("Login");
        login.setBounds(290, 220, 150, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(480, 220, 150, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);

        signup = new JButton("Sign Up");
        signup.setBounds(380, 280, 150, 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(signup);

        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String username = tfUsername.getText();
            String password = String.valueOf(tfPassword.getPassword());
            String selectedAccountType = accountType.getSelectedItem();

            boolean isAuthenticated = false;
            String empId = null;
            String rollno = null;

            if (selectedAccountType.equals("Admin")) {
                isAuthenticated = authenticateAdmin(username, password);
                if (isAuthenticated) {
                    new Project(selectedAccountType, null , null);
                    setVisible(false);
                }
            } else if (selectedAccountType.equals("Faculty")) {
                isAuthenticated = authenticateFaculty(username, password);
                if (isAuthenticated) {
                    empId = getEmpIdForFaculty(username, password);
                    new Project(selectedAccountType, empId , null);
                    showNotificationWithDelay(empId,"Faculty");
                    dispose();
                    return;
                }
            } else if (selectedAccountType.equals("Student")) {
                isAuthenticated = authenticateStudent(username, password);
                if (isAuthenticated) {
                    rollno = getRollNoForStudent(username, password);
                    new Project(selectedAccountType, null, rollno);
                    dispose();
                    showNotificationWithDelay(rollno,"Student");
                    return;
                }
            }

            if (!isAuthenticated) {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            tfUsername.setText("");
            tfPassword.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUp();
        }
    }

    // This method will handle the delayed notification with custom font size
    private void showNotificationWithDelay(String userId, String userType) {
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fetch notification based on userId and userType
                String leaveStatus = getLeaveStatus(userId, userType);
                
                // Create a custom message with larger font size
                if (leaveStatus != null) {
                    JLabel label = new JLabel("Your Leave is " + leaveStatus);
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "Leave Notification", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JLabel label = new JLabel("No information available.");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "Leave Notification", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Dummy implementation for fetching leave status (replace with your actual DB logic)
    private String getLeaveStatus(String userId, String userType) {
        String tableName = "";
        String columnName = "";
        
        if (userType.equals("Student")) {
            tableName = "studentleave";
            columnName = "rollno";
        } else if (userType.equals("Faculty")) {
            tableName = "facultyleave";
            columnName = "empId";
        }
        
        String status = null;
        try {
            Conn c = new Conn();
            String query = "SELECT status FROM " + tableName + " WHERE " + columnName + " = ? AND status != 'Pending'";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                status = rs.getString("status");
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    private boolean authenticateAdmin(String username, String password) {
        boolean isAuthenticated = false;
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAuthenticated = true;
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    private boolean authenticateFaculty(String username, String password) {
        boolean isAuthenticated = false;
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM faculty_login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAuthenticated = true;
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    private boolean authenticateStudent(String username, String password) {
        boolean isAuthenticated = false;
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM student_login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isAuthenticated = true;
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    private String getEmpIdForFaculty(String username, String password) {
        String empId = null;
        try {
            Conn c = new Conn();
            String query = "SELECT empId FROM faculty_login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                empId = rs.getString("empId");
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empId;
    }

    private String getRollNoForStudent(String username, String password) {
        String rollno = null;
        try {
            Conn c = new Conn();
            String query = "SELECT rollno FROM student_login WHERE username = ? AND password = ?";
            PreparedStatement pst = c.c.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                rollno = rs.getString("rollno");
            }
            c.c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rollno;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == accountType) {
            if (accountType.getSelectedItem().equals("Admin")) {
                signup.setVisible(false);
            } else {
                signup.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
