package org.jsjeong.algorithm.basic.sort;

import java.util.Arrays;

/**
 * 선택정렬
 *
 */
public class SelectSorting {

    private static int[] arr = {6, 14, 5, 62, 52, 32, 61, 1, 23};

    public int[] solution(int[] arr, int num){
        for (int i = 0; i < arr.length-1; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[idx])
                    idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

    public int[] solution(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectSorting T = new SelectSorting();
        System.out.println(Arrays.toString(arr));
        int[] solution = T.solution(arr);
        System.out.println(Arrays.toString(solution));

    }
}
