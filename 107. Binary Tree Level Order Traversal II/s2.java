/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return ans;

        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < level; ++i) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            ans.add(0, list);
        }
        return ans;
    }
}
