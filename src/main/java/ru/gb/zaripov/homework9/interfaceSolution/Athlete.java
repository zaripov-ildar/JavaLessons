package ru.gb.zaripov.homework9.interfaceSolution;

public interface Athlete {

    //    в методичке сказанно, что "методы просто выводят информацию о действии в
//консоль"
    void run(String text);

    void jump(String text);

    boolean isAbleToContinue();

    void leaveCompetition();

    int runLimit();

    int jumpLimit();
}
