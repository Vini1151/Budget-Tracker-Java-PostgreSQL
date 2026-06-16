/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author vini pandhare
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/expense tracker";

    private static final String USER = "postgres";
    private static final String PASSWORD = "pgadmin";
    public static Connection getConnection() {
        try {
            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);
            System.out.println("Connected Successfully");
            return con;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}