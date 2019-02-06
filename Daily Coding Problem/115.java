class Main {
    public boolean isSubTree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || equals(s.left, t) || equals(s.right, t));
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return (s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right));
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
}