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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode a, TreeNode b){        
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val == b.val){
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }
        return false;
    }
}
