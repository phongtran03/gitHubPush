package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/dbtest";
        String username = "root";
        String password="";
        try{
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            if(connection!=null){
                System.out.println("Ket noi thanh cong");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
