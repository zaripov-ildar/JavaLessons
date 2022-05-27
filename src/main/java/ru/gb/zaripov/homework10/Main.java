package ru.gb.zaripov.homework10;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] stringArray = generateIntStringArray(10, 5);
        spoilIntStringArray(stringArray);
        int sum = 0;
        try {
            sum = parseAndSum(stringArray);
        } catch (MyArraySizeException | MyArrayDataException sizeException) {
            System.out.println(sizeException.getMessage());
        }
        System.out.println(sum);
    }

    public static int parseAndSum(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {
        int width = stringArray.length;
        int height = stringArray[0].length;
        if (width != 4 && height != 4) throw new MyArraySizeException(width, height);
        int result = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (stringArray[i][j].matches("-?\\d+?"))
                    result += Integer.parseInt(stringArray[i][j]);
                else
                    throw new MyArrayDataException(i, j);
            }
        }
        return result;
    }

    public static String[][] generateIntStringArray(int width, int height) {
        Random random = new Random();
        String[][] strings = new String[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String num = Integer.toString(random.nextInt(Integer.MAX_VALUE));
                strings[j][i] = num;
            }
        }
        return strings;
    }

    public static void spoilIntStringArray(String[][] strings) {
        Random random = new Random();
        int width = random.nextInt(strings[0].length);
        int height = random.nextInt(strings.length);
        strings[height][width] = "spoiled cell";
    }
}
