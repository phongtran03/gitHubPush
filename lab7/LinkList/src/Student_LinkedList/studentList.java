package Student_LinkedList;
import Student_LinkedList.Student;

import java.util.*;

public class studentList {

    private LinkedList<Student> list;
    private int length;

    public LinkedList<Student> findByName(String name){
        boolean found = false;
        LinkedList<Student> matches = new LinkedList<>();
        for(Student s: list){
            String fullName = new String(s.getFirstName() +" " + s.getLastName()).toLowerCase();
                  if(fullName.matches(".*" + name.toLowerCase() + ".*"));
                  matches.add(s);
                  found = true;
        }
        if(found == false){
            System.out.println("Not found");
        }
        return matches;
    }

    public Student findById(int id){
        for ( Student s: list) {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public void add(Student s){
        list.add(s);
    }

    public void remove(int id){
        boolean found = false;
        for(Student s: list){
            if(s.getId() == id){
                int choice;
                System.out.println("Are you sure deleting this student? (1. YES  2. NO)");
                choice = new Scanner(System.in).nextInt();
                if(choice == 1)
                    list.remove();
                found = true;
                System.out.println("Remove Student Succesfully");
            }
        }
        if(found == false){
            System.out.println("Can not find student with id " + id);
        }
    }

    public void sortByMarks(){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return new Double(o2.getMark()).compareTo(o1.getMark());
            }
        });
    }

    public void showList(LinkedList<Student> slist){
        for(Student s : slist){
            s.printInfo();
        }
    }

    public void showList(){
        for(Student s: list){
            s.printInfo();
        }
    }
}
