package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Moveable {

    private int health = 10;
    private int damage;
    private BufferedImage image;

    public Enemy(int x, int y, int health, Direction direction, int damage, int size) {
        super(x, y, direction, size);
        this.damage = damage;
        this.health = health;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/monkey.png"));
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
        player.loseHealth(damage);
    }

    @Override
    public void drawTile(int x, int y, int gridSize, Graphics g) {
        if (image != null) {
            int centeredX = x + (gridSize - (gridSize * size)) / 2;
            int centeredY = y + (gridSize - (gridSize * size)) / 2;
            g.drawImage(image, centeredX, centeredY, gridSize * size, gridSize * size, null);
        } else {
            g.setColor(Color.BLUE);
            g.fill3DRect(x, y, gridSize, gridSize, true);
        }
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
