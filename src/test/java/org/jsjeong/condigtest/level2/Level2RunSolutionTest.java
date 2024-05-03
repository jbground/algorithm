package org.jsjeong.condigtest.level2;

import org.jsjeong.codingtest.level2.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Level2RunSolutionTest {


    @Test
    void testProblem258711() {
        Problem258711 problem = new Problem258711();

//        int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        System.out.println(Arrays.toString(problem.solution(edges)));

    }

    @Test
    void testProblem155651() {
        Problem155651 problem = new Problem155651();
        String[][] data = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int solution = problem.solution(data);
        System.out.println(solution);

    }

    @Test
    void Problem176962() {
        Problem176962 problem = new Problem176962();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] solution = problem.solution(plans);
        System.out.println(Arrays.toString(solution));

    }

    @Test
    void Problem169199() {
        Problem169199 problem = new Problem169199();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int i = problem.solution(board);
        System.out.println(i);
    }

    @Test
    void Problem154540() {
        Problem154540 problem = new Problem154540();
        String[] board = {"X591X", "X1X5X", "X231X", "1XXX1"};
        int[] solution = problem.solution(board);

        System.out.println(Arrays.toString(solution));

    }

    @Test
    void Problem152996() {
        Problem152996 problem = new Problem152996();
        int[] weights = {100, 180, 360, 100, 270};
        long solution = problem.solution(weights);
        System.out.println(solution);

    }

    @Test
    void Problem148653(){
        Problem148653 problem = new Problem148653();
//        int storey = 2554;
        int storey = 999;
//        int storey = 678;
        int solution = problem.solution(storey);
        System.out.println(solution);
    }

    @Test
    void Problem142085(){
        Problem142085 problem = new Problem142085();
//        int solution = problem.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
//        System.out.println(solution);
//        System.out.println(problem.solution(10, 3, new int[]{12, 11, 4, 2, 1, 5, 8, 6, 7}));
//        System.out.println(problem.solution(1, 6, new int[]{2, 2, 2, 2, 3, 3, 1}));
        System.out.println(problem.solution(10, 2, new int[]{5, 5, 5, 5, 5}));

    }

    @Test
    void Problem87377(){
        Problem87377 problem = new Problem87377();
        int[][] line = {{2, -1, 4},{-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(problem.solution(line)));
    }

    @Test
    void Problem42839(){
        Problem42839 problem = new Problem42839();
        System.out.println(problem.solution("1743"));
    }

    @Test
    void Problem87946(){
        Problem87946 problem = new Problem87946();
        System.out.println(problem.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    @Test
    void Problem84512(){
        Problem84512 problem = new Problem84512();
//        System.out.println(problem.solution("AAAAE"));
        System.out.println(problem.solution("EIO"));

    }
}
