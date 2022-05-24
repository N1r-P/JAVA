package gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;
import loader.*;
import products.*;


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

    private  Product product;
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
     * Loads a product catalog and starts the application.
     *
     * @param args String arguments. Not used.
     * @throws IOException if there are errors in the loading the catalog.
     */
    public static void main(String[] args) throws IOException {

        String filename = "";

        if (args.length != 1) {
            filename = "product.dat";//建立文件“product.dat"储存商品数据
        } else {
            filename = args[0];
        }
        try {
            Product product = (new FileProductLoader()).loadProduct(filename);//创造FileProductLoader()类

            JFrame frame = new JFrame("易~~~~~~~~圈");

            frame.setContentPane(new MainMenuGUI(product));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.setResizable(true);
            frame.setVisible(true);

        } catch (FileNotFoundException fnfe) {
            stdErr.println("The file does not exist");

            System.exit(1);

        } catch (DataFormatException dfe) {
            stdErr.println("The file contains malformed data: " + dfe.getMessage());

            System.exit(1);
        }
    }


    /**
     * Instantiates the components and arranges them in a window.
     *
     * @param initialProduct a product Product.
     */
    public MainMenuGUI(Product initialProduct) {

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
       /* productAdvice.addListSelectionListener(new DisplayProductListener());//要建立函数DisplayProductListener()
        mainMenuButton.addActionListener(new mainMenuListener());//要建立函数mainMenuListener()
        releaseButton.addActionListener(new releaseListener());//releaseListener()
        sortButton.addActionListener(new sortListener());//要建立函数sortListener()
        UserInformationButton.addActionListener(new UserInformationListener());//要建立函数UserInformationListener()
        searchButton.addActionListener(new searchListener());//要建立函数searchListener()*/


        /**
         * populate the product advice 填充商品、任务推荐
         */
        product = initialProduct;
        //productAdvice.setListData(Product.);//在Product中创建方法getInformation()展示商品的全部信息

        
    }



    /**
     * This inner class handles list-selection events.
     */
    class DisplayProductListener implements ListSelectionListener {

        /**
         * Displays the information of the selected product.
         *
         * @param event the event object.
         */
        public void valueChanged(ListSelectionEvent event) {

            if (!productList.getValueIsAdjusting()) {

                String code = (String) catalogList.getSelectedValue();
                Product product = catalog.getProduct(code);

                productPanel.removeAll();
                productPanel.setVisible(false); // Use this
                productPanel.add( // to update
                        getDataFieldsPanel(product.getDataFields())); // the panel
                productPanel.setVisible(true); // correctly

                statusTextArea.setText("Product " + code + " has been displayed");
            }
        }

    }

    /**
     * This inner class processes <code>addModifyButton</code> events.
     */
    class AddModifyListener implements ActionListener {

        /**
         * Adds an order item to the current order.
         *
         * @param event the event object.
         */
        public void actionPerformed(ActionEvent event) {

            int quantity = 0;
            String code = (String) catalogList.getSelectedValue();
            Product product = catalog.getProduct(code);
            OrderItem item = currentOrder.getItem(product);

            if (quantityTextField.getText().equals("") || product == null) {
                statusTextArea.setText("Please select a product code from the catalog list.");
            } else {
                try {
                    quantity = Integer.parseInt(quantityTextField.getText());
                    if (quantity < 1) {
                        statusTextArea.setText("Please enter a positive integer.");
                    } else {
                        if (item != null) {
                            item.setQuantity(quantity + item.getQuantity());
                            orderList.setListData(currentOrder.getItems());
                            statusTextArea.setText("The Product has been modified.");
                        } else {
                            currentOrder.addItem(new OrderItem(product, quantity));
                            orderList.setListData(currentOrder.getItems());
                            statusTextArea.setText("The Product has been added.");
                        }
                    }
                } catch (NumberFormatException nfe) {
                    statusTextArea.setText("Please enter an integer.");
                }
            }

            totalTextField.setText(dollarFormatter.format(currentOrder.getTotalCost()));
        }
    }

}