package mainMenu;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import products.*;
import java.util.ArrayList;
import javax.swing.border.Border;

public class MainMenuGUI extends JFrame {

    /**
     * The serial number of class ProductGUI.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Standard error stream.
     */
    static private PrintWriter stdErr = new PrintWriter(System.err, true);

    /**
     * Window width&height in pixels.
     */
    static private int WIDTH = 360;
    static private int HEIGHT = 640;

    /**
     * Size&rows of the title  in pixels.
     */
    static private int Product_Advice_SIZE = 50;
    static private int Product_Advice_ROWS = 14;

    private JLabel titleLabel;
    private JPanel integration;
    private JList productAdvice;
    private JTextArea searchTextField;
    private JButton buttonMainMenu,buttonSearch,buttonSort, buttonRelease, buttonUserInformation;
    private Border lineBorderBlack, lineBorderRed;

    public MainMenuGUI() {
        super("Main");//Using the construction method of the parent class.

        /**
         * create the components.组成原件
         */
        titleLabel = new JLabel("             Easy   Circle");
        buttonSearch = new JButton("Search🔍");
        buttonSearch.setBounds(40, 30, 100, 25);
        searchTextField = new JTextArea("", 5,10);

        //productAdvice = new JList<String>();
        /*productAdvice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productAdvice.setVisibleRowCount(Product_Advice_ROWS);
        productAdvice.setFixedCellWidth(Product_Advice_SIZE);*/

        buttonSort = new JButton("分类");
        buttonSort.setBounds(40, 30, 100, 25);
        buttonRelease = new JButton("发布");
        buttonUserInformation = new JButton("我的");
        buttonMainMenu = new JButton("主界面");


        /**
         * title panel.标题区
         */
        JPanel titlePanel = new JPanel(new GridLayout(3, 10));
        titlePanel.setBorder(BorderFactory.createTitledBorder("转易圈~"));
        Font x = new Font("Arial", Font.BOLD, 25);
        titleLabel.setFont(x);//Set the font in the JLabel.
        titlePanel.add(titleLabel,BorderLayout.NORTH);

        /**
         * search panel.搜索区
         */
        JPanel searchPanel = new JPanel(new GridLayout(2, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder("搜一下~"));
        searchPanel.add(searchTextField,BorderLayout.WEST);
        searchPanel.add(buttonSearch,BorderLayout.EAST);

        /**
         * goodsAdvice panel.商品推荐区
         */
        JPanel goodsAdvicePanel = new JPanel(new GridLayout(10, 10));
        goodsAdvicePanel.setBorder(BorderFactory.createTitledBorder("看一会~"));
        //productAdvice.setBorder(BorderFactory.createTitledBorder("商品/任务推荐"));
        /*productAdvice.add(new JScrollPane(productAdvice, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                          JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));*/


        /**
         * central panel.
         */
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.add(searchPanel, BorderLayout.CENTER);
        centralPanel.add(goodsAdvicePanel, BorderLayout.SOUTH);

        /**
         * bottom panel.
         */
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4,10,0));
        bottomPanel.add(buttonMainMenu,BorderLayout.WEST);
        bottomPanel.add(buttonRelease,BorderLayout.CENTER);
        bottomPanel.add(buttonSort,BorderLayout.CENTER);
        bottomPanel.add(buttonUserInformation,BorderLayout.EAST);

        /**
         * Arrange panels in window.
         */
        integration = new JPanel();
        integration.setLayout(new GridLayout(3, 15));//Using GridLayout to arrange the GUI components
        integration.add(titlePanel, BorderLayout.NORTH);
        integration.add(centralPanel, BorderLayout.CENTER);
        integration.add(bottomPanel, BorderLayout.SOUTH);
        this.add(integration);
        this.setSize(WIDTH, HEIGHT);// Set the window's size.
        this.setLocation(450, 10);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        /**
         * Start listening for list and buttons events.
         * 监听器检测用户操作并给出反应
         */

       /* buttonMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }

        });



        buttonRelease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }

        });
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }

        });
        buttonUserInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }

        });
        buttonRelease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }

        });*/

    }

}