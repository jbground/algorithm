package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;

/**
 * 구명보트
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 투포인터 left right pivot 이용
 */
public class Problem42885 {

    //최대 2명밖에 못타고 무게 제한도 있음
//    public int solution(int[] people, int limit) {
//        int answer = 0;
//
//        //일단 정렬
//        Arrays.sort(people);
//        int left = 0;
//        int right = people.length - 1;
//
//        while (left <= right){
//            if (people[left] + people[right] <= limit){
//                ++left;
//                --right;
//            }else{
//                --right;
//            }
//            ++answer;
//        }
//
//        return answer;
//    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }

}
