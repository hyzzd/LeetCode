class Main {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void morrisTraversalInOrder(Node root) {
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

    public static void morrisTraversalPreOrder(Node root) {
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
                    System.out.println(curr.val);
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void morrisTraversalPostOrder(Node root) {
        Node dump = new Node(-1);
        dump.left = root;
        Node pre = null;
        Node curr = dump;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    printReverse(curr.left, pre);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    private static void printReverse(Node from, Node to) {
        reverse(from, to);
        Node p = to;
        while (true) {
            System.out.println(p.val);
            if (p == from)
                break;
            p = p.right;
        }
        reverse(to, from);
    }

    private static void reverse(Node from, Node to) {
        if (from == to)
            return;
        Node x = from;
        Node y = from.right;
        Node z = null;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to)
                break;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        morrisTraversalInOrder(root);
        System.out.println();
        morrisTraversalPreOrder(root);
        System.out.println();
        morrisTraversalPostOrder(root);
        System.out.println();
    }
}