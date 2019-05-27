class Main {
    static class Node {
        int val;
        Node[] children;

        public Node(int v) {
            val = v;
            children = new Node[k];
        }

        public Node(int v, int n) {
            val = v;
            children = new Node[n];
        }
    }

    static final int k = 3;

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        Node nRoot = reverse(root);
        return isSame(root, nRoot);
    }

    public static Node reverse(Node root) {
        if (root == null)
            return null;

        Node nRoot = new Node(root.val);
        for (int i = root.children.length - 1; i >= 0; i--) {
            nRoot.children[k - i - 1] = reverse(root.children[i]);
        }

        return nRoot;
    }

    public static boolean isSame(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;

        if (n1 == null || n2 == null)
            return false;

        boolean same = true;
        for (int i = 0; i < k; i++) {
            if (!isSame(n1.children[i], n2.children[i])) {
                return false;
            }
        }

        return n1.val == n2.val && same;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.children[0] = new Node(3);
        root.children[1] = new Node(5);
        root.children[2] = new Node(3);
        root.children[0].children[0] = new Node(9);
        root.children[2].children[2] = new Node(9);
        System.out.println(isSymmetric(root));
    }
}