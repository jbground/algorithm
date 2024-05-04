package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;

/**
 *마법의 엘리베이터
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 */
public class Problem148653 {

    static int[] range = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    static int[] count = new int[9];

//    public int solution(int storey) {
//        int answer = 0;
//
//        int n;
//        while (storey != 0) {
//            n = storey % 10;
//
//            if (n >= 6) {
//                storey += 10 - n;
//                answer += 10 - n;
//            } else if (n == 5 && (storey / 10) % 10 >= 5) {
//                storey += 10 - n;
//                answer += 10 - n;
//
//            } else {
//                answer += n;
//            }
//
//            storey = storey / 10;
//        }
//
//        return answer;
//    }

    //dfs로 백트래킹
    static int[] str;
    static int result = Integer.MAX_VALUE;

//    public int solution(int storey) {
//
//        String s = String.valueOf(storey);
//        str = new int[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            str[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
//        }
//        int n = str.length;
//
//        dfs(n - 1, 0, 0);
//
//        return result;
//
//
//    }
//
//    public void dfs(int cursor, int offset, int score) {
//        if (cursor == -1) {
//            result = Math.min(result, score + offset);
//            return;
//        }
//        int num = str[cursor] + offset;
//        dfs(cursor - 1, 0, score + num);
//        dfs(cursor - 1, 1, score + 10 - num);
//    }

    public int solution(int storey) {
        return storey < 10 ? Math.min(storey, 11 - storey) : Math.min(storey % 10 + solution(storey / 10), 10 - storey % 10 + solution(storey / 10 + 1));
    }

}
