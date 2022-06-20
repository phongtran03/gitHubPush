package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "";

        try {
            Connection connect = DriverManager.getConnection(dbURL, username, password);
            if (connect != null) {
                System.out.println("Ket noi thanh cong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
