package wordgame.model;
import java.util.ArrayList;
import wordgame.GameObserver;
import wordgame.GameSubject;

public class SecretWord implements GameSubject
{
   private char    []secret;
   private char    []originalWord;
   private boolean []opened;
   private ArrayList<GameObserver> observers;

   public SecretWord(String word)
   {
      this.observers = new ArrayList<>();
      this.secret = word.toLowerCase().toCharArray();
      this.originalWord = word.toCharArray();
      this.opened = new boolean[secret.length];
   }

   public void register(GameObserver observer) 
   {
      this.observers.add(observer);
   }

   public void unregister(GameObserver observer)
   {
      this.observers.remove(observer);
   }

   public void notifyObservers()
   {
      for (GameObserver observer : observers) 
      {
         observer.update(getCurrentGuess());
      }
   }

   public boolean makeGuess(char letter)
   {
      boolean result = false;
      letter = Character.toLowerCase(letter);

      for (int i = 0; i < this.secret.length; i++)
      {
         if (this.secret[i] == letter && !this.opened[i])
         {
            result = true;
            this.opened[i] = true;
         }
      }
      notifyObservers();
      return result;
   }

   public boolean hasUnopenedLetters()
   {
      for (int i = 0; i < this.opened.length; i++)
      {
         if (!this.opened[i])
         {
            return true;
         }
      }
      return false;
   }

   public String getCurrentGuess()
   {
      String result = "";
      for (int i = 0; i < this.opened.length; i++)
      {
         if (this.opened[i])
         {
            result+=this.originalWord[i];
         }
         else
         {
            result+='_';
         }
      }
      return result;
   }

   public String reveal()
   {
      String result = new String(this.originalWord);
      return result;
   }
}
