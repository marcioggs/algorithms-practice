package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class BreadthFirstSearch<T> {

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

  private Node<T> find(T searchValue, Node<T> rootNode) {
    if (rootNode == null) {
      return null;
    }

    Queue<Node<T>> nextNodesToVisit = new ArrayDeque<>();
    Set<Node<T>> visitedNodes = new HashSet<>();

    Node<T> found = null;
    nextNodesToVisit.add(rootNode);

    while (!nextNodesToVisit.isEmpty()) {
      Node<T> node = nextNodesToVisit.poll();
      visitedNodes.add(node);

      if ((searchValue == null && node.value == null)
          || (searchValue != null && searchValue.equals(node.value))) {
        found = node;
        break;
      } else {
        nextNodesToVisit.addAll(
            node.adjacentNodes.stream()
                .filter((tempNode) -> !visitedNodes.contains(tempNode))
                .collect(Collectors.toList()));
      }
    }

    return found;
  }
}
