class Main {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void morrisTraversal(Node root) {
        if (root == null)
            return;
        Node pre = null;
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.println(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else { // restore the tree change made in if
                    pre.right = null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        morrisTraversal(root);
    }
}