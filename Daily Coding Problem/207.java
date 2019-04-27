import java.util.*;

class Main {
    final static int V = 4;

    public static boolean bipartite(int[][] G, int src) {
        int[] colorArr = new int[V];
        for (int i = 0; i < V; i++) {
            colorArr[i] = -1;
        }

        colorArr[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (G[u][u] == 1)
                return false;

            for (int v = 0; v < V; v++) {
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.offer(v);
                } else if (G[u][v] == -1 && colorArr[v] == colorArr[u]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int G[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } };
        System.out.println(isBipartite(G, 0));
    }
}