package ru.gb.zaripov.homework6;

public class Cat extends Animal {
    private static final int RUN_LIMIT = 200;
    private static final int SWIM_LIMIT = 0;
    private static int catsAmount;

    public Cat(String name) {
        super(RUN_LIMIT, SWIM_LIMIT, name);
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
