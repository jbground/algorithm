package org.jsjeong.algorithm.dynamic;

import java.util.Scanner;

/**
 * 동적 계획법
 * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다.
 * 만약 총 4계단을 오른다면 그 방법의 수는 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
 * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
 *
 * 피보나치 수열 점화식
 * F(k+1)=F(k)+F(k-1)
 * F(k)=F(k-1)+F(k-2)
 */
public class DynamicStep1 {

    private static int[] dy = new int[7];

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }

    public static void main(String[] args) {
        DynamicStep1 D = new DynamicStep1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+1];
        System.out.println(D.solution(n));
    }
}
