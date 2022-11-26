
package restaurantmanagement;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4;
    JButton b1,b2,b3;
    
    AddCustomer(){
         setBounds(600,250,850,550); 
         getContentPane().setBackground(Color.white);
         setLayout(null);
         
        JLabel l1=new JLabel("Id : ");
        l1.setBounds(30,50,250,35);
        l1.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(l1);
        t1= new JTextField();
        t1.setBounds(220,50,250,35);
        add(t1);
        
        
        
        JLabel l2=new JLabel("Name : ");
        l2.setBounds(30,110,250,35);
        l2.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(l2);
        t2= new JTextField();
        t2.setBounds(220,110,250,35);
        add(t2);
        
        
        JLabel l3=new JLabel("Address :");
        l3.setBounds(30,170,250,35);
        l3.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(l3);
        t3= new JTextField();
        t3.setBounds(220,170,250,35);
        add(t3);
        
        JLabel l4=new JLabel("Phone :");
        l4.setBounds(30,230,250,35);
        l4.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(l4);
        t4= new JTextField();
        t4.setBounds(220,230,250,35);
        add(t4);
        
        b1=new JButton ("Add");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(70,350,100,35);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton ("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(240,350,100,35);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/new Customer.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel l5=new JLabel(i3);
        l5.setBounds(450,50,400,400);
        add(l5);
        
       
         
    }
    
    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource() == b1)
        {
                 String id =      t1.getText();
                 String name =    t2.getText();
                 String address = t3.getText();
                 String phone =   t4 .getText();
                 String sql = "Insert into CUSTOMER values('"+id+"' , '"+name+"', '"+address+"', '"+phone+"' )";
            try{
                
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
                       
                 Statement statement = connection.createStatement(); 
                 statement.executeUpdate(sql);
                 
                  JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                  this.setVisible(true);
             
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null,e);
                 // e.printStackTrace();
               }
            
        }
        else if(ae.getSource() == b2)
        {
           this.setVisible(false);
        
        }
    }
    
    
    
    public static void main(String[] args)
    {
       new  AddCustomer().setVisible(true);
    }
}
