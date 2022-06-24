package mainMenu;

import sql.Sql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static user.Log.IfLog;


public class ProductDetail extends JFrame {

    public ProductDetail(String information,String name){
        super("商品详情~");
        //三个组件
        JButton exitButton;
        JButton buyButton;
        TextArea textArea;

        //容器
        Container container;

        //设置流布局
        setLayout(new FlowLayout());

        //获取容器
        container = getContentPane();

        //三个组件
        textArea = new TextArea();
        textArea.setEditable(false);
        exitButton = new JButton("退出");
        buyButton = new JButton("购买");

        //更新文本显示区内容
        textArea.setText(information);

        exitButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        buyButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                Sql sql = Sql.getInstance();
                sql.update_user_information_bought(IfLog,name+"___"+sql.inquire_user_information_bought(IfLog));
                dispose();
                buy a=new buy();
                a.setVisible(true);
            }
        });

        //装填三个组件
        container.add(textArea);
        container.add(exitButton);
        container.add(buyButton);

        setSize(800, 400);
        setLocation(300, 300);
        setVisible(true);
        setResizable(false);
    }

}

 class buy extends JFrame{
    public buy(){
        JPanel p;
        JLabel buyJLabel;
        p = new JPanel(new BorderLayout());
        buyJLabel = new JLabel("Purchase succeeded.", JLabel.CENTER);
        Font fnt1 = new Font("Arial", Font.BOLD, 18);
        buyJLabel.setFont(fnt1);
        p.add(buyJLabel);
        this.add(p);
        this.setSize(300,180);
        this.setLocation(400, 350);
        this.setResizable(false);

    }


}

