/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int ans = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) { // returns the sum of subtree
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
// O(n)
// O(h)
