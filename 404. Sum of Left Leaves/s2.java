public int sumOfLeftLeaves(TreeNode root) {
    int res = 0;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node != null) {
            if (node.left != null && node.left.left == null && node.left.right == null)
                res += node.left.val;
            stack.push(node.left);
            stack.push(node.right);
        }
    }

    return res;
}
// stack
