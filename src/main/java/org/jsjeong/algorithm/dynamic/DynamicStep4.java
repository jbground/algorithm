package org.jsjeong.algorithm.dynamic;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래
 * 에서 위로 쌓으면서 만들어 간다. 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프
 * 로그램을 작성하시오.
 * (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 * (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 * (조건3) 벽돌들의 높이는 같을 수도 있다.
 * (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 * (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 */
public class DynamicStep4 {

    private static int[] arr;
    private static int[] dy;


    public int solution(List<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Body ob : arr) {
            if (ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }
        java.lang.String s  = "fsad";
        for (char c : s.toCharArray()){
            String sss = String.valueOf(c);

        }


        return cnt;

    }

    public static void main(String[] args) {
        DynamicStep4 D = new DynamicStep4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        List<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            arr.add(new Body(h, w));
        }

        System.out.println(D.solution(arr, n));
    }

    public static class Body implements Comparable<Body> {

        public int h, w;

        Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) {
            return o.h - this.h;
        }
    }
}
