package wordgame.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import wordgame.ControllerInterface;
import wordgame.GameObserver;
import wordgame.controller.GameController;

public class WordGameGUI implements ActionListener, GameObserver
{
   private JFrame mainFrame;
   private JPanel mainPanel;
   private LetterButtons buttons;

   // user's current guess will be shown here
   private JLabel wordLabel;
   private JLabel remainingGuessesLabel;
   private ControllerInterface controller;

   public WordGameGUI(GameController controller) 
   {
      String initialGuess = controller.getInitialGuess();
      wordLabel = new JLabel(initialGuess);
      wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      remainingGuessesLabel = new JLabel("Remaining guesses: 5");
      remainingGuessesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      JFrame mainFrame = new JFrame("Word Game");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainPanel = new JPanel();
      mainPanel.setBackground(new Color(171, 229, 245));
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      mainPanel.add(wordLabel);

      buttons = new LetterButtons(controller);
      buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      buttons.setOpaque(false);
      mainPanel.add(buttons);

      mainPanel.add(remainingGuessesLabel);

      mainFrame.add(mainPanel);

      mainFrame.pack();
      mainFrame.setVisible(true);
   }

   public void disableLetterButton(char letter) 
   {
      buttons.disableLetterButton(letter);
   }

   @Override
   public void actionPerformed(ActionEvent event)
   {
      // get the source component that triggered this event
      // and cast it to a JButton
      JButton button = (JButton)event.getSource();
      String text = button.getText();
      char letter = text.charAt(0);
      System.out.println("User selected "+letter);

      // tell the controller about the user's choice
      controller.userPressed(letter);
   }

   @Override
   public void update(String currentGuess) 
   {
      wordLabel.setText(currentGuess);
   }

   public void updateRemainingGuesses(int remainingGuesses) 
   {
      remainingGuessesLabel.setText("Remaining guesses: " + remainingGuesses);
   }


   @Override
   public void endGame(boolean won, String revealedWord) 
   {
      String message;
      if (won) 
      { 
         message = "Congratulations, you revealed the hidden word: " + revealedWord;
      } 
      else 
      {
         message = "Sorry, you lost. The word was: " + revealedWord;
      }
      wordLabel.setText(message);
      buttons.disableAllButtons();
   }
}
