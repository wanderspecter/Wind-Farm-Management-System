package com.system.mysql;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class JDBC {
    private String url;
    private String user;
    private String password;
    private PreparedStatement statement;
    private Connection connection;

    private static String defaultUrl = "jdbc:mysql://45.77.206.231:3306/javawork"; // 指定数据库的位置
    private static String defaultUser = "root"; // 数据库的用户名
    private static String defaultPassword = "123"; //数据库密码

    public static JDBC getDefault() throws SQLException, ClassNotFoundException {
        return new JDBC(defaultUrl, defaultUser, defaultPassword);
    }

    public JDBC(String url, String user, String password) throws ClassNotFoundException, SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver"); // 加载连接数据库的类
        this.connection = getConnection(url, user, password);
    }

    public ResultSet querySql(String sql) throws SQLException {
        // 4.将sql语句交给数据库
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5.执行sql语句
        ResultSet rs = statement.executeQuery(); // 查询结果在rs对象中
        return rs;
    }

    @Deprecated
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

    public <T> List<T> executeQuery(String sql, Class<T> clazz, Object... params) throws SQLException {
        try {
            //创建PreparedStatement
            statement = connection.prepareStatement(sql);
            //执行
            ResultSet rs = statement.executeQuery();
            //解决ResultSet  反射
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                //rs.getXxx()
                //newInstance() 调用无参构造方法
                T t = clazz.newInstance();
                //给t的属性赋值
                //获取T的属性
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //设置允许访问
                    field.setAccessible(true);
                    //给属性赋值 底层调用 对象.属性 = 值
                    //getObject(列索引)
                    //getObject(列名)  约定: 属性名与列名一样,赋值
                    // 如果属性名与列名不一样: 列名:user_name username  属性名:username
                    // 给列名取一个属性名的别名
                    field.set(t, rs.getObject(field.getName()));
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void CUDSql(String sql, Object... obj) throws Exception {
        try {
            //预编译sql语句
            statement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 1; i <= obj.length; i++) {
                statement.setObject(i, obj[i - 1]);
            }
            //执行sql语句
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        connection.close();
        statement.close();
    }
}