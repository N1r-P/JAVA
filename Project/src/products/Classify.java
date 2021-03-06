package products;

import mainMenu.MainMenuGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Classify extends JFrame {
    private JPanel p,p1,p2;
    private JButton button1, button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,buttonBack;

    public Classify(){
        super("商品分类");
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));

        p1 = new JPanel();
        p1.setBorder(BorderFactory.createLoweredBevelBorder());
        button1 = new JButton("服饰");
        button2 = new JButton("洗护用品");
        button3 = new JButton("数码产品");
        button4 = new JButton("食品");
        button5 = new JButton("美妆");
        button6 = new JButton("电器");
        button7 = new JButton("日用品");
        button1.setBackground(Color.ORANGE);
        button2.setBackground(Color.ORANGE);
        button3.setBackground(Color.ORANGE);
        button4.setBackground(Color.ORANGE);
        button5.setBackground(Color.ORANGE);
        button6.setBackground(Color.ORANGE);
        button7.setBackground(Color.ORANGE);
        p1.setLayout(null);
        button1.setBounds(35, 35, 100, 40);
        button2.setBounds(35, 85, 100, 40);
        button3.setBounds(35, 135, 100, 40);
        button4.setBounds(35, 185, 100, 40);
        button5.setBounds(200, 35, 100, 40);
        button6.setBounds(200, 85, 100, 40);
        button7.setBounds(200, 135, 100, 40);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);


        p2 = new JPanel();
        p2.setBorder(BorderFactory.createLoweredBevelBorder());
        button8 = new JButton("跑腿");
        button9 = new JButton("借东西");
        button10 = new JButton("代排队");
        button11 = new JButton("其他");
        buttonBack = new JButton("返回");
        button8.setBackground(Color.PINK);
        button9.setBackground(Color.PINK);
        button10.setBackground(Color.PINK);
        button11.setBackground(Color.PINK);

        p2.setLayout(null);
        button8.setBounds(35, 35, 100, 40);
        button9.setBounds(35, 85, 100, 40);
        button10.setBounds(200, 35, 100, 40);
        button11.setBounds(200, 85, 100, 40);
        buttonBack.setBounds(120,200,100,40);
        p2.add(button8);
        p2.add(button9);
        p2.add(button10);
        p2.add(button11);
        p2.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                MainMenuGUI mainMenugui = new MainMenuGUI();
                mainMenugui.setVisible(true);
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("服饰");
                f.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("洗护用品");
                f.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("数码产品");
                f.setVisible(true);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("食品");
                f.setVisible(true);
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("美妆");
                f.setVisible(true);
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("电器");
                f.setVisible(true);
            }
        });

        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                GoodsDisplay f = new GoodsDisplay("日用品");
                f.setVisible(true);
            }
        });

        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                TaskDisplay f = new TaskDisplay("跑腿");
                f.setVisible(true);
            }
        });

        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                TaskDisplay f = new TaskDisplay("借东西");
                f.setVisible(true);
            }
        });

        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                TaskDisplay f = new TaskDisplay("代排队");
                f.setVisible(true);
            }
        });

        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                TaskDisplay f = new TaskDisplay("其他");
                f.setVisible(true);
            }
        });

        p.add(p1);
        p.add(p2);
        this.add(p);
        this.setSize(360, 640);// Set the window's size.
        this.setLocation(450, 10);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

