
package restaurantmanagement;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddFood extends  JFrame implements ActionListener {
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    AddFood(){
        setBounds(600,250,850,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l1=new JLabel("Item Id");
        l1.setBounds(30,50,200,35);
        add(l1);
        t1= new JTextField();
        t1.setBounds(220,50,150,35);
        add(t1);
        
        
        
        
        JLabel l2=new JLabel("Food Name");
        l2.setBounds(30,110,200,35);
        add(l2);
        t2= new JTextField();
        t2.setBounds(220,110,150,35);
        add(t2);
        
        
        JLabel l3=new JLabel("Price");
        l3.setBounds(30,170,200,35);
        add(l3);
        t3= new JTextField();
        t3.setBounds(220,170,150,35);
        add(t3);
        
        
        b1=new JButton ("Add");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,410,100,35);
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton ("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(300,410,100,35);
        b2.addActionListener(this);
        add(b2);
       
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/food.jpg"));
        Image i2=i1.getImage().getScaledInstance(330, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel l4=new JLabel(i3);
        l4.setBounds(400,40,400,400);
        add(l4);
        
        
    }
    public static void main(String[]args){
        new AddFood().setVisible(true);
        
    
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
            

            
            String query = "insert into ITEM(Item_Id,Item_Description,Price)values(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1,t1.getText());
            pst.setString(2,t2.getText());
            pst.setString(3, t3.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Food Added Successfully");
            
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        else if(ae.getSource()==b2)
        {
            
             this.setVisible(false);
            // new Dashboard().setVisible(true);
            // this.setVisible(false);
        }
        
       
    }
    
}
