package ru.gb.zaripov.homework13;

import java.util.Arrays;

public class Main {

    private final static int SIZE = 10_000_000;
    private final static int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
//
    }

    private static void firstMethod() {

        float[] arr = generateOnesFilledArray();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = formula(arr[i], i);
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    private static void secondMethod() throws InterruptedException {

        float[] arr = generateOnesFilledArray();

        long startTime = System.currentTimeMillis();

        float[] left = new float[HALF];
        float[] right = new float[HALF];
        System.arraycopy(arr, 0, left, 0, HALF);
        System.arraycopy(arr, HALF, right, 0, HALF);

        for (int i = 0; i < threadsAmount ; i++) {
            new Calculator()

        }

        Calculator calculator1 = new Calculator(left, 0);
        Calculator calculator2 = new Calculator(right, HALF);
        calculator1.start();
        calculator2.start();
        calculator1.join();
        calculator2.join();

        float[] mergedArr = new float[SIZE];
        System.arraycopy(calculator1.getArr(), 0, mergedArr, 0, HALF);
        System.arraycopy(calculator2.getArr(), 0, mergedArr, HALF, HALF);

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    private static float[] generateOnesFilledArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        return arr;
    }

    public static float formula(float arrElem, float i) {
        return (float) (arrElem * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                / 5) * Math.cos(0.4f + i / 2));
    }
}
