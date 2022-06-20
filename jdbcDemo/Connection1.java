package jdbcDemo;

import javax.swing.*;
import java.sql.*;

public class Connection1 {
    public static void main(String[] args) throws SQLException {
         Connection connection = getConnection();
         if(connection!=null){
             System.out.println("Ket noi thanh cong");
         }
     //    createProduct();
         upDateProduct();
         deleteProduct();
         readProductData();
    }

    public static Connection getConnection() throws SQLException{
         String dbURL = "jdbc:mysql://localhost:3306/dbtest";
         String username = "root";
         String password = "";
         Connection connection = DriverManager.getConnection(dbURL, username, password);
         return connection;
    }

    public static void createProduct() throws SQLException{
        Connection conn = getConnection();
        String query = "insert into product values(?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "SamSung");
        preparedStatement.setString(3, "The new product of SamSung");
        preparedStatement.setDouble(4, 1000);

        int rowInserted =  preparedStatement.executeUpdate();
        if(rowInserted > 0){
            System.out.println("Create Thanh Cong");
        }
    }

    public static void readProductData() throws SQLException{
        Connection conn = getConnection();
        String query = "Select * From product";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){ // đọc data đến hết
            int id = resultSet.getInt("id");
            String name = resultSet.getString("proName");
            String desc = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            System.out.println(id + " | " + name + " | " + desc + " | " + price);
        }
    }

    public static void upDateProduct() throws SQLException{
        Connection conn = getConnection();
        String query = "update product set proName = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, "Bphone");
        preparedStatement.setInt(2, 1);
        int rowUpdated = preparedStatement.executeUpdate();
        if (rowUpdated > 0) {
            System.out.println("Update thanh cong");
        }
    }

    public static void deleteProduct() throws SQLException{
        Connection conn = getConnection();
        String query = "DELETE FROM product WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, 4);
        int rowDeleted = preparedStatement.executeUpdate();// chi thi thuc thi cau lenh
        if(rowDeleted > 0){
            System.out.println("Delete Thanh Cong");
        }
    }

}
