package org.jsjeong.algorithm;

import org.jsjeong.algorithm.routing.bfs.BFSGraph;
import org.jsjeong.algorithm.routing.dfs.DFSGraph;
import org.jsjeong.algorithm.routing.dfs.DFSReGraph;

public class SearchApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("DFS");
        DFSGraph dg = new DFSGraph(9);
        dg.addEdge(0, 1);
        dg.addEdge(1, 2);
        dg.addEdge(1, 3);
        dg.addEdge(2, 4);
        dg.addEdge(2, 3);
        dg.addEdge(3, 4);
        dg.addEdge(3, 5);
        dg.addEdge(5, 6);
        dg.addEdge(5, 7);
        dg.addEdge(6, 8);
        dg.dfs();

        System.out.println();
        System.out.println("DFS 재귀");
        DFSReGraph drg = new DFSReGraph(9);
        drg.addEdge(0, 1);
        drg.addEdge(1, 2);
        drg.addEdge(1, 3);
        drg.addEdge(2, 4);
        drg.addEdge(2, 3);
        drg.addEdge(3, 4);
        drg.addEdge(3, 5);
        drg.addEdge(5, 6);
        drg.addEdge(5, 7);
        drg.addEdge(6, 8);
        drg.dfs();

        System.out.println();
        System.out.println("BFS");
        BFSGraph bg = new BFSGraph(9);
        bg.addEdge(0, 1);
        bg.addEdge(1, 2);
        bg.addEdge(1, 3);
        bg.addEdge(2, 4);
        bg.addEdge(2, 3);
        bg.addEdge(3, 4);
        bg.addEdge(3, 5);
        bg.addEdge(5, 6);
        bg.addEdge(5, 7);
        bg.addEdge(6, 8);
        bg.bfs();
    }
}
