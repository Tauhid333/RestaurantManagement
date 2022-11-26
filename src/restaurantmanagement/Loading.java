
package restaurantmanagement;
import java.awt.*;
import javax.swing.*;


public class Loading extends JFrame implements Runnable{
    JProgressBar p;
    Thread t;
    public void run(){
        try{
            for(int i=1;i<=101;i++)
            {
                int n = p.getMaximum();
                int m = p.getValue();
                if(m<n)
                {
                    p.setValue( p.getValue() + 1);
                }
                else
                {
                    i=101;
                    setVisible(false);
                    new Dashboard().setVisible(true);
                }
                Thread.sleep(50);
            }
            
        }catch(Exception e){}
    }
    
    Loading(String user){
        String Username = user;
        System.out.println(Username);
        t = new Thread(this);
        
        setBounds(700,250,710,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Restaurant Management Application");
        l1.setBounds(50,20,600,40);  
        l1.setFont(new Font("Raleway",Font.BOLD, 35));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        p = new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(190,100,325,35);
        add(p);
        
        JLabel l2 = new JLabel("Please Wait...");
        l2.setBounds(300,150,120,25);  
        l2.setFont(new Font("Tahoma",Font.BOLD, 18));
        l2.setForeground(Color.RED);
        add(l2);
        
        JLabel l3 = new JLabel("Welcome "+ Username);
        l3.setBounds(20,500,400,25);  
        l3.setFont(new Font("Tahoma",Font.BOLD, 18));
        l3.setForeground(Color.RED);
        add(l3);
        
        t.start();
    }
    
    public static void main(String[] args)
    {
       new Loading(" ").setVisible(true); 
    }
    
}
