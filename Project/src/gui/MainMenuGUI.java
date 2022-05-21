package gui;

import javax.swing.*;
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
    static private int Goods_Advice_SIZE = 50;

    /**
     * Visible rows in catalog list.
     */
    static private int Goods_Advice_ROWS = 14;

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
    private JList<String> goodsAdvice;
    private JTextField searchTextField;
    private JButton sortButton;
    private JButton releaseButton;
    private JButton UserInformationButton;
    private JButton mainMenuButton;




    /**
     * Instantiates the components and arranges them in a window.
     *
     * @param initialCatalog a product catalog.
     */
    public MainMenuGUI(Catalog initialCatalog) {

        /**
         * create the components.
         */
        titleLabel = new JLabel("易圈");
        searchLabel = new JLabel("🔍");
        searchTextField = new JTextField("", SEARCH__TEXTFIELD_SIZE);
        goodsAdvice = new JList<String>();
        goodsAdvice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        goodsAdvice.setVisibleRowCount(Goods_Advice_ROWS);
        goodsAdvice.setFixedCellWidth(Goods_Advice_SIZE);
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
        goodsAdvice.setBorder(BorderFactory.createTitledBorder("商品推荐"));
        goodsAdvice.add(new JScrollPane(goodsAdvice, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
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
         * below panel.
         */

        JPanel belowPanel = new JPanel();
        belowPanel.add(mainMenuButton);
        belowPanel.add(releaseButton);
        belowPanel.add(sortButton);
        belowPanel.add(UserInformationButton);



        /**
         * Arrange panels in window.
         */
        setLayout(new BorderLayout());
        add(catalogPanel, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        add(orderPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        /**
         * Start listening for list and buttons events.
         */
        catalogList.addListSelectionListener(new DisplayProductListener());
        addModifyButton.addActionListener(new AddModifyListener());
        removeButton.addActionListener(new RemoveListener());
        registerSaleButton.addActionListener(new RegisterSaleListener());
        displaySalesButton.addActionListener(new DisplaySalesListener());
        saveSalesButton.addActionListener(new SaveSalesListener());
        plainRadioButton.addActionListener(new PlainListener());
        HTMLRadioButton.addActionListener(new HTMLListener());
        XMLRadioButton.addActionListener(new XMLListener());

        /**
         * populate the product catalog
         */
        catalog = initialCatalog;
        catalogList.setListData(catalog.getCodes());

        currentOrder = new Order();
        sales = new Sales();
        salesFormatter = PlainTextSalesFormatter.getSingletonInstance();
        fileChooser = new JFileChooser();
        dollarFormatter = NumberFormat.getCurrencyInstance();
    }
}