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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }
    public void dfs(TreeNode root, List<Integer> res, int d){
        if(root == null) return;
        if(d == res.size()) res.add(root.val);
        else res.set(d, Math.max(res.get(d), root.val));
        dfs(root.left, res, d+1);
        dfs(root.right, res, d+1);
    }
}
// Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.
