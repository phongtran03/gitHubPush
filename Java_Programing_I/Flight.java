package Java_Programing_I;

import java.util.Scanner;

public class Flight {
   static Scanner input = new Scanner(System.in);
    private int number;
    private String destination;

    public Flight(int number, String destination) {
        this.number = number;
        this.destination = destination;
    }

    public Flight() {
    }

    public void display(){

        try{
            Integer Interger = getNumber();
            String text = null;
            Interger.parseInt(text);
            System.out.println(0);

        }catch (NumberFormatException e){
            System.out.println(getNumber() + ", " + getDestination());
        }
      //  System.out.println(getNumber() + ", " + getDestination());
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public static void main(String[] args) {
        Flight s1 = new Flight();
        s1.setNumber(input.nextInt());
        s1.setDestination(input.next());
        s1.display();
    }
}
