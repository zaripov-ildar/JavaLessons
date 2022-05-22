package ru.gb.zaripov.homework8;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

public class Window extends JFrame {

    private final String PATH = "src/main/resources/";
    private int WIDTH;
    private int HEIGHT;
    private final int CELL_SIZE = 30;
    private int MINES_AMOUNT;
    private final int BUTTON_LAYER = 2;
    private final int NUMBER_LAYER = 3;
    private final int IMAGE_LAYER = 1;

    private final int MESSAGE_LAYER = 0;

    private final int MIN_X = 10;
    private final int MIN_Y = 10;
    private Minesweeper minesweeper;
    private JLayeredPane layeredPane;

    private Cell[][] cells;

    public Window() {
        initiateWindow();
    }

    void initiateWindow() {
        Random random = new Random();
        int width = random.nextInt(5) + MIN_X;
        int height = random.nextInt(5) + MIN_Y;
        cells = new Cell[height][width];
        WIDTH = width;
        HEIGHT = height;
        MINES_AMOUNT = (int) (0.1 * WIDTH * HEIGHT);

        minesweeper = new Minesweeper(HEIGHT, WIDTH, MINES_AMOUNT);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE));

        layeredPane.setLayout(null);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                initiateCellLayer(i, j);
                initiateNumberLayer(i, j);
            }
        }
        layeredPane.setVisible(true);


        setTitle("Minesweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(layeredPane);
        setResizable(false);
        setAlwaysOnTop(true);
        pack();
        setVisible(true);
    }

    private void initiateNumberLayer(int i, int j) {
        JLabel label;
        int cellNumber = minesweeper.getCell(i, j);
        switch (cellNumber) {
            case (Minesweeper.EMPTY_CELL):
                label = new JLabel("  ");
                break;
            case (Minesweeper.MINE):
                ImageIcon bomb = new ImageIcon(PATH + "bomb.png");
                bomb = new ImageIcon(bomb
                        .getImage()
                        .getScaledInstance(CELL_SIZE, CELL_SIZE, Image.SCALE_SMOOTH));
                label = new JLabel(bomb);

                break;
            default:
                Color color = getNumberColor(cellNumber);
                label = new JLabel(String.valueOf(cellNumber));
                label.setForeground(color);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
        }
        label.setBounds(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        layeredPane.add(label, NUMBER_LAYER);

    }

    private Color getNumberColor(int cellNumber) {
        switch (cellNumber) {
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            default:
                return Color.BLACK;

        }
    }

    private void initiateCellLayer(int i, int j) {
        Cell cell = new Cell(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE);
        cell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    makeSound(PATH + "click.wav");
                    if (!cell.isFlagged()) {
                        minesweeper.openCell(i, j);
                        cell.setVisible(false);
                        if (minesweeper.isCellMine(i, j))
                            reaction(PATH + "explosion.png", PATH + "explosion.wav");
                        if (minesweeper.isCellEmpty(i, j))
                            openCells(i, j);
                        if (minesweeper.isWin())
                            reaction(PATH + "win.png", PATH + "win.wav");
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    makeSound(PATH + "flag.wav");
                    cell.setFlagged();
                }
            }
        });
        cells[i][j] = cell;
        layeredPane.add(cell, BUTTON_LAYER);
    }

    private void reaction(String pathToImage, String pathToSound) {
        ImageIcon reactionImage = new ImageIcon(pathToImage);
        reactionImage = new ImageIcon(reactionImage
                .getImage()
                .getScaledInstance(MIN_X * CELL_SIZE, MIN_Y * CELL_SIZE, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(reactionImage);
        label.setVisible(true);
        label.setBounds(0, 0,
                WIDTH * CELL_SIZE,
                HEIGHT * CELL_SIZE);
        openAllCells();
        makeSound(pathToSound);
        label.addMouseListener(new RestartMouseListener(this, layeredPane));
        JLabel messageClick = new JLabel("Click to continue");
        messageClick.setBounds(0, getHeight() - 100, getWidth(), 2 * CELL_SIZE);
        messageClick.setFont(new Font("Serif", Font.BOLD, 25));
        messageClick.setForeground(Color.MAGENTA);
        layeredPane.add(messageClick, MESSAGE_LAYER);
        layeredPane.add(label, IMAGE_LAYER);

    }

    private void openAllCells() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                cells[j][i].setVisible(false);
            }

        }
    }

    private void openCells(int h, int w) {
        minesweeper.openEmptyCells(h, w);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (!minesweeper.isCellVisible(i, j))
                    cells[i][j].setVisible(false);
            }
        }
    }

    private void makeSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ignored) {
        }
    }

}
