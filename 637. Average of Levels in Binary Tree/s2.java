/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, ans, count);
        for (int i = 0; i < ans.size(); ++i) {
            ans.set(i, ans.get(i) / count.get(i));
        }
        return ans;
    }

    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null)
            return;
        if (i < sum.size()) { // the level has already in the sum array
            sum.set(i, sum.get(i) + t.val); // assign new value to sum
            count.set(i, count.get(i) + 1); // assign new value to count
        } else {
            sum.add(t.val * 1.0); // new level, add value
            count.add(1); // new level, add one
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }
}
// DFS
// O(n) visit all the nodes
// O(h) height of the recurisive tree
