import java.util.*;

class Main {
    class Edge {
        int start;
        int end;
        int val;

        public Edge(int s, int e, int v) {
            start = s;
            end = e;
            val = v;
        }
    }

    class Graph {
        int numOfNodes;
        List<Edge> edges = new ArrayList<>();
    }

    public List<Edge> maxSpanningTree(Graph g) {
        UF uf = new UF(g.numOfNodes);

        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(Edge a, Edge b) {
                return b.val - a.val;
            }
        });

        for (Edge e : g.edges) {
            pq.offer(e);
        }

        List<Edge> mst = new ArrayList<>();
        while (pq.size() > 0 && mst.size() < g.numOfNodes - 1) {
            Edge curr = pq.poll();
            int n1 = curr.start;
            int n2 = curr.end;
            if (uf.find(n1) != uf.find(n2)) {
                uf.union(n1, n2);
                mst.add(curr);
            }
        }

        if (mst.size() < g.numOfNodes - 1) {
            return new Arraylist<>();
        }

        return mst;
    }
}

class UF {
    int[] parent;
    int[] rank;

    // constructor

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) {
            if (rank[ra] < rank[rb]) {
                parent[a] = b;
                rank[rb]++;
            } else if (rank[rb] > rank[ra]) {
                parent[b] = a;
                rank[ra]++;
            } else {
                parent[a] = b;
                rank[rb]++;
            }
        }
    }
}