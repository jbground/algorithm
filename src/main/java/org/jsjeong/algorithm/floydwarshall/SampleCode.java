package org.jsjeong.algorithm.floydwarshall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleCode {

    private final int INF = 9999;

    private List<Node> nodeList = new ArrayList<>();

    public void floyd(int matrix[][]){
        int num = matrix.length;

        for (int i = 0; i < num; i++){
            for (int j = 0; j < num; j++) {
                if(i != j){
                    if(matrix[i][j] == 0){
                        matrix[i][j] = INF;
                    }
                }
            }
        }
        printMatrix(matrix);

        int s, m, e;
        for (m = 0; m < num; m++) { //가운데 노드
            for (s = 0; s < num; s++) { //시작 노드
                for (e = 0; e < num; e++) { // 마지막 노드
                    if (matrix[s][e] > matrix[s][m] + matrix[m][e])
                        matrix[s][e] = matrix[s][m] + matrix[m][e]; //가운데를 거쳐가는 것이 더 빠르면 그 경로로 업데이트
                }
            }
        }
        printMatrix(matrix);
    }

    void printMatrix(int matrix[][]) {
        int num = matrix.length;

        for (int i = 0; i < num; ++i) {
            for (int j = 0; j < num; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static class Node {

        char name;
        private final Map<Node, Integer> adjacent = new HashMap<>();

        public Node(char name){
            this.name = name;
        }

        public void addEdge(Node targetNode, int weight) {
            adjacent.put(targetNode, weight);
        }

        public char getName(){
            return name;
        }

        public Map<Node, Integer> getAdjacent(){
            return adjacent;
        }
    }



    private void addEdge(char source, char target, int weight) {
        Node sourceNode = findNode(source);
        if(sourceNode == null){
            Node node = new Node(source);
            nodeList.add(node);
            sourceNode = node;
        }

        Node targetNode = findNode(target);
        if(targetNode == null){
            Node node = new Node(target);
            nodeList.add(node);
            targetNode = node;
        }

        sourceNode.addEdge(targetNode, weight);
    }

    private Node findNode(char c){
        for (Node node : nodeList) {
            if (node.getName() == c) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SampleCode sample = new SampleCode();

        sample.addEdge('A', 'B', 2);
        sample.addEdge('A', 'C', 3);
        sample.addEdge('B', 'A', 2);
        sample.addEdge('B', 'C', 4);
        sample.addEdge('B', 'D', 4);
        sample.addEdge('C', 'A', 3);
        sample.addEdge('C', 'B', 4);
        sample.addEdge('C', 'D', 2);
        sample.addEdge('C', 'G', 1);
        sample.addEdge('D', 'B', 4);
        sample.addEdge('D', 'C', 2);
        sample.addEdge('D', 'E', 9);
        sample.addEdge('D', 'G', 3);
        sample.addEdge('D', 'H', 1);
        sample.addEdge('E', 'D', 9);
        sample.addEdge('E', 'F', 1);
        sample.addEdge('E', 'I', 2);
        sample.addEdge('E', 'J', 3);
        sample.addEdge('F', 'E', 1);
        sample.addEdge('F', 'H', 2);
        sample.addEdge('F', 'K', 5);
        sample.addEdge('F', 'L', 4);
        sample.addEdge('G', 'C', 1);
        sample.addEdge('G', 'D', 3);
        sample.addEdge('G', 'K', 7);
        sample.addEdge('H', 'D', 1);
        sample.addEdge('H', 'F', 2);
        sample.addEdge('I', 'E', 2);
        sample.addEdge('I', 'J', 5);
        sample.addEdge('I', 'L', 2);
        sample.addEdge('J', 'E', 3);
        sample.addEdge('J', 'I', 5);
        sample.addEdge('K', 'F', 5);
        sample.addEdge('K', 'G', 7);
        sample.addEdge('K', 'L', 3);
        sample.addEdge('L', 'F', 4);
        sample.addEdge('L', 'I', 2);
        sample.addEdge('L', 'K', 3);

        //                 A, B, C, D, E, F, G, H, I, J, K, L
        int graph[][] =  {{0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0} //A
                        , {2, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0} //B
                        , {3, 4, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0} //C
                        , {0, 4, 2, 0, 9, 0, 3, 1, 0, 0, 0, 0} //D
                        , {0, 0, 0, 9, 0, 1, 0, 0, 2, 3, 0, 0} //E
                        , {0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 5, 4} //F
                        , {0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 7, 0} //G
                        , {0, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0} //H
                        , {0, 0, 0, 0, 2, 0, 0, 0, 0, 5, 0, 2} //I
                        , {0, 0, 0, 0, 3, 0, 0, 0, 5, 0, 0, 0} //J
                        , {0, 0, 0, 0, 0, 5, 7, 0, 0, 0, 0, 3} //K
                        , {0, 0, 0, 0, 0, 4, 0, 0, 2, 0, 3, 0}}; //L

        sample.floyd(graph);

    }
}
