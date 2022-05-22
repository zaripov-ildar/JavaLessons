package ru.gb.zaripov.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int appetite) {
        if (appetite < 0)
            throw new ArithmeticException("appetite = " + appetite + ". It can't be < 0");
        if (food >= appetite) {
            food -= appetite;
            return true;
        } else return false;
    }

    public void info() {
        System.out.printf("В тарелке осталось %d еды\n", food);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int addedFood) {
        if (addedFood < 0)
            throw new ArithmeticException("addedFood = " + addedFood + ". It can't be < 0");
        food += addedFood;
    }
}
