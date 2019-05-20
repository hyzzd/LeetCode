class UF {
    int[] parent;
    int[] rank;

    public UF(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
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
        }
    }
}