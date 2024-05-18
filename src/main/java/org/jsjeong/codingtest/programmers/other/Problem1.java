package org.jsjeong.codingtest.programmers.other;

/**
 * 최단 회문 구하기
 * KMP 알고리즘
 * https://loosie.tistory.com/192
 */
public class Problem1 {

    public String solution(String str){
        String temp = str + "-" + new StringBuilder(str).reverse();
        int[] table = failure(temp);

        return new StringBuilder(str.substring(table[table.length - 1])).reverse() + str;
    }

    private int[] failure(String str){
        int n = str.length();
        int j = 0;
        int[] arr = new int[n];
        for(int i = 1; i < n; i++){
            while(j > 0 && str.charAt(j) != str.charAt(i)) j = arr[j - 1];
            if(str.charAt(j) == str.charAt(i)) arr[i] = ++j;

        }
        return arr;
    }
}
