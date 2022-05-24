package ru.gb.zaripov.homework9.enumSolution;

public class Wall extends Barrier {
    public Wall(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        athlete.jump(size);
    }
}
