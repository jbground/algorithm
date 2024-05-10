package org.jsjeong.codingtest.programmers.level2;

import java.util.HashSet;

/**
 * 단체 사진 찍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/1835
 *
 */
public class Problem1835 {

    static char[] arr = "ACFJMNRT".toCharArray();

    public int solution(int n, String[] data) {
        int answer =0 ;
        HashSet<String> set = new HashSet<>();
        permutation(arr, 0, set);

        for (String s : set) {

            if(!validate(s, data)){
                continue;
            }

            answer++;

        }


        return answer;
    }

    private boolean validate(String s, String[] data) {
        for (String datum : data) {
            char command = datum.charAt(3);
            char t1 = datum.charAt(0);
            char t2 = datum.charAt(2);
            int abs = Math.abs(s.indexOf(t1) - s.indexOf(t2)) - 1;
            int interval = datum.charAt(4) - '0';

            switch (command) {
                case '=':
                    if (abs != interval)
                        return false;
                    break;
                case '>':
                    if (abs <= interval)
                        return false;
                    break;
                case '<':
                    if (abs >= interval)
                        return false;
                    break;

            }

        }//조건 모두 통과
        return true;
    }

    private void permutation(char[] arr, int idx, HashSet<String> set){
        if(idx == arr.length-1){
            set.add(new String(arr));
        }

        for(int i = idx; i< arr.length ; i++){
            swap(arr, idx, i);
            permutation(arr, idx+1, set);
            swap(arr, idx, i);
        }
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
