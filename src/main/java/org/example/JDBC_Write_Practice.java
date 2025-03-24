package org.example;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Write_Practice {
    public static void main(String[] args) throws SQLException {
        Driver database =null;
        Connection conn=null;
        try {
            database=new Driver();
            DriverManager.registerDriver(database);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys"
            ,"root","root");
            Statement stat = conn.createStatement();
            int resultset=stat.executeUpdate("CREATE TABLE train (\n" +
                    "    tid TINYINT PRIMARY KEY,       \n" +
                    "    tnumber INT UNIQUE NOT NULL,    \n" +
                    "    tname VARCHAR(20) NOT NULL, \n" +
                    "    from_station VARCHAR(20) NOT NULL, \n" +
                    "    to_station VARCHAR(20) NOT NULL\n" +
                    ")\n");
            System.out.println(resultset);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            conn.close();
        }

    }
}
