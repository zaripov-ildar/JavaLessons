package ru.gb.zaripov.homework6;

public class Cat extends Animal{
    private static int catsAmount;

    public Cat(String name) {
        super(200, 0,name);
        catsAmount++;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats can't swim at all");

    }

    public static int getCatsAmount() {
        return catsAmount;
    }
}
