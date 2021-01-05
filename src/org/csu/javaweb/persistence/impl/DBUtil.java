package org.csu.javaweb.persistence.impl;

import org.csu.javaweb.domain.Category;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBUtil {
    private static String driverString="com.mysql.jdbc.Driver";
    private static String ConnectionString = "jdbc:mysql://localhost:3306/jpetstore";
    private static String username = "root";
    private static String password = "root";
    public static Connection getConnection() throws Exception{
        Connection connection=null;
        try{
            Class.forName(driverString);
            connection= DriverManager.getConnection(ConnectionString,username,password);
        }
        catch (Exception e){
            throw e;
        }
        return  connection;
    }
    public  static void CloseStatement(Statement statement)throws Exception{
        statement.close();
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement)
    throws Exception{
        preparedStatement.close();
    }
    public static void closeResultSet(ResultSet resultSet)throws Exception{
        resultSet.close();
    }
    public static void closeConnection(Connection connection)throws Exception{
        connection.close();
    }
    //数据库连接测试
//    public  static void main(String[]args) throws Exception {
//
//        String Get_Category="SELECT CATID ,NAME,DESCN  FROM CATEGORY WHERE CATID =?";
//        Connection connection=DBUtil.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(Get_Category);
//        //在这里的话,sql语句需要给字符串加上引号
//        String a="BIRDS";
//        preparedStatement.setString(1, a);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        Category category=new Category();
//        if (resultSet.next()){
//        category.setCategoryId(resultSet.getString("CATID"));
//        category.setName(resultSet.getString("NAME"));
//        category.setDescription(resultSet.getString("DESCN"));
//        System.out.println(category.getDescription());
//        }
//        else
//            System.out.println(22);
//    }
}
