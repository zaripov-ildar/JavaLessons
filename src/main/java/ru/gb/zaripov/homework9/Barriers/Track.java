package ru.gb.zaripov.homework9.Barriers;

import ru.gb.zaripov.homework9.Athletes.Athlete;

public class Track extends Barrier {

    public Track(int size) {
        super(size);
    }

    @Override
    public void cross(Athlete athlete) {
        if (athlete.getRunLimit() >= size)
            athlete.run(athlete + " успешно пробежал");
        else {
            athlete.leaveCompetition();
            athlete.run(athlete + " не смог пробежать");
        }
    }

    @Override
    public String toString() {
        return "Track{" + "size=" + size +
                '}';
    }
}
