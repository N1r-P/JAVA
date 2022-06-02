package products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Post extends JFrame {
    private JPanel p,p1,p2;
    private JButton buttonProduct, buttonTask;

    public Post(){
        super("发布");
        p = new JPanel();
        p.setLayout(new GridLayout(1, 2));

        p1 = new JPanel();
        p1.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonProduct = new JButton("发布商品");
        p1.setLayout(null);
        buttonProduct.setBounds(35, 45, 100, 40);
        p1.add(buttonProduct);

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createLoweredBevelBorder());
        buttonTask = new JButton("发布任务");
        p2.setLayout(null);
        buttonTask.setBounds(35, 45, 100, 40);
        p2.add(buttonTask);

        p.add(p1);
        p.add(p2);
        this.add(p);
        this.setSize(360, 180);// Set the window's size.
        this.setLocation(450, 300);
        this.setResizable(false);// Set the form of the window not to change size.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ProductPost post = new ProductPost();
                post.setVisible(true);
            }
        });

        buttonTask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TaskPost post = new TaskPost();
                post.setVisible(true);
            }
        });


    }

}
