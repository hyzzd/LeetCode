import java.util.*;

class Main {
    public void longestPath() {
        int[] pair = new int[2];
        pair[0] = bfs(new Node(0));
        pair[1] = bfs(new Node(pair[0]));

        System.out.print(pair[0] + " " + pair[1]);
    }

    public int bfs(Node root) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Node> q = new LinkedList();
        q.add(root);
        dist[root.name] = 0;
        while (!q.isEmpty()) {
            Node t = q.poll();
            for (int i = 0; i < t.adj.size(); i++) {
                Node v = t.adj.get(i);
                if (dist[v.name] == -1) {
                    q.add(v);
                    dist[v.name] = dist[t.name] + 1;
                }
            }
        }

        int maxDist = 0;
        int nodeIdx = 0;

        for (int i = 0; i < V; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                nodeIdx = i;
            }
        }

        return nodeIdx;
    }
}

class Graph {
    int V;
    List<Node> nodes;

    Graph() {
        nodes = new ArrayList<>();
    }

    public addEdge(int v, int u, int w){
        nodes.get(u).put(nodes.get(u).get(v), w);
    }
}

class Node {
    int name;
    Map<Integer, Integer> adj;

    Node() {
        adj = new HashMap<>();
    }
}