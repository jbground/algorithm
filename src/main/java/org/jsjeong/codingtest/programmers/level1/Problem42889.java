package org.jsjeong.codingtest.programmers.level1;

import java.util.*;

public class Problem42889 {

    private static int[] stages = {4,3,2,5,1,2,6};

    public int[] solution(int N, int[] stages) {

        List<Stage> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            Stage stage = new Stage(i);

            boolean flag = true;

            while (flag){


            }
            for(int num : stages){

                if(num % N == 1){
                    continue;
                } else if (num > i) {
                    stage.clear++;
                }
            }
        }

        return new int[1];
    }

//    public int[] solution(int N, int[] stages) {
//
//        int[] clear = new int[N];
//        int[] current = new int[N];
//
//        for(int i = 0; i < stages.length; i++){
//            for (int num = 0; num < stages[i]; num++) {
//
//                if(num == stages[i]){
//                    current[num]++;
//                }else{
//                    clear[num]++;
//                }
//            }
//        }
//
//        return new int[1];
//    }

    public static void main(String[] args) {
        Problem42889 P = new Problem42889();
        System.out.println(stages);
        int[] solution = P.solution(25, stages);
        System.out.println(Arrays.toString(solution));
    }


    static class Stage implements Comparable{
        int num;
        int clear;
        int current;
        long failure;

        public Stage(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

}
