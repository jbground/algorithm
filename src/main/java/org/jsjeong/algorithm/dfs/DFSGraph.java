package org.jsjeong.algorithm.dfs;

import java.util.LinkedList;
import java.util.Stack;
/**
 * 깊이 우선 탐색
 */
public class DFSGraph {
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

    public DFSGraph(int size) {
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

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    public void dfs() {
        dfs(0);

    }
    void visit(Node r) {
        System.out.print(r.data + " ");
    }
}
