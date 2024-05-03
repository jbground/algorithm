package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem169198 {

    int horizontal;
    int vertical;

    public static void main(String[] args) {
        int[][] arr = {{7, 7}, {2, 7}, {7, 3}};
        System.out.println(Arrays.toString(solution(10, 10, 3, 7, arr)));
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        List<Integer> result = new ArrayList<>();
        for (int[] target : balls) {
            int targetX = target[0];
            int targetY = target[1];

            int x_down = (int) (Math.pow((targetX - startX), 2) + Math.pow((targetY * startY), 2));
            int x_up = (int) (Math.pow((targetX - startX), 2) + Math.pow((targetY - 2*n + startY), 2));
            int y_left = (int) (Math.pow((targetX + startX), 2) + Math.pow((targetY-startY), 2));
            int y_right = (int) (Math.pow((targetX - 2*m + startX), 2) + Math.pow((targetY - startY), 2));

            if(targetX == startX){
                if(targetY > startY){
                    result.add(Math.min(Math.min(x_down, y_left), y_right));
                }else{
                    result.add(Math.min(Math.min(x_up, y_left), y_right));
                }
            } else if (targetY == startY) {
                if(targetX > startX){
                    result.add(Math.min(Math.min(x_down, x_up), y_left));
                }else{
                    result.add(Math.min(Math.min(x_down, x_up), y_right));
                }
            }else{
                result.add(Math.min(Math.min(Math.min(x_down, x_up), y_right), y_left));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }


}
