package wordgame.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import wordgame.ControllerInterface;
import wordgame.model.SecretWord;
import wordgame.view.WordGameGUI;

public class GameController implements ControllerInterface, ActionListener
{
    private SecretWord secretWord;
    private WordGameGUI gui;
    private int remainingGuesses;

    public GameController(SecretWord secretWord) 
    {
        this.secretWord = secretWord;
        this.remainingGuesses = 5;
        this.gui = new WordGameGUI(this);
        this.secretWord.register(gui);
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JButton button = (JButton) event.getSource();
        String text = button.getText();
        char letter = text.charAt(0);

        userPressed(letter);
    }

    @Override
    public void userPressed(char letter) 
    {
        boolean correctGuess = secretWord.makeGuess(letter);

        if (correctGuess) 
        {
            gui.update(secretWord.getCurrentGuess());
        } 
        else 
        {   
            remainingGuesses--;
            gui.updateRemainingGuesses(remainingGuesses);
        }
        gui.disableLetterButton(letter);

        if (!secretWord.hasUnopenedLetters()) 
        {   
            gui.endGame(true, secretWord.reveal());
        } 
        else if (remainingGuesses <= 0) 
        {
            gui.endGame(false, secretWord.reveal());
        }
    }

    public String getInitialGuess() 
    {
        return secretWord.getCurrentGuess();
    }
}
