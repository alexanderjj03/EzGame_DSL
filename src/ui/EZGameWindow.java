package ui;

import gamemaker.EZGameBuilder;

import javax.swing.*;
import java.awt.*;

// Main Game Frame for 2d Top Game called EZGameUI
public class EZGameWindow extends JFrame {
    public static final int WINDOW_WIDTH = 850;
    public static final int WINDOW_HEIGHT = 650;
    private EZGameBuilder builder;

    public EZGameWindow() throws HeadlessException {
        super("EZGame");
        initConfig();
        initGamePanels();
        setVisible(true);
    }

    // Overload
    public EZGameWindow(EZGameBuilder builder) throws HeadlessException {
        super("EZGame");
        this.builder = builder;
        initConfig();
        EZGamePanel gamePanel = new EZGamePanel(builder);
        add(gamePanel);
        setVisible(true);
    }

    private void initGamePanels() {
        EZGamePanel gamePanel = new EZGamePanel(null);
        add(gamePanel);
    }

    private void initConfig() {
        setTitle("EZGame");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
