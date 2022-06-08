package graph;

import java.util.HashSet;
import java.util.Set;

class DepthFirstSearch<T> {

    private final Set<Node<T>> visitedNodes = new HashSet<>();

    @SafeVarargs
    final Node<T> find(T searchValue, Node<T>... rootNodes) {
        if (rootNodes == null || rootNodes.length == 0) {
            return null;
        }

        Node<T> found = null;

        for (Node<T> rootNode : rootNodes) {
            found = this.find(searchValue, rootNode);
            if (found != null) {
                break;
            }
        }

        return found;
    }

    private Node<T> find(T searchValue, Node<T> node) {
        if (node == null || this.visitedNodes.contains(node)) {
            return null;
        }

        Node<T> found = null;
        this.visitedNodes.add(node);

        if ((searchValue == null && node.value == null) || (searchValue != null && searchValue.equals(node.value))) {
            found = node;
        } else {
            for (Node<T> adjacentNode : node.adjacentNodes) {
                found = this.find(searchValue, adjacentNode);
                if (found != null) {
                    break;
                }
            }
        }

        return found;
    }
}
