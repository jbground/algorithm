package org.jsjeong.codingtest.programmers.level2;

import javafx.scene.shape.PathElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 순위 검색
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */
public class Problem72412 {

    /**
     * 정규 표현식은 효율성 박살남
     */
//    public int[] solution(String[] info, String[] query) {
//        int[] answer = new int[query.length];
//        Pattern p_query = Pattern.compile("([a-z-]+)\\sand\\s([a-z-]+)\\sand\\s([a-z-]+)\\sand\\s([a-z-]+)\\s([0-9]+)");
//        Pattern p_info = Pattern.compile("([0-9]+)");
//        Matcher m_query = p_query.matcher("");
//        Matcher m_info = p_info.matcher("");
//
//        for(int i = 0 ; i< query.length; i++){
//            m_query.reset(query[i]);
//            m_query.find();
//
//
//            StringBuilder sb = new StringBuilder();
//            for(int n = 1 ; n< 5; n++){
//                if (m_query.group(n).equals("-")){
//                    sb.append("[\\w]+");
//
//                }else{
//                    sb.append(m_query.group(n));
//                }
//                sb.append("\\s");
//            }
//            sb.append("([0-9]+)$");
//            System.out.println(sb);
//
//            Pattern p = Pattern.compile(sb.toString());
//            Matcher matcher = p.matcher("");
//            for (String str : info) {
//                matcher.reset(str);
//                if (matcher.matches()) {
//                    m_info.reset(str);
//                    m_info.find();
//
//                    if(Integer.parseInt(m_info.group(0)) >= Integer.parseInt(m_query.group(5)))
//                        answer[i]++;
//                }
//
//            }
//
//        }
//
//        return answer;
//    }

    static HashMap<String, ArrayList<Integer>> scoreMap;
    static int score;
    static String[] strings;
    static String[] sInfoArr;
    public static int[] solution(String[] info, String[] query) {
        scoreMap = new HashMap<>();

        for (String sInfo : info) {
            strings = new String[4];
            sInfoArr = sInfo.split(" ");
            score = Integer.parseInt(sInfoArr[4]);
            dfs(0);
        }

        for (String key : scoreMap.keySet())
            Collections.sort(scoreMap.get(key));

        int idx = 0;
        int[] answer = new int[query.length];
        for (String q : query) {
            String[] strs = q.split(" and | ");
            String key = strs[0] + strs[1] + strs[2] + strs[3];

            if (!scoreMap.containsKey(key))
                answer[idx++] = 0;
            else {
                ArrayList<Integer> ansList = scoreMap.get(key);
                answer[idx++] = ansList.size() - lowerBound(ansList, Integer.parseInt(strs[4]));
            }
        }
        return answer;
    }

    static void dfs(int lv) {

        if (lv == 4) {
            String str = String.join("", strings);
            if (!scoreMap.containsKey(str))
                scoreMap.put(str, new ArrayList<>());
            scoreMap.get(str).add(score);
        }else {
            strings[lv] = sInfoArr[lv];
            dfs(lv + 1);
            strings[lv] = "-";
            dfs(lv + 1);
        }
    }
    static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
