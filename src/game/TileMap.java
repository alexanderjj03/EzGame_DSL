package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Create TileMap For Game, Runs off a 2d grid
public class TileMap {
    private List<List<Tile>> tileMap;
    private List<Moveable> moveables;
    private Map<String, Tile> nameMap;
    private Player player;
    private final int rows;
    private final int cols;
    private final int gridSize;
    private EndCriteria endCriteria;

    public TileMap(int rows, int cols, int grid_size) {
        this.tileMap = new ArrayList<>();
        this.moveables = new ArrayList<>();
        this.nameMap = new HashMap<>();
        this.rows = rows;
        this.cols = cols;
        this.gridSize = grid_size;
        initTileMap(rows, cols);
    }

    private void initTileMap(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            List<Tile> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(new EmptySpace());
            }
            tileMap.add(row);
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    // Complete if adding tile to tileMap is successful
    public void setTileMap(int posX, int posY, Tile tileType) {
        if (inRange(posX, posY)) {
            tileMap.get(posX).set(posY, tileType);
        }
    }

    // Getter, will need the key to exist
    public Tile getTileFromName(String name) {
        return nameMap.get(name);
    }

    // Return true if the key exists in the TileMap, pair with getter
    public boolean hasName(String name) {
        return nameMap.containsKey(name);
    }

    // Remove by replacing it with EmptySpace
    public void removeTileMap(int posX, int posY) {
        setTileMap(posX, posY, new EmptySpace());
    }

    // Load BitMap with Walls to make map building easier [0] is empty space [1] is wall
    public void loadBitMap(int[][] bitMap) {
        if (bitMap.length != cols && bitMap[0].length != rows) {
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Only add walls
                if (bitMap[j][i] == 1 && ((player == null) || (player.getPosX() != i || player.getPosY() != j))) {
                    Tile wall = new Wall();
                    setTileMap(i, j, wall);
                }
            }
        }
    }

    private boolean inRange(int posX, int posY) {
        return posX >= 0 && posX < rows && posY >= 0 && posY < cols;
    }
    public boolean hasFreeSpace(int posX, int posY) {
        return inRange(posX, posY) && !getTile(posX, posY).isCollidable();
    }

    // Assumes in range
    public Tile getTile(int x, int y) {
        return tileMap.get(x).get(y);
    }

    // Directions (REQUIRE condition is done by TileMap hopefully)
    public void playerMoveDirection(int directionX, int directionY) {
        if (player == null) {
            return;
        }
        if (!inRange(player.getPosX() + directionX, player.getPosY() + directionY)) {
            return;
        }
        Tile otherTile = this.getTile(player.getPosX() + directionX, player.getPosY() + directionY);
        if (!otherTile.isCollidable()) {
            // Make better eventually
            if (otherTile instanceof Collectable) {
                this.removeTileMap(player.getPosX(), player.getPosY());
            } else {
                this.setTileMap(player.getPosX(), player.getPosY(), otherTile);
            }
            this.setTileMap(player.getPosX() + directionX, player.getPosY() + directionY, this.player);
            player.setPosX(player.getPosX() + directionX);
            player.setPosY(player.getPosY() + directionY);
        }
        otherTile.onCollision(player);
    }

    // REQUIRE: Assume that the next point is in the clear
    public void moveToPosition(int oldX, int oldY, int newX, int newY, Moveable curr) {
        if (!inRange(newX, newY)) {
            return;
        }
        Tile otherTile = this.getTile(newX, newY);
        if (!otherTile.isCollidable()) {
            this.setTileMap(oldX, oldY, otherTile);
            this.setTileMap(newX, newY, curr);
            curr.setX(newX);
            curr.setY(newY);
        }
    }

    // Add more stuff
    public void updateMoveables() {
        List<Moveable> toRemove = new ArrayList<>();
        for (Moveable moveable : moveables) {
            int oldX = moveable.getX();
            int oldY = moveable.getY();
            if (!moveable.isSetActive()) {
                toRemove.add(moveable);
                removeTileMap(oldX, oldY);
                continue;
            }
            moveable.update(this);
            int newX = moveable.getX();
            int newY = moveable.getY();
            if (oldX != newX || newY != oldY) {
                moveToPosition(oldX, oldY, newX, newY, moveable);
            }
        }
        for (Moveable move: toRemove) {
            moveables.remove(move);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public boolean atPlayerPosition(int x, int y) {
        return inRange(x, y) && player != null && x == player.getPosX() && y == player.getPosY();
    }

    public List<Enemy> getEnemies() {
        List<Enemy> enemyList = new ArrayList<>();
        for (Moveable moveable : moveables) {
            if (moveable instanceof Enemy) {
                enemyList.add((Enemy) moveable);
            }
        }
        return enemyList;
    }

    public List<Collectable> getCollectables() {
        List<Collectable> collectableList = new ArrayList<>();
        for (Moveable moveable : moveables) {
            if (moveable instanceof Collectable) {
                collectableList.add((Collectable) moveable);
            }
        }
        return collectableList;
    }

    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacleList = new ArrayList<>();
        for (Moveable moveable : moveables) {
            if (moveable instanceof Obstacle) {
                obstacleList.add((Obstacle) moveable);
            }
        }
        return obstacleList;
    }


    // Add End Conditions
    public void checkEndCondition() {
        if (endCriteria == null) {
            return;
        }
        if (endCriteria.hasLost(nameMap)) {
            GameManager.getInstance().setGameState(GameState.LOSE);
        }
        if (endCriteria.hasWon(nameMap)) {
            GameManager.getInstance().setGameState(GameState.WIN);
        }
    }


    // Builder Helpers, to make entities and assign attributes

    // Add Obstacles given a string name
    public void addObstacle(int posX, int posY, String name, Direction direction, int size) {
        if (inRange(posX, posY)) {
            Obstacle obstacle = new Obstacle(posX, posY, direction, size);
            setTileMap(posX, posY, obstacle);
            moveables.add(obstacle);
            nameMap.putIfAbsent(name, obstacle);
        }
    }

    // Make Enemy given a string name
    public void addEnemy(int posX, int posY, int health, String name, Direction direction, int damage, int size) {
        if (inRange(posX, posY)) {
            Enemy newEnemy = new Enemy(posX, posY, health, direction, damage, size);
            setTileMap(posX, posY, newEnemy);
            moveables.add(newEnemy);
            nameMap.putIfAbsent(name, newEnemy);
        }
    }

    // Add Collectable of a certain name
    public void addCollectable(int posX, int posY, String name, int points, Direction direction, int size) {
        if (inRange(posX, posY)) {
            Collectable collectable = new Collectable(posX, posY, direction, points, size);
            setTileMap(posX, posY, collectable);
            moveables.add(collectable);
            nameMap.putIfAbsent(name, collectable);
        }
    }

    // Add player to game
    public void addPlayer(int posX, int posY, String name, int health, int size) {
        if (player != null) {
            return;
        }
        if (inRange(posX, posY)) {
            player = new Player(posX, posY, health, size);
            setTileMap(posX, posY, player);
            nameMap.putIfAbsent(name, player);
        }
    }

    // Add behaviour to Moveables, if does not exist, do nothing
    public void addInstructionToMoveables(String name, InstructionNode node) {
        if (hasName(name)) {
            Tile tile = getTileFromName(name);
            if (tile instanceof Moveable) {
                Moveable moveable = (Moveable) tile;
                moveable.addInstruction(node);
            }
        }
    }

    // Add EndCriteria To Game
    public void addEndCriteria(EndCriteria endCriteria) {
        this.endCriteria = endCriteria;
    }
}
