package bank.management.sys;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener{
    JTextField panNumber,aadharNumber;
    JRadioButton seniorYes,seniorNo,existingYes,existingNo;
    JButton next;
    JComboBox religion,category,income,education,occupation;
    String formno1;
    SignUpTwo(String formno2){
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setSize(900,800);
        setLocation(350,10);
        setLayout(null);
        
          
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        formno1 = formno2;
                        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details Form No: "+formno2);
        additionalDetails.setBounds(230, 80, 450, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setBounds(100,140,200,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);
        
        String valReligion[] = {"Select","Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(330,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        
        
        JLabel Category = new JLabel("Category:");
        Category.setBounds(100,190,200,30);
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        add(Category);
        
        String valCategory[] = {"Select","General", "OBC", "ST", "SC", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(330, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel Income = new JLabel("Income:");
        Income.setBounds(100,240,200,30);
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        add(Income);
        
        String valIncome[] = {"Select","Null","< 1,50,000", "< 2,50,000", "< 5,00,000", "< Upto !0,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(330,240,400,30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel Educational = new JLabel("Educational:");
        Educational.setBounds(100,290,200,30);
        Educational.setFont(new Font("Raleway",Font.BOLD,20));
        add(Educational);
        
        String valEducational[] = {"Select","10","12","Graduate", "Non-Graduate"};
        education = new JComboBox(valEducational);
        education.setBounds(330,290,400,30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setBounds(100,340,200,30);
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(Occupation);
        
        String valOccupation[] = {"Select","Salaried","Business", "Job","Student","Retired", "Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(330,340,400,30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel PAN = new JLabel("PAN Number:");
        PAN.setBounds(100,390,200,30);
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        add(PAN);
        
        panNumber = new JTextField();
        panNumber.setBounds(330,390,400,30);
        add(panNumber);
        
        JLabel Aadhar = new JLabel("Aadhar Number:");
        Aadhar.setBounds(100,440,200,30);
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(Aadhar);
        
        aadharNumber = new JTextField();
        aadharNumber.setBounds(330,440,400,30);
        add(aadharNumber);
        
        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setBounds(100, 490, 200, 30);
        Senior.setFont(new Font("Raleway",Font.BOLD,20));
        add(Senior);
        
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(330,490,100,30);
        seniorYes.setBackground(Color.white);
        add(seniorYes);
        
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(480,490,100,30);
        seniorNo.setBackground(Color.white);
        add(seniorNo);
        
        ButtonGroup seniorbutton = new ButtonGroup();
        seniorbutton.add(seniorYes);
        seniorbutton.add(seniorNo);
        
        JLabel Existing = new JLabel("Existing Account:");
        Existing.setBounds(100,540,200,30);
        Existing.setFont(new Font("Raleway",Font.BOLD,20));
        add(Existing);
        
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(330, 540, 100, 30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
        
        existingNo = new JRadioButton("No");
        existingNo.setBounds(480,540,100,30);
        existingNo.setBackground(Color.white);
        add(existingNo);
        
        ButtonGroup existingButton = new ButtonGroup();
        existingButton.add(existingYes);
        existingButton.add(existingNo);
        
        next = new JButton("Next");
        next.setBounds(630,590,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
    
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = formno1; 
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(seniorYes.isSelected()){
            seniorcitizen = "Yes";
        }else if(seniorNo.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if(existingYes.isSelected()){
            existingaccount = "Yes";
        }else if(existingNo.isSelected()){
            existingaccount = "No";
        }
        
        String pannumber = panNumber.getText();
        String aadharnumber = aadharNumber.getText();
        
        try{
            if(sreligion.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select your Religion else 'other'");
                return;
            }
            if(scategory.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select your Category else 'other'");
                return;

            }
            if(sincome.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select your Income else 'Null'");
                return;

            }
            if(seducation.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select your Education else Non_Graduate");
                return;
            }
            if(soccupation.equals("Select")){
                JOptionPane.showMessageDialog(null, "Select your Occupation else 'Other'");
                return;
            }
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+seniorcitizen+"', '"+existingaccount+"', '"+pannumber+"', '"+aadharnumber+"') ";
            c.s.execute(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.print(e);
        }
                    
    }
    
    public static void main(String args[]){
        new SignUpTwo("");
    }
}
