package ru.gb.zaripov.homework9.interfaceSolution;

public class Cat implements Athlete {

    private boolean ableToContinue;
    private final int runLimit;
    private final int jumpLimit;

    public Cat(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        ableToContinue = true;
    }

    @Override
    public void run(String text) {
        System.out.println(text);
    }

    @Override
    public void jump(String text) {
        System.out.println(text);
    }


    @Override
    public boolean isAbleToContinue() {
        return ableToContinue;
    }

    @Override
    public void leaveCompetition() {
        ableToContinue = false;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

}
