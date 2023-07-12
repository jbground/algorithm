package org.jsjeong.algorithm.floydwarshall;

public class FloydWarshall {
    final static int INF = 9999, nV = 4;

    // Implementing floyd warshall algorithm
    void floydWarshall(int graph[][]) {
        int matrix[][] = new int[nV][nV];
        int i, j, k;

        for (i = 0; i < nV; i++)
            for (j = 0; j < nV; j++)
                matrix[i][j] = graph[i][j];

        // Adding vertices individually
        for (k = 0; k < nV; k++) { //가운데 노드
            for (i = 0; i < nV; i++) { //시작 노드
                for (j = 0; j < nV; j++) { // 마지막 노드
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j]; //가운데를 거쳐가는 것이 더 빠르면 그 경로로 업데이트
                }
            }
        }
        printMatrix(matrix);
    }

    void printMatrix(int matrix[][]) {
        for (int i = 0; i < nV; ++i) {
            for (int j = 0; j < nV; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }
}