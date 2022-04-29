package ru.gb.zaripov.homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            isFull = true;
        }
    }

    public void catInfo(){
        System.out.println(name +
                (isFull?" сыт":" голоден"));
    }
}
