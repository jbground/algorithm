package org.jsjeong.codingtest.programmers.level2;

/**
 * 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */
public class Problem77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = new int[rows+1][columns+1];
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <=columns; j++){
                matrix[i][j] = j + (columns * (i-1));
            }
        }

        for (int i = 0; i < queries.length; i++) {
            //회전 + 가장 작은 값 리턴
            answer[i] = rotation(matrix, queries[i]);
        }

        return answer;
    }

    public int rotation(int[][] matrix, int[] query){
        int left = query[1];
        int right = query[3];
        int top = query[0];
        int bottom = query[2];
        int firstNum = matrix[top][right];
        int min = firstNum;

        // 위 이동
        for (int i=top; i<=top; i++) {
            for (int j=right; j>left; j--) {
                matrix[i][j] = matrix[i][j-1];
                min = Math.min(matrix[i][j], min);
            }
        }

        // 좌 이동
        for (int i=top; i<bottom; i++) {
            for (int j=left; j<=left; j++) {
                matrix[i][j] = matrix[i+1][j];
                min = Math.min(matrix[i][j], min);
            }
        }

        // 아래 이동
        for (int i=bottom; i<=bottom; i++) {
            for (int j=left; j<right; j++) {
                matrix[i][j] = matrix[i][j+1];
                min = Math.min(matrix[i][j], min);
            }
        }

        // 우 이동
        for (int i=bottom; i>top+1; i--) {
            for (int j=right; j<=right; j++) {
                matrix[i][j] = matrix[i-1][j];
                min = Math.min(matrix[i][j], min);
            }
        }

        // 끼워넣기
        matrix[top+1][right] = firstNum;
        min = Math.min(firstNum, min);

        return min;
    }
}
