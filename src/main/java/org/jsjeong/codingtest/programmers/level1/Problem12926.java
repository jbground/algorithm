package org.jsjeong.codingtest.programmers.level1;

/**
 * 시저암호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * 공백 32
 * A 65
 * Z 90
 * a 97
 * z 122
 */
public class Problem12926 {
    private static String string = " . h zZ";

    public String solution(String s, int n) {

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (64 < arr[i] && arr[i] < 91) {
                arr[i] += (char) n;
                if (arr[i] > 90) {
                    arr[i] = (char) (64 + (arr[i] - 90));
                }

            } else if (96 < arr[i] && arr[i] < 123) {
                arr[i] += (char) n;
                if (arr[i] > 122) {
                    arr[i] = (char) (96 + (arr[i] - 122));
                }
            }
        }
        return new String(arr);
    }


    public static void main(String[] args) {
        Problem12926 P = new Problem12926();
        System.out.println(string);
        String solution = P.solution(string, 25);
        System.out.println(solution);
    }
}
