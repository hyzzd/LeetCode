/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<String> qstr = new LinkedList<>();
        if (root == null)
            return ans;
        q.add(root);
        qstr.add("");
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            String curstr = qstr.remove();
            if (cur.left == null && cur.right == null)
                ans.add(curstr + cur.val);
            if (cur.left != null) {
                q.add(cur.left);
                qstr.add(curstr + cur.val + "->");
            }
            if (cur.right != null) {
                q.add(cur.right);
                qstr.add(curstr + cur.val + "->");
            }
        }
        return ans;
    }
}
