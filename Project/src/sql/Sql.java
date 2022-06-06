package sql;/*
    @author nir_p
    @blog https://www.nirpblog.com/
    @file run.java
    @time 2022/6/6 16:40
*/

import java.sql.*;

public class Sql {
    //单例模式
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String command = null;
    /**
     * 创建一个Sql的对象
     */
    private static Sql sql = new Sql();

    /**
     * 让构造函数为 private，这样该类就不会被实例化
     */
    private Sql(){}

    /**
     * 获取唯一可用的对象
     * @return sql
     */
    public static Sql getInstance()
    {
        return sql;
    }

    public void getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_sql",
                    "root", "root");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add_goods(String name,double price,String description,String classification)
    {
        this.getConnection();
        command = String.format("INSERT INTO goods VALUES(NULL,'%s','%s','%f','%s')",name,description,price,classification);
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }

    public void add_task(String name,String description,double price,String time,String classification)
    {
        this.getConnection();
        command = String.format("INSERT INTO task VALUES(NULL,'%s','%s','%f','%s','%s')",name,description,price,time,classification);
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }


}
