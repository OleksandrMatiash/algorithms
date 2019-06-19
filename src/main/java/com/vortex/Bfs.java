package com.vortex;

import com.vortex.domain.Node;

import java.util.*;

import static java.util.Collections.singletonList;

public class Bfs {

    public Node findRecursive(Node node, int toFind) {
        return findRecursive(singletonList(node), toFind);
    }

    private Node findRecursive(List<Node> nodes, int toFind) {
        if (!nodes.isEmpty()) {
            List<Node> childNodes = new ArrayList<>();
            for (Node node : nodes) {
                if (node.getValue() == toFind) {
                    return node;
                }
                if (node.getChildNodes() != null) {
                    childNodes.addAll(node.getChildNodes());
                }
            }
            return findRecursive(childNodes, toFind);
        }
        return null;
    }

    public Node findNonRecursive(Node root, int toFind) {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addFirst(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.removeFirst();
            if (node.getValue() == toFind) {
                return node;
            }
            nodes.addAll(node.getChildNodes());
        }
        return null;
    }
}
