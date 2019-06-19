package com.vortex.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Node {
    private int value;
    private List<Node> childNodes;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public String toString() {
        return "Node{value='" + value + '\'' + ", childNodes=" + childNodes + '}';
    }
}
