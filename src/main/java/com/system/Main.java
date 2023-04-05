package com.system;

import com.system.data.PowerData;
import com.system.mysql.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static JDBC jdbc;

    static {
        try {
            jdbc = JDBC.getDefault();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        ResultSet rs;
        // rs = jdbc.querySql("select * from j00252_power");
        // 方法已弃用
        // rs = jdbc.querySql("C_TIME", "j00252_power", "C_TIME >= '2021-10-06 21:30:00.000' && C_TIME <= '2021-10-06 23:30:00.000'", "C_TIME", true, null);
//
//        while (rs.next()) {
//            String c_time = rs.getString(1);
//            System.out.println(c_time);
//        }
        String sql = "select C_TIME cTime, C_EF_CODE cEfCode, C_VALUE cValue from j00252_power";
        List<PowerData> powerData = jdbc.executeQuery(sql, PowerData.class);
        for (PowerData p : powerData) {
            System.out.println(p.getcValue());
            System.out.println(p.getcTime());
        }
        jdbc.close();
    }

//    public static void login() {
//    }
//
//    public static void register() {
//    }
//
//    public static void init() {
//    }
//
//    public static void queryTurbine() {
//    }
//
//    public static void queryTable() {
//    }
//
//    public static void getDownload() {
//    }
}