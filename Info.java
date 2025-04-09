
package bank.management.sys;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
public class Info extends JFrame implements ActionListener{
    JTextField userText;
    JPasswordField passwordText;
    JTable table;
    JButton next;
    Info(){

    JLabel user = new JLabel("USER INFORMATION");
    user.setBounds(450,30,300,30);
    user.setFont(new Font("Raleway",Font.BOLD,16));
    add(user);
    
    JLabel username = new JLabel("Username");
    username.setBounds(300,80,100,30);
    username.setFont(new Font("Raleway", Font.BOLD, 16));
    add(username);
    
    userText = new JTextField();
    userText.setBounds(400,80,210,30);
    userText.setFont(new Font("Raleway", Font.BOLD, 16));
    add(userText);
        
    JLabel password = new JLabel("Password");
    password.setBounds(300,130,100,30);
    password.setFont(new Font("Raleway", Font.BOLD, 16));
    add(password);
    
    passwordText = new JPasswordField();
    passwordText.setBounds(400,130,210,30);
    passwordText.setFont(new Font("Raleway", Font.BOLD, 16));
    add(passwordText);
    
    next = new JButton("Next");
    next.setBounds(400,180,100,30);
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway", Font.BOLD, 16));
    next.addActionListener(this);
    add(next);
    
    table = new JTable();
    
    
//    JScrollPane jsp = new JScrollPane(table);
//    jsp.setBounds(0,230,1150,800);
//    add(jsp);

    setSize(1150,800);
    setLayout(null);
    setLocation(200,20);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String usernamevalue = userText.getText();
        String passwordvalue = passwordText.getText();
        try{
            if(usernamevalue.equals("owner") && passwordvalue.equals("2004")){
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from ((signup inner join signuptwo on signup.formno=signuptwo.form_no) inner join signupthree on signup.formno=signupthree.formno)");
                while(rs.next()){
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }
                JScrollPane jsp = new JScrollPane(table);
                jsp.setBounds(0,230,1150,800);
                add(jsp);

            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
                new Login().setVisible(true );
        }

        }catch(Exception e){
            System.out.print(e);
        }
    }
    
    public static void main(String args[]){
        new Info();
    }
}
