package org.jsjeong.condigtest.programmers.level2;

import org.jsjeong.codingtest.programmers.level2.Problem49993;
import org.jsjeong.codingtest.programmers.level2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LevelTwoRunnerTest {


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

    @Test
    void Problem12914() {
        Problem12914 problem = new Problem12914();
        System.out.println(problem.solution(4));

    }

    @Test
    void Problem12923(){
        Problem12923 problem = new Problem12923();
//        System.out.println(Arrays.toString(problem.solution(1, 10)));
        System.out.println(Arrays.toString(problem.solution(232412340, 232412345)));

    }

    @Test
    void Problem12913(){
        Problem12913 problem = new Problem12913();
        System.out.println(problem.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }

    @Test
    void Problem12936(){
        Problem12936 problem = new Problem12936();
        System.out.println(Arrays.toString(problem.solution(3, 5)));
    }

    @Test
    void Problem49993(){
        Problem49993 problem = new Problem49993();
        System.out.println(problem.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    @Test
    void Problem159993(){
        Problem159993 problem = new Problem159993();
//        String[] arr = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] arr = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println(problem.solution(arr));

    }

    @Test
    void Problem42746(){
        Problem42746 problem = new Problem42746();
        System.out.println(problem.solution(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    void Problem1835(){
        Problem1835 problem = new Problem1835();
        System.out.println(problem.solution(2, new String[]{"N~F=0", "R~T>2"}));
    }

    @Test
    void Problem17686(){
        Problem17686 problem = new Problem17686();
        System.out.println(Arrays.toString(problem.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    @Test
    void Problem68936(){
        Problem68936 problem = new Problem68936();
        System.out.println(Arrays.toString(problem.solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
    }

    @Test
    void Problem42885(){
        Problem42885 problem = new Problem42885();
        System.out.println(problem.solution(new int[]{70, 50, 80, 50}, 100));
    }

    @Test
    void Problem77485(){
        Problem77485 problem = new Problem77485();
        System.out.println(Arrays.toString(problem.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }

    @Test
    void Problem42577(){
        Problem42577 problem = new Problem42577();
        System.out.println(problem.solution(new String[]{"119", "97674223", "1195524421"}));
    }

    @Test
    void Problem154538(){
        Problem154538 problem = new Problem154538();
        System.out.println(problem.solution(10, 40, 5));

    }

    @Test
    void Problem154539(){
        Problem154539 problem = new Problem154539();
//        System.out.println(Arrays.toString(problem.solution(new int[]{9, 1, 5, 3, 6, 2})));
        System.out.println(Arrays.toString(problem.solution(new int[]{10, 1, 10, 2, 10, 3, 10, 10, 10, 11, 11, 11, 12})));
        int[] answer = {11, 10, 11, 10, 11, 10, 11, 11, 11, 12, 12, 12, -1};
        int[] result = problem.solution(new int[]{10, 1, 10, 2, 10, 3, 10, 10, 10, 11, 11, 11, 12});
        Assertions.assertArrayEquals(answer, result);

    }

    @Test
    void Problem42584(){
        Problem42584 problem = new Problem42584();
        System.out.println(Arrays.toString(problem.solution(new int[]{1, 2, 3, 2, 3})));
    }

    @Test
    void Problem72412(){
        Problem72412 problem = new Problem72412();
        System.out.println(Arrays.toString(problem.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }

    @Test
    void Problem148652(){
        Problem148652 problem = new Problem148652();
        System.out.println(problem.solution(2, 4, 17));

    }

    @Test
    void Problem147354(){
        Problem147354 problem = new Problem147354();
        System.out.println(problem.solution(new int[][]{{2,2,6},{1,5,10},{4,2,9},{3,8,}}, 2, 2, 3));
    }

    @Test
    void Problem138476(){
        Problem138476 problem = new Problem138476();
//        System.out.println(problem.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(problem.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}
