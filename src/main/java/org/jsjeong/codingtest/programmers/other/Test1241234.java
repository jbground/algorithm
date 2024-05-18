package org.jsjeong.codingtest.programmers.other;

import java.util.Arrays;
import java.util.Comparator;

public class Test1241234 {
    public int solution(int[][] scores) {

        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i < scores.length ; i++){
            sum1 += scores[i][0];
            sum2 += scores[i][1];
        }
        System.out.println(Arrays.deepToString(scores));

        int finalSum = sum1;
        int finalSum1 = sum2;

        Comparator<int[]> customComparator = (i1, i2) ->{
            if (finalSum == finalSum1) {

            }
            return 0;
        };

        return 0;
    }
}
