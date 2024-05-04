package org.jsjeong.codingtest.programmers.level2;

import java.util.*;


/**
 * 광물 캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * dia = dia 1, iron 1, stone 1
 * iron = dia 5, iron 1, stone 1
 * stone = dia 25, iron 5, stone 1
 */
public class Problem172927 {

    public static void main(String[] args) {
        int[] picks = {1, 1, 0}; // dia, iron, stone 갯수
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone", "iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond"};
        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        //채굴가능한 광물 수
        int total = Math.min((picks[0]+picks[1]+picks[2])*5, minerals.length);

        int length = total % 5 == 0 ? total / 5 : (total / 5) + 1;
        Queue<String> queue = makePickQueue(picks);



        int[] cost = new int[length];
        String[] order = new String[length];
        int n = 0;

        for (int i = 0; i < total; i++) {

            if("diamond".equals(minerals[i])){
                cost[n] += 25;
            }else if("iron".equals(minerals[i])){
                cost[n] += 5;
            }else {
                cost[n] += 1;
            }

            if((i+1) % 5 == 0){
                n++;
            }
        }

        for(int j = 0; j<cost.length; j++){
            int max = 0;
            int v = 0;
            for (int i = 0; i < cost.length; i++) {

                if(max < cost[i]){
                    max = cost[i];
                    v = i;
                }
            }
            order[v] = queue.poll();
            cost[v] = -1;
        }


        n = 0;
        for (int i = 0; i < total; i++) {

            if(order[n] == null){
                return answer;
            }

            if("diamond".equals(order[n])){
                answer += 1;
            }else if("iron".equals(order[n])){
                if("diamond".equals(minerals[i])){
                    answer += 5;
                }else{
                    answer += 1;
                }
            }else {
                if("diamond".equals(minerals[i])){
                    answer += 25;
                }else if("iron".equals(minerals[i])){
                    answer += 5;
                }else{
                    answer += 1;
                }
            }

            if((i+1) % 5 == 0){
                n++;
            }
        }

        return answer;
    }

    private static Queue<String> makePickQueue(int[] picks) {
        Queue<String> result = new PriorityQueue<>();

        int cnt = 0;

        for (int i = 0; i < picks[0]; i++) {
            result.offer("diamond");
        }

        for (int i = 0; i < picks[1]; i++) {
            result.offer("iron");
        }

        for (int i = 0; i < picks[2]; i++) {
            result.offer("stone");
        }

        return result;
    }




}
