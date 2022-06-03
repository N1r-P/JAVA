package user;

import mainMenu.MainMenuGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Log extends JFrame{
    private JPanel p, p1, p2, p3, p4, p5, p6, p7, p8;
    private JTextArea phoneJTextArea, passwordJTextArea;
    private JButton buttonLog,buttonBack;
    private JLabel titleJLabel;
    private Border lineBorderBlack;

    public Log() {
        super("登录");//Using the construction method of the parent class.
        p = new JPanel();
        p.setLayout(new GridLayout(4, 1));

        p1 = new JPanel(new BorderLayout());
        titleJLabel = new JLabel("请输入您的电话和密码 ", JLabel.CENTER);//Let the JLabel be in the center.
        p1.add(titleJLabel, BorderLayout.CENTER);

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("电话"));//Use createTitledBorder() method to set the border of JPanel.
        Color bgColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p2_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "电话"));//Composite border
        p2_1.setBackground(bgColor);//Set background color of the JPanel
        phoneJTextArea = new JTextArea("", 1, 10);
        p2_1.add(phoneJTextArea);
        p2.add(p2_1);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("密码"));//Use createTitledBorder() method to set the border of JPanel.
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p3_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p3_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "密码"));//Composite border
        p3_1.setBackground(bgColor);//Set background color of the JPanel
        passwordJTextArea = new JTextArea("", 1, 10);
        p3_1.add(passwordJTextArea);
        p3.add(p3_1);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("登录"));
        buttonLog = new JButton("登录");
        buttonBack = new JButton("返回");
        p4.setLayout(null);
        buttonLog.setBounds(50,40,100,40);
        buttonBack.setBounds(200,40,100,40);
        p4.add(buttonBack);
        p4.add(buttonLog);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        this.add(p);
        this.setSize(360, 420);// Set the window's size.
        this.setLocation(450, 200);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"确定"};
                int result= JOptionPane.showOptionDialog(null,"登录成功！！","提示",JOptionPane.INFORMATION_MESSAGE,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                if(result==0)
                {
                    dispose();
                    MainMenuGUI mainMenugui = new MainMenuGUI();
                    mainMenugui.setVisible(true);
                }
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
    }
}
