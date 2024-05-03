package org.jsjeong.codingtest.programmers;

import java.util.*;

public class Problem123 {

    public static void main(String[] args) {
        String[][] values = {{"100","ryan","music","2"}
            , {"200","apeach","math","2"}
            ,{"300","tube","computer","3"}
            ,{"400","con","computer","4"}
            ,{"500","muzi","music","3"}
            ,{"600","apeach","music","2"}};

        System.out.println(solution(values));

    }

    public static int solution(String[][] relation){
        int answer = 0;
        int[] result = new int[relation[0].length+1];
        Map<Integer, Integer[]> map = new HashMap<>();

        for (int i = 1; i < relation[0].length; i++) {

            map.put(i, duplication(relation, i));


        }

        int column = 1;
        for(Integer[] arr : map.values()){
            if(arr.length == 0){
                return 1;
            }

            for(Integer i : arr){
                result[i]++;
            }
        }

        return answer;
    }

    public static Integer[] duplication(String[][] relation, int column){
        final Set<Integer> result = new HashSet<>();
        for(int i = 0; i < relation.length; i++){
            for(int j=0; j<i;j++){

                if(relation[i][column].equals(relation[j][column])){
                    result.add(i);
                    result.add(j);
                }

            }

        }

        return result.toArray(new Integer[0]);
    }
}
