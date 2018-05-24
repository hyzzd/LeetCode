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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(set, root);
        
        int min = root.val;
        int ans = Integer.MAX_VALUE;
        for(int i: set){
            if(min < i && i < ans) ans = i;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
    public void dfs(Set<Integer> set, TreeNode root){
        if(root == null) return;
        set.add(root.val);
        dfs(set, root.left);
        dfs(set, root.right);
    }
}
// O(n)
// O(n)
