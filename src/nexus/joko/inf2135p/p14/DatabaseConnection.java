/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nexus.joko.inf2135p.p14;

import java.sql.*;

/**
 *
 * @author jokosupriyanto
 */
public class DatabaseConnection {

    private static Connection connection = null;

    private final static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/mahasiswa";
    private final static String user = "root";
    private final static String password = "password";

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName(jdbcDriver);
                System.out.println("Trying conect to database...");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            System.out.println("Connection created successfully!");
        }

        return connection;
    }

    public static void CloseConnection() {
        try {
            System.out.println("Closing connection...");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
