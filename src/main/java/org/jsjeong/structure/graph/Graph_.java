package org.jsjeong.structure.graph;

import java.util.LinkedList;

public class Graph_ {

    final Node[] nodes;

    Graph_(int n) {
        nodes = new Node[n];
    }

    class Node {

        Object data;
        LinkedList<Node> adjacent;
        boolean visited;

        Node() {
            visited = false;
            adjacent = new LinkedList<>();
        }

        Node(int data) {
            this.data = data;
            this.visited = false;
            adjacent = new LinkedList<>();
        }
    }

    static class Builder {
        Node[] nodes;
        int nodeCount;

        public Builder(int size) {
            nodes = new Node[size];
        }

        public Builder addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2))
                n1.adjacent.add(n2);
            if (!n2.adjacent.contains(n1))
                n2.adjacent.add(n1);
            return this;
        }

        public Builder setNodeSize(int size) {
            nodes = new Node[size];
            return this;
        }


        public Graph_ build() {
            return new Graph_(nodeCount);
        }
    }

}
