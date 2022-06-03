package products;

import mainMenu.MainMenuGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductPost extends JFrame{
    private JPanel p, p1, p2, p3, p4, p5, p6;
    private JTextArea nameJTextArea, priceJTextArea, descriptionJTextArea;
    private JLabel titleJLabel;
    private JComboBox<String> classifyJComboBox;
    private JButton buttonPost, buttonClear, buttonExit;
    private Border lineBorderBlack;

    /**
     * This method is the construction method of the class Post
     */
    public ProductPost() {
        super("发布");//Using the construction method of the parent class.
        p = new JPanel();
        p.setLayout(new GridLayout(6, 1));//Using GridLayout to arrange the GUI components

        p1 = new JPanel(new BorderLayout());
        titleJLabel = new JLabel("发布商品信息", JLabel.CENTER);//Let the JLabel be in the center.
        p1.add(titleJLabel, BorderLayout.CENTER);//Let the JLabel be in the center.

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("名称"));//Use createTitledBorder() method to set the border of JPanel.
        Color bgColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p2_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p2_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "商品名称"));//Composite border
        p2_1.setBackground(bgColor);//Set background color of the JPanel
        nameJTextArea = new JTextArea("", 1, 10);
        p2_1.add(nameJTextArea);
        p2.add(p2_1);//Add the second level JPanel p2_1 into JPanel p2

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createTitledBorder("价格"));//Use createTitledBorder() method to set the border of JPanel.
        Color bColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p3_1 = new JPanel();
        p3_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "商品价格"));//Composite border
        p3_1.setBackground(bColor);//Set background color of the JPanel
        priceJTextArea = new JTextArea("", 1, 10);
        p3_1.add(priceJTextArea);
        p3.add(p3_1);

        p4 = new JPanel();
        p4.setBorder(BorderFactory.createTitledBorder("描述"));//Use createTitledBorder() method to set the border of JPanel.
        Color gColor = new Color(255, 255, 255);
        lineBorderBlack = BorderFactory.createLineBorder(Color.black, 2);
        JPanel p4_1 = new JPanel();//This JPanel is the second level JPanel in JPanel p2
        p4_1.setBorder(BorderFactory.createTitledBorder(lineBorderBlack, "商品描述"));//Composite border
        p4_1.setBackground(gColor);//Set background color of the JPanel
        descriptionJTextArea = new JTextArea("", 1, 10);
        p4_1.add(descriptionJTextArea);
        p4.add(p4_1);

        p5 = new JPanel();
        p5.setBorder(BorderFactory.createTitledBorder("分类"));//Use createTitledBorder() method to set the border of JPanel.
        JPanel p5_1 = new JPanel();
        p5_1.setBorder(BorderFactory.createTitledBorder("分类"));
        classifyJComboBox = new JComboBox<String>();//Declare the variable types of JComboBox.
        classifyJComboBox.addItem(new String("---"));//Set Index 0.
        classifyJComboBox.addItem(new String("服饰"));
        classifyJComboBox.addItem(new String("洗护用品"));
        classifyJComboBox.addItem(new String("数码产品"));
        classifyJComboBox.addItem(new String("食品"));
        classifyJComboBox.addItem(new String("美妆"));
        classifyJComboBox.addItem(new String("电器"));
        classifyJComboBox.addItem(new String("日用品"));
        p5_1.add(classifyJComboBox);
        p5.add(p5_1);

        p6 = new JPanel();
        p6.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonPost = new JButton("发布");
        buttonClear = new JButton("清空");
        buttonExit = new JButton("返回");
        /**
         * Let the Layout invalid and set the buttons' position with setBounds() method.
         */
        p6.setLayout(null);
        buttonPost.setBounds(35, 45, 80, 25);
        buttonClear.setBounds(135, 45, 80, 25);
        buttonExit.setBounds(235, 45, 80, 25);
        p6.add(buttonPost);
        p6.add(buttonClear);
        p6.add(buttonExit);

        /**
         * Add each JPanel into the main JPanel.
         */
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        this.add(p);
        this.setSize(360, 640);// Set the window's size.
        this.setLocation(450, 10);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"确定"};
                int result= JOptionPane.showOptionDialog(null,"发布成功！！","提示",JOptionPane.INFORMATION_MESSAGE,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
                if(result==0)
                {
                    dispose();
                    MainMenuGUI mainMenugui = new MainMenuGUI();
                    mainMenugui.setVisible(true);
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear the text in the text box, and make the JComboBox's index to 0.
                classifyJComboBox.setSelectedIndex(0);
                nameJTextArea.setText("");
                priceJTextArea.setText("");
                descriptionJTextArea.setText("");
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // To exit the program.
                dispose();
                MainMenuGUI mainMenugui = new MainMenuGUI();
                mainMenugui.setVisible(true);
            }
        });
    }
}


