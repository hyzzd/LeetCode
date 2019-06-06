class Main {
    static class Node {
        int val;
        Node left;
        Node right;
    }

    public static boolean isBalanced(Node root) {
        if (root == null)
            return false;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.abs(left - right) < 2 ? true : false;
    }

    public static int dfs(Node node) {
        if (node == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}