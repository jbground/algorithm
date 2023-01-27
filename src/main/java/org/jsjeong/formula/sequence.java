package org.jsjeong.formula;

public class sequence {
    /*
    등차수열 합 공식
    (b - a + 1) * (a + b) / 2
     */
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
