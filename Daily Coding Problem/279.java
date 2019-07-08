import java.util.*;

class Main {
    public int getGroupNum(List<List<Integer>> adjList) {
        UF uf = new UF(adjList.size());
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); i++) {
                uf.union(i, adjList.get(i).get(j));
            }
        }

        return uf.size;
    }

}

class UF {
    int[] parent;
    int[] rank;
    int size;

    public UF(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        size = n;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xx = find(x);
        int yy = find(y);
        if (xx != yy) {
            if (rank[xx] > rank[yy]) {
                parent[yy] = xx;
            } else if (rank[yy] > rank[xx]) {
                parent[xx] = yy;
            } else {
                parent[xx] = yy;
                rank[yy]++;
            }
            size--;
        }
    }
}