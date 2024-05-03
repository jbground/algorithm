package org.jsjeong.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayProblem2 {

    public int[] solution(int []arr) {

        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num)
                tempList.add(num);
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i).intValue();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[300000];
        Random r = new Random();
        for (int i = 0; i < 300000; i++) {
            arr[i] = r.nextInt(9);
        }

        long start = System.currentTimeMillis();
        System.out.println(start);
        ArrayProblem2 a = new ArrayProblem2();
        int[] solution = a.solution(arr);
        System.out.println(Arrays.toString(solution));
        long end = System.currentTimeMillis();
        System.out.println(end);

        System.out.println(end - start);
    }

}
