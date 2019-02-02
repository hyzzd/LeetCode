class Main {
    public static void main(String[] args) {
        Main tree = new Main(); 
        tree.root = new Node(5); 
        tree.root.left = new Node(4); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(4); 
        tree.root.right.right = new Node(5); 
        
        System.out.println(tree.countUniversal(tree.root));
    }
    
    Node root;
    Count c = new Count();
    public boolean isUniversal(Node node, Count c){
        if(node == null){
            return true;
        }
        
        boolean left = isUniversal(node.left, c);
        boolean right = isUniversal(node.right, c);
        
        if(left == false || right == false)
            return false;
        if(node.left != null && node.left.val != node.val)
            return false;
        if(node.right != null && node.right.val != node.val)
            return false;
        
        c.count++;
        return true;
    }
    public int countUniversal(Node root){
        isUniversal(root, c);
        return c.count;
    }
}

class Count{
    int count = 0;
}

class Node{
    int val;
    Node left, right;
    
    public Node(int value){
        this.val = value;
        this.left = this.right = null;
    }
}