package Generics_and_java.util;
import java.util.*;

public class Word {
         private String value;
         private int position;

         public Word(String v, int p){
             value = v;
             position = p;
         }

         public String getValue(){
             return value;
         }

         public int getPosition(){
             return position;
         }

}
