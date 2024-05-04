package org.jsjeong.algorithm.routing.dfs;

import java.util.LinkedList;

/**
 * 깊이 우선 탐색 재귀함수 사용
 */
public class DFSReGraph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    public DFSReGraph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    Node[] nodes;

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2))
            n1.adjacent.add(n2);
        if (!n2.adjacent.contains(n1))
            n2.adjacent.add(n1);
    }

    void dfs(Node r) {
        if(r == null) return;
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if(n.marked == false)
                dfs(n);
        }
    }

    void dfs(int index) {
        Node r = nodes[index];
        dfs(r);
    }

    public void dfs() {
        dfs(0);

    }
    void visit(Node r) {
        System.out.print(r.data + " ");
    }
}
