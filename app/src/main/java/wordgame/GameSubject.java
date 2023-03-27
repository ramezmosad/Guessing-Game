package wordgame;

public interface GameSubject 
{
    public void register(GameObserver observer);
    public void unregister(GameObserver observer);
    public void notifyObservers();
}
