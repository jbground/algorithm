package org.jsjeong.codingtest.programmers.level2;

import java.util.*;

/**
 * 두 큐 합 같게 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 *
 */
public class Problem118667 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int max = queue1.length * 3;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum_q1 = 0;
        long sum_q2 = 0;

        //initialize
        for(int i = 0 ; i< queue1.length; i++){
            sum_q1 += queue1[i];
            q1.add(queue1[i]);

            sum_q2 += queue2[i];
            q2.add(queue2[i]);
        }

        if((sum_q1 + sum_q2) % 2 != 0)
            return -1;

        while(answer <= max){
            if(sum_q1 == sum_q2){
                break;
            }

            if(sum_q1 > sum_q2){
                int poll = q1.peek() != null ? q1.poll() : 0;
                sum_q1 -= poll;
                sum_q2 += poll;
                q2.add(poll);
            }else {
                int poll = q2.peek() != null ? q2.poll() : 0;
                sum_q2 -= poll;
                sum_q1 += poll;
                q1.add(poll);
            }
            answer++;
        }

        return answer > max ? -1 : answer;
    }
}
