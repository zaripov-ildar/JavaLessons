package ru.gb.zaripov.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 5, b =-8;
        if (a+b>=0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor(){
        int value = 99;
        if (value<=0) System.out.println("Красный");
        else if (value<=100) System.out.println("Жёлтый");
        else System.out.println("Зелёный");
    }

    public static void compareNumbers(){
        int a = 12, b =-45;
        if (a>=b) System.out.println("a>=b");
        else System.out.println("a<b");
    }
}
