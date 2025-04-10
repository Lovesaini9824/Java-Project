package bank.management.sys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton hundred,hundred5,thousand,thousand2,thousand5,thousand10,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        hundred5 = new JButton("Rs 500");
        hundred5.setBounds(355,415,150,30);
        hundred5.addActionListener(this);
        image.add(hundred5);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        thousand2 = new JButton("Rs 2000 ");
        thousand2.setBounds(355,450,150,30);
        thousand2.addActionListener(this);
        image.add(thousand2);
        
        thousand5 = new JButton("Rs 5000");
        thousand5.setBounds(170,485,150,30);
        thousand5.addActionListener(this);
        image.add(thousand5);
        
        thousand10 = new JButton("Rs 10000");
        thousand10.setBounds(355,485,150,30);
        thousand10.addActionListener(this);
        image.add(thousand10);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance "+"\n"+"Available Balance is "+balance);
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                conn.s.executeUpdate(query);
                balance -= Integer.parseInt(amount);
                JOptionPane.showMessageDialog(null, "Rs "+ amount+" Debited Successfully"+"\n"+"Available Balance is "+balance);
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
