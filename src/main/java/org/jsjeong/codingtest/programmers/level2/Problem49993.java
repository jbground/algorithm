package org.jsjeong.codingtest.programmers.level2;

/**
 * 스킬트리
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */
public class Problem49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String s : skill_trees){
            String format = "[^" + skill +"]";
            String s1 = s.replaceAll(format, "");
            if (skill.indexOf(s1) == 0){
                answer++;
            }

        }

        return answer;
    }

}

