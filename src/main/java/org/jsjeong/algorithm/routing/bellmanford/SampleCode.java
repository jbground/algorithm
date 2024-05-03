package org.jsjeong.algorithm.routing.bellmanford;

import java.util.*;

/**
 * 그래프 기준으로 벨만포드 알고리즘 실행
 */
public class SampleCode {

    private final List<Node> nodeList = new ArrayList<>();

    public void bellman(){

        //정점(노드)의 개수
        int v = nodeList.size();

        //간선의 개수
        int e = 0;
        for (Node node : nodeList) {
            e += node.adjacent.size();
        }

        //경로 저장 생성
        Map<Character, Integer> distribution = new LinkedHashMap<>();

        //모든 정점으로의 거리 무한대 설정
        distribution.put('A', Integer.MAX_VALUE);
        distribution.put('B', Integer.MAX_VALUE);
        distribution.put('C', Integer.MAX_VALUE);
        distribution.put('D', Integer.MAX_VALUE);
        distribution.put('E', Integer.MAX_VALUE);
        distribution.put('F', Integer.MAX_VALUE);
        distribution.put('G', Integer.MAX_VALUE);
        distribution.put('H', Integer.MAX_VALUE);
        distribution.put('I', Integer.MAX_VALUE);
        distribution.put('J', Integer.MAX_VALUE);
        distribution.put('K', Integer.MAX_VALUE);
        distribution.put('L', Integer.MAX_VALUE);


        //시작 정점 거리 0 설정
        distribution.put('A', 0);

        //모든 정점, 간선별 가중치 설정 n - 1 번 수행
        for (Node node : nodeList) {
            for(Node child : node.getAdjacent().keySet()){
                char start = node.getName();
                char end = child.getName();
                int weight = node.getAdjacent().get(child);

                if (distribution.get(start) != Integer.MAX_VALUE && distribution.get(start) + weight < distribution.get(end)) {
                    distribution.put(end, distribution.get(start) + weight);
                }
            }
        }

        //

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
        
        sample.bellman();

    }
}
