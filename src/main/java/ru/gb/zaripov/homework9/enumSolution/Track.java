package ru.gb.zaripov.homework9.enumSolution;

public class Track extends Barrier {
    public Track(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        athlete.run(size);
    }
}
