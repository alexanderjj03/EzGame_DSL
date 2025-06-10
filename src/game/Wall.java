package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wall implements Tile {

    private BufferedImage image;

    public Wall() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/wall.png"));
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
            g.drawImage(image, x, y, gridSize, gridSize, null);
        } else {
            g.setColor(Color.BLACK);
            g.fill3DRect(x, y, gridSize, gridSize, true);
        }
    }
}
