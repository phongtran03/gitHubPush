package jdbcDemo;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    static PRODUCT product = new PRODUCT();

    public static void menu(){
        System.out.println("Create Product: ");
        System.out.println("Update Product: ");
        System.out.println("Delete Product: ");
        System.out.println("Read Product Data: ");
        System.out.println("View All Product Sort BY Name: ");
        System.out.println("Search Product by ID: ");
        System.out.println("Search Product by name: ");
        System.out.println("Exit");
    }

    public static void main(String[] args) throws SQLException {

        while (true){
            menu();
            System.out.println("Enter your Choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    product.createProduct();
                    break;
                case 2:
                    product.updateProduct();
                    break;
                case 3:
                    product.deleteProduct();
                    break;
                case 4:
                    product.readProductData();
                    break;
                case 5:
                    product.ViewAllProductSort();
                    break;
                case 6:
                    product.searchById();
                    break;
                case 7:
                    product.searchByName();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("None");
            }

        }
    }
}
