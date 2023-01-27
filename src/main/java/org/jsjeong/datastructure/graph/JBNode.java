package org.jsjeong.datastructure.graph;

import java.util.HashMap;
import java.util.Map;

public class JBNode {

    private String name;
    private final Map<JBNode, JBNodeData> nodes;

    public JBNode(String name) {
        this.name = name;
        nodes = new HashMap<>();
    }
}
