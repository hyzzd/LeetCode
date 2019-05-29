import java.util.*;

class Main {
    static Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static Set<Integer> nodes;
    static Map<Integer, List<Integer>> edges = new HashMap<>();

    public static int validPattern(int len) {
        if (len == 1) {
            return nodes.size();
        }

        int count = 0;
        for (int node : nodes) {
            count += dfs(len, node, new HashSet<>());
        }

        return count;
    }

    public static int dfs(int len, int curr, Set<Integer> seen) {
        if (len == 0)
            return 1;

        seen.add(curr);

        List<Integer> nodes = edges.get(curr);
        int count = 0;
        for (int node : nodes) {
            count += dfs(len - 1, node, seen);
            seen.remove(curr);
        }

        return count;
    }

    public static void main(String[] args) {
        nodes = new HashSet<Integer>(Arrays.asList(arr));
        edges.put(1, new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 4 })));
        edges.put(2, new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, 5 })));
        edges.put(3, new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 6 })));
        edges.put(4, new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 5, 7 })));
        edges.put(5, new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 4, 6, 8 })));
        edges.put(6, new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 5, 9 })));
        edges.put(7, new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 8 })));
        edges.put(8, new ArrayList<Integer>(Arrays.asList(new Integer[] { 5, 7, 9 })));
        edges.put(9, new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 8 })));

        System.out.println(validPattern(1));
        System.out.println(validPattern(2));
        System.out.println(validPattern(3));
    }
}