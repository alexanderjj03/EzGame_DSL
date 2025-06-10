package game;

import java.util.LinkedList;
import java.util.Queue;

import static game.GameManager.FRAME_TIME;

public abstract class Moveable implements Tile{
    protected Queue<InstructionNode> instructions;
    protected InstructionNode curr;
    protected int x;
    protected int y;
    protected Direction direction;
    protected int size = 1;
    protected int framesTillUpdate = 100 / FRAME_TIME;
    protected int maxFramesTillUpdate = 100 / FRAME_TIME;
    protected int effectRate = 0;
    protected final int maxEffectRate = 150/FRAME_TIME;

    protected boolean setActive = true;

    public Moveable(int x, int y, Direction direction, int size) {
        this.instructions = new LinkedList<>();
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.size = size;
    }

    public void update(TileMap tileMap) {
        if (!this.instructions.isEmpty()) {
            if (framesTillUpdate <= 0) {
                curr = instructions.peek();
                switch (curr.getType()) {
                    case MOVE_COORD:
                        if (tileMap.hasFreeSpace(curr.getParam_x(), curr.getParam_y())) {
                            x = curr.getParam_x();
                            y = curr.getParam_y();
                            instructions.poll();
                        }
                        break;
                    case MOVE_DISP:
                        moveDirection(tileMap);
                        break;
                    case WAIT:
                        framesTillUpdate = 1000 * curr.getParam() / FRAME_TIME;
                        instructions.poll();
                        break;
                    case FACE:
                        direction = curr.getDirection();
                        instructions.poll();
                        break;
                    default:
                        instructions.poll();
                        break;
                }
                // if it isn't updated anyways
                if (framesTillUpdate <= 0) {
                    framesTillUpdate = maxFramesTillUpdate;
                }
                if (effectRate > 0) {
                    effectRate--;
                }
            }
            framesTillUpdate--;
        }
    }

    protected void moveDirection(TileMap tileMap) {
        int tempX = x;
        int tempY = y;
        if (direction == Direction.LEFT) {
            tempX -= 1;
        } else if (direction == Direction.DOWN) {
            tempY += 1;
        } else if (direction == Direction.UP) {
            tempY -= 1;
        } else if (direction == Direction.RIGHT) {
            tempX += 1;
        }
        if (tileMap.hasFreeSpace(tempX, tempY)) {
            x = tempX;
            y = tempY;
            instructions.poll();
        } else if (tileMap.atPlayerPosition(tempX, tempY)) {
            // Player is nearby
            if (effectRate == 0) {
                onCollision(tileMap.getPlayer());
                effectRate = maxEffectRate;
            }
        }
    }

    public void addInstruction(InstructionNode node) {
        instructions.add(node);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isSetActive() {
        return setActive;
    }

    public void setActive(boolean setActive) {
        this.setActive = setActive;
    }
}
