import java.util.*;

class Main {
    public static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
    }

    public static void displayGraph(List<List<Integer>> adj, int v) {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " --> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void transposeGraph(List<List<Integer>> adj, List<List<Integer>> transpose, int v) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                addEdge(transpose, adj.get(i).get(j), i);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
            transpose.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 0);
        addEdge(adj, 3, 2);
        addEdge(adj, 4, 1);
        addEdge(adj, 4, 3);

        transposeGraph(adj, transpose, v);
        displayGraph(adj, v);
        displayGraph(transpose, v);
    }
}