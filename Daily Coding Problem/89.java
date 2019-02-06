class Main {
    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isBSTUtil(Node root, Node prev) {
        if (root != null) {
            if (!isBSTUtil(root.left, prev))
                return false;

            // Allows only distinct valued nodes
            if (prev != null && root.val <= prev.val)
                return false;

            prev = root;

            return isBSTUtil(root.right, prev);
        }

        return true;
    }

    public boolean isBST(Node root) {
        Node prev = null;
        return isBSTUtil(root, prev);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (tree.isBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
