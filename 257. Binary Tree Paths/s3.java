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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new LinkedList<>();
        if(root == null) return ans;
        if(root.left == null && root.right == null){
            ans.add(Integer.toString(root.val));
            return ans;
        }
        for(String s: binaryTreePaths(root.left)){
            ans.add(Integer.toString(root.val)+"->"+s);
        }
        for(String s: binaryTreePaths(root.right)){
            ans.add(Integer.toString(root.val)+"->"+s);
        }
        return ans;
    }
}
