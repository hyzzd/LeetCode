class Main {
    class Node {
        int val;
        Node left, right;
    }

    public int getNum(Node root) {
        if (root == null)
            return 0;
        return 1 + getNum(root.left) + getNum(root.right);
    }
}