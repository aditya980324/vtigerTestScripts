package org.example;

import com.mysql.jdbc.Driver;

import java.sql.*;


public class SampleSql {
    public static void main(String[] args) throws SQLException {
        Driver driverref = new Driver();
        DriverManager.registerDriver(driverref);
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys",
                "root","root");
        System.out.println("connected");
        Statement stat= conn.createStatement();
        ResultSet res= stat.executeQuery("select * from sys_config");
        res.next();
        System.out.println("execution started");
        while (res.next())
        System.out.println(res.getString(1));
        System.out.println("executed");
        conn.close();

    }
}
