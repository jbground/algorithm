package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Problem42746 {

    static long result = 0;


    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }

        Comparator<String> customComparator = (s1, s2) -> {

            while(true) {
                if(s1.length() ==  s2.length())//길이가 같은 문자열
                    return s2.compareTo(s1);

                if(s1.length() <  s2.length()) {
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i))
                            return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                    }
                    s2 = s2.substring(s1.length());
                }else {
                    for (int i = 0; i < s2.length(); i++) {
                        if (s1.charAt(i) != s2.charAt(i))
                            return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                    }
                    s1 = s1.substring(s2.length());
                }
            }
        };

        Arrays.sort(arr, customComparator);
        StringBuilder sb = new StringBuilder();
        for (String item : arr){
            sb.append(item);
        }
        return sb.substring(0, 1).equals("0") ? "0" : sb.toString();
    }

//    public String solution(int[] numbers) {
//        String[] arr = new String[numbers.length];
//        for(int i = 0; i < numbers.length; i++){
//            arr[i] = Integer.toString(numbers[i]);
//        }
//        System.out.println(Arrays.toString(arr));
//
//        permutation(arr, 0);
//
//        return Long.toString(result);
//    }

    private void permutation(String[] arr, int index){
        String s = String.join("", arr);
        result = Math.max(result, Long.parseLong(s));

        for(int i = index; i < arr.length; i++){
            swap(arr, index, i);
            permutation(arr, index+1);
            swap(arr, index, i);
        }
    }

    private void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
