package ru.gb.zaripov.homework9;

import ru.gb.zaripov.homework9.enumSolution.Athlete;
import ru.gb.zaripov.homework9.enumSolution.Barrier;
import ru.gb.zaripov.homework9.enumSolution.Track;
import ru.gb.zaripov.homework9.enumSolution.Wall;

public class AppEnum {

    public static void main(String[] args) {
        Barrier[] barriers = {
                new Wall(1),
                new Track(100),
                new Wall(2),
                new Track(500),
                new Wall(3)
        };

        for (Barrier barrier : barriers) {
            for (Athlete athlete : Athlete.values()) {
                if (athlete.isAbleToContinue())
                    barrier.cross(athlete);
            }
            System.out.println();
        }
    }
}
