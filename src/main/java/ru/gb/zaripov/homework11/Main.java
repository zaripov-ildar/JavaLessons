package ru.gb.zaripov.homework11;

public class Main {
    public static void main(String[] args) {
//        the first task
        System.out.println("The first task");
        String sentence = "Lorem ipsum dolor sit. Doloribus, debitis? Ipsum! Lorem ipsum dolor sit amet consectetur adipisicing elit";
        String[] words = sentence.split("\\W+");
        FirstTask firstTask = new FirstTask();
        firstTask.countUniqueWords(words);

//        the second task
        System.out.println("\nThe second task");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("789", "Kassad");
        phoneBook.add("456", "Shrike");
        phoneBook.add("123", "Shrike");
        phoneBook.add("147", "Hoyt");
        phoneBook.add("369", "Shrike");
        phoneBook.add("258", "Hoyt");

        phoneBook.printNumberList("Shrike");
        phoneBook.printNumberList("Hoyt");
    }
}
