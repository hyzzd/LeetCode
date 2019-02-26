/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null)
            return res;
        return getPath(root, "", res);
    }

    public List<String> getPath(TreeNode root, String str, List<String> res) {
        if (root.left == null && root.right == null) { // leaf
            if (str.equals("")) {
                str += root.val;
            } else {
                str += "->" + root.val;
            }
            res.add(str);
            return res;
        }
        if (str.equals("")) {
            str += root.val;
        } else {
            str += "->" + root.val;
        }
        if (root.left != null) {
            getPath(root.left, str, res);
        }
        if (root.right != null) {
            getPath(root.right, str, res);
        }
        return res;
    }
}
