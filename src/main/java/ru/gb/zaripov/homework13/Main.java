package ru.gb.zaripov.homework13;

public class Main {
    private final static int SIZE = 10_000_000;
    private static int THREADS_AMOUNT;

    public static void main(String[] args) throws InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + processors);
        firstMethod();
        for (int i = processors; i < 10000; i += 1000) {
            THREADS_AMOUNT = i;
            secondMethod();
        }
    }

    private static void firstMethod() {

        float[] arr = Tools.generateArrayFilledBy(SIZE, 1.0f);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Tools.formula(arr[i], i);
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    private static void secondMethod() throws InterruptedException {

        float[] arr = Tools.generateArrayFilledBy(SIZE, 1.0f);

        long startTime = System.currentTimeMillis();

        Calculator[] calculators = new Calculator[THREADS_AMOUNT];

        sliceAndStart(calculators, arr);

        for (int i = 0; i < THREADS_AMOUNT; i++) {
            calculators[i].join();
        }

        float[] mergedArray = Tools.mergeArray(calculators);
        System.out.println(THREADS_AMOUNT + " threads time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

    private static void sliceAndStart(Calculator[] calculators, float[] arr) {
        int step = SIZE / THREADS_AMOUNT;
        for (int i = 0; i < THREADS_AMOUNT; i++) {
//         the  last slice can have another length if SIZE divided on THREADS_AMOUNT with remainder so
            int to = i + 1 == THREADS_AMOUNT ? SIZE : (i + 1) * (SIZE / THREADS_AMOUNT);
            int from = i * (SIZE / THREADS_AMOUNT);
            int resultSize = to - from;
            float[] slice = new float[resultSize];
            System.arraycopy(arr, from, slice, 0, resultSize);

            calculators[i] = new Calculator(slice, step * i);
            calculators[i].start();
        }
    }
}
