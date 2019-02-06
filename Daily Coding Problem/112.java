class Main {
    TreeNode ans;

    Main() {
        this.ans = null;
    }

    private boolean recurseTree(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return false;
        int left = recurseTree(node.left, p, q) ? 1 : 0;
        int right = recurseTree(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;
        if (mid + left + right > 1)
            this.ans = node;

        return mid + left + right > 0;
    }

    public TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        recurseTree(node, p, q);
        return this.ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
}