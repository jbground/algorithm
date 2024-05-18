package org.jsjeong.condigtest;

import org.jsjeong.codingtest.programmers.other.Test1241252;
import org.jsjeong.codingtest.programmers.other.Test1241234;
import org.jsjeong.codingtest.programmers.other.Test4123124;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestRunner {

    @Test
    void test1(){
        Test1241252 test = new Test1241252();
        String[] data = new String[2];
        System.out.println(Arrays.deepToString(test.solution(new int[][]{{1, 0}, {0, 1}}, 2)));
    }
    @Test
    void test2(){
        Test1241234 test = new Test1241234();
        String[] data = new String[2];
    }
    @Test
    void test3(){
        Test4123124 test = new Test4123124();
        String[] data = new String[2];
        System.out.println(test.solution(data));
    }

}
