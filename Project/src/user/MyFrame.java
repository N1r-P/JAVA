package user;

import mainMenu.MainMenuGUI;
import sql.Sql;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is the main frame and contains all main components
 *
 */

public class MyFrame extends JFrame {

    private JPanel p, p1, p2, p3, p4, p5, p6, p7, p8;
    private JTextArea firstNameJTextArea, surnameJTextArea, addressJTextArea, phoneJTextArea, passwordJTextArea;
    private JLabel titleJLabel;
    private JTextField addressJTextField, phoneJTextField, passwordJTextField;
    private JComboBox<String> doBMonthJComboBox, doBYearJComboBox;
    private JCheckBox checkBox1, checkBox2;
    private JButton buttonNextstep, buttonClear, buttonExit;
    private Border lineBorderBlack, lineBorderRed;

    /**
     * This method is the construction method of the class MyFrame
     */
    public MyFrame() {
        super("注册");//Using the construction method of the parent class.
        p = new JPanel();
        p.setLayout(new GridLayout(8, 1));//Using GridLayout to arrange the GUI components

        p1 = new JPanel(new BorderLayout());
        titleJLabel = new JLabel("请填写以下信息: ", JLabel.CENTER);//Let the JLabel be in the center.
        p1.add(titleJLabel, BorderLayout.CENTER);//Let the JLabel be in the center.

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("名字"));//Use createTitledBorder() method to set the border of JPanel.
        Color bgColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p2_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "姓名"));//Composite border
        p2_1.setBackground(bgColor);//Set background color of the JPanel
        firstNameJTextArea = new JTextArea("", 1, 10);
        p2_1.add(firstNameJTextArea);
        p2.add(p2_1);//Add the second level JPanel p2_2 into JPanel p2

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("年级"));//Use createTitledBorder() method to set the border of JPanel.
        JPanel p3_1 = new JPanel();
        p3_1.setBorder(BorderFactory.createTitledBorder("年级"));
        doBMonthJComboBox = new JComboBox<String>();//Declare the variable types of JComboBox.
        doBMonthJComboBox.addItem(new String("---"));//Set Index 0.
        doBMonthJComboBox.addItem(new String("2022级"));
        doBMonthJComboBox.addItem(new String("2021级"));
        doBMonthJComboBox.addItem(new String("2020级"));
        doBMonthJComboBox.addItem(new String("2019级"));
        doBMonthJComboBox.addItem(new String("2018级"));
        doBMonthJComboBox.addItem(new String("2017级"));
        doBMonthJComboBox.addItem(new String("2016级"));
        doBMonthJComboBox.addItem(new String("2015级"));
        doBMonthJComboBox.addItem(new String("2014级"));
        doBMonthJComboBox.addItem(new String("2013级"));
        doBMonthJComboBox.addItem(new String("2012级"));
        doBMonthJComboBox.addItem(new String("2011级"));
        p3_1.add(doBMonthJComboBox);
        p3.add(p3_1);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("地址"));
        JPanel p4_1 = new JPanel(new GridLayout(1, 1));
        p4_1.setBorder(BorderFactory.createLoweredBevelBorder());//Use createLoweredBevelBorder() method to get embedded border.
        p4_1.setBackground(bgColor);
        addressJTextArea = new JTextArea("", 1, 30);
        p4_1.add(addressJTextArea);
        p4.add(p4_1);

        p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("电话"));
        JPanel p5_1 = new JPanel(new GridLayout(1, 1));
        p5_1.setBorder(BorderFactory.createLoweredBevelBorder());//Use createLoweredBevelBorder() method to get embedded border.
        p5_1.setBackground(bgColor);
        phoneJTextArea = new JTextArea("", 1, 20);
        p5_1.add(phoneJTextArea);
        p5.add(p5_1);

        p6 = new JPanel();
        p6.setBorder(BorderFactory.createTitledBorder("密码"));
        JPanel p6_1 = new JPanel(new GridLayout(1, 1));
        p6_1.setBorder(BorderFactory.createLoweredBevelBorder());
        p6_1.setBackground(bgColor);
        passwordJTextArea = new JTextArea("", 1, 16);
        p6_1.add(passwordJTextArea);
        p6.add(p6_1);

        p7 = new JPanel();
        p7.setBorder(BorderFactory.createEtchedBorder());//Use createEtchedBorder() method to get no title border.
        checkBox1 = new JCheckBox("我已阅读并同意用户协议和隐私政策");
        checkBox2 = new JCheckBox("我确认以上信息均正确");
        p7.add(checkBox1);
        p7.add(checkBox2);

        p8 = new JPanel();
        p8.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonNextstep = new JButton("下一步");
        buttonExit = new JButton("返回");
        /**
         * Let the Layout invalid and set the buttons' position with setBounds() method.
         */
        p8.setLayout(null);
        buttonNextstep.setBounds(60, 30, 80, 25);
        buttonExit.setBounds(220, 30, 80, 25);
        p8.add(buttonNextstep);
        p8.add(buttonExit);

        /**
         * Add each JPanel into the main JPanel.
         */
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        this.add(p);
        this.setSize(360, 740);// Set the window's size.
        this.setLocation(450, 10);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonNextstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> strings = new ArrayList<String>();
                strings.add("姓名 : " + firstNameJTextArea.getText() + " " + surnameJTextArea.getText());
                strings.add("年级 : " + doBMonthJComboBox.getSelectedItem() + " " + doBYearJComboBox.getSelectedItem());
                strings.add("地址 : " + addressJTextArea.getText());
                strings.add("电话 : " + phoneJTextArea.getText());
                strings.add("密码 : " + passwordJTextArea.getText());
                //Use this if else to determine whether JPanel is empty or not.
                if (firstNameJTextArea.getText().equals("") || surnameJTextArea.getText().equals("") || doBMonthJComboBox.getSelectedIndex() == 0 || doBYearJComboBox.getSelectedIndex() == 0
                        || addressJTextArea.getText().equals("") || phoneJTextArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "请将信息填写完整", null, JOptionPane.WARNING_MESSAGE);
                    lineBorderRed = BorderFactory.createLineBorder(Color.RED, 2);
                    /**
                     * Below are many if else to check whether user fill this text or not, and
                     * change the border into lineBorderRed.
                     */
                    if (firstNameJTextArea.getText().equals("")) {
                        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "姓名"));
                    } else {
                        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "姓名"));
                    }

                    if (doBMonthJComboBox.getSelectedIndex() == 0) {
                        p3_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "年级"));
                    } else {
                        p3_1.setBorder(BorderFactory.createTitledBorder("年级"));
                    }

                    if (addressJTextArea.getText().equals("")) {
                        p4_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "地址"));
                        addressJTextArea.setSize(100, 10);
                    } else {
                        p4_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }

                    if (phoneJTextArea.getText().equals("")) {
                        p5_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "电话"));
                    } else {
                        p5_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }

                    if (passwordJTextArea.getText().equals("")) {
                        p6_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "密码"));
                    } else {
                        p6_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }
                }
                // If no JPanel is empty, then enter into another frame.
                else {
                    if (checkBox1.isSelected() && checkBox2.isSelected()) {
                        int a = JOptionPane.showConfirmDialog(null, "你是否已经检查过所有信息? 信息提交后你将无法再修改", "确认提交?", JOptionPane.YES_NO_OPTION);
                        if (a == JOptionPane.YES_OPTION) {
                            Sql sql = Sql.getInstance();
                            sql.add_user_information(firstNameJTextArea.getText(),(String) doBMonthJComboBox.getSelectedItem(),addressJTextArea.getText(),phoneJTextArea.getText(),passwordJTextArea.getText());
                            JFrame anotherJFrame = new AnotherFrame(strings.get(0), strings.get(1), strings.get(2), strings.get(3), strings.get(4));
                            anotherJFrame.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "请确保您已勾选所有复选框!", null, JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                Mygui mygui = new Mygui();
                mygui.setVisible(true);
            }
        });
    }
}
