package game;

// Singleton Game Manager for keeping score and other things
public class GameManager {
    private static GameManager instance;
    public static final int FRAME_TIME = 15;
    private int score = 0;
    private GameState gameState = GameState.MAIN;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
