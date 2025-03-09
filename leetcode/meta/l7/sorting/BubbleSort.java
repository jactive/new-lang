package leetcode.meta.l7.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 8, 2, 4, 9};
        for (int i = 0; i < array.length; i++) {
            // GoOver j < array.length - i - 1
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
