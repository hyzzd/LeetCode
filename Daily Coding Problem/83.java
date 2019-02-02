class Main {
    public Node invert(Node root){
        if(root == null) return null;
        
        Node left = invert(root.left);
        Node right = invert(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}