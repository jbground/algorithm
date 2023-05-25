package org.jsjeong.algorithm.combination;

/**
 * 조합 알고리즘
 */
public class Combination_Sample1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        boolean[] visited = new boolean[arr.length];

        //1. 백트래킹을 이용해 구현
        System.out.println("-------- 1. 백트래킹 ---------");
        combination1(arr, visited, 0, 3);

        //2. 재귀를 이용해 구현
        System.out.println("\n---------- 2. 재귀 ----------");
        combination2(arr, visited, 0, 3);
    }

    /**
     * 백트래킹을 이용한 방법
     * 시작지점 전달을 통해 for문으로 해당 지점에서부터 새로 시작하는 방식
     * @param arr
     * @param visited
     * @param start
     * @param r
     */
    static void combination1(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                combination1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 재귀 함수를 이용한 방법
     *  - for문을 재귀로 대체
     * @param arr
     * @param visited
     * @param depth
     * @param r
     */
    static void combination2(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            combination2(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            combination2(arr, visited, depth + 1, r);
        }
    }

    public static void combination3(int[] arr, int index, int n, int r, int target) {
        if (r == 0)
            print(arr, index);
        else if (target == n)
            return;
        else {
            arr[index] = target;
            combination3(arr, index + 1, n, r - 1, target + 1);
            combination3(arr, index, n, r, target + 1);
        }
    }

    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
