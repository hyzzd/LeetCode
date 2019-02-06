import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topoOrder;

    private void init(int num) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topoOrder = new ArrayList<>();

        for (int i = 0; i < num; ++i) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if (!this.isPossible) {
            return;
        }

        this.color.put(node, GRAY);
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }

        this.color.put(node, BLACK);
        this.topoOrder.add(node);
    }

    public int[] findOrder(int num, int[][] prerequisites) {
        this.init(num);

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        for (int i = 0; i < num; i++) {
            if (this.color.get(i) == WHITE) {
                this.dfs(i);
            }
        }

        int[] order;
        if (this.isPossible) {
            order = new int[num];
            for (int i = 0; i < num; ++i) {
                order[i] = this.topoOrder.get(num - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}