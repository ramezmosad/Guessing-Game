package wordgame.view;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class LetterButtons extends JPanel
{
   private JButton []buttons;

   public LetterButtons(ActionListener listener)
   {
      this.buttons = new JButton[26];
      int nextButton = 0;
      this.setLayout(new GridLayout(3,10));
      for (char letter = 'a'; letter <= 'z'; letter++)
      {
         // create a button and attach the listener to it
         // the listener was provided to us as an argument
         this.buttons[nextButton] = new JButton(String.valueOf(letter));
         this.buttons[nextButton].addActionListener(listener);

         this.add(this.buttons[nextButton]);
         nextButton++;
      }
   }

   public void add(char letter)
   {
      char lowerCaseLetter = Character.toLowerCase(letter);
      this.buttons[lowerCaseLetter-'a'].setEnabled(false);
   }

}
