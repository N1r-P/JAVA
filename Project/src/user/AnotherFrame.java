package user;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is the another frame and contains some components of the application.
 */

public class AnotherFrame extends JFrame {

    JLabel northJLabel;
    JPanel p, centerJPanel, southJPanel;
    JTextArea centerJTextArea;
    JButton southJButton;

    /**
     * This method is the construction method of the class MyFrame.
     */

    public AnotherFrame(String string0, String string1, String string2, String string3, String string4){
        super("Check in complete!");
        p = new JPanel(new BorderLayout());
        northJLabel = new JLabel("You have checked in successfully.", JLabel.CENTER);
        Font fnt1 = new Font("Arial", Font.BOLD, 18);
        northJLabel.setFont(fnt1);
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
        Font fnt2 = new Font("Arial", Font.PLAIN ,17);
        centerJTextArea.setFont(fnt2);
        centerJTextArea.setForeground(Color.BLACK);
        centerJPanel.add(centerJTextArea);
        p.add(centerJPanel, BorderLayout.CENTER);

        southJPanel = new JPanel();
        southJPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        southJButton = new JButton("Finish");
        southJPanel.add(southJButton);
        p.add(southJPanel, BorderLayout.SOUTH);

        this.add(p);
        this.setSize(500,220);
        this.setLocation(300, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        southJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }


}