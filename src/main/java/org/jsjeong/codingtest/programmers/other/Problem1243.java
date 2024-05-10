package org.jsjeong.codingtest.programmers.other;

/**
 * 토마토 문자 찾기
 */
public class Problem1243 {

    public static void main(String[] args) {

        System.out.println(solution("a"));
//        System.out.println(solution("abcdcbaabcdcbaabcdcba"));
//        System.out.println(solution("abcdcba"));



    }

    public static int solution(String s){
        int answer = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int num = check(arr, i);

            if (answer <= num) {
                answer = num;
            }
        }

        return answer;
    }

    public static int check(char[] arr, int criteria){
        int answer = 0;
        int num = 1;
        int prev;
        int next;

        while(true){
            prev = criteria - num;
            next = criteria + num;
            if(prev < 0 || next >= arr.length){ //배열 크기 벗어 났을 때
                return answer;
            }

            if(arr[prev] == arr[next]){
                num++;
                answer += 2;
            }else{
                return answer;
            }
        }
    }

    public static int solution2(int coin, int[] cards){
        int answer = 0;

        return answer;
    }
}
