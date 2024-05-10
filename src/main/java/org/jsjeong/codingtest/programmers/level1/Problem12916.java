package org.jsjeong.codingtest.programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class Problem12916 {

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

}
