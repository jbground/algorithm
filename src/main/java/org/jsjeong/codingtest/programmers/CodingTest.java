package org.jsjeong.codingtest.programmers;

public class CodingTest {
    public static void main(String[] args){
        CodingTest t = new CodingTest();

        int[][] board = {{0,1,1,1}
                , {1,1,1,1}
                , {1,1,1,1}
                , {0,0,1,0}};
//        int[][] board = {{0, 0, 1, 0},
//                        {1, 0, 0, 0},
//                        {0, 0, 0, 0},
//                        {0, 0, 0, 0}};
        System.out.println(t.solution(board));
        Math.max(1, 1);
    }

    int[][] board;
    int x_size;
    int y_size;

    public int solution(int[][] board) {


        return 0;
    }

    public int check(int x, int y) {
        int answer = 1;

        return Math.max(board[x][y], answer);
    }
}
