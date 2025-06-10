package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Collectable extends Moveable {
    private int points;
    private BufferedImage image;

    public Collectable(int x, int y, Direction direction, int points, int size) {
        super(x, y, direction, size);
        this.points = points;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/collectable.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void onCollision(Player player) {
        GameManager.getInstance().addScore(points);
        setActive = false;
    }

    @Override
    public void drawTile(int x, int y, int gridSize, Graphics g) {
        if (image != null) {
            int centeredX = x + (gridSize - (gridSize * size)) / 2;
            int centeredY = y + (gridSize - (gridSize * size)) / 2;
            g.drawImage(image, centeredX, centeredY, gridSize * size, gridSize * size, null);
        } else {
            g.setColor(Color.YELLOW);
            g.fill3DRect(x, y, gridSize, gridSize, true);
        }
    }

    public int getPoints() {
        return points;
    }
}
