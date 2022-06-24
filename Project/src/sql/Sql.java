package sql;

import java.sql.*;
import java.util.ArrayDeque;

public class Sql {
    /**
     * 单例模式
     */
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
     * 加载基础的数据
     */
    private Sql()
    {
        add_goods("AD钙奶",10,"五瓶，江安自提","食品");
        add_goods("香肠",5,"土家香肠，家长带来的，吃不完了","食品");
        add_goods("NIKE空军一号",999,"马卡龙拼色款","服饰");
        add_goods("UR吊带裙",199,"黑色，全新未拆标签","服饰");
        add_goods("MUF散粉",200,"余量三分之二，正装非小样","美妆");
        add_goods("美瞳",99,"小鹿棕，左0右0","美妆");
        add_goods("卡诗洗发水",399,"黑金款，未开封","洗护用品");
        add_goods("黑人牙膏",10,"1管","洗护用品");
        add_goods("飞利浦吹风机",168,"1000W，大寝不可用","电器");
        add_goods("松下台灯",49,"充电款","电器");
        add_goods("佳能单反相机",4999,"配镜头","数码产品");
        add_goods("卡西欧手表",688,"透明表带情侣款黑色","数码产品");
        add_goods("维达卷纸",30,"一提10卷，江安自提","日用品");
        add_goods("玻璃碗",10,"凹凸花纹，微波炉不可用","日用品");
        add_task("帮寄快递","在西园三舍取东西，寄顺丰，具体信息面谈",10,"21-06-05，下午两点","其他");
        add_task("买水果","买一份西瓜和哈密瓜的拼盘，送到西园八舍楼下",3,"21-06-05，中午午饭时间","其他");
        add_task("借鼠标","鼠标坏了，快递还没到，想借一个鼠标用用，三天左右",10,"21-06-09，下午两点","借东西");
        add_task("借pencil二代","pencil坏了，快递还没到，想借一支pencil用用，五天左右",20,"21-06-010，上午九点","借东西");
        add_task("江安网球场核酸排队","时间约早了，不想太早去，也不想排队，想找个人代排队",5,"21-06-09，上午十点","代排队");
        add_task("校外花雕醉鸡排队","人太多，想找个人代排队",10,"21-06-09，下午五点","代排队");
        add_task("代买山姆瑞士卷","突然很想吃山姆的瑞士卷，可是太远了，有没有UU去的可以帮忙捎回来",40,"22-05-29，下午三点","跑腿");
        add_task("江安-望江送材料","有一个申请材料要交到望江行政楼204，有没有去望江的同学可以帮忙带过去",5,"22-05-14，上午十点","跑腿");

    }

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

    public void add_user_information(String name,String grade,String address,String phone_number,String password)
    {
        this.getConnection();
        command = String.format("INSERT INTO user_information VALUES(NULL,'%s','%s','%s','%s','%s',NULL,NULL)",name,grade,address,phone_number,password);
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }

    public String inquire_goods(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM goods");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                   result = "名称 : "+resultSet.getString("name")+"\n"+
                            "描述 : "+resultSet.getString("description")+"\n"+
                            "价格 : "+resultSet.getString("price")+"\n"+
                            "分类 : "+resultSet.getString("classification");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_task(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM task");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = "名称 : "+resultSet.getString("name")+"\n"+
                            "描述 : "+resultSet.getString("description")+"\n"+
                            "价格 : "+resultSet.getString("price")+"\n"+
                            "时间 : "+resultSet.getString("time")+"\n"+
                            "分类 : "+resultSet.getString("classification");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_goods_name(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM goods");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_task_name(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM task");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_goods_classification(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM goods");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("classification");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_task_classification(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM task");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("classification");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_name(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_grade(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("grade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_address(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("address");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_password(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_phone(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("phone_number");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_sold(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("sold");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public String inquire_user_information_bought(int i)
    {
        String result = null;
        this.getConnection();
        command = String.format("SELECT * FROM user_information");
        try {
            resultSet = statement.executeQuery(command);
            while(resultSet.next())
            {
                if (resultSet.getInt("id")==i)
                {
                    result = resultSet.getString("bought");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return result;
    }

    public void update_user_information_sold(int id,String sold)
    {
        this.getConnection();
        command = String.format("UPDATE user_information SET sold = '%s' WHERE id = %x",sold,id);
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }

    public void update_user_information_bought(int id,String bought)
    {
        this.getConnection();
        command = String.format("UPDATE user_information SET bought = '%s' WHERE id = %x",bought,id);
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
    }
}
