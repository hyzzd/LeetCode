/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = level(root.left);
        int right = level(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int level(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(level(root.left), level(root.right)) + 1;
    }
}
