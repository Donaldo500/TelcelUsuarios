package com.ebac.modulo33;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    public MysqlConnection(){
        //Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}