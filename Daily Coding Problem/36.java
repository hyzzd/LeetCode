class Main {

    Node root;

    // Constructor
    Main() {
        root = null;
    }

    // function to insert new nodes
    public void insert(int data) {
        this.root = this.insertRec(this.root, data);
    }

    /*
     * A utility function to insert a new node with given key in BST
     */
    Node insertRec(Node node, int data) {
        /* If the tree is empty, return a new node */
        if (node == null) {
            this.root = new Node(data);
            return this.root;
        }

        /* Otherwise, recur down the tree */
        if (data < node.data) {
            node.left = this.insertRec(node.left, data);
        } else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    public void secondLarge(Node root) {
        Count C = new Count();
        secondLargeUtil(root, C);
    }

    public void secondLargeUtil(Node node, Count C) {
        if (node == null || C.c >= 2) {
            return;
        }

        secondLargeUtil(node.right, C);
        C.c++;
        if (C.c == 2) {
            System.out.println(node.data);
        }
        secondLargeUtil(node.left, C);
    }

    public class Count {
        int c = 0;
    }

    public static void main(String[] args) {
        Main m = new Main();
        /*
         * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
         */
        m.insert(50);
        m.insert(30);
        m.insert(20);
        m.insert(40);
        m.insert(70);
        m.insert(60);
        m.insert(80);

        m.secondLarge(m.root);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
    }
}