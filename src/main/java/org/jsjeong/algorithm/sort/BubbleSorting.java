package org.jsjeong.algorithm.sort;

import java.util.Arrays;

/**
 * 버블정렬
 *
 */
public class BubbleSorting {
    private static int[] arr = {6, 14, 5, 62, 52, 32, 61, 1, 23};

    public int[] solution(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSorting T = new BubbleSorting();
        System.out.println(Arrays.toString(arr));
        int[] solution = T.solution(arr);
        System.out.println(Arrays.toString(solution));

    }
}
