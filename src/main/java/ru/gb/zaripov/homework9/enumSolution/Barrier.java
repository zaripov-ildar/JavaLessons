package ru.gb.zaripov.homework9.enumSolution;

public abstract class Barrier {
    protected final int size;

    public Barrier(int size) {
        this.size = size;
    }

    public abstract void cross(Athlete athlete);

}
