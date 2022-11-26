
package restaurantmanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
       JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Dashboard(){
           setExtendedState(JFrame.MAXIMIZED_BOTH); 
           setLayout(null);
           
           JPanel p1=new JPanel();
           p1.setLayout(null);
           p1.setBounds(0,0,1920,65);
           p1.setBackground(new Color(0,32,63));
           add(p1);
           
           ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/2.png"));
           Image i5= i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
           ImageIcon i6 = new ImageIcon(i5);
           JLabel l2 = new JLabel(i6);
           l2.setBounds(5,0,70,70);
           p1.add(l2);
           
           
           JLabel l3 = new JLabel("Dashboard");
           l3.setFont(new Font("Tahoma",Font.BOLD,30));
           l3.setForeground(Color.WHITE);
           l3.setBounds(80,10,300,40);
           p1.add(l3);
           
           
           JPanel p2=new JPanel();
           p2.setLayout(null);
           p2.setBounds(0,65,300,1080);
           p2.setBackground(new Color(0,32,63));
           add(p2);
           
           
           b1 = new JButton("Add Food");
           b1.setBackground(new Color(0,0,102));
           b1.setFont(new Font("Tahoma",Font.PLAIN,20));
           b1.setForeground(Color.WHITE);
           b1.setMargin(new Insets(0,0,0,100));
           b1.setBounds(0,0,300,50);
           b1.addActionListener(this);
           p2.add(b1);
           
           
           
           b2 = new JButton("Food Items");
           b2.setBackground(new Color(0,0,102));
           b2.setFont(new Font("Tahoma",Font.PLAIN,20));
           b2.setForeground(Color.WHITE);
           b2.setMargin(new Insets(0,0,0,80));
           b2.setBounds(0,100,300,50);
           b2.addActionListener(this);
           p2.add(b2);
           
           b3 = new JButton("Add Employee");
           b3.setBackground(new Color(0,0,102));
           b3.setFont(new Font("Tahoma",Font.PLAIN,20));
           b3.setForeground(Color.WHITE);
           b3.setMargin(new Insets(0,0,0,60));
           b3.setBounds(0,200,300,50);
           b3.addActionListener(this);
           p2.add(b3);
           
           
           b4 = new JButton("All Employee");
           b4.setBackground(new Color(0,0,102));
           b4.setFont(new Font("Tahoma",Font.PLAIN,20));
           b4.setForeground(Color.WHITE);
           b4.setMargin(new Insets(0,0,0,70));
           b4.setBounds(0,300,300,50);
           b4.addActionListener(this);
           p2.add(b4);
           
           b5 = new JButton("Add Customer");
           b5.setBackground(new Color(0,0,102));
           b5.setFont(new Font("Tahoma",Font.PLAIN,20));
           b5.setForeground(Color.WHITE);
           b5.setMargin(new Insets(0,0,0,60));
           b5.setBounds(0,400,300,50);
           b5.addActionListener(this);
           p2.add(b5);
           
           b6 = new JButton("All Customer");
           b6.setBackground(new Color(0,0,102));
           b6.setFont(new Font("Tahoma",Font.PLAIN,20));
           b6.setForeground(Color.WHITE);
           b6.setMargin(new Insets(0,0,0,70));
           b6.setBounds(0,500,300,50);
           b6.addActionListener(this);
           p2.add(b6);
           
           
           b7 = new JButton("Order Details");
           b7.setBackground(new Color(0,0,102));
           b7.setFont(new Font("Tahoma",Font.PLAIN,20));
           b7.setForeground(Color.WHITE);
           b7.setMargin(new Insets(0,0,0,60));
           b7.setBounds(0,600,300,50);
           b7.addActionListener(this);
           p2.add(b7);
           
           b8 = new JButton("Report");
           b8.setBackground(new Color(0,0,102));
           b8.setFont(new Font("Tahoma",Font.PLAIN,20));
           b8.setForeground(Color.WHITE);
           b8.setMargin(new Insets(0,0,0,110));
           b8.setBounds(0,700,300,50);
           b8.addActionListener(this);
           p2.add(b8);
           
           
            
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("restaurantmanagement/icons/bg-3.png"));
           Image i2= i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel l1 = new JLabel(i3);
           l1.setBounds(0,0,1950,1000);
           add(l1);
           
              
            JLabel l4 = new JLabel("Restaurant Management System");
            l4.setBounds(700,100,1000,70);
            l4.setForeground(Color.WHITE);
            l4.setFont(new Font("Tahoma",Font.BOLD,60));
            l1.add(l4);
      
    }
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try{
                new AddFood().setVisible(true);
            }catch(Exception e){}
        }
        else if(ae.getSource()==b2)
        {
            try{
                new FoodItems().setVisible(true);
            }catch(Exception e){}
            
        }
        else if(ae.getSource()==b3)
        {
            try{
                
               new AddEmployee().setVisible(true);
                
                
            }catch(Exception e){}
        }
        else if(ae.getSource()==b4)
        {
            try{
                
                new AllEmployee().setVisible(true);
                
                
            }catch(Exception e){}
            
            
        }
        else if(ae.getSource()==b5)
        {
            try{
                
                new AddCustomer().setVisible(true);
                
                
            }catch(Exception e){}
            
            
        }
          else if(ae.getSource()==b6)
        {
            try{
                
                new AllCustomer().setVisible(true);
                
                
            }catch(Exception e){}
            
            
        }
           else if(ae.getSource()==b7)
        {
            try{
                
                new OrderDetails().setVisible(true);
                
                
            }catch(Exception e){}
            
            
        }
        
    }
    
    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
    
}
