package org.jsjeong.codingtest.level2;

import java.util.*;

public class Problem72411 {

    public static void main(String[] args) {
        Problem72411 problem = new Problem72411();
        problem.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    public String[] solution(String[] orders, int[] course) {
        Set<Character> tmp = new HashSet<>();
        for (String s : orders) {
            for (char c : s.toCharArray()) {
                tmp.add(c);
            }
        }
        char[] alpha = new char[tmp.size()];
        int index = 0;
        for (char c : tmp) {
            alpha[index] = c;
            index++;
        }


        for (int i = 0; i < alpha.length; i++) {
            for (int j = i; j < alpha.length; j++) {

            }
        }

        Map<Character, Integer> rank = new HashMap<>();
        for (String s : orders) {
            for (char c : s.toCharArray()) {

                if (rank.containsKey(c)) {

                    int count = rank.get(c);
                    rank.put(c, ++count);

                } else {
                    rank.put(c, 1);
                }

            }
        }


        String[] answer = {};
        return answer;
    }


    public void createCombination(Map<Character, Integer> rank, int course) {

        for (char key : rank.keySet()) {
            if (rank.get(key) >= course) {

            }
        }
        Map<String, Integer> temp = new HashMap<>();


    }


}
