package Student_LinkedList;

import Student_LinkedList.Student;
import Student_LinkedList.studentList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.print.attribute.standard.PrinterInfo;

public class Application {

    private static Scanner input = new Scanner(System.in);
    private static studentList list;

    public static void menu(){
        System.out.println("1. Add a new Student to the list");
        System.out.println("2. Delete a student from the list");
        System.out.println("3. Search by name");
        System.out.println("4. Search by id");
        System.out.println("5. Print student info in descending order of mark");
        System.out.println("6. PrintInfo");
        System.out.println("7. Exit");
    }
    public static void main(String[] args){
        list = new studentList();
        menu();

        int choice = input.nextInt();

        do {
            switch (choice){
                case 1:
                    addStudent();
                    menu();
                    break;
                case 2:
                    deleteStudent();
                    menu();
                    break;
                case 3:
                    searchByName();
                    menu();
                    break;
                case 4:
                    searchById();
                    menu();
                    break;
                case 5:
                    printSorted();
                    menu();
                    break;
                case 6:
                    showList();
                    menu();
                    break;
                case 7:
                    System.exit(0);
            }

        } while(choice != 7);
        
    }

    public static void showList(){
        list.showList();
    }

    public static void addStudent(){
         int id = 0;
         String fn;
         String ln;
         double mark;
         String fullName;
        System.out.println("Enter student ID: ");
        id = input.nextInt();
        System.out.println("Enter first name: ");
        fn = input.next();
        System.out.println("Enter last name: ");
        ln = input.next();
        System.out.println("Enter mark: ");
        mark = input.nextDouble();
        Student s = new Student(id, fn, ln, mark);
        list.add(s);
    }

    public static void deleteStudent(){
        int id;
        System.out.println("Enter student id: ");
        id = input.nextInt();
        list.remove(id);
    }

    public static void searchByName(){
        String name;
        System.out.println("Enter a name: ");
        name = input.next();
        LinkedList<Student> found = list.findByName(name);
        list.showList(found);
    }

    public static void searchById(){
        int id;
        System.out.println("Enter an ID: ");
        id = input.nextInt();
        Student s = list.findById(id);
        if(s == null){
            System.out.println("Not found");
        } else{
            s.printInfo();
        }
    }
    public static void printSorted(){
        list.sortByMarks();
        list.showList();
    }
}
