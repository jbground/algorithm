package org.jsjeong.codingtest.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Problem557556 {

//[1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	12
//        [0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]

    public static void main(String[] args) {
        int [] picks = {0, 1, 1};
        String [] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        Problem557556 o = new Problem557556();
        System.out.println(o.solution2(picks, minerals));
    }

    public int solution2(int[] picks, String[] minerals){



        IntStream.range(0, minerals.length).forEach(value -> {
            String s = minerals[value];
        });


//        return IntStream.iterate(0, i -> i <Math.min(minerals.length, Arrays.stream(picks).sum() * 5)>, i -> i + 5)
//                .mapToObj(i -> Arrays.stream(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length)))
//                        .mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1).toArray())
//                .sorted((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum())
//                .mapToInt(arr -> {
//                    int n = picks[0]--> 0 ? 25 : picks[1]--> 0 ? 5 : 1;
//                    return Arrays.stream(arr).map(i -> Math.max(i / n, 1)).sum();
//                }).sum();
        return 0;
    }

    public int solution(int[] picks, String[] minerals) {
        //광물 개수와 곡괭이 개수로 최대 사용 가능한 곡괭이 수 추출
        int answer = 0;

        int max = Math.min((picks[0] + picks[1] + picks[2]) * 5, minerals.length); //최대 채굴 가능 광물 갯수
        int need = max%5 > 0 ? max/5 + 1 : max/5; //모두 캐기 위한 필요 곡괭이 갯수

        List<Integer> arr = new ArrayList<>();

        //다이아곡 적립
        for (int i = 0; i < picks[0]; i++) {
            arr.add(0);
        }//철곡 적립
        for (int i = 0; i < picks[1]; i++) {
            arr.add(1);
        }//돌곡 적립
        for (int i = 0; i < picks[2]; i++) {
            arr.add(2);
        }

        //우선 순위 큐를 이용한 작업 순서 정렬
        PriorityQueue<Group> queue = new PriorityQueue<>();
        Group group = new Group();
        queue.offer(group);
        int num = 1;
        for (int i = 0; i < max; i++) {

            if(num > 5){
                group = new Group();
                queue.offer(group);
                num = 1;
            }
            group.addMineral(minerals[i]);
            num++;
        }

        while (!queue.isEmpty()) {
            Group poll = queue.poll();
            answer += poll.mineByPick(arr.remove(0));
        }

        return answer;
    }

    class Group implements Comparable<Group> {

        int cost;
        ArrayList<String> minerals;

        public Group() {
            minerals = new ArrayList<>();
        }

        public void addMineral(String mineral){
            minerals.add(mineral);
            switch (mineral) {
                case "diamond":
                    cost += 25;
                    break;
                case "iron":
                    cost += 5;
                    break;
                case "stone":
                    cost += 1;
                    break;
            }
        }

        public int mineByPick(int pick) {

            if (pick == 0) //다이아 곡
                return 5;

            if (pick == 2) //돌곡
                return cost;

            //철곡
            int result = 0;
            for (String m : minerals) {
                if (m.equals("diamond")) {
                    result += 5;
                } else {
                    result++;
                }

            }
            return result;
        }

        @Override
        public int compareTo(Group o) {
            return o.cost - this.cost ;
        }
    }
}
