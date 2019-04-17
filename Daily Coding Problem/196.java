import java.util.*;

class Main {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int freqSum(Node root) {
        if (root == null)
            return 0;
        helper(root);
        int max = 0, res = 0;
        for (int i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                res = i;
            }
        }
        return res;
    }

    private static void helper(Node root) {
        if (root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(-5);

        System.out.println(freqSum(root));
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}