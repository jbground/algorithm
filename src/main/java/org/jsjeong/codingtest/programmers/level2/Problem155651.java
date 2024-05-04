package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * 호텔 대실
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651#qna
 */
public class Problem155651 {

    public int solution(String[][] book_time) {
        int answer = 0;

        ArrayList<int[]> list = new ArrayList<>();
        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].substring(0, 2)) * 60 + Integer.parseInt(time[0].substring(3));
            int end = Integer.parseInt(time[1].substring(0, 2)) * 60 + Integer.parseInt(time[1].substring(3));
            list.add(new int[]{start, end});
        }
        list.sort(Comparator.comparingInt((int[] o) -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int[] time : list) {
            int reserveTime = time[0];
            int endTime = time[1];

            if (queue.isEmpty() && answer == 0) {//최초 입실
                queue.offer(endTime);
                answer++;

            }else{
                Integer peek = queue.peek();
                if (peek + 10 > reserveTime) { //퇴실 시간 + 청소 시간 보다 이를 경우 방 추가
                    answer++;
                    queue.offer(endTime);
                }else{ // 퇴실 시간 + 청소 시간 이후 예약은 방 그대로
                    queue.poll();
                    queue.offer(endTime);
                }
            }
        }


        return answer;
    }
}
