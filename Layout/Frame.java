package Layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PasswordGenerator.Password;

public class Frame implements ActionListener{
    Password ob=new Password();
    JFrame f;
    JLabel heading,lower,upper,special,number,info;
    JButton generate,reset;
    JComboBox<String> lowercb,uppercb,specialcb,numbercb,infocb;
    JTextField password;
    String[] numbers={"0","1","2","3","4","5"};
    public Frame(){
        f=new JFrame("Password generator");

        heading=new JLabel("Strong Password Generator");
        heading.setBounds(120,40,250,50);
        heading.setFont(new Font("Verdana",Font.PLAIN,17));

        info=new JLabel("Enter the number of character needed");
        info.setBounds(120,90,350,50);

        lower=new JLabel("Lowercase: ");
        lower.setBounds(120,130,130,50);

        lowercb=new JComboBox<String>(numbers);
        lowercb.setBounds(240, 145,90,20);
        
        upper=new JLabel("Uppercase: ");
        upper.setBounds(120,160,130,50);

        uppercb=new JComboBox<String>(numbers);
        uppercb.setBounds(240,175,90,20);

        special=new JLabel("Special Characters: ");
        special.setBounds(120, 190, 130, 50);

        specialcb=new JComboBox<String>(numbers);
        specialcb.setBounds(240,205,90,20);

        number=new JLabel("Digits");
        number.setBounds(120,220,130,50);

        numbercb=new JComboBox<String>(numbers);
        numbercb.setBounds(240,235,90,20);

        password=new JTextField();
        password.setBounds(150,270,150,22);
        password.setEditable(false);

        generate=new JButton("Generate");
        generate.setBounds(100,320,100,30);
        generate.addActionListener(this);

        reset=new JButton("Reset");
        reset.setBounds(240,320,100,30);
        reset.addActionListener(this);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(470,500);
        f.setVisible(true);

        f.add(heading);
        f.add(info);
        f.add(lower);
        f.add(lowercb);
        f.add(upper);
        f.add(uppercb);
        f.add(special);
        f.add(specialcb);
        f.add(number);
        f.add(numbercb);
        f.add(password);
        f.add(generate);
        f.add(reset);
    }
    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();
        if(s.equals("Generate")){
            int lower=Integer.parseInt(lowercb.getSelectedItem()+"");
            int upper=Integer.parseInt(uppercb.getSelectedItem()+"");
            int special=Integer.parseInt(specialcb.getSelectedItem()+"");
            int number = Integer.parseInt(numbercb.getSelectedItem()+"");
            String passwords=ob.generate(lower, upper, special, number);
            password.setText(passwords);
        }
        if(s.equals("Reset")){
            password.setText("");
            lowercb.setSelectedItem("0");
            uppercb.setSelectedItem("0");
            specialcb.setSelectedItem("0");
            numbercb.setSelectedItem("0");
        }
    }
}
