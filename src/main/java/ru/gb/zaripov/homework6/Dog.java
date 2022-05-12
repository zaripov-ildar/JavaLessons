package ru.gb.zaripov.homework6;

public class Dog extends Animal {
    private static int dogsAmount;

    public Dog(String name) {
        super(500, 10, name);
        dogsAmount++;
    }

    public static int getDogsAmount() {
        return dogsAmount;
    }
}
