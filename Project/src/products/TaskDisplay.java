package products;

import mainMenu.ProductDetail;
import sql.Sql;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaskDisplay extends JFrame{
    public TaskDisplay(String classification) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 10, 360, 640); //位置（100 ，100）宽：450，高300
        JPanel contentPane = new JPanel();
        //Border描述了面板四周的边界（属于面板内部），EmptyBorder为5的一个空白的边界；
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        //添加新的JPanel到JScrollPane下
        JPanel panel = new JPanel();

        int x = 20;
        int y = 1;
        panel.setLayout(new GridLayout(x, y));
        Sql sql = Sql.getInstance();
        for (int i = 0; i < x * y; i++) {
            String classification_ = classification;
            if(i==x-1){
                JButton button = new JButton("返回");
                button.setPreferredSize(new Dimension(40, 40));
                panel.add(button);
                //添加按钮动作监听
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        Classify c = new Classify();
                        c.setVisible(true);
                    }
                });
            }
           else if (sql.inquire_task_classification(i+1)!=null)
            {
                if(sql.inquire_task_classification(i+1).equals(classification_))
            {
                JButton button = new JButton(sql.inquire_task_name(i+1));
                button.setPreferredSize(new Dimension(300, 100));
                panel.add(button);
                //添加按钮动作监听
                int finalI = i+1;
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductDetail p1 = new ProductDetail(sql.inquire_task(finalI),sql.inquire_task_name(finalI));
                        p1.setVisible(true);
                    }
                });
            }
            }
        }

        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //先把panel添加到contentPane
        contentPane.add(panel);
        //添加Jscrollpane滚动,只能用
        JScrollPane scrollPane = new JScrollPane(contentPane);
        //最后添加上scrollPane
        setContentPane(scrollPane);
    }
}
