package ru.gb.zaripov.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int hungerLevel) {
//в проверке нет необходимости т.к. кот не будет есть если
//ему мало, но такое задание
        if (food >= hungerLevel)
            food -= hungerLevel;
    }

    public void info() {
        System.out.printf("В тарелке осталось %d еды\n",food);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int i) {
        food += i;
    }
}
