package ru.gb.zaripov.homework11;

public class Main {
    public static void main(String[] args) {
//        the first task
        System.out.println("The first task");
        String sentence = "Lorem ipsum dolor sit. Doloribus, debitis? Lorem ipsum dolor sit amet consectetur adipisicing elit";
        String[] words = sentence.split("\\W+");

        FirstTask firstTask = new FirstTask();
        firstTask.printUniqueList(words);
        firstTask.printStatistics(words);

//        the second task
        System.out.println("\nThe second task");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(789, "Kassad");
        phoneBook.add(456, "Shrike");
        phoneBook.add(123, "Shrike");
        phoneBook.add(147, "Hoyt");
        phoneBook.add(369, "Shrike");
        System.out.println(phoneBook.get("Shrike"));
    }
}
