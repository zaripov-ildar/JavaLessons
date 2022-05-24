package ru.gb.zaripov.homework9;

import ru.gb.zaripov.homework9.Athletes.Athlete;

public class Team {

    private final String name;
    private final Athlete[] athletes;

    public Team(String name, Athlete... athletes) {
        this.name = name;
        this.athletes = athletes;
    }

    public void showResults() {
        System.out.println("\nВ команде " + name + " прошли дистанцию:");
        for (Athlete athlete : athletes) {
            if (athlete.isAbleToContinue())
                System.out.println(athlete);
        }
        System.out.println();
    }

    public void getInfo() {
        System.out.println("\nКоманда " + name + ":");
        for (Athlete athlete : athletes) {
            System.out.println(athlete);
        }
        System.out.println();
    }

    public Athlete[] getAthletes() {
        return athletes;
    }
}
