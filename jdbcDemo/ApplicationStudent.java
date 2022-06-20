package jdbcDemo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationStudent {
    static STUDENT student = new STUDENT();
    static Scanner input = new Scanner(System.in);

    public static void menu(){
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Remove Student");
        System.out.println("4. View All Student");
        System.out.println("5. Search Student By ID");
        System.out.println("6. Search Student By Name");
        System.out.println("7. Save List To File");
        System.out.println("8. Exit");

    }

    public static void main(String[] args) throws SQLException, IOException {

        while(true){

            menu();
            int choice = input.nextInt();

            switch (choice){

                case 1 -> student.createStudent();
                case 2 -> student.updateStudentById();
                case 3 -> student.removeStudentById();
                case 4 -> student.viewAllStudent();
                case 5 -> student.searchStudentById();
                case 6 -> student.searchStudentByName();
                case 7 -> student.saveToFile();
                case 8 -> System.exit(0);
                default -> System.out.println("Khong co lua chon nay");
            }
        }
    }
}
