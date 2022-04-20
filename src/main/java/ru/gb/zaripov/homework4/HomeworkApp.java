package ru.gb.zaripov.homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeworkApp {
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;
    private static final char EMPTY_CELL = '.';
    private static final char X_CELL = 'X';
    private static final char O_CELL = 'O';
    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random rnd = new Random();

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
            aiTurn();
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
        if (map[x][y] == EMPTY_CELL)
            return true;
        return false;
    }

//    private static boolean checkWin(char ch) {
//        int firstDiagonalCounter = 0,
//                secondDiagonalCounter = 0;
//        for (int i = 0; i < SIZE; i++) {
//            int rowShCounter = 0,
//                    columnShCounter = 0;
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == ch)
//                    rowShCounter++;
//                if (map[j][i] == ch)
//                    columnShCounter++;
//            }
//            if (rowShCounter == DOTS_TO_WIN || columnShCounter == DOTS_TO_WIN)
//                return true;
//            if (map[i][i] == ch)
//                firstDiagonalCounter++;
//            if (map[SIZE - 1 - i][i] == ch)
//                secondDiagonalCounter++;
//        }
//        return firstDiagonalCounter == DOTS_TO_WIN || secondDiagonalCounter == DOTS_TO_WIN;
//    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_CELL) return false;
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        }
        while (!isInputValid(x, y));
        map[x][y] = O_CELL;
        System.out.printf("Компутер сходил на (%d;%d)\n", x + 1, y + 1);
    }

    private static boolean checkWin(char ch){
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                int rowDots = 0,
                        columnDots = 0,
                        firstDiagonalDots = 0,
                        secondDiagonalDots = 0;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (map[i][j+k] == ch){
                        rowDots++;
                        if (rowDots == DOTS_TO_WIN) return true;
                    }
                    else rowDots = 0;
                    if (map[j+k][i] == ch){
                        columnDots++;
                        if (columnDots == DOTS_TO_WIN) return true;
                    }
                    else columnDots = 0;
                    if (map[i+k][j+k] == ch){
                        firstDiagonalDots++;
                        if (firstDiagonalDots == DOTS_TO_WIN) return true;
                    }
                    else firstDiagonalDots = 0;
                    if(map[SIZE-1-i-k][j+k] == ch) {
                        secondDiagonalDots++;
                        if (secondDiagonalDots == DOTS_TO_WIN) return true;
                    }
                    else seconDiagonalDots = 0;
                }
            }
        }
        return false;
    }


}
