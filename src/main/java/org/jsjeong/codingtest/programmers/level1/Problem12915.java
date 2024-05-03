package org.jsjeong.codingtest.programmers.level1;

import java.util.Arrays;

/**
 * 문자열 내 마음대로 정렬하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class Problem12915 {

//    private static String[] strings = {"sun", "bed", "car"};
    private static String[] strings = {"abce", "abcd", "cdx"};

    public String[] solution(String[] strings, int n){

        for(int i=0; i<strings.length-1;i++){
            for(int j = i + 1; j < strings.length; j++){
                if(compareStrings(strings[i], strings[j], n) > 0){
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;

                }
            }
        }
        return strings;
    }

    /**
     * return
     * 음수 = 오름차순
     * 양수 = 내림차순
     */
    public int compareStrings(String word1, String word2, int n) {

        if(word1.charAt(n) == word2.charAt(n)){
            for(int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
                if((int)word1.charAt(i) != (int)word2.charAt(i))
                    return (int)word1.charAt(i) - (int)word2.charAt(i);
            }

            if(word1.length() != word2.length())
                return word1.length() - word2.length();
            else
                return 0;

        }else{
            return (int)word1.charAt(n) - (int)word2.charAt(n);
        }
    }

    public static void main(String[] args) {
        Problem12915 P = new Problem12915();
        System.out.println(Arrays.toString(strings));
        String[] solution = P.solution(strings, 1);
        System.out.println(Arrays.toString(solution));
    }
}
