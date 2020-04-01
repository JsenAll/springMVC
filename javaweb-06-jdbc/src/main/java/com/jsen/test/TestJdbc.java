package com.jsen.test; /*
 *@author Jsen
 *@description
 */

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=true&useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String passWord = "jhs123";

        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2:连接数据库 connection 相当于数据库 ;
        Connection connection = DriverManager.getConnection(url, userName, passWord);

        //3:获取向数据库发送sql的对象 Statement 可以进行CRUD
        Statement statement = connection.createStatement();

        String sql = "select * from users";

        //执行sql语句
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("password"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
