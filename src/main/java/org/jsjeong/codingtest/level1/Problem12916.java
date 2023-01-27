package org.jsjeong.codingtest.level1;

import java.util.Arrays;

/**
 * 문자열 내 p와 y의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class Problem12916 {
    private static String string = "abDHceFa";

    public boolean solution(String s){

        int count = 0;
        for(char c : s.toCharArray()){
            if(c == 80 || c == 112){
                count++;
            }else if(c == 89 || c == 121){
                count--;
            }
        }
        char[] arr = {'c', 'd'};
        String string1 = new String(arr);
        return count == 0;




    }


    public static void main(String[] args) {
        Problem12916 P = new Problem12916();
        System.out.println(string);
        boolean solution = P.solution(string);
        System.out.println(solution);
    }
}
