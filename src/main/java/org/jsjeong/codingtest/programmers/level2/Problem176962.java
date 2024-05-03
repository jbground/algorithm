package org.jsjeong.codingtest.programmers.level2;

import java.util.*;

public class Problem176962 {

    class Pair {

        String name;
        int remainTime;

        public Pair(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }

    }

    public static int convert(String stringTime) {
        String[] times = stringTime.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList();

        Arrays.sort(plans, (x, y) -> convert(x[1]) - convert(y[1]));
        Stack<Pair> working = new Stack();

        for(int i = 0; i < plans.length; i++) {

            String name = plans[i][0];
            int nowTime = convert(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            //우선적으로는 마지막 타임이었다면, 그냥 답에 추가해주면 된다.
            if (i == plans.length - 1) {
                answer.add(name);
            } else {

                int nextTime = convert(plans[i+1][1]);
                int remainTime = nextTime - nowTime;

                //일단은 방금 들어온 목록을 working에 추가함.
                working.push(new Pair(name, playTime));

                //working에 대해서 순회하고 remain이 0이 라면, 정답에 추가함.
                while (!working.isEmpty() && remainTime > 0) {

                    Pair nowWorking = working.pop(); //최근에 진행했던 공부를 불러옴.
                    int played = Math.min(remainTime, nowWorking.remainTime); //진행한 공부 시간

                    //처리가 가능한 공부인 경우 정답에 추가.
                    if (played == nowWorking.remainTime) {
                        answer.add(nowWorking.name);
                    } else { //아닌 경우는 다시 working 대기열에 공부시간을 차감하여 추가함.
                        working.add(new Pair(nowWorking.name, nowWorking.remainTime - played));
                    }
                    remainTime -= played;
                }
            }

        }

        while (!working.isEmpty()) {
            answer.add(working.pop().name);
        }

        return answer.toArray(new String[]{});
    }
}
