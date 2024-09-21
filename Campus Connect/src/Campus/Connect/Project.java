package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Project extends JFrame implements ActionListener {

    private String userRole;
    String empId;
    String rollno;

    // Constructor accepting user role and empId
    public Project(String role, String empId , String rollno) {
        this.userRole = role;
    if (role.equals("Faculty")) {
        this.empId = empId;
        this.rollno = null;
    } else if (role.equals("Student")) {
        this.empId = null;
        this.rollno = rollno;
    } else {
        this.empId = null;
        this.rollno = null;
    }
        // Set the frame to fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);

        // Create a panel to hold the image
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Load the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image img = i1.getImage();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Image scaledImg = img.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(scaledImg);
        JLabel image = new JLabel(i3);
        panel.add(image, BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);

        // Create a custom font for the menu
        Font menuFont = new Font("Arial", Font.BOLD, 18);

        // Set the default font for all menu components
        UIManager.put("Menu.font", menuFont);
        UIManager.put("MenuItem.font", menuFont);

        JMenuBar mb = new JMenuBar();
        
        //Border menuBorder = BorderFactory.createLineBorder(Color.BLACK, 2); // Black border with thickness of 2

        // New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        newInformation.setFont(new Font("Arial",Font.BOLD,27));
        //newInformation.setBorder(menuBorder);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("Add Faculty");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        facultyInfo.setFont(new Font("Arial",Font.BOLD,20));
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("Add Student");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        studentInfo.setFont(new Font("Arial",Font.BOLD,20));
        newInformation.add(studentInfo);

        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        details.setFont(new Font("Arial",Font.BOLD,27));
        details.setMargin(new Insets(10, 10, 10, 10)); // Add space around the menu
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        facultydetails.setFont(new Font("Arial",Font.BOLD,20));
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        studentdetails.setFont(new Font("Arial",Font.BOLD,20));
        details.add(studentdetails);

        // Leave
        JMenu applyleave = new JMenu("Apply Leave");
        applyleave.setForeground(Color.BLUE);
        applyleave.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(applyleave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        facultyleave.setFont(new Font("Arial",Font.BOLD,20));
        applyleave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        studentleave.setFont(new Font("Arial",Font.BOLD,20));
        applyleave.add(studentleave);
        
        //Leave Requests
        JMenu leaverequests = new JMenu("View Leave Requests");
        leaverequests.setForeground(Color.RED);
        leaverequests.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(leaverequests);

        JMenuItem facultyleaverequests = new JMenuItem("Faculty Leave Requests");
        facultyleaverequests.setBackground(Color.WHITE);
        facultyleaverequests.addActionListener(this);
        facultyleaverequests.setFont(new Font("Arial",Font.BOLD,20));
        leaverequests.add(facultyleaverequests);

        JMenuItem studentleaverequests = new JMenuItem("Student Leave Requests");
        studentleaverequests.setBackground(Color.WHITE);
        studentleaverequests.addActionListener(this);
        studentleaverequests.setFont(new Font("Arial",Font.BOLD,20));
        leaverequests.add(studentleaverequests);

        // Leave Details
        JMenu leaveDetails = new JMenu("View Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        leaveDetails.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(leaveDetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        facultyleavedetails.setFont(new Font("Arial",Font.BOLD,20));
        leaveDetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        studentleavedetails.setFont(new Font("Arial",Font.BOLD,20));
        leaveDetails.add(studentleavedetails);
        
        
        // Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        exam.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        examinationdetails.setFont(new Font("Arial",Font.BOLD,20));
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        entermarks.setFont(new Font("Arial",Font.BOLD,20));
        exam.add(entermarks);

        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        updateInfo.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        examinationdetails.setFont(new Font("Arial",Font.BOLD,20));
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updatestudentinfo.setFont(new Font("Arial",Font.BOLD,20));
        updateInfo.add(updatestudentinfo);

        // Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.RED);
        fee.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(fee);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        feestructure.setFont(new Font("Arial",Font.BOLD,20));
        fee.add(feestructure);

        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        feeform.setFont(new Font("Arial",Font.BOLD,20));
        fee.add(feeform);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        utility.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        notepad.setFont(new Font("Arial",Font.BOLD,20));
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        calc.setFont(new Font("Arial",Font.BOLD,20));
        utility.add(calc);

        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.RED);
        about.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        ab.setFont(new Font("Arial",Font.BOLD,20));
        about.add(ab);

        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        exit.setFont(new Font("Arial",Font.BOLD,27));
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        ex.setFont(new Font("Arial",Font.BOLD,20));
        exit.add(ex);

        setJMenuBar(mb);

        // Adjust visibility based on user role
        adjustMenuVisibility();

        setVisible(true);
    }

    private void adjustMenuVisibility() {
        JMenuBar menuBar = getJMenuBar();

        // Get the menus
        JMenu newInformation = menuBar.getMenu(0);
        JMenu details = menuBar.getMenu(1);
        JMenu applyleave = menuBar.getMenu(2);
        JMenu leaveDetails = menuBar.getMenu(4);
        JMenu updateInfo = menuBar.getMenu(6);
        JMenu fee = menuBar.getMenu(7);
        JMenu exam = menuBar.getMenu(5);
        JMenu leaverequests = menuBar.getMenu(3);
        

        // Adjust visibility based on user role
        if (userRole.equals("Admin")) {
            applyleave.setVisible(false); // Hide "Apply Leave" for Admin
            updateInfo.setVisible(false); // Hide "Update Details" for Admin
            leaveDetails.setVisible(false);
            fee.remove(1);
            
        } else if (userRole.equals("Faculty")) {
            newInformation.setVisible(false); // Hide "New Information" for Faculty
            leaverequests.setVisible(false);
            updateInfo.setVisible(false); // Hide "Update Details" for Faculty
            fee.setVisible(false); // Hide "Fee Details" for Faculty
            details.remove(1); // Hide "View Student Details" for Faculty
            applyleave.remove(1); // Hide "Student Leave" for Faculty
            leaveDetails.remove(1); // Hide "Student Leave Details" for Faculty
        } else if (userRole.equals("Student")) {
            newInformation.setVisible(false); // Hide "New Information" for Student
            leaverequests.setVisible(false);
            updateInfo.setVisible(false); // Hide "Update Details" for Student
            exam.remove(1); // Hide "Enter Marks" for Student
            details.remove(0); // Hide "View Faculty Details" for Student
            applyleave.remove(0); // Hide "Faculty Leave" for Student
            leaveDetails.remove(0); // Hide "Faculty Leave Details" for Student
            leaverequests.setVisible(false);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
            new Login();
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Add Faculty")) { 
            new AddTeacher();
        } else if (msg.equals("Add Student")) { 
            new AddStudent();
        } else if (msg.equals("View Faculty Details")) {
            if (userRole.equals("Admin")) {
                // Admin can see all faculty details
                new TeacherDetails("Admin",null); // Pass "Admin" as a role , empId as null
            } else if(userRole.equals("Faculty")) {
                // Faculty can see their own details
                new TeacherDetails("Faculty",empId); // pass "Faculty" as a role and the actual empId   
            }
                } else if (msg.equals("View Student Details")) {
            if (userRole.equals("Admin")) {
                // Admin can see all student details
                new StudentDetails("Admin", null); // Pass "Admin" as a role, rollno as null
            } else if (userRole.equals("Student")) {
                // Student can see their own details
                new StudentDetails("Student", this.rollno); // Pass "Student" as a role and the actual rollno
            }
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeaveReq("Faculty",empId);
        } else if (msg.equals("Student Leave")) {
            new StudentLeaveReq("Student",rollno);
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Faculty Leave Requests")){
            new TeacherLeaveDetails();
        } else if (msg.equals("Student Leave Requests")){
            new StudentLeaveDetails();
        } else if (msg.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails(this.userRole,this.rollno);
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About")) {
            new About();
        } else if (msg.equals("Student Fee Form")) {
            new StudentFeeForm();
        }
    }

    public static void main(String[] args) {
        new Project("Admin", null , null); // Example with Admin
    }
}
