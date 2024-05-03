package org.jsjeong.algorithm.basic.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 재귀 방식을 이용한 조합
 * n개의 숫자열 중 r개의 숫자열 조합을 리턴함
 */
public class Combination_Sample2 {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        List<int[]> result = makeCombinationList(arr, 3);
        for (int[] ints : result) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        }
    }


    /**
     *
     * @param arr 해당 숫자열
     * @param r 뽑으려는 숫자열 갯수
     * @return
     */
    public static List<int[]> makeCombinationList(int[] arr, int r){
        List<int[]> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        combination(result, arr, visited, 0, arr.length, r);
        return result;
    }

    public static void combination(List<int[]> result, int[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0){
            result.add(makeArr(arr, visited));
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(result, arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;
        combination(result, arr, visited, depth + 1, n, r);

    }

    public static int[] makeArr(int[] arr, boolean[] visited) {
        int[] result = new int[3];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(visited[i]){
                result[cnt++] = arr[i];
            }
        }
        return result;
    }
}
