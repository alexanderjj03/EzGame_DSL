package ui;

import game.*;
import gamemaker.EZGameBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static game.GameManager.FRAME_TIME;

public class EZGamePanel extends JPanel implements ActionListener, KeyListener {

    // MAKE THIS VARIABLE TO WINDOW SIZE
    private int rows = 32;
    private int cols = 24;
    private static final int GRID_SIZE = 25;
    private TileMap tileMap;
    public static final int[][] bitMap = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public EZGamePanel(EZGameBuilder builder) {
        setBackground(new Color(150, 200, 162));
        setFocusable(true);
        addKeyListener(this);
        if (builder == null) {
            // GOTO DEMO GAME
            this.tileMap = new TileMap(rows, cols, GRID_SIZE);
            this.tileMap.addPlayer(12, 12, "mario", 20, 1);
            this.tileMap.loadBitMap(bitMap);
            // Add random coin somewhere
            this.tileMap.addCollectable(5, 5, "coin", 5, Direction.RIGHT, 2);
            // Add random enemy somewhere
            this.tileMap.addEnemy(10, 10, 10, "goomba", Direction.RIGHT, 2, 2);
            for (int i = 0; i < 4; i++) {
                this.tileMap.addInstructionToMoveables("coin", new InstructionNode(InstructionType.FACE, Direction.DOWN));
                this.tileMap.addInstructionToMoveables("coin", new InstructionNode(InstructionType.MOVE_DISP, 1));
            }
            this.tileMap.addObstacle(15, 15, "box", Direction.RIGHT, 2);
            for (int i = 0; i < 5; i++) {
                this.tileMap.addInstructionToMoveables("box", new InstructionNode(InstructionType.MOVE_DISP, 1));
            }
        } else {
            this.tileMap = builder.build();
            this.rows = this.tileMap.getRows();
            this.cols = this.tileMap.getCols();

        }
        // Super barebones way to add ticks, since hard physics don't matter
        Timer timer = new Timer(FRAME_TIME, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameState currState = GameManager.getInstance().getGameState();
        if (currState == GameState.MAIN) {
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            g.drawString("Score: " + GameManager.getInstance().getScore() +
                            " Health: " + (tileMap.getPlayer() != null ? tileMap.getPlayer().getHealth() : "N/A"),
                    getWidth() / 2 - 100, 50);
            drawGrid(g);
        } else if (currState == GameState.LOSE) {
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            g.drawString("GAME OVER: Score: " + GameManager.getInstance().getScore(),
                    getWidth()/2 - 150, getHeight()/2);
        } else if (currState == GameState.WIN) {
            g.setColor(Color.GREEN);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
            g.drawString("YOU WIN: Score: " + GameManager.getInstance().getScore(),
                    getWidth()/2 - 150, getHeight()/2);
        }
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tileMap.getTile(i, j).drawTile(i * GRID_SIZE, j * GRID_SIZE + 60, GRID_SIZE, g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState currState = GameManager.getInstance().getGameState();
        if (currState == GameState.MAIN) {
            this.tileMap.updateMoveables();
        }
        // Update Graphics
        this.tileMap.checkEndCondition();
        repaint();
    }

    // Key Handler
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> tileMap.playerMoveDirection(0, -1);
            case KeyEvent.VK_DOWN -> tileMap.playerMoveDirection(0, 1);
            case KeyEvent.VK_LEFT -> tileMap.playerMoveDirection(-1, 0);
            case KeyEvent.VK_RIGHT -> tileMap.playerMoveDirection(1, 0);
//            case KeyEvent.VK_R -> this.restartState();
        }
    }

//    private void restartState() {
//        GameManager.getInstance().setGameState(GameState.MAIN);
//    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
