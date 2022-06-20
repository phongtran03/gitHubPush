package jdbcDemo;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionPRODUCT {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/product";
        String username = "root";
        String password = "";
        try{
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            if(connection!=null){
                System.out.println("Ket Noi Thanh Cong");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
