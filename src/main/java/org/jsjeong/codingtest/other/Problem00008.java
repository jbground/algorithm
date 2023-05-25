package org.jsjeong.codingtest.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * PriorityQueue 사용 문제
 * 기간 안에 강연을 완료하면 강연료를 지급함
 * 단, 하루에 한 개의 강연만 가능함
 * 최대 수익을 낼 수 있는 금액은
 */
public class Problem00008 {

    public static void solution(int[][] arr) {
        Arrays.sort(arr, (t1, t2)-> t2[1] - t1[1]); // 내림차순
//        Arrays.sort(arr, Comparator.comparingInt(a -> a[0])); //오름차순

        PriorityQueue<Integer> possible = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = arr[0][1]; i > 0 ; i--) {
            for (; j < arr.length; j++) {

                if(arr[j][1] < i){
                    break;
                }

                possible.offer(arr[j][0]);

            }
            if(!possible.isEmpty()){
                System.out.println(possible.poll());
            }

        }


    }

    public static void main(String[] args) {
        int[][] arr = {{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}; // {강연료, 기간}
        solution(arr);
    }

    static class Lecture{
        int money, time;

        public Lecture(int[] arr){
            this.money = arr[0];
            this.time = arr[1];
        }
    }
}
