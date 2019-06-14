import java.util.*;

class Main {
    public int[][] getTransitiveClosure(List<List<Integer>> adjList) {
        int n = adjList.size();
        int transitiveClosure[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            transitiveClosure[i][i] = 1;
        }

        for (int i = 0; i < adjList.size(); i++) {
            update(i, i, adjList, transitiveClosure);
        }

        return transitiveClosure;
    }

    public void update(int ori, int node, List<List<Integer>> list, int[][] mat) {
        if (list.get(node) == 1)
            return;

        for (int adj : list.get(node)) {
            if (ori == adj || node == adj) {
                continue;
            }

            mat[ori][adj] = 1;
            update(ori, adj, list, mat);
        }
    }
}