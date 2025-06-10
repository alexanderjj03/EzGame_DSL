package game;

import java.awt.*;

public interface Tile {
    public boolean isCollidable();
    // For interactions with the player
    public void onCollision(Player player);
    public void drawTile(int x, int y, int gridSize, Graphics g);
}
