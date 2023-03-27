package wordgame;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import wordgame.model.SecretWord;
import wordgame.model.Dictionary;
import wordgame.controller.GameController;
import wordgame.view.WordGameGUI;

public class Game
{
   public static String pickWord(String fileName) throws IOException
   {
      Dictionary dictionary = new Dictionary(fileName);
      ArrayList<String> allWords = dictionary.getWords();
      Random randomizer = new Random();
      int randomLocation = randomizer.nextInt(allWords.size());
      return allWords.get(randomLocation);
   }

   public static void main(String []args)
   {
      // Pick a secret word (create the model)
      SecretWord secretWord;
      try
      {
         secretWord = new SecretWord(pickWord("dictionary.txt"));
      }
      catch(IOException e)
      {
         System.out.println(e.getMessage());
         return;
      }

      // For MVC pattern, instantiate a controller, and pass secretWord to the controller
      // Let the controller instantiate WordGameGUI, instead of the main method
      GameController controller = new GameController(secretWord);
      
   }

}
