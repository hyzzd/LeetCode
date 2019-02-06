class Main {
    public Node generate() {
        if (coinflip()) {
            return new Node();
        }

        return new Node(null, generate());
    }

    private boolean coinflip() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Node {
    int val;
    Node left, right;

    Node() {
        this.left = this.right = null;
    }

    Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}