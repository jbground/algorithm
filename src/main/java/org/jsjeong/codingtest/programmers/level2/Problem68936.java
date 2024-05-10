package org.jsjeong.codingtest.programmers.level2;

public class Problem68936 {

    int[][] arr;
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        this.arr = arr;
        quad(0, 0, arr.length);
        return answer;
    }

    private void quad(int x, int y, int size) {
        if (calculate(x, y, size, arr[x][y])) {//안의 값이 모두 동일 하면 stop
            if (arr[x][y] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
            return; //stop
        }

        int half = size / 2;
        quad(x, y, half); //00
        quad(x, y + half, half); //01
        quad(x + half, y, half); //10
        quad(x + half, y + half, half); //11
    }

    private boolean calculate(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val)
                    return false;
            }
        }
        return true;
    }
}
