
package restaurantmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Signup extends JFrame implements ActionListener {
     JButton b1,b2;
     JTextField t0,t1,t2,t3,t4;
    Signup(){
        setBounds(600,280,900,700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(77,214,146));
        p1.setBounds(0,0,425,700);
        p1.setLayout(null);
        add(p1);
        
        
        JLabel l0 = new JLabel("ID");
	l0.setBounds(50, 80, 100, 35);
        l0.setFont(new Font("Tahoma",Font.BOLD, 20));
	p1.add(l0);
        
        t0 = new JTextField();
        t0.setBounds(160,80,220,35);
        t0.setBorder(BorderFactory.createEmptyBorder());
        add(t0);
        
        JLabel l1 = new JLabel("Name");
	l1.setBounds(50, 150, 100, 35);
        l1.setFont(new Font("Tahoma",Font.BOLD, 20));
	p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(160,150,220,35);
        t1.setBorder(BorderFactory.createEmptyBorder());
        add(t1);
        
        JLabel l2 = new JLabel("Address");
	l2.setBounds(50, 220, 100, 35);
        l2.setFont(new Font("Tahoma",Font.BOLD, 20));
	p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(160,220,220,35);
        t2.setBorder(BorderFactory.createEmptyBorder());
        add(t2);
        
         JLabel l3 = new JLabel("Phone");
	l3.setBounds(50, 290, 100, 35);
        l3.setFont(new Font("Tahoma",Font.BOLD, 20));
	p1.add(l3);
        
        t3 = new JTextField();
        t3.setBounds(160,290,220,35);
        t3.setBorder(BorderFactory.createEmptyBorder());
        add(t3);
        
        JLabel l4 = new JLabel("Password");
	l4.setBounds(50, 360, 220, 35);
        l4.setFont(new Font("Tahoma",Font.BOLD, 20));
	p1.add(l4);
        
        t4 = new JTextField();
        t4.setBounds(160,360,220,35);
        t4.setBorder(BorderFactory.createEmptyBorder());
        add(t4);
          
        
       b1 = new JButton("Create");
       b1.setFont(new Font("Tahoma",Font.BOLD, 18));
       b1.setForeground(new Color(133,193,233));
       b1.setBackground(Color.WHITE);
       b1.addActionListener(this);
       b1.setBounds(60,450,120,40);
       p1.add(b1);
       
       b2 = new JButton("Back");
       b2.setFont(new Font("Tahoma",Font.BOLD, 18));
       b2.setForeground(new Color(133,193,233));
       b2.setBackground(Color.WHITE);
       b2.addActionListener(this);
       b2.setBounds(240,450,120,40);
       p1.add(b2);
       
     
         
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/signup.png")); 
       Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l5 = new JLabel(i3);
       l5.setBounds(520,150,300,300);
       add(l5);
       
         JPanel p2 = new JPanel();
         p2.setBackground(new Color(0,32,63));
         p2.setLayout(null);
         p2.setBounds(400,0,485,700);
         add(p2);
         
        
    }
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
            

           
            String query = "insert into MANAGER(Manager_Name,Manager_Address,Manager_phone,Manager_Password)"
                    + "values(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,t1.getText());
            pst.setString(2,t2.getText());
            pst.setString(3, t3.getText());
            pst.setString(4, t4.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Account Created Successfully");
            this.setVisible(false);
            new Login().setVisible(true);

            } catch (Exception e) {
                     JOptionPane.showMessageDialog(null,e);
                    //e.printStackTrace();
               }
          
          
        }
        else if(ae.getSource() == b2)
        {
           this.setVisible(false);
           new Login().setVisible(true);
           //this.setVisible(false);
        }
      
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
        
    }
    
}
