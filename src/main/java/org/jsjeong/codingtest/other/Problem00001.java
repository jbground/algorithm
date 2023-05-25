package org.jsjeong.codingtest.other;

/**
 * 합이 같은 부분집합(DFS)
 */
public class Problem00001 {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    public static void solution(int depth, int sum, int[] arr) {
        if (flag) return;
        if(sum > total/2) return;
        if (depth == arr.length) {
            if (total / 2 == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            solution(depth + 1, sum + arr[depth], arr);
            solution(depth + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 15, 27, 42, 64};
        for (int i : arr) {
            total += i;
        }

        solution(0, 0, arr);
        System.out.println(answer);

    }
}
