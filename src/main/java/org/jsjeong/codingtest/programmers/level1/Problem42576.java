package org.jsjeong.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Problem42576 {

//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//
//        HashMap<String, Integer> finishers = new HashMap<>();
//
//        for(String finisher : completion) {
//            if(!finishers.containsKey(finisher)) {
//                finishers.put(finisher, 1);
//            } else {
//                finishers.replace(finisher, finishers.get(finisher) + 1);
//            }
//        }
//
//        for(String runner : participant) {
//            if(finishers.containsKey(runner) && finishers.get(runner) != 0) {
//                finishers.replace(runner, finishers.get(runner) - 1);
//            } else {
//                answer = runner;
//                break;
//            }
//        }
//
//        return answer;
//    }

//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (String player : participant)
//            hm.put(player, hm.getOrDefault(player, 0) + 1);
//
//        for (String player : completion)
//            hm.put(player, hm.get(player) - 1);
//
//        for (String key : hm.keySet()) {
//            if (hm.get(key) != 0){
//                answer = key;
//            }
//        }
//        return answer;
//    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length ; i++) {
            map.compute(participant[i], (k, v) -> v != null ? null : 1);
            if (i < completion.length)
                map.compute(completion[i], (k,v) -> v != null ? null : 1);
        }

        return map.keySet().iterator().next();
    }
}
