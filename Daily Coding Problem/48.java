class BinaryTree {
    Node root;
    static int preIndex = 0;
    
    Node buildTree(char in[], char pre[], int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
  
        return tNode; 
    } 
    
    int search(char arr[], int strt, int end, char value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    } 
    
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); 
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
        int len = in.length; 
        Node root = tree.buildTree(in, pre, 0, len - 1); 
        
        tree.printInorder(root); 
    }
}

class Node{
    char data;
    Node left, right;
    
    Node(char item){
        data = item;
        left = right = null;
    }
}