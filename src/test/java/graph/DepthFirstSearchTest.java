package graph;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    /**
     * 0  →  1  ←  2         ↗ 12
     * ↓  ↘  ↓  ↘  ↑      11
     * 5     4  ←  3         ↘ empty
     */
    @Test
    void find() {
        // first connected sub-graph
        Node<Integer> zero = new Node<>(0, new HashSet<>());
        Node<Integer> one = new Node<>(1, new HashSet<>());
        Node<Integer> two = new Node<>(2, new HashSet<>());
        Node<Integer> three = new Node<>(3, new HashSet<>());
        Node<Integer> four = new Node<>(4, new HashSet<>());
        Node<Integer> five = new Node<>(5, new HashSet<>());

        zero.adjacentNodes.add(one);
        zero.adjacentNodes.add(four);
        zero.adjacentNodes.add(five);
        one.adjacentNodes.add(four);
        one.adjacentNodes.add(three);
        three.adjacentNodes.add(two);
        three.adjacentNodes.add(four);
        two.adjacentNodes.add(one);

        // second connected sub-graph
        Node<Integer> eleven = new Node<>(11, new HashSet<>());
        Node<Integer> twelve = new Node<>(12, new HashSet<>());
        Node<Integer> empty = new Node<>(null, new HashSet<>());

        eleven.adjacentNodes.add(twelve);
        eleven.adjacentNodes.add(empty);


        assertEquals(three, new DepthFirstSearch<Integer>().find(3, zero, eleven));
        assertEquals(twelve, new DepthFirstSearch<Integer>().find(12, zero, eleven));
        assertEquals(empty, new DepthFirstSearch<Integer>().find(null, zero, eleven));
        assertNull(new DepthFirstSearch<Integer>().find(null, zero));
        assertNull(new DepthFirstSearch<Integer>().find(99, zero));
    }
}