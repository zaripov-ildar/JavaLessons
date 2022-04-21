package ru.gb.zaripov.homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeworkApp {
    private static final int SIZE = 5;
    private static int DOTS_TO_WIN = 4;
    private static final char EMPTY_CELL = '.';
    private static final char X_CELL = 'X';
    private static final char O_CELL = 'O';
    private static char[][] map;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        mapInit();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_CELL)) {
                System.out.println("Победил человек!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            int temp = DOTS_TO_WIN;
            DOTS_TO_WIN = 3;
            aiTurn();
            DOTS_TO_WIN = temp;
            printMap();
            if (checkWin(O_CELL)) {
                System.out.println("Победил компутер!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
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
        System.out.print(" ");
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
            System.out.println("Введите X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isInputValid(x, y));
        map[x][y] = X_CELL;
    }

    private static boolean isInputValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[x][y] == EMPTY_CELL;
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
        System.out.printf("Компутер сходил на (%d;%d)\n", x + 1, y + 1);
    }

    private static int findDangerousCell() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_CELL) {
                    char[][] testMap = deepCopyArray(map);
                    testMap[i][j] = X_CELL;
                    if (checkWin(X_CELL, testMap)) return i * SIZE + j;
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
        return checkWin(ch, map);
    }

    private static boolean checkWin(char ch, char[][] map) {
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                if (checkSubMap(i, j, ch, map)) return true;
            }
        }
        return false;
    }

    private static boolean checkSubMap(int x, int y, char ch, char[][] map) {
        boolean diag1 = true,
                diag2 = true;
        for (int i = x; i < x + DOTS_TO_WIN; i++) {
            boolean row = true,
                    column = true;
            for (int j = y; j < y + DOTS_TO_WIN; j++) {
                row &= map[i][j] == ch;
                column &= map[j][i] == ch;
            }
            if (row || column) return true;
            diag1 &= map[i][i] == ch;
            diag2 &= map[SIZE - 1 - i][i] == ch;
        }
        return diag1 || diag2;
    }


}
