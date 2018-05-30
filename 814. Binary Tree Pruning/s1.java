/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    public boolean containsOne(TreeNode node){
        if(node == null) return false;
        boolean c1 = containsOne(node.left);
        boolean c2 = containsOne(node.right);
        if(!c1) node.left = null;
        if(!c2) node.right = null;
        return node.val == 1 || c1 || c2;
    }
}
// O(n)
// O(h)
