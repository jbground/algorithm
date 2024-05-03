package org.jsjeong.algorithm.circuit.dfs;

/**
 * 이진 트리의 깊이 우선 탐색
 */
public class DFS_Sample3 {

    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        DFS_Sample3 dfs_sample3 = new DFS_Sample3();
        dfs_sample3.root = new Node(1);
        dfs_sample3.root.lt = new Node(2);
        dfs_sample3.root.rt = new Node(3);
        dfs_sample3.root.lt.lt = new Node(4);
        dfs_sample3.root.lt.rt = new Node(5);
        dfs_sample3.root.rt.lt = new Node(6);
        dfs_sample3.root.rt.rt = new Node(7);
        dfs_sample3.DFS(dfs_sample3.root);

    }
}

class Node{
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}