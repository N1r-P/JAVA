package user;

import sql.Sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static user.Log.IfLog;

public class Sold extends JFrame{
    JLabel northJLabel;
    JPanel p, centerJPanel, southJPanel;
    JTextArea centerJTextArea;
    JButton southJButton;
    public Sold() {
        p = new JPanel(new BorderLayout());
        northJLabel = new JLabel("购买信息", JLabel.CENTER);
        p.add(northJLabel, BorderLayout.NORTH);

        Sql sql = Sql.getInstance();

        centerJPanel = new JPanel();
        centerJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        centerJTextArea = new JTextArea(5,30);
        centerJTextArea.append(sql.inquire_user_information_sold(IfLog));
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