package ru.gb.zaripov.homework10;

public class MyArraySizeException extends Exception {
    private static final String ERROR_MESSAGE = "Неверный размер массива: [%d][%d], должен быть:  [4][4]";

    public MyArraySizeException(int width, int height) {
        super(String.format(ERROR_MESSAGE, width, height));
    }
}
