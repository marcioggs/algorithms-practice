package graph;

import java.util.*;
import java.util.stream.Collectors;

class BreadthFirstSearch<T> {

  private final Queue<Node<T>> nextNodesToVisit = new ArrayDeque<>();
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

  private Node<T> find(T searchValue, Node<T> rootNode) {
    if (rootNode == null) {
      return null;
    }

    Node<T> found = null;
    this.nextNodesToVisit.add(rootNode);

    while (!this.nextNodesToVisit.isEmpty()) {
      Node<T> node = this.nextNodesToVisit.poll();
      this.visitedNodes.add(node);

      if ((searchValue == null && node.value == null)
          || (searchValue != null && searchValue.equals(node.value))) {
        found = node;
        break;
      } else {
        this.nextNodesToVisit.addAll(
            node.adjacentNodes.stream()
                .filter((tempNode) -> !this.visitedNodes.contains(tempNode))
                .collect(Collectors.toList()));
      }
    }

    return found;
  }
}
