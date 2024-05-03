package org.jsjeong.graph.example;

import java.util.ArrayList;

public class GraphExample {

    int[][] ex1 = {{1, 2}
            , {1, 3}
            , {2, 3}
            , {2, 4}
            , {3, 4}
            , {4, 5}
            , {5, 6}
            , {5, 7}
            , {6, 7}};

    int[][] ex2 = {{1, 0, 1, 1, 1, 1}
            , {1, 0, 1, 1, 0, 1}
            , {1, 0, 1, 1, 1, 1}
            , {1, 1, 1, 1, 1, 1}
            , {1, 0, 0, 0, 1, 1}
            , {0, 1, 1, 1, 1, 0}
            , {0, 1, 1, 0, 1, 0}
            , {0, 0, 1, 1, 1, 1}};

    int[][] ex3 = {{1, 2, 7}
            , {1, 3, 5}
            , {2, 3, 4}
            , {2, 4, 3}
            , {3, 4, 1}
            , {4, 5, 1}
            , {5, 6, 8}
            , {5, 7, 4}
            , {6, 7, 9}};

    public static void main(String[] args) {
        GraphExample o = new GraphExample();

        o.makeGraph1(o.ex1);
        o.makeGraph1(o.ex1);

        o.makeGraph1(o.ex2);
        o.makeGraph1(o.ex2);

        o.makeGraph1(o.ex3);
        o.makeGraph1(o.ex3);


    }

    /**
     * 인접 행렬 그래프로 표현
     */
    public void makeGraph1(int[][] edges){
        int n = edges.length;
        int m = edges[0].length;
        int[][] matrix = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 인접 리스트 그래프로 표현
     */
    public void makeGraph2(int[][] edges){
        int n = edges.length;
        int m = edges[0].length;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++) list.add(new ArrayList<>());

        for(int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        //출력
        for (int i = 1; i < list.size(); i++) {
            for(int j = 0 ; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j)+" ");
            System.out.println();
        }
    }

    /**
     * 인접 행렬 그래프로 표현
     */
    public void makeGraph3(int[][] arr){

    }

    /**
     * 인접 리스트 그래프로 표현
     */
    public void makeGraph4(int[][] arr){

    }

    /**
     * 인접 행렬 그래프로 표현
     */
    public void makeGraph5(int[][] edges){
        int n = edges.length;
        int m = edges[0].length;

        int[][] matrix = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 인접 리스트 그래프로 표현
     */
    public void makeGraph6(int[][] edges){
        int n = edges.length;
        int m = edges[0].length;

        ArrayList[] list = new ArrayList[n+1];
        for (int i = 0; i < n; i++) list[i].add(new ArrayList<Integer>());

        for(int[] edge: edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
    }
}
