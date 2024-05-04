package org.jsjeong.codingtest.programmers.level2;

import java.util.HashSet;

/**
 * 소수 찾기
 * 완전 탐색, Brute-Force알고리즘, 재귀 호출 permutations(순열)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Problem42839 {

    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        int count = 0;

        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 순열 재귀
     */
    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);

        if (!"".equals(prefix))//처음 입력 제외하고 add
            set.add(Integer.parseInt(prefix));

        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);

    }

    /**
     * 소수 인지 검사
     * %2 는 한 번만 수행 하고
     * 홀수만 Math.sqrt(n) 까지 나머지 검사 방법
     * O(n/2)
     *
     * a % 2 != 0 && isPrime(a) 이 선행되어야 함.
     */
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    /**
     * 홀수 검사와 짝수 검사 계속 진행
     * O(n)
     */
    private boolean isPrime2(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

//    public int solution(String numbers) {
//        int answer = 0;
//
//        int[] arr = new int[10]; //numbers[i]의 범위는 0~9 까지
//        //initialize
//        String[] split = numbers.split("");
//        for (String s : split) {
//            arr[Integer.parseInt(s)]++;
//        }
//        for(int i = 2; i < 1000000; i ++){
//            if (isPrime(i) && isContains(arr, i)){
//                answer++;
//            }
//        }
//
//        return answer;
//    }

    public boolean isContains(int[] arr, int num) {
        int[] temp = arr.clone();

        while (num > 0) {
            if (temp[num % 10] == 0) {
                return false;
            }
            temp[num % 10]--;
            num /= 10;
        }
        return true;
    }


}
