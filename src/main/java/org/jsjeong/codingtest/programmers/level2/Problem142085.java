package org.jsjeong.codingtest.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142085
 * 재귀로 돌릴 경우 시간복잡도가 너무 높아짐. 시간 초과.
 */
public class Problem142085 {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            queue.add(e);
            answer++;
            n -= e;
            if (n < 0) {
                if(k==0){
                    return answer-1;
                }
                n = n + queue.poll();
                k--;
            }
        }

        return enemy.length;
    }

    static int killed;
    static int result;
    static int total;
//    public int solution(int n, int k, int[] enemy) {
//        total = n;
//        dfs(enemy, 0, 0, k);
//
//        return result;
//    }
//    //적 배열, 라운드, 내가 가진 병사 수, 적을 처리한 수, 무적권 수
//    public void dfs(int[] enemy, int round, int killed, int k){
//        if(killed > total){
//            result = Math.max(round-1, result);
//            return;
//        }
//        if(round == enemy.length){
//            result = round;
//            return;
//        }
//
//        int num = enemy[round];
//        if(k > 0) {//무적권이 남았을 경우 무적권 사용 라운드 진행
//            dfs(enemy, round+1, killed, k-1);
//        }
//        dfs(enemy, round+1, killed+num, k);//무적권 미적용 라운드
//    }
}
