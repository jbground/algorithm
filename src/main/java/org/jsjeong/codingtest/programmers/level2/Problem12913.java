package org.jsjeong.codingtest.programmers.level2;


import java.util.Arrays;

/**
 * 땅따먹기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Problem12913 {

   public int solution(int[][] land) {
       int answer = 0;

       int[][] result = new int[land.length + 1][4];

       for(int i = 1; i <= land.length; i++) {
           for(int j = 0; j < 4; j++) {
               for(int k = 0; k < 4; k++) {
                   if(k == j) continue;

                   result[i][j] = Math.max(result[i][j], land[i-1][j] + result[i-1][k]);
               }
           }
       }

       for (int val : result[land.length]) {
           answer = Math.max(answer, val);
       }
       return answer;
    }

}
