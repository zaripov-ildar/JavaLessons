package ru.gb.zaripov.homework6;

public class Dog extends Animal {
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;
    private static int dogsAmount;

    public Dog(String name) {
        super(RUN_LIMIT, SWIM_LIMIT, name);
        dogsAmount++;
    }

    public static int getDogsAmount() {
        return dogsAmount;
    }
}
