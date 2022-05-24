package ru.gb.zaripov.homework9.interfaceSolution;

public class Track extends Barrier {

    public Track(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        if (athlete.getRunLimit() >= size)
            athlete.run(athlete.getClass().getSimpleName() + " успешно пробежал");
        else {
            athlete.leaveCompetition();
            athlete.run(athlete.getClass().getSimpleName() + " не смог пробежать");
        }

    }
}
