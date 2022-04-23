package ru.gb.zaripov.homework5;

public class Person {
    private String name;
    private String post;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String name, String post, String email, String phone, double salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("name: " + name);
        System.out.println("post: " + post);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("salary: " + salary);
        System.out.println("age: " + age);
        System.out.println("__________________________");
    }

    public int getAge() {
        return age;
    }
}
