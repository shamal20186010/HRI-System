package Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class db_connection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hris_system?useSSL=false", "root", "root");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;

    }

    public static void main(String[] args) {
        try {
            System.out.println(getConnection().getCatalog());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
