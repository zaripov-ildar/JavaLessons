package ru.gb.zaripov.homework13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
//
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        int half = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] left = new float[half];
        float[] right = new float[half];
        System.arraycopy(arr, 0, left, 0, half);
        System.arraycopy(arr, half, right, 0, half);

        Calculator calculator1 = new Calculator(left, 0);
        Calculator calculator2 = new Calculator(right, half);
        calculator1.start();
        calculator2.start();
        calculator1.join();
        calculator2.join();
        float[] mergedArr = new float[size];
        System.arraycopy(calculator1.getArr(), 0, mergedArr, 0, half);
        System.arraycopy(calculator2.getArr(), 0, mergedArr, half, half);

        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }
}
