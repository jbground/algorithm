package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 도넛과 막대 그래프
 * https://school.programmers.co.kr/learn/courses/30/lessons/258711
 */
public class Problem258711 {

    public int[] solution(int[][] edges) {

        int size = 0;
        for (int[] edge : edges) {
            int max = Math.max(edge[0], edge[1]);
            if (max >= size) {
                size = max;
            }
        }

        int[] inArr = new int[size];
        int[] outArr = new int[size];

        for (int[] edge : edges) {
            outArr[edge[0]-1]++;
            inArr[edge[1]-1]++;
        }

        int node = 0;
        int eight = 0;
        int stick = 0;
        for (int i = 0; i < size; i++) {
            if(outArr[i] >= 2) {
                if(inArr[i] == 0) {
                    node = i;
                }else {
                    eight++;
                }
            }else if(outArr[i] == 0 && inArr[i] > 0){
                stick++;
            }

        }

        return new int[]{node+1, outArr[node]-eight-stick, stick, eight};// 정점, 도넛, 막대, 8자
    }

//    HashMap<Integer, int[]> map = new HashMap<>();
//        for (int[] edge : edges) {
//
//        //간선 in count
//        if (!map.containsKey(edge[1])) {
//            map.put(edge[1], new int[2]);
//        }
//        map.get(edge[1])[0] += 1;
//
//        //간선 out count
//        if (!map.containsKey(edge[0])) {
//            map.put(edge[0], new int[2]);
//
//        }
//        map.get(edge[0])[1] += 1;
//
//    }
//
//        for (int node : map.keySet()) {
//        int in = map.get(node)[0];
//        int out = map.get(node)[1];
//
//        if (out == 0) {
//            answer[2] += 1;
//        } else if (out == 2) {
//            if (in > 0) {
//                answer[3] += 1;
//            } else {
//                answer[0] = node;
//            }
//
//        } else if (out > 2) {
//            answer[0] = node;
//        }
//
//
//    }
//    answer[1] = map.get(answer[0])[1] - answer[2] - answer[3];
}
