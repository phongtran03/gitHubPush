package Generics_and_java.util;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class LyricWordUsingGeneric {
    private static final Word[] lyric = {
      new Word("you", 1), new Word("say", 2), new Word("it", 3),
      new Word("best", 4), new Word("when", 5), new Word("you", 6),
      new Word("say", 7), new Word("nothing", 8), new Word("at", 9),
      new Word("all", 10)
    };

     public static void main(String[] args){
         // Create a list that's implemented by ArrayList
         List<Word> lyric = new ArrayList<Word>();
         for(Word w : lyric){
             lyric.add(w);
         }
         //show all elements of words
         for (Word w: lyric){
             System.out.println(w.getValue()+ ", " +w.getPosition());
         }
     }
}
