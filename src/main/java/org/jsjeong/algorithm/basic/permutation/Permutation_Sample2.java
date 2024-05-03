package org.jsjeong.algorithm.basic.permutation;

import java.util.Arrays;

public class Permutation_Sample2 {

    static boolean[] visited;
    static int[] input;
    public static void main(String[] args) {
        solution(new int[]{6, 4, 5, 2, 1, 3});
    }
    //입력 받은 배열에서 n의 크기만큼 조합 출력
    private static void solution(int[] ints) {
        visited = new boolean[ints.length];
        input = new int[ints.length];
//        dfs(0, ints, 3);

    }

    private static void dfs(int start, int max) {
//        if (target.length == max) {
//            System.out.println(Arrays.toString(target));
//            return;
//        }
//
//        for(int i = max ; i < ints.length; i++){
//            dfs();
//        }
    }

}
