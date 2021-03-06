/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) { // returns the min diff after the root node
        if (root == null)
            return min;

        minDiffInBST(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        minDiffInBST(root.right);

        return min;
    }
}
// O(n)
// O(h)
