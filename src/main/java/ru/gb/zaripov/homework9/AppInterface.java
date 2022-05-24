package ru.gb.zaripov.homework9;

import ru.gb.zaripov.homework9.interfaceSolution.*;

public class AppInterface {
    public static void main(String[] args) {
        Athlete[] athletes = {
                new Cat(100, 2),
                new Human(1000, 1),
                new Robot(5000, 5)
        };

        Barrier[] barriers = {
                new Wall(1),
                new Track(100),
                new Wall(2),
                new Track(500),
                new Wall(3)
        };

        for (Barrier barrier : barriers) {
            for (Athlete athlete : athletes) {
                if (athlete.isAbleToContinue())
                    barrier.cross(athlete);
            }
            System.out.println();
        }

    }
}
