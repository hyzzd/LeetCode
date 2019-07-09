import java.util.*;

class Main {
    class Node {
        int val;
        List<Node> adjList;
    }

    public boolean hasCycle(List<Node> nodes, Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node node : curr.adjList) {
                if (visited.contains(node)) {
                    return true;
                }

                q.add(node);
                visited.add(node);
            }
        }
        return false;
    }
}