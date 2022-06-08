package graph;

import java.util.Objects;
import java.util.Set;

class Node<T> {
    final T value;
    final Set<Node<T>> adjacentNodes;

    Node(T value, Set<Node<T>> adjacentNodes) {
        if (adjacentNodes == null) {
            throw new RuntimeException("adjacentNodes should not be null");
        }

        this.value = value;
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", adjacentNodes=" + adjacentNodes +
                '}';
    }
}
