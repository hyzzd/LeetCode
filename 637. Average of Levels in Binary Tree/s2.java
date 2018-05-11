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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            long sum = 0, count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if(n.left != null) temp.add(n.left);
                if(n.right != null) temp.add(n.right);
            }
            queue = temp;
            ans.add(sum * 1.0 / count);
        }
        */
        List<Integer> count = new ArrayList<>();
        average(root, 0, ans, count);
        for(int i = 0; i < ans.size(); ++i){
            ans.set(i, ans.get(i)/count.get(i));
        }        
        return ans;
    }
    
    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if(t == null) return;
        if(i < sum.size()){
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        }else{
            sum.add(t.val*1.0);
            count.add(1);
        }
        average(t.left, i+1, sum, count);
        average(t.right, i+1, sum, count);
    }
}
// DFS
// O(n) visit all the nodes
// O(h) height of the recurisive tree
