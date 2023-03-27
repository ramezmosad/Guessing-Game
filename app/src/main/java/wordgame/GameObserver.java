package wordgame;

public interface GameObserver 
{
    void update(String currentGuess);
    void updateRemainingGuesses(int remainingGuesses);
    void endGame(boolean won, String revealedWord);
}
