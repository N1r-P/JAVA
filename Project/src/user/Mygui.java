package user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mygui extends JFrame{
    private JPanel p, p1, p2, p3, p4;
    private JButton buttonRegister, buttonPI, buttonSold,buttonBought;
    public Mygui(){
        super("Mine");//Using the construction method of the parent class.

        p = new JPanel();
        p.setLayout(new GridLayout(4, 1));//Using GridLayout to arrange the GUI components

        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("Register"));
        buttonRegister = new JButton("Register");
        p1.setLayout(null);
        buttonRegister.setBounds(125,80,100,25);
        p1.add(buttonRegister);

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("Personal Information"));
        buttonPI = new JButton("Personal Information");
        p2.setLayout(null);
        buttonPI.setBounds(75,80,200,25);
        p2.add(buttonPI);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("I Sold"));
        buttonSold = new JButton("I Sold");
        p3.setLayout(null);
        buttonSold.setBounds(125,80,100,25);
        p3.add(buttonSold);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("I Bought"));
        buttonBought = new JButton("I Bought");
        p4.setLayout(null);
        buttonBought.setBounds(125,80,100,25);
        p4.add(buttonBought);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        this.add(p);
        this.setSize(360, 740);// Set the window's size.
        this.setLocation(450, 10);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MyFrame f = new MyFrame();
                f.setVisible(true);
            }
        });
    }
}