package ru.gb.zaripov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Window extends JFrame {
    private int WIDTH;
    private int HEIGHT;
    private final int CELL_SIZE = 30;
    private int MINES_AMOUNT;
    private final int BUTTON_LAYER = 1;
    private final int NUMBER_LAYER = 2;
    private final int IMAGE_LAYER = 0;

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
        setBounds(100, 100, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE + 35);
        setTitle("Minesweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        minesweeper = new Minesweeper(HEIGHT, WIDTH, MINES_AMOUNT);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 300));
        layeredPane.setLayout(null);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                initiateCellLayer(i, j);
                initiateNumberLayer(i, j);
            }
        }
        layeredPane.setVisible(true);
        add(layeredPane);
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
                ImageIcon bomb = new ImageIcon("src/main/resources/bomb.png");
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
                    if (!cell.isFlagged()) {
                        minesweeper.openCell(i, j);
                        cell.setVisible(false);
                        if (minesweeper.isCellMine(i, j))
                            reaction("src/main/resources/explosion.png");
                        if (minesweeper.isCellEmpty(i, j))
                            openCells(i, j);
                        if (minesweeper.isWin())
                            reaction("src/main/resources/win.png");

                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    cell.setFlagged();
                }
            }
        });
        cells[i][j] = cell;
        layeredPane.add(cell, BUTTON_LAYER);
    }


    private void reaction(String path) {
        ImageIcon explosion = new ImageIcon(path);
        explosion = new ImageIcon(explosion
                .getImage()
                .getScaledInstance(MIN_X * CELL_SIZE, MIN_Y * CELL_SIZE, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(explosion);
        label.setVisible(true);
        label.setBounds(0, 0,
                WIDTH * CELL_SIZE,
                HEIGHT * CELL_SIZE);
        openAllCells();
        label.addMouseListener(new RestartMouseListener(this, layeredPane));
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
}
