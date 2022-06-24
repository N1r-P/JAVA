package user;

import mainMenu.MainMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Mygui extends JFrame{
    private JPanel p, p1, p2, p3, p4, p5, p6;
    private JButton buttonRegister,buttonLog, buttonPI, buttonSold,buttonBought,buttonBack;
    public Mygui(){
        super("我的");//Using the construction method of the parent class.

        p = new JPanel();
        p.setLayout(new GridLayout(6, 1));//Using GridLayout to arrange the GUI components

        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("注册"));
        buttonRegister = new JButton("注册");
        p1.setLayout(null);
        buttonRegister.setBounds(125,45,100,40);
        p1.add(buttonRegister);

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("登录"));
        buttonLog = new JButton("登录");
        p2.setLayout(null);
        buttonLog.setBounds(125,45,100,40);
        p2.add(buttonLog);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("我的信息"));
        buttonPI = new JButton("我的信息");
        p3.setLayout(null);
        buttonPI.setBounds(75,45,200,40);
        p3.add(buttonPI);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("我卖的"));
        buttonSold = new JButton("我卖的");
        p4.setLayout(null);
        buttonSold.setBounds(125,45,100,40);
        p4.add(buttonSold);

        p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("我买的"));
        buttonBought = new JButton("我买的");
        p5.setLayout(null);
        buttonBought.setBounds(125,45,100,40);
        p5.add(buttonBought);

        p6 = new JPanel();
        p6.setBorder(BorderFactory.createTitledBorder("返回"));
        buttonBack = new JButton("返回");
        p6.setLayout(null);
        buttonBack.setBounds(125,45,100,40);
        p6.add(buttonBack);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
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

        buttonLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Log f = new Log();
                f.setVisible(true);
            }
        });

        buttonPI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> strings = new ArrayList<String>();
                strings.add("姓名 : " );
                strings.add("生日 : " );
                strings.add("地址 : " );
                strings.add("电话 : " );
                strings.add("密码 : " );
                dispose();
                JFrame information = new Information(strings.get(0), strings.get(1), strings.get(2), strings.get(3), strings.get(4));
                information.setVisible(true);
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                MainMenuGUI mainMenugui = new MainMenuGUI();
                mainMenugui.setVisible(true);
            }
        });

        buttonSold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                Sold f = new Sold();
                f.setVisible(true);
            }
        });

        buttonBought.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                Bought f = new Bought();
                f.setVisible(true);
            }
        });
    }
}