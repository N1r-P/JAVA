import java.sql.*;

public class test_test {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();

            // 建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_sql",
                    "root", "root");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            // 创建Statement对象
            stmt = conn.createStatement();

            // 执行SQL语句
            rs = stmt.executeQuery("select * from user_information");
            System.out.println("id\tname\tage\taddress\tphone_number\tpassword");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t" + rs.getInt(3)+
                        "\t" + rs.getString(4)+"\t" + rs.getString(5)+"\t" + rs.getString(6));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}