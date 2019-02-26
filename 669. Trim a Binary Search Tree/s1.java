/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;

        if (root.val < L)
            return trimBST(root.right, L, R);
        if (root.val > R)
            return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
// first check the edge condition
// if < L, the result tree should be right of the node
// if > R, the result tree should be left of the node
// O(n) number of nodes, visit each node at once
// O(n) stack for nodes
