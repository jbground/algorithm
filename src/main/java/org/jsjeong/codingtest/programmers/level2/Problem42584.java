package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주식 가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Problem42584 {

//    public int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//
//        Stack<Integer[]> stack = new Stack<>();
//
//        for (int i = 0; i < prices.length; i++) {
//            Integer[] tmp = {prices[i], i};
//
//            if (stack.empty()) {
//                stack.push(tmp);
//                continue;
//            } else {
//                while (stack.peek()[0] > prices[i]) {//가격 안떨어짐
//                    answer[stack.peek()[1]] = i - stack.peek()[1];
//                    stack.pop();
//                    if (stack.empty())
//                        break;
//                }
//            }
//
//            stack.push(tmp);
//        }
//
//        while (!stack.empty()) {
//            answer[stack.peek()[1]] = prices.length - 1 - stack.peek()[1];
//            stack.pop();
//        }
//
//        return answer;
//    }

    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            while (!stack.empty() && prices[i] < prices[stack.peek()]) {

                int idx = stack.pop();
                answer[idx] = i - idx;

            }

            stack.push(i);
        }

        while (!stack.empty()) {
            int idx = stack.pop();
            answer[idx] = len - idx - 1;
        }

        return answer;
    }


//    public int[] solution(int[] prices) {
//        int len = prices.length;
//        int[] answer = new int[len];
//        int i, j;
//        for (i = 0; i < len; i++) {
//            for (j = i + 1; j < len; j++) {
//                answer[i]++;
//                if (prices[i] > prices[j])
//                    break;
//            }
//        }
//        return answer;
//    }

//    public int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            int std = prices[i];
//            int sec = 0;
//
//            for (int j = i + 1; j < prices.length; j++) {
//                int cmp = prices[j];
//                sec++;
//
//                if (std > cmp) {
//                    break;
//                }
//            }
//
//            answer[i] = sec;
//        }
//
//        return answer;
//    }
}
