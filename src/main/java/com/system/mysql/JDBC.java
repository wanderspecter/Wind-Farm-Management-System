package com.system.mysql;

import java.sql.*;

public class JDBC {
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public JDBC(String url, String user, String password) throws ClassNotFoundException, SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver"); // 加载连接数据库的类
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public ResultSet querySql(String sql) throws SQLException {
        // 4.将sql语句交给数据库
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5.执行sql语句
        ResultSet rs = statement.executeQuery(); // 查询结果在rs对象中
        return rs;
    }

    public ResultSet querySql(String label, String table, String where, String orderBy, Boolean ifDesc, String limit) throws SQLException {
        String tmp = "select " + label + " from " + table;
        if (where != null) tmp += " where " + where;
        if (orderBy != null) {
            tmp += " order by " + orderBy;
            if (ifDesc != null && ifDesc == true) {
                tmp += " desc ";
            }
        }
        if (limit != null) tmp += " limit " + limit;
        return querySql(tmp);
    }

    public void close() throws SQLException {
        connection.close();
    }
}