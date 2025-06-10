package gamemaker;


import game.Direction;
import game.EndCriteria;
import game.InstructionNode;
import game.TileMap;

// WIP and deal with exception later
// Makes a game via TileMap, called by Evaluator. Simplifies methods called by Evaluator
public class EZGameBuilder {
    private TileMap tileMap;

    public EZGameBuilder() { }

    // ARENA METHODS, initialize a new tileMap
    public EZGameBuilder addArena(int row, int col, int gridSize) {
        // Deal with exceptions later
        this.tileMap = new TileMap(row, col, gridSize);
        return this;
    }

    // ATTRIBUTE METHODS
    public EZGameBuilder addPlayerEntity(String name, int startX, int startY, int health, int size) {
        this.tileMap.addPlayer(startX, startY, name, health, size);
        return this;
    }

    public EZGameBuilder addEnemyEntity(String name, int startX, int startY, int health, int damage, Direction direction, int size) {
        this.tileMap.addEnemy(startX, startY, health, name, direction, damage, size);
        return this;
    }

    public EZGameBuilder addObstacleEntity(String name, int startX, int startY, Direction direction, int size) {
        this.tileMap.addObstacle(startX, startY, name, direction, size);
        return this;
    }

    public EZGameBuilder addCollectableEntity(String name, int startX, int startY, Direction direction, int points, int size) {
        this.tileMap.addCollectable(startX, startY, name, points, direction, size);
        return this;
    }

    // BEHAVIOUR METHODS

    public EZGameBuilder addBehaviour(String name, InstructionNode node) {
        this.tileMap.addInstructionToMoveables(name, node);
        return this;
    }

    // END_CRITERIA METHODS
    public EZGameBuilder addEndCriteria(EndCriteria endCriteria) {
        this.tileMap.addEndCriteria(endCriteria);
        return this;
    }

    public TileMap build() {
        return tileMap;
    }
}
