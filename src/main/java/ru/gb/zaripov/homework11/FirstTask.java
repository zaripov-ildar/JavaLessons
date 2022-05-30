package ru.gb.zaripov.homework11;

import java.util.*;

public class FirstTask {

    public void countUniqueWords(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (wordMap.containsKey(word))
                wordMap.put(word, wordMap.get(word) + 1);
            else
                wordMap.put(word, 1);
        }
        System.out.println(wordMap);

    }
}
