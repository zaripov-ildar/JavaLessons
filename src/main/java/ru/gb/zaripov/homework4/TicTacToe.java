package ru.gb.zaripov.homework4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 9;
    private static final int DOTS_TO_WIN = 4;
    private static final char EMPTY_CELL = '.';
    private static final char X_CELL = 'X';
    private static final char O_CELL = 'O';
    private static char[][] map;
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        mapInit();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_CELL)) {
                System.out.println("The human won");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(O_CELL)) {
                System.out.println("The computer won");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("Game over");
        scanner.close();
    }

    private static void mapInit() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Input X & Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isInputValid(y, x));
        map[y][x] = X_CELL;
    }

    private static boolean isInputValid(int x, int y) {
        return (x >= 0 && y >= 0 && x < SIZE && y < SIZE  && map[x][y] == EMPTY_CELL);
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_CELL)
                    return false;
            }
        }
        return true;
    }

    private static void aiTurn() {
        final Random rnd = new Random();
        int x, y;
        int cellNumber = findDangerousCell();
        if (cellNumber >= 0) {
            x = cellNumber / SIZE;
            y = cellNumber % SIZE;
        } else {
            do {
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            }
            while (!isInputValid(x, y));
        }
        map[x][y] = O_CELL;
        System.out.printf("The computer's move is (%d;%d)\n", y + 1, x + 1);
    }

    private static int findDangerousCell() {
        for (int dangerousLineSize = DOTS_TO_WIN; dangerousLineSize > 1; dangerousLineSize--) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == EMPTY_CELL) {
                        char[][] plusOneMoveMap = deepCopyArray(map);
                        plusOneMoveMap[i][j] = X_CELL;
                        if (checkWin(X_CELL, plusOneMoveMap, dangerousLineSize))
                            return i * SIZE + j;
                    }
                }
            }
        }
        return -1;
    }

    private static char[][] deepCopyArray(char[][] arr) {
        int len = arr.length;
        char[][] result = new char[len][len];
        for (int i = 0; i < len; i++) {
            System.arraycopy(arr[i], 0, result[i], 0, len);
        }
        return result;
    }

    private static boolean checkWin(char ch) {
        return checkWin(ch, map, DOTS_TO_WIN);
    }

    private static boolean checkWin(char ch, char[][] map, int DOTS_TO_WIN) {
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                int[][] subMap = createSubMap(i, j, map, DOTS_TO_WIN);
                if (checkSubMap(subMap, ch)) return true;
            }
        }
        return false;
    }

    private static int[][] createSubMap(int i, int j, char[][] map, int dots_to_win) {
        int[][] result = new int[dots_to_win][dots_to_win];
        for (int k = 0; k < dots_to_win; k++) {
            for (int l = 0; l < dots_to_win; l++) {
                result[k][l] = map[i + k][l + j];
            }
        }
        return result;
    }

    private static boolean checkSubMap(int[][] subMap, char ch) {
        int size = subMap.length;
        boolean diag1 = true,
                diag2 = true;
        for (int i = 0; i < size; i++) {
            boolean row = true,
                    column = true;
            for (int j = 0; j < size; j++) {
                row &= subMap[i][j] == ch;
                column &= subMap[j][i] == ch;
            }
            if (row || column)
                return true;
            diag1 &= subMap[i][i] == ch;
            diag2 &= subMap[size - 1 - i][i] == ch;
        }
        return (diag1 || diag2);
    }


}
