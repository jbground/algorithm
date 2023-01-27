package org.jsjeong.algorithm.expression;


/**
 * 소수 구하기
 * 1과 자기 자신으로 밖에 나눌 수 없는 수
 * 에라토스테네스 체 를 이용한 풀이
 */
public class PrimeNumber {

    private static int n = 5;

    private int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i < n; i++) {
            if(ch[i] == 0){
                answer++;
                for(int j = i; j <= n; j+=i){
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PrimeNumber T = new PrimeNumber();
        System.out.println(n);
        System.out.println(T.solution(n));
    }

}
