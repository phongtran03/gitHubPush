package jdbcDemo;
import com.mysql.cj.protocol.x.XProtocolError;
import com.sun.jdi.NativeMethodException;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;
import java.util.Scanner;

public class PRODUCT {
    static Scanner input = new Scanner(System.in);

        public static Connection getConnection() throws SQLException{
            String dbURL = "jdbc:mysql://localhost:3306/product";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            return connection;
    };

        public static void createProduct() throws SQLException{
            Connection conn = getConnection();
            String query = "insert into product values(?,?,?,?)";
            int id = input.nextInt();
            String name = input.next();
            String desc = input.next();
            Double price = input.nextDouble();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id );
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, desc);
            preparedStatement.setDouble(4, price);

            int rowInserted = preparedStatement.executeUpdate();
            if(rowInserted > 0){
                System.out.println("Them Product Thanh Cong");
            }
        }

       public static void readProductData() throws SQLException{
           Connection conn = getConnection();
            String query = "Select * From product";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Name");
                String desc = resultSet.getString("Product_desc");
                double price = resultSet.getDouble(4);
                System.out.println(id + " | " + name + " | " + desc + " | " +price);
            }
        }

      public static void updateProduct() throws SQLException{
            Connection conn = getConnection();
            String query = "update product set NAME = ?, PRODUCT_DESC = ?, PRICE = ? WHERE ID = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
              String name = input.next();
              String desc = input.next();
              Double price = input.nextDouble();
              int id = input.nextInt();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, desc);
            preparedStatement.setDouble(3,  price);
            preparedStatement.setInt(4, id);

            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Update Product Thanh Cong");
            }
      }

      public static void deleteProduct() throws SQLException{
            Connection conn = getConnection();
            String query = "delete from product where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            int id = input.nextInt();
            preparedStatement.setInt(1,1);
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated >= 0){
              System.out.println("Update Product Thanh Cong");
          }
      }

     public static void ViewAllProductSort() throws SQLException{
            Connection conn = getConnection();
            String query = "SELECT * FROM `product` ORDER BY NAME";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ // đọc data đến hết
             int id = resultSet.getInt(1);
             String name = resultSet.getString(2);
             String desc = resultSet.getString(3);
             double price = resultSet.getDouble(4);
             System.out.println(id + " | " + name + " | " + desc + " | " + price);
         }
      }

    public static void searchById()throws SQLException {
        int id;
        Connection connection = getConnection();
        String query = "SELECT * from product where id = ?";

        PreparedStatement statement = connection.prepareStatement(query);

        System.out.println("Enter student id: ");
        id = input.nextInt();
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int idp = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String desc = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            System.out.println(idp + " " + name + " " + desc + " " + price);
        }
    }

    public static void searchByName() throws SQLException{
            String name1;
            Connection connection = getConnection();
            String query = "Select * from product where name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println("Enter name: ");
            name1 = input.next();
            statement.setString(1, name1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int idp = resultSet.getInt(1);
            String namez = resultSet.getString(2);
            String desc = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            System.out.println(idp + " " + namez + " " + desc + " " + price);
        }
    }
    }

