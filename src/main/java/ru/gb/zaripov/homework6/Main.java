package ru.gb.zaripov.homework6;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Tom"),
                new Cat("Princess"),
                new Dog("Beethoven"),
                new Dog("Butch"),
                new Dog("Fang")
        };


        for (Animal animal : animals) {
            animal.run(100);
            animal.swim(20);
        }

        System.out.println("\n*Additional task:");
        System.out.println("Animals amount is " + Animal.getAnimalsAmount());
        System.out.println("Dogs amount is " + Dog.getDogsAmount());
        System.out.println("Cats amount is " + Cat.getCatsAmount());

    }
}
