package campus.connect;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton cancel, submit;
    
    EnterMarks() {
        
        
        setSize(1200, 600);
        setLocation(250, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 40, 400, 300); 
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 600, 60); 
        heading.setFont(new Font("Tahoma", Font.BOLD, 30)); 
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 80, 200, 30); 
        lblrollnumber.setFont(new Font("Tahoma", Font.PLAIN, 18)); 
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(250, 80, 200, 30); // Adjusted size and position
        crollno.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Set font size for the choice component
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 120, 200, 30); // Adjusted size and position
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(lblsemester);
        
        String semester[] = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 120, 200, 30); // Adjusted size and position
        cbsemester.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 170, 250, 40); // Adjusted position
        lblentersubject.setFont(new Font("Tahoma", Font.BOLD, 22)); // Increased font size
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(380, 170, 250, 40); // Adjusted position
        lblentermarks.setFont(new Font("Tahoma", Font.BOLD, 22)); // Increased font size
        add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 230, 250, 30); // Adjusted size and position
        tfsub1.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 270, 250, 30); // Adjusted size and position
        tfsub2.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 310, 250, 30); // Adjusted size and position
        tfsub3.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 350, 250, 30); // Adjusted size and position
        tfsub4.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 390, 250, 30); // Adjusted size and position
        tfsub5.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfsub5);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(330, 230, 250, 30); // Adjusted size and position
        tfmarks1.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfmarks1);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(330, 270, 250, 30); // Adjusted size and position
        tfmarks2.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfmarks2);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(330, 310, 250, 30); // Adjusted size and position
        tfmarks3.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfmarks3);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(330, 350, 250, 30); // Adjusted size and position
        tfmarks4.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfmarks4);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(330, 390, 250, 30); // Adjusted size and position
        tfmarks5.setFont(new Font("Tahoma", Font.PLAIN, 18)); // Increased font size
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(100, 450, 180, 35); // Adjusted size and position
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 18)); // Increased font size
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(330, 450, 180, 35); // Adjusted size and position
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 18)); // Increased font size
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == submit) {
                try {
                    Conn c = new Conn();

                    String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                    String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                setVisible(false);
            }
        }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
