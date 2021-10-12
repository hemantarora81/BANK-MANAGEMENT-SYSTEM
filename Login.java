
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    Login(){
        //Moving Text("HEMANT PERSONAL BANK") to Center at Top
        setFont(new Font("System",Font.BOLD,22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("HEMANT PERSONAL BANK");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s",pad);
        setTitle(pad +"HEMANT PERSONAL BANK");
        
        
        l1 = new JLabel("HEMANT PERSONAL BANK");
        l1.setFont(new Font("Osward",Font.BOLD,28));
        
        l2 = new JLabel("Card Number:");
        l2.setFont(new Font("Raleway",Font.BOLD,21));
        
        l3 = new JLabel("Pin:");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        
        tf1 = new JTextField(15);//Size of Input
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("Sign In");//Not Showing
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Clear");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Sign Up");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(175,50,450,200);//setBound Function used for set the Position
        add(l1);//For Visible
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial",Font.BOLD,14));
        tf1.setBounds(300,235,230,30);
        add(tf1);
        
        pf2.setFont(new Font("Arial",Font.BOLD,14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD,14));
        b1.setBounds(450,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(300,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        b1.addActionListener(this);//What Action perform when button clicks
        b2.addActionListener(this);
        b3.addActionListener(this);
        
       getContentPane().setBackground(Color.WHITE);
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            conn c1 = new conn();
            String a = tf1.getText();
            String b = pf2.getText();
            String q = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);//When take data from database
            if(ae.getSource()==b1){
                if(rs.next()){
                    new Transcations().setVisible(true);               
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Password");
                } 
            }
            else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");    
            }
            else if(ae.getSource()==b3){
                new Signup().setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("error: "+e);
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}
