class Main {
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        Node temp = null;
        if (data <= node.data) {
            temp = insert(node.left, data);
            node.left = temp;
        } else {
            temp = insert(node.right, data);
            node.right = temp;
        }

        return node;
    }

    public int minPath(Node root) {
        if (root == null) {
            return 0;
        }

        int left = minPath(root.left);
        int right = minPath(root.right);
        return Math.min(left, right) + root.data;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Node root = null;
        root = tree.insert(root, 10);
        root = tree.insert(root, 5);
        root = tree.insert(root, 5);
        root = tree.insert(root, 2);
        root = tree.insert(root, 1);
        root = tree.insert(root, -1);
        System.out.print(tree.minPath(root));
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}