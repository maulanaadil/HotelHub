package database;

import java.sql.*;

public class Config {
    private static Connection MySQLConfig;
    
    public static Connection configDB() throws SQLException {
        try {
        String url = "jdbc:mysql://localhost:3306/db10119221Hotel";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Failed Connect to Database" + e.getMessage());
        }
        return MySQLConfig;
    }
}
        
