package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * Stack 활용
 */
public class Problem154539 {
//    public int[] solution(int[] numbers) {
//        int[] answer = new int[numbers.length];
//        Arrays.fill(answer, -1);
//        //i보다 뒤에 있는 숫자 중에서 자신 보다 크면서  i < x  가장 가까이 있는 수를 뒷 큰수
//        //number 는 그대로 유지된 채로 뒷 큰수만 찾아서 입력 해야 함. number <= 1,000,000
//
//        for (int i = numbers.length - 2; i >= 0; i--) {
//            for (int j = i + 1; j < numbers.length; j++) {
//
//                if (numbers[i] < numbers[j]) {
//                    answer[i] = numbers[j];
//                    break;
//                } else if (numbers[i] >= numbers[j]) {
//
//                    if (answer[j] == -1) {
//                        answer[i] = -1;
//                        break;
//                    } else if (numbers[i] < answer[j]) {
//                        answer[i] = answer[j];
//                        break;
//                    }
//
//                }
//            }
//        }
//
//        return answer;
//    }

//    public int[] solution(int[] numbers) {
//        int[] answer = new int[numbers.length];
//        Arrays.fill(answer, -1);
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = numbers.length - 1; i >= 0; i--) {
//
//            while (!stack.empty() && numbers[i] >= stack.peek()) {
//                stack.pop();
//            }
//
//            if (!stack.empty()) {
//                answer[i] = stack.peek();
//            }
//
//            stack.push(numbers[i]);
//        }
//
//        return answer;
//    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < numbers.length; i++){

            while(!s.isEmpty()){
                int idx = s.pop();
                if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때
                    s.push(idx);
                    break;
                }
            }

            s.push(i);
        }

        return answer;
    }
}
