package org.jsjeong.codingtest.programmers.level2;

/**
 * 숫자 블록
 * https://school.programmers.co.kr/learn/courses/30/lessons/12923
 */
public class Problem12923 {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        //1부터 1_000_000_000 사이의 begin 과 end 사이 블록
        //1 <= begin <= 1_000_000_000
        for (int i = 0; i < answer.length ; i++) {
            long num = begin + i;

            long measure = measure(num);
            if (measure == 0) //소수인 경우
                answer[i] = 1; //약수가 1과 자기자신 밖에 없다.
            else
                answer[i] = (int) measure;

        }

        if (begin == 1)
            answer[0] = 0;
        return answer;
    }

    public long measure(long n) {
        long result = 0;
        for (long div = 2; div <= Math.sqrt(n); div++) { //약수 구하기
            if (n % div == 0) {//약수일 경우
                if (n / div > 10000000){
                    result = div;
                    continue;
                } else{
                    result =  (n / div);
                }
                break;
            }
        }
        return result; //약수 중 자기 자신을 제외한 가장 큰 값
    }
}
