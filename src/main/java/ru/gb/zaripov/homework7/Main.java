package ru.gb.zaripov.homework7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Мурзик", 15),
                new Cat("Вальдемар", 10),
                new Cat("Китти", 30),
                new Cat("Джесси", 7)
        };

        Plate plate = new Plate(50);
        System.out.printf("В тарелке %d единиц еды\n\n", plate.getFood());

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.catInfo();
            plate.info();
            System.out.println();
        }
    }
}
