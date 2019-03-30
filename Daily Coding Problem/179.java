import java.util.*;

class Main {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node reconstruct(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }

        int index = 0, rootVal = arr.get(arr.size() - 1);
        Node root = new Node(rootVal);
        for (; index < arr.size() - 1; index++) {
            if (arr.get(index) > rootVal) {
                break;
            }
        }
        
        root.left = reconstruct(arr.subList(0, index));
        root.right = reconstruct(arr.subList(index, arr.size() - 1));
        return root;
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(8);
        arr.add(7);
        arr.add(5);
        postOrder(reconstruct(arr));
    }
}