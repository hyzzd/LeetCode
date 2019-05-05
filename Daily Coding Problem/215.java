import java.util.*;

class Main {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static List<Integer> bottomView(Node root) {
        if (root == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            list.add(map.get(i));
        }

        Collections.sort(list);

        return list;
    }

    private static void dfs(Node root, int dist, Map<Integer, Integer> map) {
        if (root == null)
            return;

        if (!map.containsKey(dist)) {
            map.put(dist, root.val);
        }
        dfs(root.left, dist - 1, map);
        dfs(root.right, dist + 1, map);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.left.left.left = new Node(0);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        List<Integer> arr = bottomView(root);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}