package org.jsjeong.codingtest.programmers.other;

/**
 * https://im-developer.tistory.com/80
 */
public class Problem123 {

    public int solution(long n){
        long count = 0;

//        long p = 1;
//        while(n > p){
//            p *= 5;
//            count += (long) Math.floor((double) n / p);
//        }

        for(int i = 5; i < n; i *= 5){
            count += n / i;
        }

        return (int) count;
    }
}
