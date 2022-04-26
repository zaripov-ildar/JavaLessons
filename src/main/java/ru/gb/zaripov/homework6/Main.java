package ru.gb.zaripov.homework6;

public class Main {
    public static void main(String[] args) {
        Cat tom = new Cat("Tom");
        Cat princess = new Cat("Princess");
        Dog beethoven = new Dog("Beethoven");
        Dog butch = new Dog("Butch");
        Dog fang = new Dog("Fang");

        tom.run(15);
        princess.swim(10);

        beethoven.run(250);
        butch.swim(15);
        fang.swim(5);

        System.out.println("\n*Additional task:");
        System.out.println("Animals amount is " + Animal.getAnimalsAmount());
        System.out.println("Dogs amount is " + Dog.getDogsAmount());
        System.out.println("Cats amount is " + Cat.getCatsAmount());

    }
}
