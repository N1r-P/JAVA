package user;


import javax.swing.*;
import java.awt.*;

public class Mygui extends JFrame{
    public Mygui(){
        setSize(360,640);
        setLayout(new GridLayout(5,1));
        add(new JLabel("        NAME"));
        add(new JButton("register"));
        add(new JButton("personal information"));
        add(new JButton("I sold"));
        add(new JButton("I bought"));

    }
    public static void main(String args[]){
        Mygui mygui = new Mygui();
        mygui.setTitle("mine");
        mygui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mygui.setVisible(true);
    }
}

