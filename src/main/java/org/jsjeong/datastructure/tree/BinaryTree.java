package org.jsjeong.datastructure.tree;

public class BinaryTree {
    int[][] tree;
    int n;
    public BinaryTree(int n){
        this.n = n;
        tree = new int[26][2];
    }

    void binary(String text) {
        for (int i = 0; i < n; i++) {
            String[] temp = text.split(" ");
            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                tree[node][0] = -1;
            } else {
                tree[node][0] = left - 'A';
            }
            if (right == '.') {
                tree[node][1] = -1;
            } else {
                tree[node][1] = right = 'A';
            }
        }
    }

    public void preOrder(int now) {
        if (now == -1) return;

        System.out.println((char)(now+'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    public void inOrder(int now) {
        if (now == -1) return;

        inOrder(tree[now][0]);
        System.out.println((char)(now+'A'));
        inOrder(tree[now][1]);
    }

    public void postOrder(int now) {
        if (now == -1) return;

        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.println((char)(now+'A'));
    }
}
