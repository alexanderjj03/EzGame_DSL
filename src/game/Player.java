package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player implements Tile{
    private int posX;
    private int posY;
    private int health;
    private int size = 1;
    private BufferedImage image;

    public Player(int posX, int posY, int health, int size) {
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.size = size;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/penguin.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Getters and Setters
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSize() {return this.size;}

    // Directions (REQUIRE condition is done by TileMap hopefully)
    public void moveLeft() {
        this.posX -= 1;
    }

    public void moveRight() {
        this.posX += 1;
    }

    public void moveUp() {
        this.posY -= 1;
    }

    public void moveDown() {
        this.posY += 1;
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    // No collisions with player
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
            g.setColor(Color.RED);
            g.fill3DRect(x, y, gridSize * size, gridSize * size, true);
        }
    }

    public int getHealth() {
        return health;
    }

    public void loseHealth(int healthLost) {
        int loss = this.health - healthLost;
        this.health = Math.max(loss, 0);
    }
}
