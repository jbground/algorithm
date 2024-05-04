package org.jsjeong.algorithm;

import org.jsjeong.algorithm.routing.bfs.BFS_Sample;
import org.junit.jupiter.api.Test;

public class BFSRunner {

    @Test
    void test1(){
        BFS_Sample bfs = new BFS_Sample();
        String[] arr = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(bfs.solution(arr));
    }
}
