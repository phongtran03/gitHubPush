package Generics_and_java.util;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class LyricWordWithoutGeneric {
    private static final Word[] addlyric = {
      new Word("you", 1), new Word("say", 2), new Word("it", 3),
      new Word("best", 4), new Word("when", 5), new Word("you", 6),
      new Word("say", 7), new Word("nothing", 8), new Word("at", 9),
      new Word("all", 10)};

    public static void main(String[] args){
        //Create a list that's implemented by Arraylist

        List lyric = new ArrayList<>();
     //List lyric = new ArrayList<>();
        for (Word w: addlyric){
            lyric.add(w);
        }

        for (Object o : lyric){
            Word w = (Word) o;
            System.out.println(w.getValue() + ", " + w.getPosition());
        }
    }
}
