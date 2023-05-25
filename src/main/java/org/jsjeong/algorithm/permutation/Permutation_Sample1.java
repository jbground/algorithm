package org.jsjeong.algorithm.permutation;

/**
 * 순열 알고리즘
 */
public class Permutation_Sample1 {

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        permutation1(arr, output, visited, 0, 3);
        System.out.println();
        permutation2(arr, 0, 3);
    }

    // 사전순으로 순열 구하기
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void permutation1(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation1(arr, output, visited, depth + 1, r);
                visited[i] = false;;
            }
        }
    }

    // 순열 구하기 백트래킹 기법
    // 사용 예시: permutation(arr, 0, 4);
    static void permutation2(int[] arr, int depth, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation2(arr, depth + 1, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
