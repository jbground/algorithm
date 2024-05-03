package org.jsjeong.structure.tree;

public class TrieTree {
    class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }

    tNode root = new tNode();

    //트라이 자료구조 구축
    void trie(String text) {
        int n = text.length();
        while (n > 0) {
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null)
                    now.next[c - 'a'] = new tNode();

                now = now.next[c - 'a'];
                if (i == text.length() - 1)
                    now.isEnd = true;
            }
            n--;
        }
    }

    //트라이 자료구조 검색
    void search(String text){
        int count = 0;
        int m = text.length();
        while (m > 0) {
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if(now.next[c-'a'] == null)
                    break;
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd)
                    count++;
            }
            m--;
        }
        System.out.println(count);
    }
}
