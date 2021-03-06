
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener  {
    JPasswordField t1,t2,t3;
    JButton b1,b2;
    JLabel l1,l2,l3,l4;
    Pin(){
        setFont(new Font("System",Font.BOLD,22));
         Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("PIN CHANGE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s",pad);
        setTitle(pad+"PIN CHANGE"); 
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System",Font.BOLD,40));
        l2 = new JLabel("CURRENT PIN");
        l2.setFont(new Font("System",Font.BOLD,20));
        l3 = new JLabel("NEW PIN");
        l3.setFont(new Font("System",Font.BOLD,23));
        l4 = new JLabel("Re-Enter new Pin");
        l4.setFont(new Font("System",Font.BOLD,23));
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway",Font.BOLD,22));
        t3 = new JPasswordField();
        t3.setFont(new Font("Raleway",Font.BOLD,22));
        b1 = new JButton("SAVE");
        b1.setFont(new Font("Raleway",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("BACK");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(null);
        l1.setBounds(220,130,800,60);
        add(l1);
        l2.setBounds(100,240,150,40);
        add(l2);
        l3.setBounds(100,300,150,40);
        add(l3);
        l4.setBounds(100,360,200,40);
        add(l4);
        t1.setBounds(310,240,360,40);
        add(t1);
         t2.setBounds(310,300,360,40);
        add(t2);
         t3.setBounds(310,360,360,40);
        add(t3);
        b1.setBounds(220,460,160,50);
        add(b1);
        b2.setBounds(400,460,160,50);
        add(b2);
         getContentPane().setBackground(Color.WHITE);
     setSize(800,800);
      setLocation(500,90);
          setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String a = t1.getText();
            String b= t2.getText();
            String c = t3.getText();
            if(ae.getSource()==b1){
             if(t1.equals("")){
                 JOptionPane.showMessageDialog(null, "Please Enter Current PIN");
             }if(t2.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Enter new PIN");
             }if(t3.getText().equals("")){
                 JOptionPane.showMessageDialog(null,"RE-ENTER NEW PIN");
             }
             if(t2.getText().equals(t3.getText())){
                 conn c1 = new conn();
                 String q1 = "Update bank set pin = '"+b+"' where pin = '"+a+"' ";
                 String q2 = "Update login set pin = '"+b+"' where pin = '"+a+"' ";
                 String q3 = "Update signup3 set pin = '"+b+"' where pin = '"+a+"' ";
                 c1.s.executeUpdate(q1);
                 c1.s.executeUpdate(q2);
                 c1.s.executeUpdate(q3);
              JOptionPane.showMessageDialog(null,"PIN change Successfully");
             new Transcations().setVisible(true);
            
              setVisible(false);
             }else{
                 JOptionPane.showMessageDialog(null,"PIN entered Doesnt match");
             }
            }else if(ae.getSource()==b2){
                new Transcations().setVisible(true);
                setVisible(false);
            }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("Error: "+e);
    }
}
    public static void main(String[] args){
        new Pin().setVisible(true);
    }
}