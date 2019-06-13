class Main {
    class Node {
        int val;
        Node left, right;
    }

    public Node convertFull(Node root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;
        else if (root.left != null && root.right != null) {
            root.left = convertFull(root.left);
            root.right = convertFull(root.right);
            return root;
        } else if (root.left != null) {
            return convertFull(root.left);
        } else {
            return convertFull(root.right);
        }
    }
}