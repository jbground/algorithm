package org.jsjeong.codingtest.level2;

import org.jsjeong.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem181188 {

    public static void main(String[] args) {
        int[][] arr = {{0, 5}, {4, 8},  {10, 14},  {11, 13},  {5, 12},  {3, 7},  {1, 4}, {4,5}, {11, 15}, {12, 13}};
        solution(arr);

    }

    public static void solution(int[][] arr){
        int answer = 0;
        List<Missile> missileList = new ArrayList<>();

        for (int[] ints : arr) {
            Missile missile = new Missile(ints);
            missileList.add(missile);
        }

        Collections.sort(missileList);
        System.out.println(missileList);

        int e = 0;
        for (Missile missile : missileList) {

            if(missile.start < e){
                e = Math.min(e, missile.end);
            }else{
                answer++;
                e = missile.end;
            }

        }

        System.out.println(answer);
    }



    static class Missile implements Comparable<Missile>{

        int start, end;

        public Missile(int[] arr){
            this.start = arr[0];
            this.end = arr[1];
        }

        @Override
        public int compareTo(Missile o) {
            if(this.start == o.start){
                return this.end - o.end;
            }else{
                return this.start - o.start;
            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Missile{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }
}
