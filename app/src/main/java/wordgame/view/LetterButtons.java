package wordgame.view;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

import wordgame.controller.GameController;

public class LetterButtons extends JPanel
{
   private JButton []buttons;

   public LetterButtons(GameController controller) 
   {
      this.buttons = new JButton[26];
      int nextButton = 0;
      this.setLayout(new GridLayout(3, 10));
      for (char letter = 'a'; letter <= 'z'; letter++) 
      {
         this.buttons[nextButton] = new JButton(String.valueOf(letter));
         this.buttons[nextButton].addActionListener(controller);

         this.add(this.buttons[nextButton]);
         nextButton++;
      }
   }

   public void add(char letter)
   {
      char lowerCaseLetter = Character.toLowerCase(letter);
      this.buttons[lowerCaseLetter-'a'].setEnabled(false);
   }

   public void disableLetterButton(char letter) 
   {
      char lowerCaseLetter = Character.toLowerCase(letter);
      this.buttons[lowerCaseLetter - 'a'].setEnabled(false);
   }

   public void disableAllButtons() 
   {
      for (JButton button : buttons) 
      {
          button.setEnabled(false);
      }
   }

}
