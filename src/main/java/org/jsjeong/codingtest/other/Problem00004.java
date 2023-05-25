package org.jsjeong.codingtest.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem00004 {

    public static void solution(int[] heights, int[] weight){
        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            Player player = new Player(heights[i], weight[i]);
            playerList.add(player);
        }

        Collections.sort(playerList);
        int max = Integer.MIN_VALUE;
        for (Player p : playerList) {
            if(p.weight > max){
                max = p.weight;
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        solution(new int[]{172, 183, 180, 170, 181}, new int[]{67, 65, 70, 72, 60});
    }

    static class Player implements Comparable<Player>{
        int height, weight;

        public Player(int height, int weight){
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player player) {
            return player.height - this.height;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Player{");
            sb.append("height=").append(height);
            sb.append(", weight=").append(weight);
            sb.append('}');
            return sb.toString();
        }
    }
}
