package user;

import mainMenu.MainMenuGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is the another frame and contains some components of the application.
 */

public class Information extends JFrame {

    JLabel northJLabel;
    JPanel p, centerJPanel, southJPanel;
    JTextArea centerJTextArea;
    JButton southJButton;

    /**
     * This method is the construction method of the class MyFrame.
     */

    public Information(String string0, String string1, String string2, String string3, String string4){
        super("您的信息");
        p = new JPanel(new BorderLayout());
        northJLabel = new JLabel("您的基本信息", JLabel.CENTER);
        p.add(northJLabel, BorderLayout.NORTH);

        centerJPanel = new JPanel();
        centerJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        centerJTextArea = new JTextArea(5,30);
        centerJTextArea.append(string0);//Add string param into the JTextArea through append() method.
        centerJTextArea.append("\n");//Add line feed.
        centerJTextArea.append(string1);
        centerJTextArea.append("\n");
        centerJTextArea.append(string2);
        centerJTextArea.append("\n");
        centerJTextArea.append(string3);
        centerJTextArea.append("\n");
        centerJTextArea.append(string4);
        centerJTextArea.append("\n");
        centerJTextArea.setEditable(false);
        centerJTextArea.setOpaque(false);//Make the JTextArea be transparency.
        centerJTextArea.setForeground(Color.BLACK);
        centerJPanel.add(centerJTextArea);
        p.add(centerJPanel, BorderLayout.CENTER);

        southJPanel = new JPanel();
        southJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        southJButton = new JButton("完成");
        southJPanel.add(southJButton);
        p.add(southJPanel, BorderLayout.SOUTH);

        this.add(p);
        this.setSize(500,220);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        southJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                Mygui m = new Mygui();
                m.setVisible(true);
            }
        });
    }
}
