package campus.connect;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame implements Runnable {
    
    Thread t;
    
    Home() {
        // Load and scale image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setSize(1000,700); // Initial size
        setLocationRelativeTo(null); // Center on screen initially
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        // Animation
        int x = 1;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        for (int i = 2; i <= 600; i += 4, x += 1) {
            int width = i + 3 * x;
            int height = i + x / 2;
            
            int xPos = (screenWidth - width) / 2;
            int yPos = (screenHeight - height) / 2;
            
            setLocation(xPos, yPos);
            setSize(width, height);
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void run() {
        try {
            Thread.sleep(5000); // Display splash screen for 4 seconds
            setVisible(false);
            
            // Next Frame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Home();   
    }
}
