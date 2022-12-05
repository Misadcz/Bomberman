package game.bomberman;

public interface GameListener {

    void stateChanged(int live, int timers,int score);

    void gameOver();
}
