class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> maxLengthMap = new HashMap<>();
        stack.push(root);
        int maxDiameter = 0;
        boolean explored = false;
        while (stack.size() != 0) {
            TreeNode node = stack.peek();
            explored = (node.left != null && maxLengthMap.containsKey(node.left)) || node.left == null;
            if (!explored && node.left != null) {
                stack.push(node.left);
            }
            explored &= (node.right != null && maxLengthMap.containsKey(node.right)) || node.right == null;
            if (!explored && node.right != null) {
                stack.push(node.right);
            }
            // System.out.println("explored - " + explored + ", node val - " + node.val);
            if (explored) {
                int leftLength = maxLengthMap.getOrDefault(node.left, 0);
                if (node.left != null) {
                    leftLength += 1;
                }
                int rightLength = maxLengthMap.getOrDefault(node.right, 0);
                if (node.right != null) {
                    rightLength += 1;
                }

                // System.out.println("-- leftLength - " + leftLength + ", rightLength - " +
                // rightLength);
                maxLengthMap.put(node, Math.max(leftLength, rightLength));
                int diameter = leftLength + rightLength;
                if (maxDiameter < diameter) {
                    maxDiameter = diameter;
                }
                stack.pop();
            }
        }
        return maxDiameter;
    }
}
