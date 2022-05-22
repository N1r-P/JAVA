package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainMenuGUI extends JPanel {

    /**
     * The serial number of class CatalogGUI.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Standard error stream.
     */
    static private PrintWriter stdErr = new PrintWriter(System.err, true);

    /**
     * Window width in pixels.
     */
    static private int WIDTH = 360;

    /**
     * Window height in pixels.
     */
    static private int HEIGHT = 640;

    /**
     * Size of the title  in pixels.
     */
    static private int Product_Advice_SIZE = 50;

    /**
     * Visible rows in catalog list.
     */
    static private int Product_Advice_ROWS = 14;

    /**
     * Size of the order list cell in pixels.
     */
    static private int ORDER_CELL_SIZE = 100;

    /**
     * Visible rows in order list.
     */
    static private int ORDER_LIST_ROWS = 6;

    /**
     * Size search text field.
     */
    static private int SEARCH__TEXTFIELD_SIZE = 150;

    /**
     * Size total text field.
     */
    static private int TOTAL__TEXTFIELD_SIZE = 8;

    /**
     * Rows in status text area rows.
     */
    static private int STATUS_ROWS = 10;

    /**
     * Rows in status text area cols.
     */
    static private int STATUS_COLS = 40;

    private JLabel titleLabel;
    private JLabel searchLabel;
    private JPanel titlePanel;
    private JButton searchButton;
    private JList<String> productAdvice;
    private JTextField searchTextField;
    private JButton sortButton;
    private JButton releaseButton;
    private JButton UserInformationButton;
    private JButton mainMenuButton;




    /**
     * Instantiates the components and arranges them in a window.
     *
     * @param initialProduct a product Product.
     */
    public MainMenuGUI(product initialProduct) {

        /**
         * create the components.
         */
        titleLabel = new JLabel("易圈");
        searchLabel = new JLabel("🔍");
        searchTextField = new JTextField("", SEARCH__TEXTFIELD_SIZE);
        productAdvice = new JList<String>();
        productAdvice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productAdvice.setVisibleRowCount(Product_Advice_ROWS);
        productAdvice.setFixedCellWidth(Product_Advice_SIZE);
        searchButton = new JButton("搜索🔍");
        sortButton = new JButton("分类");
        releaseButton = new JButton("发布");
        UserInformationButton = new JButton("我的");
        mainMenuButton = new JButton("主界面");



        /*totalTextField = new JTextField("￥0.00", TOTAL__TEXTFIELD_SIZE);
        totalTextField.setEditable(false);
        statusTextArea = new JTextArea(STATUS_ROWS, STATUS_COLS);
        statusTextArea.setEditable(false);*/


        /**
         * title panel
         */
        titlePanel = new JPanel();
        titlePanel.setBorder(BorderFactory.createTitledBorder("转易圈~"));



        /**
         * goodsAdvice panel.
         */
        JPanel goodsAdvicePanel = new JPanel();
        productAdvice.setBorder(BorderFactory.createTitledBorder("商品/任务推荐"));
        productAdvice.add(new JScrollPane(productAdvice, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        /**
         * search panel.
         */
        JPanel searchPanel = new JPanel(new GridLayout(2, 1));
        searchPanel.add(searchLabel);
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        /**
         * central panel.
         */
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.add(searchPanel, BorderLayout.CENTER);
        centralPanel.add(goodsAdvicePanel, BorderLayout.SOUTH);

        /**
         * bottom panel.
         */
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(mainMenuButton,BorderLayout.WEST);
        bottomPanel.add(releaseButton,BorderLayout.CENTER);
        bottomPanel.add(sortButton,BorderLayout.CENTER);
        bottomPanel.add(UserInformationButton,BorderLayout.WEST);



        /**
         * Arrange panels in window.
         */
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        /**
         * Start listening for list and buttons events.
         * 监听器检测用户操作并给出反应
         */
        productAdvice.addListSelectionListener(new DisplayProductListener());//要建立函数DisplayProductListener()
        mainMenuButton.addActionListener(new mainMenuListener());//要建立函数mainMenuListener()
        releaseButton.addActionListener(new releaseListener());//releaseListener()
        sortButton.addActionListener(new sortListener());//要建立函数sortListener()
        UserInformationButton.addActionListener(new UserInformationListener());//要建立函数UserInformationListener()
        searchButton.addActionListener(new searchListener());//要建立函数searchListener()


        /**
         * populate the product catalog
         */
        product = initialProduct;
        catalogList.setListData(catalog.getCodes());

        currentOrder = new Order();
        sales = new Sales();
        salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
        fileChooser = new JFileChooser();
        dollarFormatter = NumberFormat.getCurrencyInstance();
    }


}