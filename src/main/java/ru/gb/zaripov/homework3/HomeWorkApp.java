package ru.gb.zaripov.homework3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        task_8(new int[]{1,2,3,4,5},-2);
        task_8(new int[]{1,2,3,4,5},17);
    }

    private static void task_1() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random());
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                arr[i] = 0;
            else arr[i] = 1;
        }
    }

    private static void task_2() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    private static void task_3() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
    }

    private static void task_4() {
        int size = 9;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - 1 - i] = 1;
        }
    }

    private static int[] task_5(int len, int initialValue) {
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = initialValue;
        }
        return result;
    }

    private static void task_6() {
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        int min = arr[0],
                max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max)
                max = arr[i];
            min = Math.min(arr[i], min);
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("Max = %d \t Min = %d", max, min);
    }

    private static boolean task_7(int[] arr) {
        if (arr.length == 1) return false;
        for (int i = 0; i < arr.length; i++) {
            int firstPartialSum = partialSum(arr, 0, i),
                    secondPartialSum = partialSum(arr, i, arr.length);
            if (firstPartialSum == secondPartialSum) return true;
        }
        return false;
    }

    private static int partialSum(int[] arr, int begin, int end) {
        int sum = 0;
        for (int i = begin; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static void task_8(int [] arr, int n){
        int step = simplifyStep(n, arr.length);
        for (int i = 0; i < step; i++) {
            oneStepForward(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int simplifyStep(int n, int len){
//        we don't need to spin our array more than len times so:
        n = n%len;
//        negative direction, when n<0, gives the same result that len+n so
        if (n<0)
            n +=len;
        return n;
    }
    
    private static void oneStepForward(int [] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            int temp2 = arr[i+1];
            arr[i+1] = temp;
            temp = temp2;
        }
        arr[0]=temp;
    }
}
