package org.jsjeong.condigtest.other;

import org.jsjeong.codingtest.other.Problem9;
import org.jsjeong.codingtest.programmers.other.Problem1;
import org.jsjeong.codingtest.programmers.other.Problem123;
import org.jsjeong.codingtest.programmers.other.Problem1234;
import org.jsjeong.codingtest.programmers.other.Problem2;
import org.junit.jupiter.api.Test;

public class OtherRunner {

    @Test
    void Problem1(){
        Problem1 problem = new Problem1();
        System.out.println(problem.solution("abacd"));
    }

    @Test
    void Problem2(){
        Problem2 problem = new Problem2();
        System.out.println(problem.solution("abababab"));
    }
    @Test
    void Problem9(){
        Problem9 problem = new Problem9();
        problem.solution(7);
    }

    @Test
    void Problem1234(){
        Problem1234 problem = new Problem1234();
        System.out.println(problem.solution(455));
    }

    @Test
    void Problem123(){
        Problem123 problem = new Problem123();
        System.out.println(problem.solution(27));
    }

}
