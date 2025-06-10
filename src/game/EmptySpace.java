package game;

import java.awt.*;

public class EmptySpace implements Tile{

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void onCollision(Player player) {

    }

    @Override
    public void drawTile(int x, int y, int gridSize, Graphics g) {
        g.setColor(Color.GRAY);
        g.drawRect(x, y, gridSize, gridSize);
    }

}
