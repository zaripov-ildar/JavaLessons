package ru.gb.zaripov.homework13;

public class Calculator extends Thread {
    private final float[] arr;
    private final int index;

    public Calculator(float[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            int foo = index + i;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + foo / 5) * Math.cos(0.2f + foo
                    / 5) * Math.cos(0.4f + foo / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }
}
