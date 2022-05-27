package ru.gb.zaripov.homework10;

public class MyArrayDataException extends Exception {
    private static final String ERROR_MESSAGE = "Ячейка [%d][%d] не содержит натуральное число";

    public MyArrayDataException(int x, int y) {
        super(String.format(ERROR_MESSAGE, x, y));
    }
}
