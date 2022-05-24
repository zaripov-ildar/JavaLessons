package ru.gb.zaripov.homework9.Barriers;

import ru.gb.zaripov.homework9.Athletes.Athlete;

public class Wall extends Barrier {

    public Wall(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        if (athlete.getJumpLimit() >= size)
            athlete.jump(athlete + " успешно перепрыгнул");
        else {
            athlete.leaveCompetition();
            athlete.jump(athlete + " не смог перепрыгнуть");
        }

    }

    @Override
    public String toString() {
        return "Wall{" + "size=" + size +
                '}';
    }
}
