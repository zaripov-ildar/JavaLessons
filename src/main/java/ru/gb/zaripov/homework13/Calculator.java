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
            arr[i] = Tools.formula(arr[i], i + index);
        }
    }

    public float[] getArr() {
        return arr;
    }
}
