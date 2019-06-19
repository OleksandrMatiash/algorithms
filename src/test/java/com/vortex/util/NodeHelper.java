package com.vortex.util;

import com.vortex.domain.Node;

import java.util.function.Consumer;

import static java.util.Arrays.asList;

public class NodeHelper {

    public static Node node(int value, Consumer<Integer> getterProxy, Node... childNodes) {
        Node node = new Node() {
            @Override
            public int getValue() {
                int value = super.getValue();
                getterProxy.accept(value);
                return value;
            }
        };
        node.setValue(value);
        node.setChildNodes(asList(childNodes));
        return node;
    }
}
