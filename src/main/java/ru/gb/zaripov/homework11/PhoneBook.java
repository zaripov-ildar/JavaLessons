package ru.gb.zaripov.homework11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, ArrayList<Integer>> phoneMap;

    public PhoneBook() {
        this.phoneMap = new HashMap<>();
    }

    public void add(int number, String surname) {
        if (phoneMap.containsKey(surname))
            phoneMap.get(surname).add(number);
        else {
            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(number);
            phoneMap.put(surname, numberList);
        }
    }

    public List<Integer> get(String surname) {
        return phoneMap.get(surname);
    }
}
