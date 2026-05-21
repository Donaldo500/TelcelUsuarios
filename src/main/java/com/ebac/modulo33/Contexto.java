package com.ebac.modulo33;   
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Contexto {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/modulo33";
        String user = "root";
        String password = "root";

        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection connection = mysqlConnection.getConnection(url, user, password);

        String sql = "SELECT * FROM usuarios";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("idUsuario"));
            System.out.println("Nome: " + resultSet.getString("nombre"));
            System.out.println("Email: " + resultSet.getInt("edad"));
            System.out.println("------------------------------");
        }

        connection.close();

    }
}
