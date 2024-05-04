package org.jsjeong.codingtest.other;

/**
 * 피보나치 수열 재귀
 */
public class Problem9 {

    public void solution(int n){
        System.out.println(fibo(n));
    }

    public int fibo(int n){
        if(n < 3)
            return 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }
}
