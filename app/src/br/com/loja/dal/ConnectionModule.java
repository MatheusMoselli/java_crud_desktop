package br.com.loja.dal;

import java.sql.*;

public class ConnectionModule {
    public static Connection connector() {
        try {
            String driver = "com.mysql.jdbc.Driver";
        
            String url = "jdbc:mysql://localhost:3306/java";
            String user = "root";
            String password = "";
        
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
}
