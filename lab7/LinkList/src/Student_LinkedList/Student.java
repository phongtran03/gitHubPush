package Student_LinkedList;

import java.util.Scanner;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double Mark;

    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Mark = mark;
    }


    public void scanInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id: ");
        id = input.nextInt();
        System.out.println("Enter First Name: ");
        firstName = input.next();
        System.out.println("Enter Last Name: ");
        lastName = input.next();
        System.out.println("Enter Mark: ");
        Mark = input.nextDouble();
    }

    public void printInfo(){
        System.out.printf("%d | %s20%s | %5f\n", getId(), getFirstName(), getLastName(), getMark());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMark() {
        return Mark;
    }
}
