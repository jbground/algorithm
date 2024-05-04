package org.jsjeong.codingtest.programmers.level2;

/**
 * 멀리 뛰기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
public class Problem12914 {


    /**
     * 피보나치 수열 동적계획법 점화식 이용한 방법
     */
    public long solution(int n) {
        long[] memo = new long[2001];
        memo[1] = 1;
        memo[2] = 2;

        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }

        return memo[n];
    }
}
