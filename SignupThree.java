package bank.management.sys;
import javax.swing.*;   //for JFrame class swing packege is used
import java.awt.*;  //for font class awt package is used
import java.awt.event.*;    // for ActionListener interface
import java.util.*;     // for Random class; 
public class SignupThree extends JFrame implements ActionListener{
    long cardnum,cardpin;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){

        this.formno = formno;
        Random ran = new Random();
        cardnum = Math.abs((ran.nextLong() % 90000000L) + 5085461100000000L);

        String segment = ""+ cardnum;
        String segment4 = segment.substring(12,16);
        JLabel l1 = new JLabel("Page 3: Account Details ");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280, 50, 300, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Account Type");
        l2.setFont(new Font("Raleway", Font.BOLD,20));
        l2.setBounds(100,130,200,30);
        add(l2);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.PLAIN,15));
        r1.setBounds(100,170,150,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.PLAIN,15));
        r2.setBounds(350,170,200,20);
        r2.setBackground(Color.white);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.PLAIN,15));
        r3.setBounds(100,200,150,20);
        r3.setBackground(Color.white);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway",Font.PLAIN,15));
        r4.setBounds(350,200,250,20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup accoutType = new ButtonGroup();
        accoutType.add(r1);
        accoutType.add(r2);
        accoutType.add(r3);
        accoutType.add(r4);
        
        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(100,270,200,30);
        add(cardno);
        
        JLabel card = new JLabel("XXXX-XXXX-XXXX-"+segment4);   //cardnum
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(300,270,400,30);
        add(card);
        
        JLabel cardinfo = new JLabel("Your 16 Digit Card number ");
        cardinfo.setFont(new Font("Dialog", Font.PLAIN,10));
        cardinfo.setBounds(100,300,300,10);
        add(cardinfo);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,350,200,30);
        add(pin);
        
        cardpin = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel pinno = new JLabel("XXXX");  //cardpin
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        pinno.setBounds(300,350,100,30);
        add(pinno);
        
        JLabel pininfo = new JLabel("Your 4 digit password");
        pininfo.setFont(new Font("Dialog",Font.PLAIN,10));
        pininfo.setBounds(100,385,300,10);
        add(pininfo);
        
        JLabel l4 = new JLabel("Services Required:");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(100,440,200,30);
        add(l4);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,490,200,20);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,490,200,20);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,530,200,20);
        add(c3);
        
        c4 = new JCheckBox("E-MAIL AND SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,530,250,20);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,570,200,20);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,570,200,20);
        add(c6);
        
        c7 = new JCheckBox("I hearby declare that the above entered details are correct to my best of my knowledge");
        c7.setBackground(Color.white);
        c7.setBounds(100,630,520,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.PLAIN,16));
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.setBounds(250,670,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.PLAIN,16));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400,670,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,800);
        setLocation(350,10);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
            accountType = "Saving Account"; 
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Recurring Deposite Account";
            }
            String cardNumber = "" + cardnum;
            String pinNumber = "" + cardpin;
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            }
            if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(c4.isSelected()){
                facility = facility + " E-MAIL AND SMS ALERT";
            }
            if(c5.isSelected()){
                facility = facility  + " Check Book";
            }
            if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if(accountType == null || accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                
                }
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Select the  checkbox");
                    setVisible(false);
                    new SignupThree(formno);
                }
                else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber+ "\n Pin: "+ pinNumber);
                }
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }


        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
        
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
