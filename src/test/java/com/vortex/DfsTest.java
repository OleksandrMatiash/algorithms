package com.vortex;

import com.vortex.Dfs;
import com.vortex.domain.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.vortex.util.NodeHelper.node;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class DfsTest {

    @Test
    public void findRecursive() {
        List<Integer> traverseOrder = new ArrayList<>();
        Consumer<Integer> p = traverseOrder::add;

        Node tree = node(1, p,
                node(2, p,
                        node(3, p,
                                node(4, p),
                                node(5, p)),
                        node(6, p)),
                node(7, p),
                node(8, p,
                        node(9, p,
                                node(10, p),
                                node(11, p)),
                        node(12, p)));

        Node result = new Dfs().findRecursive(tree, 12);

        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), traverseOrder);
        assertEquals(12, result.getValue());
    }

    @Test
    public void findNonRecursive() {
        List<Integer> traverseOrder = new ArrayList<>();
        Consumer<Integer> p = traverseOrder::add;

        Node tree = node(1, p,
                node(2, p,
                        node(3, p,
                                node(4, p),
                                node(5, p)),
                        node(6, p)),
                node(7, p),
                node(8, p,
                        node(9, p,
                                node(10, p),
                                node(11, p)),
                        node(12, p)));

        Node result = new Dfs().findNonRecursive(tree, 12);

        assertEquals(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), traverseOrder);
        assertEquals(12, result.getValue());
    }
}