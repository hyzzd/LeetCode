import java.util.*;

class Main {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class UF {
        int[] parent, rank;

        UF(int V) {
            this.parent = new int[V];
            this.rank = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);
            if (rank[xp] < rank[yp]) {
                parent[xp] = yp;
            } else if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else {
                parent[yp] = xp;
                rank[xp]++;
            }
        }
    }

    int V, E;
    Edge[] edge;

    Main(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edge);

        UF uf = new UF(V);

        i = 0;
        
        while (e < V - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = uf.find(next_edge.src);
            int y = uf.find(next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                uf.union(x, y);
            }
        }

        System.out.println("Following are the edges in " + "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }

    public static void main(String[] args) {

        /*
         * Let us create following weighted graph 10 0--------1 | \ | 6| 5\ |15 | \ |
         * 2--------3 4
         */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Main graph = new Main(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}