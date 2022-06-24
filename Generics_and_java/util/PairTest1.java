package Generics_and_java.util;

public class PairTest1 {
    public static void main(String[] args) {

        String[] words = {"Marry", "had", "a", "little", "lamb"};
        Pair<String> mm = Pair.ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
