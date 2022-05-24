package ru.gb.zaripov.homework9;

import ru.gb.zaripov.homework9.Athletes.Cat;
import ru.gb.zaripov.homework9.Athletes.Human;
import ru.gb.zaripov.homework9.Athletes.Robot;
import ru.gb.zaripov.homework9.Barriers.Track;
import ru.gb.zaripov.homework9.Barriers.Wall;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(
                new Wall(1),
                new Track(100),
                new Wall(2),
                new Track(500),
                new Wall(3)
        );

        Team team = new Team("DreamTeam",
                new Cat(100, 2),
                new Human(1000, 1),
                new Robot(5000, 5),
                new Cat(200, 3)
        );

        team.getInfo();
        course.dolt(team);
        team.showResults();
    }
}
