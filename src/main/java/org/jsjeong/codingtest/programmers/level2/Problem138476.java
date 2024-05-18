package org.jsjeong.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 귤 고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class Problem138476 {

//    public int solution(int k, int[] tangerine) {
//        int answer = 0;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : tangerine) {
//            if (map.containsKey(i)) {
//                map.put(i, map.get(i) + 1);
//            } else {
//                map.put(i, 1);
//            }
//        }
//
//        ArrayList<Integer> arr = new ArrayList<>(map.values());
//        arr.sort(Collections.reverseOrder());
//        for(int a : arr){
//            answer++;
//            k = k - a;
//            if(k <= 0){
//                break;
//            }
//        }
//
//        return answer;
//    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        for (Integer key : list) {
            k -= map.get(key);
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
