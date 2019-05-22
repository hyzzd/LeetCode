class BinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // bst + inorder -> sorted

    public TreeNode createBST(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // thinking in recursive way
}