package org.jsjeong.condigtest.programmers.level1;

import org.jsjeong.codingtest.programmers.level1.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LevelOneTest {

    @Test
    void Problem12915(){
        Problem12915 problem = new Problem12915();
        System.out.println(Arrays.toString(problem.solution(new String[]{"abce", "abcd", "cdx"}, 1)));
    }
    @Test
    void Problem12916(){
        Problem12916 problem = new Problem12916();
        System.out.println(problem.solution("abDHceFa"));
    }
    @Test
    void Problem12926(){
        Problem12926 problem = new Problem12926();
        System.out.println(problem.solution(" . h zZ", 25));
    }


    @Test
    void Problem42576(){
        Problem42576 problem = new Problem42576();
        System.out.println(problem.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }

    @Test
    void Problem42889(){
        Problem42889 problem = new Problem42889();
        System.out.println(Arrays.toString(problem.solution(25, new int[]{4, 3, 2, 5, 1, 2, 6})));
    }

}
