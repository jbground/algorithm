package org.jsjeong.algorithm.basic.sort;

import java.util.Arrays;

/**
 * 삽입정렬
 *
 */
public class InsertSorting {
    private static int[] arr = {6, 14, 5, 62, 52, 32, 61, 1, 23};

    public int[] solution(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >=0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSorting T = new InsertSorting();
        System.out.println(Arrays.toString(arr));
        int[] solution = T.solution(arr);
        System.out.println(Arrays.toString(solution));

    }
}
