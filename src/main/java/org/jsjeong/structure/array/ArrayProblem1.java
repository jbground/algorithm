package org.jsjeong.structure.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArrayProblem1 {

    public int[] solution(int []arr) {

        int p2 = 0;
        int[] answer = {arr[0]};
        for(int num : arr) {
            if (num != answer[p2]) {
                int[] copy = (int[]) Array.newInstance(int.class, answer.length + 1);
                System.arraycopy(answer, 0, copy, 0, answer.length);
                answer = copy;
                answer[++p2] = num;
            }
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
        ArrayProblem1 a = new ArrayProblem1();

        int[] solution = a.solution(arr);
        System.out.println(Arrays.toString(solution));

        long end = System.currentTimeMillis();
        System.out.println(end);

        System.out.println(end - start);

    }


}
