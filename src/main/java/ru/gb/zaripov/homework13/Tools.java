package ru.gb.zaripov.homework13;

import java.util.Arrays;

public class Tools {
    // was used to check if many threads calculations are correct
    public static boolean areArraysEqual(float[] firstMethod, float[] secondMethod) {
        if (firstMethod.length != secondMethod.length)
            return false;
        for (int i = 0; i < firstMethod.length; i++) {
            if (firstMethod[i] != secondMethod[i])
                return false;
        }
        return true;
    }

    public static float[] mergeArray(Calculator[] calculators) {
        int size = 0;
        for (Calculator value : calculators) {
            size += value.getArr().length;
        }
        float[] result = new float[size];
        int from = 0;

        for (Calculator calculator : calculators) {
            int to = calculator.getArr().length;
            System.arraycopy(calculator.getArr(), 0, result, from, to);
            from += to;
        }
        return result;
    }

    public static float[] generateArrayFilledBy(int size, float insides) {
        float[] arr = new float[size];
        Arrays.fill(arr, insides);
        return arr;
    }

    public static float formula(float arrElem, float initialArrayIndex) {
        return (float) (arrElem * Math.sin(0.2f + initialArrayIndex / 5) * Math.cos(0.2f + initialArrayIndex
                / 5) * Math.cos(0.4f + initialArrayIndex / 2));
    }
}
