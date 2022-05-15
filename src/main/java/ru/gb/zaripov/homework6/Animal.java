package ru.gb.zaripov.homework6;

public abstract class Animal {
    private final int runLimit;
    private final String name;
    private final int swimLimit;
    private static int animalsAmount;

    public void run(int distance) {
        if (runLimit > distance)
            System.out.printf("%s ran %d m\n", name, distance);
        else
            System.out.println(name + " can't do it! That is too much");
    }

    public void swim(int distance) {
        if (swimLimit > distance)
            System.out.printf(name + " swam %d m\n", distance);
        else
            System.out.println(name + " can't do it! That's too much");
    }

    public Animal(int runLimit, int swimLimit, String name) {
        this.runLimit = runLimit;
        this.name = name;
        this.swimLimit = swimLimit;
        animalsAmount++;
    }

    public static int getAnimalsAmount() {
        return animalsAmount;
    }
}
