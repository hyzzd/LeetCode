import java.util.*;

class Main {
    class Node {
        int val;
        Node left, right;
    }

    public static List<Integer> bfs(Node root) {
        List<Integer> res = new LinkedList<>();

        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (flag) {
                    res.add(0, curr.val);
                } else {
                    res.add(curr.val);
                }

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }

        return res;
    }
}