package ru.gb.zaripov.homework9.interfaceSolution;

public abstract class Barrier {

    protected int size;

    public Barrier(int size) {
        this.size = size;
    }

    public abstract void cross(Athlete athlete);
}
