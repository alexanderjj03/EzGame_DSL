package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Obstacle extends Moveable implements Tile{
    private BufferedImage image;
    public Obstacle(int x, int y, Direction direction, int size) {
        super(x, y, direction, size);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/obstacle.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public void onCollision(Player player) {

    }

    @Override
    public void drawTile(int x, int y, int gridSize, Graphics g) {
        if (image != null) {
            int centeredX = x + (gridSize - (gridSize * size)) / 2;
            int centeredY = y + (gridSize - (gridSize * size)) / 2;
            g.drawImage(image, centeredX, centeredY, gridSize * size, gridSize * size, null);
        } else {
            g.setColor(Color.GRAY);
            g.fill3DRect(x, y, gridSize, gridSize, true);
        }
    }
}
