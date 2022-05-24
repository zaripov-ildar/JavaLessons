package ru.gb.zaripov.homework9.interfaceSolution;

public class Wall extends Barrier {

    public Wall(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        if (athlete.getJumpLimit()>= size)
            athlete.jump(athlete.getClass().getSimpleName() + " успешно перепрыгнул");
        else {
            athlete.leaveCompetition();
            athlete.jump(athlete.getClass().getSimpleName() + " не смог перепрыгнуть");
        }

    }
}
