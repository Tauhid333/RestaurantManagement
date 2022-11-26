
package restaurantmanagement;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Login extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(550,250,900,700);
       
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(0,32,63));
        p1.setBounds(0,0,400,700);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/login.png")); 
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(100,80,200,450);
        p1.add(l1);
        
        
         JPanel p2 = new JPanel();
         p2.setBackground(new Color(77,214,146));
         p2.setLayout(null);
         p2.setBounds(435,0,450,700);
         add(p2);
         
        JLabel l2 = new JLabel("Username");
	l2.setBounds(60, 120, 100, 25);
        l2.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
	p2.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(60,160,300,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);
        
        
        JLabel l3 = new JLabel("Password");
	l3.setBounds(60, 210, 100, 25);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN, 20));
	p2.add(l3);
        
        t2 = new JPasswordField();
        t2.setBounds(60,250,300,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(60,300,130,30);
        b1.setBackground(new Color(133,193,233));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Signup");
        b2.setBounds(230,300,130,30);
        b2.setForeground(new Color(133,193,233));
        b2.setBackground(Color.WHITE);
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        b2.addActionListener(this);
        p2.add(b2);
 
        b3 = new JButton("Forget Password");
        b3.setBounds(130,350,160,30);
        b3.setForeground(new Color(133,193,233));
        b3.setBackground(Color.WHITE);
        b3.setBorder(new LineBorder(new Color(133,193,233)));
        b3.addActionListener(this);
        p2.add(b3);
        
        JLabel l4  = new JLabel("Trouble in login...");
        l4.setForeground(Color.RED);
	l4.setBounds(300,350,100,20);
        p2.add(l4);
         
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1)
        {
            try{
                 String Username = t1.getText();
                 String Password = t2.getText();
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
                 String sql = "select * from MANAGER where Manager_Name = '"+Username+"' "
                        + "AND Manager_Password = '"+Password+"'";
                 Statement statement = connection.createStatement(); 
                 ResultSet resultSet = statement.executeQuery(sql);
                
                if(resultSet.next())
                {
                    this.setVisible(false);
                    new Loading(Username).setVisible(true);
           
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
               
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null,e);
               }
            
        }
        else if(ae.getSource() == b2)
        {
           this.setVisible(false);
           new Signup().setVisible(true);
          
        }
        else if(ae.getSource() == b3)
        {
            
        }
        
    }
    
    
    public static void main(String[] args)
    {
        new Login();
    }
}


