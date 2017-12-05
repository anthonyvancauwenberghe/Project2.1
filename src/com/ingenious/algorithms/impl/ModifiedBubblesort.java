package com.ingenious.algorithms.impl;
public class ModifiedBubblesort {

    // logic to sort the elements
    public static int[][] bubble_srt(int array[][])
    {
        int n = array.length;
        int k;

        for (int m = n; m >= 0; m--)
        {
            for (int i = 0; i < n - 1; i++)
            {
                k = i + 1;
                if (array[i][0] > array[k][0])
                {
                    swapNumbers(i, k, array);
                }
            }
        }
        return array;
    }

    private static void swapNumbers(int i, int j, int[][] array) {

        int[] temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}