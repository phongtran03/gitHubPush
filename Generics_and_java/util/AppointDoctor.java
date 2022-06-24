package Generics_and_java.util;

import java.util.PriorityQueue;

public class AppointDoctor {
    /*Creates a new instance of AppointDoctor*/
    public AppointDoctor(){
    }
    public static void main(String[] args){
        //Todo code application logic here

        //Creating a PriorityQueue
        PriorityQueue pq = new PriorityQueue();

        //Creating Doctor objects
        Doctor Cardiologist = new Doctor("Casuality", 1);
        Doctor Gynescologist = new Doctor("Surgery", 2);
        Doctor Paediatric = new Doctor("Routine Check-up", 3);

        pq.offer(Cardiologist);
        pq.offer(Gynescologist);
        pq.offer(Paediatric);

        //remove the emplements from the queue as per their priorites
        while (!pq.isEmpty()){
            //displaying the header infomation
            System.out.println("\nAppointing doctors based on their priorities: ");
            System.out.println("*************************************");
            //removing the Doctors as per their priorites
            Doctor doctor = ((Doctor) pq.remove());

            //Invoking the toString() method
            System.out.println(doctor.toString());
        }


    }
}
