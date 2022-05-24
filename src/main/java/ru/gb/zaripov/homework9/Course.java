package ru.gb.zaripov.homework9;

import ru.gb.zaripov.homework9.Athletes.Athlete;
import ru.gb.zaripov.homework9.Barriers.Barrier;

public class Course {
    private final Barrier[] barriers;

    public Course(Barrier... barriers) {
        this.barriers = barriers;
    }

    public void dolt(Team team) {
        for (Barrier barrier : barriers) {
            System.out.println(barrier);
            for (Athlete athlete : team.getAthletes()) {
                if (athlete.isAbleToContinue())
                    barrier.cross(athlete);
            }
            System.out.println();
        }
    }
}
