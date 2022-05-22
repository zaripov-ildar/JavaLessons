package ru.gb.zaripov.homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        if (appetite < 0)
            throw new ArithmeticException("appetite = " + appetite + ". It can't be < 0");
        if (name.length()<2)
            throw new RuntimeException("name have to contain 3 or more characters");
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate plate) {
        isFull = plate.decreaseFood(appetite);
        if (isFull) {
            System.out.printf("%s съел %d единиц еды\n", name, appetite);
        } else {
            System.out.println("Недостаточно еды для " + name);
        }
    }

    public void catInfo() {
        System.out.println(name +
                (isFull ? " сыт" : " голоден"));
    }
}
