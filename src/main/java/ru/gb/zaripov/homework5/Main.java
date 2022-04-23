package ru.gb.zaripov.homework5;

public class Main {
    public static void main(String[] args) {
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30_000, 30);
        personArray[1] = new Person("Petr Petrov", "Project manager", "petpetr@mailbox.com", "892312313", 55_000, 55);
        personArray[2] = new Person("Sidor Sidorov", "HR", "sisidr@mailbox.com", "892312314", 43_000, 43);
        personArray[3] = new Person("Olga Ololoeva", "Security service", "ololo@mailbox.com", "911", 100_000, 25);
        personArray[4] = new Person("Magripa Haripulaevna", "Top manager", "grgrgrgr@mailbox.com", "892312314", 50_0000, 18);
        for (Person person : personArray) {
            if (person.getAge() > 40)
                person.printInfo();
        }
    }
}
