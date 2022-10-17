package org.jsjeong.algorithm.search.bfs;

import sun.misc.Queue;

import java.util.LinkedList;
import java.util.Stack;
/**
 * 넓이 우선 탐색
 */
public class BFSGraph {

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

    Node[] nodes;

    public BFSGraph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2))
            n1.adjacent.add(n2);
        if (!n2.adjacent.contains(n1))
            n2.adjacent.add(n1);
    }

    void bfs(int index) throws InterruptedException {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.dequeue();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);
        }
    }

    public void bfs() throws InterruptedException {
        bfs(0);
    }

    void visit(Node r) {
        System.out.print(r.data + " ");
    }
}
