package ru.gb.zaripov.homework11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> phoneMap;

    public PhoneBook() {
        phoneMap = new HashMap<>();
    }

    public void add(String phoneNumber, String surname) {
        phoneMap.put(phoneNumber, surname);
    }

    public List<String> get(String surName) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            if (entry.getValue().equals(surName))
                result.add(entry.getKey());
        }
        return result;
    }

    public void printNumberList(String surname) {
        List<String> numberList = get(surname);
        System.out.printf("%d numbers were found by the surname %s:\n", numberList.size(), surname);
        numberList.forEach(System.out::println);

    }
}
