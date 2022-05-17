package ru.gb.zaripov;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {
    private final int WIDTH;
    private final int HEIGHT;
    private final int MINES_AMOUNT;
    private static int[][] map;
    private static int[][] field;

    private static final int MINE = 9;
    private static final int EMPTY_CELL = 0;
    private static final int CLOSED_CELL = -1;
    private static final int OPEN_CELL = -3;

    public Minesweeper(int HEIGHT, int WIDTH, int MINES_AMOUNT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.MINES_AMOUNT = MINES_AMOUNT;
        initMap();
        initField();

    }

    private void initField() {
        field = new int[HEIGHT][WIDTH];
        for (int[] val : field) {
            Arrays.fill(val, -1);
        }
    }

    private void initMap() {
        Random rnd = new Random();
        map = new int[HEIGHT][WIDTH];
        int minesCounter = MINES_AMOUNT;
        while (minesCounter != 0) {
            int x = rnd.nextInt(HEIGHT);
            int y = rnd.nextInt(WIDTH);
            if (map[x][y] != MINE) {
                map[x][y] = MINE;
                addNumbers(x, y, map);
                minesCounter--;
            }
        }
    }

    public void openCell(int i, int j) {
        field[i][j] = OPEN_CELL;
    }

    public boolean isWin() {
        int openCellCounter = 0;
        for (int[] val : field) {
            for (int i : val) {
                if (i == OPEN_CELL)
                    openCellCounter++;
            }
        }
        System.out.println(openCellCounter);
        return openCellCounter >= HEIGHT * WIDTH - MINES_AMOUNT;
    }

    private void addNumbers(int x, int y, int[][] map) {
        int leftBorder = Math.max(0, y - 1);
        int rightBorder = Math.min(WIDTH, y + 2);
        int topBorder = Math.max(0, x - 1);
        int bottomBorder = Math.min(HEIGHT, x + 2);
        for (int i = leftBorder; i < rightBorder; i++) {
            for (int j = topBorder; j < bottomBorder; j++) {
                if (map[j][i] != MINE)
                    map[j][i]++;
            }
        }
    }

    public int getCELL_SIZE() {
        return 30;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void move(int x, int y) {
        if (map[x][y] == EMPTY_CELL)
            openEmptyCells(x, y);

    }

    private void openEmptyCells(int x, int y) {
        int leftBorder = Math.max(0, y - 1);
        int rightBorder = Math.min(WIDTH, y + 2);
        int topBorder = Math.max(0, x - 1);
        int bottomBorder = Math.min(HEIGHT, x + 2);
        for (int i = topBorder; i < bottomBorder; i++) {
            for (int j = leftBorder; j < rightBorder; j++) {
                if (field[i][j] != OPEN_CELL) {
                    field[i][j] = OPEN_CELL;
                    if (map[i][j] == EMPTY_CELL)
                        openEmptyCells(i, j);
                }
            }
        }
    }

    public boolean isCellVisible(int x, int y) {
        return field[x][y] == CLOSED_CELL;
    }

    public boolean isCellMine(int x, int y) {
        return map[x][y] == MINE;
    }

    public String getCell(int i, int j) {
        if (map[i][j] == EMPTY_CELL)
            return " ";
        else return "" + map[i][j];
    }
}
