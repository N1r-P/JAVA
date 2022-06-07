package user;

import mainMenu.MainMenuGUI;
import mainMenu.ProductDetail;
import products.Classify;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SoldAndBought extends JFrame{
    JLabel northJLabel;
    JPanel p, centerJPanel, southJPanel;
    JTextArea centerJTextArea;
    JButton southJButton;
    public SoldAndBought() {
        p = new JPanel(new BorderLayout());
        northJLabel = new JLabel("购买信息", JLabel.CENTER);
        p.add(northJLabel, BorderLayout.NORTH);

        centerJPanel = new JPanel();
        centerJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        centerJTextArea = new JTextArea(5,30);
        centerJTextArea.append("\n");
        centerJTextArea.setEditable(false);
        centerJTextArea.setOpaque(false);//Make the JTextArea be transparency.
        centerJTextArea.setForeground(Color.BLACK);
        centerJPanel.add(centerJTextArea);
        p.add(centerJPanel, BorderLayout.CENTER);

        southJPanel = new JPanel();
        southJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        southJButton = new JButton("返回");
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

