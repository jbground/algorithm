package org.jsjeong.codingtest.programmers.level4;

import java.util.HashSet;
import java.util.Set;

public class Problem42894 {

    int[][][] types = {{{1, 0}, {1, 1}, {1, 2}}
                    , {{1, 0}, {2, 0}, {2, -1}}
                    , {{1, 0}, {1, -1}, {1, -2}}
                    , {{1, 0}, {2, 0}, {2, 1}}
                    , {{1, 0}, {1, -1}, {1, 1}}
                    , {{0, 1}, {0, 2}, {1, 2}}
                    , {{0, 1}, {1, 0}, {2, 0}}
                    , {{0, 1}, {0, 2}, {1, 0}}
                    , {{0, 1}, {1, 1}, {2, 1}}
                    , {{1, 0}, {1, 1}, {2, 0}}
                    , {{0, 1}, {0, 2}, {1, 1}}
                    , {{1, 0}, {1, -1}, {2, 0}}
                    };

    int[][][] blank = {{{0, 1}, {0, 2}}
                    , {{0, -1}, {1, -2}}
                    , {{0, -1}, {0, -2}}
                    , {{0, 1}, {1, 1}}
                    , {{0, -1}, {0, 1}}
                      };

    int n;
    Set<Integer> closed = new HashSet<>();
    Set<Integer> visited = new HashSet<>();


    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        int number = Integer.MAX_VALUE;

        //맨 윗줄부터 블록 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                //블록 있는 걸 감지 하면 블록 타입 검사
                if(board[i][j] != 0) {

                    //이미 검사한 블록인지 확인
                    if (visited.contains(board[i][j])) {
                        continue;
                    }else{
                        visited.add(board[i][j]);
                    }

                    for (int k = 0; k < types.length; k++) {
                        if(checkType(board, types[k], i, j)){
                            number = k;
                        }
                    }
                }

                if(number > 4) {
                    closed.add(j);
                    for (int[] val : types[number]) {
                        int dy = j + val[1];
                        closed.add(dy);
                    }

                }else{

                    //해당 타입 블록삭제가 가능하면 삭제
                    if (checkBlack(board, blank[number], i, j)) {
                        answer += removeBlock(board, i, j, types[number]);
                    }else{
                        closed.add(j);
                        for (int[] val : types[number]) {
                            int dy = j + val[1];
                            closed.add(dy);
                        }
                    }
                }

//                    if(board[i][j] == name){
//                        continue;
//                    }else{
//                        name = board[i][j];
//                    }
//
//                    int number = checkBlockType(board, i, j, name);
//                    if (number == -1) {
//                        closed.add(j);
//                        continue;
//                    }

                    //4보다 큰 블록은 삭제 불가능 블록


            }
        }

        return answer;
    }

    public boolean checkBlack(int[][] board, int[][] blank, int x, int y){

        for (int[] val : blank) {
            int dx = x + val[0];
            int dy = y + val[1];

            if (closed.contains(dy)) {
                return false;
            }

            if (board[dx][dy] != 0) {
                return false;
            }
        }

        return true;
    }


    public boolean checkType(int[][] board, int[][] type, int x, int y) {
        int name = board[x][y];
        for (int[] var2 : type) {
            int dx = x + var2[0];
            int dy = y + var2[1];

            if (dx < 0 || dx >= n || dy < 0 || dy >= n || board[dx][dy] != name) {
                return false;
            }
        }
        return true;
    }

    public int removeBlock(int[][] board, int x, int y, int[][] coordinate){
        board[x][y] = 0;
        for (int[] val : coordinate) {
            int dx = x + val[0];
            int dy = y + val[1];
            board[dx][dy] = 0;
        }

        return 1;
    }


    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,0,0,0,0,0,0}
                        ,{0,0,0,0,1,0,0,0,0,0}
                        ,{0,0,0,1,1,1,0,0,0,0}};
//        int[][] board = {{0,0,0,0,0,0,0,0,0,0}
//                        ,{0,0,0,0,0,0,0,0,0,0}
//                        ,{0,0,0,0,4,0,0,0,7,7}
//                        ,{0,0,1,4,4,4,0,0,0,7}
//                        ,{0,0,1,0,0,0,6,0,0,7}
//                        ,{0,0,1,1,3,6,6,6,0,0}
//                        ,{0,0,3,3,3,0,0,0,0,0}
//                        ,{0,0,0,2,0,0,0,0,0,0}
//                        ,{1,2,2,2,0,0,0,0,5,0}
//                        ,{1,1,1,0,0,0,5,5,5,0}};



        Problem42894 problem = new Problem42894();
        System.out.println(problem.solution(board));
    }
}
