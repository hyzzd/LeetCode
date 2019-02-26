/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(t.val));
        if (t.left == null && t.right == null)
            sb.append("");
        else if (t.right == null)
            sb.append("(" + tree2str(t.left) + ")");
        else
            sb.append("(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")");
        return sb.toString();
    }
}
// O(n)
// O(n)
