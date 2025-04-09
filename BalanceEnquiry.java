package bank.management.sys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        int balance = 0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
        }catch(Exception e){
            System.out.print(e);
        }
        JLabel text = new JLabel("Your Available Balance is: ");
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(170,350,300,30);
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel avabalance = new JLabel("Rs. "+balance+"/-");
        avabalance.setFont(new Font("Raleway", Font.BOLD, 16));
        avabalance.setForeground(Color.yellow);
        avabalance.setBackground(Color.white);
        avabalance.setBounds(370,350,300,30);
        image.add(avabalance);
            
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
