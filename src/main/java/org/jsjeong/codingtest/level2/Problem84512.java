package org.jsjeong.codingtest.level2;

import java.util.*;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 *
 */
public class Problem84512 {

    static int cnt = 1;
//    public int solution(String word) {
//
//        HashMap<String, Integer> map = new HashMap<>();
//        permutation(0, "", map);
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < word.length(); i++){
//            char target = word.charAt(i);
//            if(target == 'A') sb.append(0);
//            else if(target == 'E') sb.append(1);
//            else if(target == 'I') sb.append(2);
//            else if(target == 'O') sb.append(3);
//            else if(target == 'U') sb.append(4);
//        }
//        String key = sb.toString();
//        Integer i = map.get(key);
//        return i;
//    }


    public static void permutation(int depth, String cur, HashMap<String, Integer> map){
        if(depth == 5)
            return;

        for(int i = 0; i < 5; i++){
            String next = cur + i;
            map.put(next, cnt);
            cnt++;
            permutation(depth + 1, next, map);
        }
    }

//    public int solution(String word) {
//        int answer = 0;
//        int[] cha = {781,156,31,6,1};
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("A", 0);
//        map.put("E", 1);
//        map.put("I", 2);
//        map.put("O", 3);
//        map.put("U", 4);
//
//        String[] word_arr = word.split("");
//        answer += word_arr.length;
//
//        int k=0;
//        for(int i=0; i<word_arr.length; i++) {
//            answer += cha[k++] * map.get(word_arr[i]);
//        }
//        return answer;
//    }

//    public int solution(String word) {
//        int answer = 0, per = 3905;
//        for(String s : word.split(""))
//            answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
//        return answer;
//    }

    List<String> list = new ArrayList<>();
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
    void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++)
            dfs(str + "AEIOU".charAt(i), len + 1);
    }
}
