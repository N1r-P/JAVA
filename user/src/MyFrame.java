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
        super("Register");//Using the construction method of the parent class.
        p = new JPanel();
        p.setLayout(new GridLayout(8, 1));//Using GridLayout to arrange the GUI components

        p1 = new JPanel(new BorderLayout());
        titleJLabel = new JLabel("Please complete the information below: ", JLabel.CENTER);//Let the JLabel be in the center.
        Font fnt = new Font("Arial", Font.BOLD, 14);
        titleJLabel.setFont(fnt);//Set the font in the JLabel.
        p1.add(titleJLabel, BorderLayout.CENTER);//Let the JLabel be in the center.

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("Name"));//Use createTitledBorder() method to set the border of JPanel.
        Color bgColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p2_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "First Name"));//Composite border
        p2_1.setBackground(bgColor);//Set background color of the JPanel
        firstNameJTextArea = new JTextArea("", 1, 10);
        p2_1.add(firstNameJTextArea);
        JPanel p2_2 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p2_2.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "Surname"));
        p2_2.setBackground(bgColor);
        surnameJTextArea = new JTextArea("", 1, 10);
        p2_2.add(surnameJTextArea);
        p2.add(p2_1);//Add the second level JPanel p2_1 into JPanel p2
        p2.add(p2_2);//Add the second level JPanel p2_2 into JPanel p2

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("Date of Birth"));//Use createTitledBorder() method to set the border of JPanel.
        JPanel p3_1 = new JPanel();
        p3_1.setBorder(BorderFactory.createTitledBorder("Month"));
        doBMonthJComboBox = new JComboBox<String>();//Declare the variable types of JComboBox.
        doBMonthJComboBox.addItem(new String("---"));//Set Index 0.
        doBMonthJComboBox.addItem(new String("January"));
        doBMonthJComboBox.addItem(new String("February"));
        doBMonthJComboBox.addItem(new String("March"));
        doBMonthJComboBox.addItem(new String("April"));
        doBMonthJComboBox.addItem(new String("May"));
        doBMonthJComboBox.addItem(new String("June"));
        doBMonthJComboBox.addItem(new String("July"));
        doBMonthJComboBox.addItem(new String("August"));
        doBMonthJComboBox.addItem(new String("September"));
        doBMonthJComboBox.addItem(new String("October"));
        doBMonthJComboBox.addItem(new String("November"));
        doBMonthJComboBox.addItem(new String("December"));
        p3_1.add(doBMonthJComboBox);
        JPanel p3_2 = new JPanel();
        p3_2.setBorder(BorderFactory.createTitledBorder("Year"));
        doBYearJComboBox = new JComboBox<String>();//Declare the variable types of JComboBox.
        doBYearJComboBox.addItem(new String("---"));
        doBYearJComboBox.addItem(new String("1991"));
        doBYearJComboBox.addItem(new String("1992"));
        doBYearJComboBox.addItem(new String("1993"));
        doBYearJComboBox.addItem(new String("1994"));
        doBYearJComboBox.addItem(new String("1995"));
        doBYearJComboBox.addItem(new String("1996"));
        doBYearJComboBox.addItem(new String("1997"));
        doBYearJComboBox.addItem(new String("1998"));
        doBYearJComboBox.addItem(new String("1999"));
        doBYearJComboBox.addItem(new String("2000"));
        doBYearJComboBox.addItem(new String("2001"));
        doBYearJComboBox.addItem(new String("2002"));
        doBYearJComboBox.addItem(new String("2003"));
        doBYearJComboBox.addItem(new String("2004"));
        doBYearJComboBox.addItem(new String("2005"));
        p3_2.add(doBYearJComboBox);
        p3.add(p3_1);
        p3.add(p3_2);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("Address"));
        JPanel p4_1 = new JPanel(new GridLayout(1, 1));
        p4_1.setBorder(BorderFactory.createLoweredBevelBorder());//Use createLoweredBevelBorder() method to get embedded border.
        p4_1.setBackground(bgColor);
        addressJTextArea = new JTextArea("", 1, 30);
        p4_1.add(addressJTextArea);
        p4.add(p4_1);

        p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("Phone number"));
        JPanel p5_1 = new JPanel(new GridLayout(1, 1));
        p5_1.setBorder(BorderFactory.createLoweredBevelBorder());//Use createLoweredBevelBorder() method to get embedded border.
        p5_1.setBackground(bgColor);
        phoneJTextArea = new JTextArea("", 1, 20);
        p5_1.add(phoneJTextArea);
        p5.add(p5_1);

        p6 = new JPanel();
        p6.setBorder(BorderFactory.createTitledBorder("Password"));
        JPanel p6_1 = new JPanel(new GridLayout(1, 1));
        p6_1.setBorder(BorderFactory.createLoweredBevelBorder());
        p6_1.setBackground(bgColor);
        passwordJTextArea = new JTextArea("", 1, 16);
        p6_1.add(passwordJTextArea);
        p6.add(p6_1);

        p7 = new JPanel();
        p7.setBorder(BorderFactory.createEtchedBorder());//Use createEtchedBorder() method to get no title border.
        checkBox1 = new JCheckBox("I have read and agree to the terms and conditions.");
        checkBox2 = new JCheckBox("I confirm that the information provided is correct.");
        p7.add(checkBox1);
        p7.add(checkBox2);

        p8 = new JPanel();
        p8.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonNextstep = new JButton("Next step");
        buttonClear = new JButton("Clear");
        buttonExit = new JButton("Exit");
        /**
         * Let the Layout invalid and set the buttons' position with setBounds() method.
         */
        p8.setLayout(null);
        buttonNextstep.setBounds(40, 30, 100, 25);
        buttonClear.setBounds(160, 30, 80, 25);
        buttonExit.setBounds(260, 30, 60, 25);
        p8.add(buttonNextstep);
        p8.add(buttonClear);
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
                strings.add("Full name : " + firstNameJTextArea.getText() + " " + surnameJTextArea.getText());
                strings.add("Date of birth : " + doBMonthJComboBox.getSelectedItem() + " " + doBYearJComboBox.getSelectedItem());
                strings.add("Address : " + addressJTextArea.getText());
                strings.add("Phone number : " + phoneJTextArea.getText());
                strings.add("Password : " + passwordJTextArea.getText());
                //Use this if else to determine whether JPanel is empty or not.
                if (firstNameJTextArea.getText().equals("") || surnameJTextArea.getText().equals("") || doBMonthJComboBox.getSelectedIndex() == 0 || doBYearJComboBox.getSelectedIndex() == 0
                        || addressJTextArea.getText().equals("") || phoneJTextArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in the missing information", null, JOptionPane.WARNING_MESSAGE);
                    lineBorderRed = BorderFactory.createLineBorder(Color.RED, 2);
                    /**
                     * Below are many if else to check whether user fill this text or not, and
                     * change the border into lineBorderRed.
                     */
                    if (firstNameJTextArea.getText().equals("")) {
                        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "First Name"));
                    } else {
                        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "First Name"));
                    }

                    if (surnameJTextArea.getText().equals("")) {
                        p2_2.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "surname"));
                    } else {
                        p2_2.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "surname"));
                    }

                    if (doBMonthJComboBox.getSelectedIndex() == 0) {
                        p3_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "Month"));
                    } else {
                        p3_1.setBorder(BorderFactory.createTitledBorder("Month"));
                    }

                    if (doBYearJComboBox.getSelectedIndex() == 0) {
                        p3_2.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "Year"));
                    } else {
                        p3_2.setBorder(BorderFactory.createTitledBorder("Year"));
                    }

                    if (addressJTextArea.getText().equals("")) {
                        p4_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "Address"));
                        addressJTextArea.setSize(100, 10);
                    } else {
                        p4_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }

                    if (phoneJTextArea.getText().equals("")) {
                        p5_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "Phone number"));
                    } else {
                        p5_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }

                    if (passwordJTextArea.getText().equals("")) {
                        p6_1.setBorder(BorderFactory.createTitledBorder(lineBorderRed, "Password"));
                    } else {
                        p6_1.setBorder(BorderFactory.createLoweredBevelBorder());
                    }
                }
                // If no JPanel is empty, then enter into another frame.
                else {
                    if (checkBox1.isSelected() && checkBox2.isSelected()) {
                        int a = JOptionPane.showConfirmDialog(null, "Have you checked all the information is correct? You can't change the information once the information is submitted", "Confirm check in?", JOptionPane.YES_NO_OPTION);
                        if (a == JOptionPane.YES_OPTION) {
                            JFrame anotherJFrame = new AnotherFrame(strings.get(0), strings.get(1), strings.get(2), strings.get(3), strings.get(4));
                            anotherJFrame.setVisible(true);
                            setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please ensure you have checked all the checkbox!", null, JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the text in the text box, and make the JComboBox's index to 0.
                doBMonthJComboBox.setSelectedIndex(0);
                doBYearJComboBox.setSelectedIndex(0);
                firstNameJTextArea.setText("");
                surnameJTextArea.setText("");
                addressJTextArea.setText("");
                phoneJTextArea.setText("");
                passwordJTextArea.setText("");
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                System.exit(0);
            }
        });
    }
}