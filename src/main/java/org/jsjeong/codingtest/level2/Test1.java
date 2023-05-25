package org.jsjeong.codingtest.level2;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(solution(2, new String[]{"A~B=0", "A~B>3"}));
    }

    public static int solution(int n, String[] data) {
        List<Condition> conditions = new ArrayList<>();
        for (String str : data) {
            Condition cond = new Condition(str);
            conditions.add(cond);
        }

        Permutation pem = new Permutation(conditions);
        pem.permutation(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}, 0);

        return  pem.getResult();
    }

    static class Permutation{
        int count = 0;
        List<Condition> conditions;

        public Permutation(List<Condition> conditions){
            this.conditions = conditions;
        }


        public void permutation(char[] arr, int depth) {
            if(depth == arr.length){
                boolean flag = true;
                for(Condition cond : conditions){
                    if(!cond.isPossible(arr)){
                        flag = false;
                    }
                }

                if(flag)
                    count++;

                return;
            }

            for(int i = depth; i< arr.length; i++){
                swap(arr, depth, i);
                permutation(arr, depth+1);
                swap(arr, depth, i);
            }
        }

        public static void swap(char[] arr, int depth, int i){
            char temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }

        public int getResult(){
            return count;
        }
    }



    static class Condition {
        char a;
        char b;
        int sign;
        int interval;

        public Condition(String s) {

            char[] arr = s.toCharArray();

            this.a = arr[0];
            this.b = arr[2];

            if (arr[3] == '=') {
                this.sign = 0;
            } else if (arr[3] == '<') {
                this.sign = 1;
            } else if (arr[3] == '>') {
                this.sign = 2;
            }

            this.interval = Integer.parseInt(String.valueOf(arr[4]));
        }

        public boolean isPossible(char[] arr) {
            int num = findInterval(arr);
            switch (sign) {
                case 0: // =
                    return num == interval;
                case 1: // <
                    return num < interval;
                case 2: // >
                    return num > interval;
                default:
                    return false;
            }
        }

        private int findInterval(char[] arr) {
            boolean flag = true;
            int first = 0;
            int second = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == a || arr[i] == b) {
                    if (flag) {
                        first = i;
                        flag = false;
                    } else {
                        second = i;
                    }
                }
            }
            return second - first - 1;
        }
    }
}
