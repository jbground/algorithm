package org.jsjeong.codingtest.other.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_1 {

    /*
     0,0 0,1 0,2 0,3 0,4 0,5
     1,0 1,1 1,2 1,3 1,4 1,5
     2,0 2,1 2,2 2,3 2,4 2,5
     3,0 3,1 3,2 3,3 3,4 3,5

    */
    static int[] dx={-1, 0, 1, 0}; //x 좌표 증가 감소
    static int[] dy={0, 1, 0, -1}; //y 좌표 증가 감소

    static int[][] dis;

    public static int solution(int[][] arr) {
        int answer = 0;

        Queue<Point> queue = new LinkedList<>();
        dis = new int[arr.length][arr[0].length]; //경로 저장 배열

        for(int i=0; i<arr.length; i++){
            for (int j = 0; j < arr[0].length; j++) {

                if(arr[i][j] == 1){
                    queue.offer(new Point(i, j)); //시작 지점 등록
                }
            }
        }

        bfs(queue, arr);

        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==0) {
                    flag = false;
                }
            }
        }

        if(flag){
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

        return answer;
    }

    public static void bfs(Queue<Point> queue, int[][] arr){
        while(!queue.isEmpty()){
            Point tmp = queue.poll();

            /*
            0 : x-1, y 위

            1 : x, y+1 오른쪽

            2 : x+1, y 밑

            3 : x, y-1 왼쪽
             */
            for (int i = 0; i < 4; i++) { // 동서남북 4방향 진행
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length){ // 배열 범위를 벗어나지 않고
                    if(arr[nx][ny] == 0){ // 해당 좌표 값이 0일때
                        arr[nx][ny] = 1;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1; //시작 지점에서 [tmp.x][tmp.y] 지점까지 오는 거리 + [nx][ny]으로 가는 거리 : 1

                        queue.offer(new Point(nx, ny)); //다음 진행 항목으로 추가
                    }

                }
            }
        }
    }


    static class Point{
        public int x, y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    public static void main(String[] args) {
        int[][] arr ={{0, 0, -1, 0, 0, 0},
                      {0, 0, 1 ,0 ,-1, 0},
                      {0, 0, -1, 0, 0, 0},
                      {0, 0, 0 ,0 ,-1, 1}};

        solution(arr);
    }
}
