package org.jsjeong.codingtest.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem00007 {

    public static void solution(int[][] arr) {
        int answer = 0;
        int cnt = 0;
        List<Wedding> weddingList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            Wedding arrive = new Wedding(arr[i][0], 's');
            weddingList.add(arrive);

            Wedding depart = new Wedding(arr[i][1], 'e');
            weddingList.add(depart);
        }

        Collections.sort(weddingList);
        System.out.println(weddingList);

        for (Wedding w : weddingList) {
            if(w.status == 's'){
                cnt++;
            }else{
                cnt--;
            }

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        int[][] arr = {{14, 18}, {12, 15}, {15, 20}, {20, 30}, {5, 14}};
        solution(arr);

    }

    static class Wedding implements Comparable<Wedding>{
        int time;
        char status;

        public Wedding(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Wedding o) {
            if(o.time == this.time){
                return this.status- o.status;
            }else{
                return this.time - o.time;
            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Wedding{");
            sb.append("time=").append(time);
            sb.append(", status=").append(status);
            sb.append('}');
            return sb.toString();
        }
    }
}
