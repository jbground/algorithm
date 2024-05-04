package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;

/**
 * 줄 서는 방법
 * https://school.programmers.co.kr/learn/courses/30/lessons/12936
 */
public class Problem12936 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        k = k-1;
        int idx = 0;

        for(int i=1; i<=n; i++){
            list.add(i);
        }

        n--;
        while(n != -1){
            long fact = factorial(n);
            int cur = (int) (k / fact);
            answer[idx++] = list.get(cur);
            list.remove(cur);
            k %= fact;
            n--;
        }

        return answer;
    }


    /**
     * 팩토리얼
     */
//    long factorial(long n){
//       if(n == 1){
//           return 1;
//        }
//        return n * factorial(n - 1);
//    }

    /**
     * 팩토리얼
     */
    long factorial(long n){
        long total = 1;

        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}
