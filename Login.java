package bank.management.sys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  // used for ResultSet class
public class Login extends JFrame implements ActionListener{    //JFrame is a container in Java's Swing framework. It is a top-level window that can hold other components (like buttons, labels, panels, etc.).
    JButton login,clear,signup,info;
    JTextField cardTextField;
    JPasswordField pintextfield;
    Login() {
        setTitle("AUTOMATIC TELLER MACHINE");
        setLayout(null);
        setSize(800, 440);    //width=800 height=500  of the frame

        // Set up the ATM image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm-machine.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);  // Place image in JLabel
        label.setBounds(100, 10, 100, 100);    // Positioning the image on the frame
        add(label);

        // Welcome Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(250, 40, 350, 40);
        add(text);

        // Card Number Label and TextField
        JLabel cardno = new JLabel("Enter Card NO.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(100, 150, 200, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);  // Corrected bounds for cardTextField
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        // Pin Number Label and TextField
        JLabel pinno = new JLabel("Enter Pin NO.");
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        pinno.setBounds(100, 200, 200, 30);
        add(pinno);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(300, 200, 230, 30);  // Corrected bounds for pintextfield
        pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintextfield);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,250,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,300,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        info = new JButton("USER INFORMATION");
        info.setBounds(300,350,230,30);
        info.setBackground(Color.black);
        info.setForeground(Color.white);
        info.addActionListener(this);
        add(info);


        // Set background color
        getContentPane().setBackground(Color.white);

        // Make the frame visible
        setVisible(true);

        // Set the position of the window
        setLocation(350, 200);     // Position of the frame (x=350, y=200)
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pintextfield.setText("");

        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pintextfield.getText();
            String query = "select * from login where cardNumber = '"+cardnumber+"' and pinNumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin");
                }
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if (ae.getSource() == info){
            setVisible(false);
            new Info().setVisible(true);
        }
    }

    public static void main(String args[]) {
        Login lg = new Login();  // Create an instance of Login class to display the frame
    }
}
