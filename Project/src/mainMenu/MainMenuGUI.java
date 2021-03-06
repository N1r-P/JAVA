package mainMenu;


import products.Classify;
import products.Post;
import sql.Sql;
import user.Mygui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.Random;

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
    static private int HEIGHT = 740;



    private JLabel titleLabel;
    private JPanel integration;
    private JButton buttonSort, buttonRelease, buttonUserInformation ,
                    buttonAdvice1,buttonAdvice2,buttonAdvice3,buttonAdvice4;


    public MainMenuGUI() {
        super("易圈");//Using the construction method of the parent class.

        Random random = new Random();
        int random_production = random.nextInt(1);

        /**
         * create the components.组成原件
         */
        titleLabel = new JLabel("          Easy         Circle");
        Sql sql = Sql.getInstance();
        buttonAdvice1 = new JButton(sql.inquire_goods_name(random_production+1));
        buttonAdvice2 = new JButton(sql.inquire_goods_name(random_production+2));
        buttonAdvice3 = new JButton(sql.inquire_task_name(random_production+1));
        buttonAdvice4 = new JButton(sql.inquire_task_name(random_production+2));
        buttonSort = new JButton("分类");
        buttonRelease = new JButton("发布");
        buttonUserInformation = new JButton("我的");

        buttonAdvice1.setBackground(Color.ORANGE);//advice1按钮橙色
        buttonAdvice2.setBackground(Color.ORANGE);//advice2按钮橙色
        buttonAdvice3.setBackground(Color.PINK);//advice3按钮粉色
        buttonAdvice4.setBackground(Color.PINK);//advice3按钮粉色
        buttonSort.setBackground(Color.WHITE);//分类按钮白色
        buttonRelease.setBackground(Color.WHITE);//发布按钮白色
        buttonUserInformation.setBackground(Color.WHITE);//用户按钮白色
        buttonAdvice1.setPreferredSize(new Dimension(100, 115));
        buttonAdvice2.setPreferredSize(new Dimension(100, 115));
        buttonAdvice3.setPreferredSize(new Dimension(100, 115));
        buttonAdvice4.setPreferredSize(new Dimension(100, 115));
        buttonRelease.setPreferredSize(new Dimension(100, 100));
        buttonSort.setPreferredSize(new Dimension(100, 100));
        buttonUserInformation.setPreferredSize(new Dimension(100, 100));


        /**
         * title panel.标题区
         */
        JPanel titlePanel = new JPanel(new BorderLayout(1,1));
        titlePanel.setBorder(BorderFactory.createTitledBorder("转易圈~"));
        Font x = new Font("Arial", Font.BOLD, 25);
        titleLabel.setFont(x);//Set the font in the JLabel.
        titlePanel.add(titleLabel,BorderLayout.NORTH);



        /**
         * goodsAdvice panel.商品推荐区
         */
        JPanel goodsAdvicePanel = new JPanel(new BorderLayout(10,10));
        goodsAdvicePanel.add(buttonAdvice1,BorderLayout.NORTH);
        goodsAdvicePanel.add(buttonAdvice2,BorderLayout.CENTER);
        goodsAdvicePanel.add(buttonAdvice3,BorderLayout.SOUTH);


        /**
         * central panel.
         */
        JPanel centralPanel = new JPanel(new BorderLayout(10,10));
        centralPanel.setBorder(BorderFactory.createTitledBorder("看一会~"));
        centralPanel.add(goodsAdvicePanel, BorderLayout.CENTER);
        centralPanel.add(buttonAdvice4,BorderLayout.SOUTH);

        /**
         * bottom panel.
         */
        JPanel bottomPanel = new JPanel(new BorderLayout(10,10));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("底部菜单栏~"));
        bottomPanel.add(buttonRelease,BorderLayout.WEST);
        bottomPanel.add(buttonSort,BorderLayout.CENTER);
        bottomPanel.add(buttonUserInformation,BorderLayout.EAST);





        /**
         * Arrange panels in window.
         */
        integration = new JPanel();
        integration.setLayout(new BorderLayout(1,1));
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
        buttonAdvice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sql sql = Sql.getInstance();
                ProductDetail p1 = new ProductDetail(sql.inquire_goods(random_production+1),sql.inquire_goods_name(random_production+1));
                p1.setVisible(true);
            }
        });
        buttonAdvice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sql sql = Sql.getInstance();
                ProductDetail p2 = new ProductDetail(sql.inquire_goods(random_production+2),sql.inquire_goods_name(random_production+2));
                p2.setVisible(true);
            }
        });
        buttonAdvice3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sql sql = Sql.getInstance();
                ProductDetail p3 = new ProductDetail(sql.inquire_task(random_production+1),sql.inquire_task_name(random_production+1));
                p3.setVisible(true);
            }
        });
        buttonAdvice4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sql sql = Sql.getInstance();
                ProductDetail p4 = new ProductDetail(sql.inquire_task(random_production+2),sql.inquire_task_name(random_production+2));
                p4.setVisible(true);
            }
        });
        buttonRelease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Post post = new Post();
                post.setVisible(true);
            }
        });
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Classify f = new Classify();
                f.setVisible(true);
            }
        });
        buttonUserInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mygui mygui = new Mygui();
                mygui.setVisible(true);
            }
        });

    }

}