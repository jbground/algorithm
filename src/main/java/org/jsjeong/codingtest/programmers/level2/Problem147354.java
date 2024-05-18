package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;

/**
 * 테이블 해시 함수
 * https://school.programmers.co.kr/learn/courses/30/lessons/147354
 */
public class Problem147354 {

    //행렬의 열은 컬럼, 행은 튜플
    //첫 번째 컬럼 = 첫 번째 열 중복되지 않도록 보장,
    //테이블의 튜플을 col 번째 컬럼의 값을 기준으로 오름차순 정렬, 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순
    //정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합으로 정의
    //i인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시값으로서 반환합니다.
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data,  (o1, o2) -> {
            if(o1[col-1]==o2[col-1]){
                return o2[0]-o1[0];
            }
            return o1[col-1] - o2[col-1];
        });

        for (int i = row_begin-1; i < row_end; i++) {

            int finalI = i + 1;
            int dataTotal = Arrays.stream(data[i])
                    .map(j -> j % finalI)
                    .sum();

            // 4. XOR한 값 저장
            answer = (answer ^ dataTotal);
        }

        return answer;
    }
}
