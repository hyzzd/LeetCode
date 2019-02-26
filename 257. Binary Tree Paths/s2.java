/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        dfs(ans, "", root);
        return ans;
    }

    public void dfs(List<String> list, String s, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.add(s + root.val);
        dfs(list, s + root.val + "->", root.left);
        dfs(list, s + root.val + "->", root.right);
    }
}
