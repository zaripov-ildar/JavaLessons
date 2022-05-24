package ru.gb.zaripov.homework9.enumSolution;

public enum Athlete {
    CAT(100, 2), HUMAN(3000, 1), ROBOT(5000, 5);

    private final int runLimit;
    private final int jumpLimit;
    private boolean ableToContinue;

    Athlete(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        ableToContinue = true;
    }

    public boolean isAbleToContinue() {
        return ableToContinue;
    }

    public void run(int size) {
        ableToContinue = size <= runLimit;
        System.out.println(this +
                (ableToContinue ? " успешно пробежал" : " не смог пробежать")
        );
    }

    public void jump(int size) {
        ableToContinue = size <= jumpLimit;
        System.out.println(this +
                (ableToContinue ? " успешно перепрыгнул" : " не смог перепрыгнуть")
        );
    }
}
