package Generics_and_java.util;

public class Pair <T>{
    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T newValue){
        first = newValue;
    }

    public void setSecond(T newValue){
        second = newValue;
    }

    static class ArrayAlg{
        /* Gets the mininum and maximum of an array of strings.
         @param a an array of strings
         @return a pair with the min and max value, or null if a is
         null or empty
         * */

        public static Pair<String> minmax(String[] a){
            if(a == null || a.length == 0)
                return null;
            String min = a[0];
            String max = a[0];

            for(int i=1; i<a.length; i++){
              if(min.compareTo(a[i]) > 0)
                  min = a[i];
              if(max.compareTo(a[i]) < 0)
                  max = a[i];
          }
            return new Pair<String>(min, max);
        }


    }
}

