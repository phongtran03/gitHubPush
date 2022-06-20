package jdbcDemo;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STUDENT {
    static Scanner input = new Scanner(System.in);
    static List<Students> studentlist = new ArrayList<Students>();

    Students students = new Students();

    public static Connection getConnection() throws SQLException{
        String dbURL = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "";
        Connection connect = DriverManager.getConnection(dbURL, username, password);
        return connect;
    }

    public static void createStudent() throws SQLException{

        Connection connect = getConnection();

        String query = "insert into student values(?,?,?,?)";

        PreparedStatement Statement = connect.prepareStatement(query);

        System.out.println("Nhap ID Sinh vien moi: ");
        int id = input.nextInt();
        Statement.setInt(1, id);

        System.out.println("Nhap ten sinh vien moi: ");
        String name = input.next();
        Statement.setString(2, name);

        System.out.println("Nhap sinh nhat sinh vien moi: ");
        int Dob = input.nextInt();
        Statement.setInt(3, Dob);

        System.out.println("Nhap diem sinh vien moi: ");
        Double mark = input.nextDouble();
        Statement.setDouble(4, mark);

        Statement.executeUpdate();
        System.out.println("Them Sinh Vien Thanh Cong\n");


        studentlist.add(new Students(id, name, Dob, mark));

    }

    public static void updateStudentById() throws SQLException{

        Connection connect = getConnection();
        String query = "update student set Name = ?, Dob = ?, Mark = ? order by ID = ?";

        PreparedStatement Statement = connect.prepareStatement(query);

        System.out.println("Nhap ID sinh vien muon thay doi: ");
        int id = input.nextInt();
        Statement.setInt(4, id);

        System.out.println("Nhap ten sinh vien muon thay doi");
        String name = input.next();
        Statement.setString(1, name);

        System.out.println("Nhap ngay sinh cua sinh vien muon thay doi");
        int dob = input.nextInt();
        Statement.setInt(2, dob);

        System.out.println("Nhap diem cua sinh vien muon thay doi");
        double mark = input.nextDouble();
        Statement.setDouble(3, mark);

        Statement.executeUpdate();
        System.out.println("Sua thong tin sinh vien thanh cong\n");
    }

    public static void removeStudentById() throws SQLException{

        Connection connect = getConnection();
        String query = "DELETE FROM Student WHERE ID = ?";

        PreparedStatement Statement = connect.prepareStatement(query);

        System.out.println("Nhap ID sinh vien muon xoa");
        int id = input.nextInt();
        Statement.setInt(1, id);
        Statement.executeUpdate();
        System.out.println("Xoa Sinh Vien Thanh Cong\n");
    }

   public static void viewAllStudent() throws SQLException{

        Connection connect = getConnection();
        String query = "Select * From student";

        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int dob = resultSet.getInt(3);
            double price = resultSet.getDouble(4);
            System.out.println(id + " | " + name + " | " + dob + " | " + price);
        }
   }

   public static void searchStudentById() throws SQLException{

        Connection connect = getConnection();
        String query = "SELECT * FROM student WHERE ID = ?";
        PreparedStatement Statment = connect.prepareStatement(query);
        System.out.println("Nhap ID sinh vien muon tim kiem: ");
        int id = input.nextInt();
        Statment.setInt(1, id);
        ResultSet resultSet = Statment.executeQuery();
        while (resultSet.next()){
            int cot1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int nam = resultSet.getInt(3);
            double mark = resultSet.getDouble(4);
            System.out.println(cot1 + " | " + name + " | " + nam + " | " + mark);
        }

   }

   public static void searchStudentByName() throws SQLException{

        Connection connect = getConnection();
        String query = "Select * from student where name = ?";
        PreparedStatement Statment = connect.prepareStatement(query);
        System.out.println("Nhap ten sinh vien muon tim kiem: ");
        String name = input.next();
        Statment.setString(1, name);
        ResultSet resultSet = Statment.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name1 = resultSet.getString(2);
            int dob = resultSet.getInt(3);
            double mark = resultSet.getDouble(4);
            System.out.println(id + " | " + name + " | " + dob + " | " + mark);
        }
   }

   public static void saveToFile() throws IOException{
       Writer writer = new FileWriter("studentlist.json");
       Gson gson = new Gson();
       gson.toJson(studentlist, writer);
       writer.close();
       System.out.println("Save To File thanh cong");
   }
}
