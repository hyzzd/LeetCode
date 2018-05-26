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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return backtrack(root, 0, sum, map);
    }
    
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null) return 0;
        sum += root.val;
        int res = map.getOrDefault(sum-target, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
// O(n)
// O(n)
