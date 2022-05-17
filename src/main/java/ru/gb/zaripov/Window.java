package ru.gb.zaripov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    private final int CELL_SIZE = 30;
    private final int MINES_AMOUNT;
    private final Minesweeper minesweeper;
    private final JLayeredPane layeredPane;

    public Window(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        MINES_AMOUNT = (int) (0.1 * WIDTH * HEIGHT);
        setBounds(100, 100, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        setTitle("Minesweeper");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        minesweeper = new Minesweeper(HEIGHT, WIDTH, MINES_AMOUNT);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                initiateCellLayer(i, j);
                initiateNumberLayer(i, j);
            }

        }


        layeredPane.add(new Cell(10, 10, 30), JLayeredPane.POPUP_LAYER, 1);
        layeredPane.setVisible(true);
        add(layeredPane);
        setVisible(true);
    }

    private void initiateCellLayer(int i, int j) {
        Cell cell = new Cell(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE);
        cell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (!cell.isFlagged()) {
                        minesweeper.openCell(i,j);
                        cell.setVisible(false);

                    }
                }
            }
        });




        layeredPane.add(cell);
    }

}
