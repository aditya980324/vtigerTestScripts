package org.example;

import com.mysql.jdbc.Driver;
import java.sql.*;

public class JDBC_Read_Practice {
    public static void main(String[] args) throws SQLException{
        Connection conn=null;
        try {
            Driver d1=new Driver();
            DriverManager.registerDriver(d1);
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","root");
            System.out.println("connected");
            Statement stat= conn.createStatement();
            ResultSet res=stat.executeQuery("select * from sys_config");
            res.next();
            System.out.println("execution started");
            while (res.next())
                System.out.println(res.getString(1)+"   "+res.getString(2)
                +"   "+res.getString(3));
            System.out.println("executed");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        finally {
            conn.close();
        }

    }
}
