package wordgame.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WordGameGUI implements ActionListener
{
   private JFrame mainFrame;
   private JPanel mainPanel;
   private LetterButtons buttons;

   // user's current guess will be shown here
   private JLabel wordLabel;

   public WordGameGUI()
   {

      // hard-coded placeholder word, needs to be replaced with a real word used in the game
      String word = new String("_ _ _ _ _ _ _ _ _");
      wordLabel = new JLabel(word);
      wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      JFrame mainFrame = new JFrame("Word Game");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainPanel = new JPanel();
      mainPanel.setBackground(new Color(171, 229, 245));
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      mainPanel.add(wordLabel);

      buttons = new LetterButtons(this); // passing 'this' object as the ActionListener

      buttons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      buttons.setOpaque(false);
      mainPanel.add(buttons);

      mainFrame.add(mainPanel);

      mainFrame.pack();
      mainFrame.setVisible(true);
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

      // TODO: tell the controller about the user's choice
   }
}
