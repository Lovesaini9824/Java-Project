package bank.management.sys;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    MiniStatement(String pinnumber){
                 
        JLabel bank = new JLabel("Punjab National Bank");
        bank.setBounds(120,20,150,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,70,300,20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,150,500,200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber = '"+pinnumber+"'");
            while(rs.next()){
                 card.setText("Card Number:  "+rs.getString("cardNumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("cardNumber").substring(12,16));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        int avabalance = 0;
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    avabalance += Integer.parseInt(rs.getString("amount"));
                }else {
                    avabalance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        balance.setText("Available Balance is Rs. "+avabalance+"/-");
        }catch(Exception e){
            System.out.print(e);
        }
        
        
             
        
        setTitle("Mini Statement");
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
