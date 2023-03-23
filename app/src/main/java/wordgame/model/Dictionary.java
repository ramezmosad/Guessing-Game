package wordgame.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary
{
   private String fileName;
   ArrayList<String> words;

   public Dictionary(String fileName) throws IOException
   {
      this.fileName = fileName;
      words = new ArrayList<String>();

      //read the words from the file
      Scanner scanner = new Scanner(new File(fileName));
      String nextWord = "";
      while (scanner.hasNextLine())
      {
         nextWord = scanner.nextLine();
         words.add(nextWord);
      }
   }

   public ArrayList<String> getWords()
   {
      return words;
   }
}
