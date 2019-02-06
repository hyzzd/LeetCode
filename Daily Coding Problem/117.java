import java.util.LinkedList;
import java.util.Queue;

class Main {
    public int maxLevelSum(Node root) {
        if (root == null)
            return 0;

        int result = root.val;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int tempVal = 0;
            int count = q.size();
            while (count-- > 0) {
                Node tempNode = q.poll();
                tempVal += tempNode.val;
                if (tempNode.left != null)
                    q.add(tempNode.left);
                if (tempNode.right != null)
                    q.add(tempNode.right);
            }

            result = Math.max(result, tempVal);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Node {
    int val;
    Node left, right;
}