package org.jsjeong.codingtest.programmers.level2;

import java.util.Arrays;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Problem42626 {
    public static void main(String[] args) {

        int i = 15;
        System.out.println(15 / 2);

        int[] scoville = {1, 10, 3, 8, 2, 12};

        System.out.println(solution(scoville, 7));

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        //오름차순 정렬
        Arrays.sort(scoville);

        //검사
        while(true){
            int check = check(scoville, K);
            if(0 < check){ //섞을 수 있음
                answer++; //1회 추가
                combine(scoville, K);
            }
            else if(0 == check){//모두 K 이상임
                return answer;
            }
            else{ //더 이상 섞을 수 없음
                return -1;
            }
        }

    }

    public static int check(int[] scoville, int K){
        //섞을 수 있는 기준은 -1이 아닌 값이 2개 이상일 때
        int count = 0;
        for(int i : scoville){
            if(i != -1)
                count++;
        }

        if(count < 2){
            return -1;
        }


        count = 0;
        for(int i : scoville){

            if(i != -1 && i < K){
                count++;
            }
        }
        return count;

    }

    public static void combine(int[] scoville, int K){

        for(int i = 0; i<scoville.length; i++){
            int item = scoville[i];
            if(item != -1 && K > item){
                scoville[i] = -1;

                if(i+1 == scoville.length){ //더 이상 섞을 게 없을 때
                    break;
                }else{
                    scoville[i+1] = item + scoville[i+1] * 2;
                    Arrays.sort(scoville);
                    return;
                }
            }
        }

    }

}
