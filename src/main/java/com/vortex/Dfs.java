package com.vortex;

import com.vortex.domain.Node;

import java.util.LinkedList;
import java.util.List;

public class Dfs {

    public Node findRecursive(Node node, int toFind) {
        if (node.getValue() == toFind) {
            return node;
        }
        if (node.getChildNodes() != null) {
            for (Node childNode : node.getChildNodes()) {
                Node result = findRecursive(childNode, toFind);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public Node findNonRecursive(Node root, int toFind) {
        LinkedList<Node> l = new LinkedList<>();
        l.addFirst(root);

        while (!l.isEmpty()) {
            Node node = l.removeFirst();
            if (node.getValue() == toFind) {
                return node;
            }
            List<Node> childNodes = node.getChildNodes();
            if (childNodes != null) {
                for (int i = childNodes.size() - 1; i >= 0; i--) {
                    l.addFirst(childNodes.get(i));
                }
            }
        }
        return null;
    }
}
