package org.jsjeong.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JBGraph {
    private String name;    //그래프 이름
    private final List<JBNode> nodes;

    public JBGraph() {
        nodes = new LinkedList<>();
    }



    public void addEdge(String node1, String node2) {

        JBNode node = new JBNode(node1);

    }
}
