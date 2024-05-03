package org.jsjeong.codingtest.level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 교점에 별 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */
public class Problem87377 {

    public String[] solution(int[][] line) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        HashMap<Long, ArrayList<Long>> intersections = new HashMap<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long[] cal = calculate(line[i], line[j]);

                if (cal == null)
                    continue;

                long x = cal[0];
                long y = cal[1];

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);

                if (!intersections.containsKey(y)) {
                    intersections.put(y, new ArrayList<>());
                }

                intersections.get(y).add(x);
            }
        }
        //n n*2+1 ->  n-x
        HashMap<Long, String> result = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> xs;
        for (long i = minY; i <= maxY; i++) {
            sb.setLength(0);
            xs = intersections.getOrDefault(i, null);

            for (long j = minX; j <= maxX; j++) {
                if (xs != null && xs.contains(j)) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }

            result.put(i, sb.toString());
        }

        String[] answer = new String[(int) (maxY - minY + 1)];
        int idx = 0;
        for (long i = maxY; i >= minY; i--) {
            answer[idx++] = result.get(i);
        }

        return answer;
    }

    //Ax + By + E = 0
    //Cx + Dy + F = 0
    //BF-ED/AD-BC = x, EC-AF/AD-BC = y
    public long[] calculate(int[] a, int[] b) {
        long ADBC = ((long) a[0] * b[1]) - ((long) a[1] * b[0]);
        if (ADBC == 0)
            return null;

        long BFED = ((long) a[1] * b[2]) - ((long) a[2] * b[1]);

        if (BFED % ADBC != 0)
            return null;

        long ECAF = ((long) a[2] * b[0]) - ((long) a[0] * b[2]);
        if (ECAF % ADBC != 0)
            return null;

        return new long[]{BFED / ADBC, ECAF / ADBC};

    }
}
