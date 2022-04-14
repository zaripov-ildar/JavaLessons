package ru.gb.zaripov.homework2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(isYearLeap(1900));
        System.out.println(isYearLeap(1600));
        System.out.println(isYearLeap(32));
    }

    private static boolean isSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void checkNumberSign(int num) {
        String sign = num >= 0 ? "положительное" : "отрицательное";
        System.out.println("Число " + sign);
    }

    private static boolean isNumberNegative(int num) {
        return num < 0;
    }

    private static void printWordManyTimes(String str, int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.println(str);
        }
    }

    private static boolean isYearLeap(int year) {
        boolean div4 = year % 4 == 0;
        boolean div100 = year % 100 != 0;
        boolean div400 = year % 400 == 0;
        return div4 && (div100 ^ div400);
    }
}

