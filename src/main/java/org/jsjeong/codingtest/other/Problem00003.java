package org.jsjeong.codingtest.other;

/**
 * 최대 점수 구하기(DFS)
 */
public class Problem00003 {
    static int answer = 0;
    static int total = 0;
    static boolean flag = false;

    public static void solution(int depth, int sum, int[] arr) {
        if(sum > total) return;

        if (depth == arr.length) {
            answer = Math.max(answer, sum);

        }else{
            solution(depth + 1, sum + arr[depth], arr);
            solution(depth + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {81, 58, 42, 33, 61};
        total = 259;
        solution(0, 0, arr);
        System.out.println(answer);

    }
}
