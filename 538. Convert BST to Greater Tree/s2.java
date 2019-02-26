/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode t = stack.pop();
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.right;
            }
            t = stack.pop();
            sum += t.val;
            t.val = sum;

            t = t.left;
        }
        return root;
    }
}
// O(n)
// O(n)
