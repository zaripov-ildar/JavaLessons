package ru.gb.zaripov.homework4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private static final Random rnd = new Random();
    private static final int MINE = 1000;
    private static final int EMPTY_CELL = 0;
    private static final int CLOSED_CELL = -1;
    private static final int FLAG_CELL = -2;
    private static final int OPEN_CELL = -3;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 10;
    private static final int MINES_AMOUNT = 7;
    private static int[][] map;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println("Welcome to Minesweeper!\n" +
                "to choose a cell input something like:b 3\n" +
                "to put a flag: b 4 *\n" +
                "to remove flag input the same command:b 4 *");
        boolean win = false;
        map = initMap();
        int[][] field = initField();
        int x, y;
        printArr(field);
        do {
            do {
                System.out.println("Input letter 'space' number ('space' *)");
                Scanner sc = new Scanner(System.in);
                String inp = sc.nextLine().toUpperCase(Locale.ROOT);
                String[] inpArr = inp.split(" ");
                try {
                    y = inpArr[0].charAt(0) - 'A';
                    x = Integer.parseInt(inpArr[1]) - 1;
                    if (y < 0 || y >= WIDTH || x < 0 || x >= HEIGHT) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Wrong input, try again");
                    continue;
                }
                if (inpArr.length == 3 && inpArr[2].equals("*")) {
                    if (field[x][y] == FLAG_CELL)
                        field[x][y] = CLOSED_CELL;
                    else if(field[x][y] == CLOSED_CELL)
                        field[x][y] = FLAG_CELL;
                    printArr(field);
                } else if (isIfInputValid(x, y, field))
                    break;
            }
            while (true);
            if (map[x][y] == MINE) {
                printArr(map);
                drawExplosion();
                break;
            }
            field[x][y] = OPEN_CELL;
            if (map[x][y] == EMPTY_CELL)
                openEmptyCells(field, x, y);
            printArr(field);
            win = isWin(field);
        }
        while (!win);

        if (win)
            drawWin();
    }


    private static void openEmptyCells(int[][] field, int x, int y) {
        int leftBorder = Math.max(0, y - 1);
        int rightBorder = Math.min(WIDTH, y + 2);
        int topBorder = Math.max(0, x - 1);
        int bottomBorder = Math.min(HEIGHT, x + 2);
        for (int i = topBorder; i < bottomBorder; i++) {
            for (int j = leftBorder; j < rightBorder; j++) {
                if (field[i][j] != OPEN_CELL) {
                    field[i][j] = OPEN_CELL;
                    if (map[i][j] == EMPTY_CELL)
                        openEmptyCells(field, i, j);
                }
            }
        }
    }

    private static void drawExplosion() {
        final String colorCode = getColorCode(3);
        System.out.print(colorCode);
        System.out.println("\n" +
                "████████████████████████████████\n" +
                "██████████▀▀▀▀▀▀▀▀▀▀▀███████████\n" +
                "██████▀▀▀░░░░░░░░░░░░░▀▀████████\n" +
                "███▀░░░░░░░▄▄▄░░░▄▄▄░░░░░░░▀████\n" +
                "███░░░░░▄▄███████████▄▄▄░░░░░███\n" +
                "███░░░░████▀▀▀▀▀▀▀▀▀█████▄░░░███\n" +
                "████▄▄░█▀▀░░▄▄░░▄▄░░░░░██▀░░▄███\n" +
                "████████░░▄▄█████████░░█████████\n" +
                "████████▄▄██▀░░░░░▀█████████████\n" +
                "█████████████▄░░░▄██████████████\n" +
                "██████████████░░░███████████████\n" +
                "██████████████░░░███████████████\n" +
                "█████████████▀░░░▀██████████████\n" +
                "███████▄▄████░░░░░████▄▄████████\n" +
                "█████░▄▄░███░░░░░░░███░▄▄░██████\n" +
                "█████░▀██▀▀░░░░░░░░░▀▀██▀░██████\n" +
                "██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████\n" +
                "████████████████████████████████\n"
        );
        System.out.println("You've been exploded!!!");
        System.out.print(ANSI_RESET);
    }

    private static void drawWin() {
        final String colorCode = getColorCode(100500);
        System.out.print(colorCode);
        System.out.println("\n" +
                "░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░\n" +
                "░░░▄▄▄▄████████████▀▀█▄▄▄▄░\n" +
                "░░░█▄░░████████████░░█░░░█░\n" +
                "░░░░█░░████████████░▄█░░█░░\n" +
                "░░░░░▀▄░██████████░░█░▄▀░░░\n" +
                "░░░░░░░▀▀████████▀░█▀▀░░░░░\n" +
                "░▄░░░░░░░░▀█████▀▄▀░░░░░▄█▄\n" +
                "▀█▀░░░░░░░░░▀███▀░░░░░░░░▀░\n" +
                "░░░░░░░▄░░░░░░█░░░░░░░░░░░░\n" +
                "░░░░░░▀█▀░░░░░█░░░░░░░░░░░░\n" +
                "░░░░░░░░░░░░░▄█▄░░░░░░░░░░░\n" +
                "░░░░░░░░░░▄▄▄███▄▄▄░░░░░░░░\n" +
                "░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░\n" +
                "░░░░░░░███████████████░░░░░\n" +
                "░░░░░░░████▀▀▀▀▀▀▀████░░░░░\n" +
                "░░░░░░░███░░░░░░░░░███░░░░░\n" +
                "░░░░░░░████▄▄▄▄▄▄▄████░░░░░\n" +
                "░░░░░░░███████████████░░░░░\n" +
                "░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░\n"
        );
        System.out.print(ANSI_RESET);
    }

    private static boolean isIfInputValid(int x, int y, int[][] field) {
        return x >= 0 && x < HEIGHT && y >= 0 && y < WIDTH && field[x][y] != OPEN_CELL;
    }

    private static boolean isWin(int[][] field) {
        int openCellCounter = 0;
        for (int[] val : field) {
            for (int i : val) {
                if (i == OPEN_CELL)
                    openCellCounter++;
            }
        }
        return openCellCounter == HEIGHT * WIDTH - MINES_AMOUNT;
    }

    private static int[][] initField() {
        int[][] field = new int[HEIGHT][WIDTH];
        for (int[] val : field) {
            Arrays.fill(val, -1);
        }
        return field;
    }

    private static int[][] initMap() {
        int[][] map = new int[HEIGHT][WIDTH];
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
        return map;
    }

    private static void addNumbers(int x, int y, int[][] map) {
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

    private static void printArr(int[][] field) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%2d", i + 1);
            for (int j = 0; j < WIDTH; j++) {
                if (field[i][j] == CLOSED_CELL)
                    drawCell(CLOSED_CELL);
                else if (field[i][j] == FLAG_CELL)
                    drawCell(FLAG_CELL);
                else drawCell(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void drawCell(int cellCode) {
        final String colorCode = getColorCode(cellCode);
        System.out.print(colorCode);
        switch (cellCode) {
            case 1000:
                System.out.print(" *");
                break;
            case 0:
                System.out.print(" .");
                break;
            case CLOSED_CELL:
                System.out.print("[]");
                break;
            case FLAG_CELL:
                System.out.print(" " + "\u2691");
                break;
            default:
                System.out.printf("%2d", cellCode);
        }
        System.out.print(ANSI_RESET);
    }

    private static String getColorCode(int i) {
        switch (i) {
            case EMPTY_CELL:
            case CLOSED_CELL:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
            case FLAG_CELL:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }

}
