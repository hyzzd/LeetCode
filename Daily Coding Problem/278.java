import java.util.*;

class Main {
    class Node {
        int val;
        Node left, right;
    }

    public List<Node> createTrees(int n) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
        return getTrees(nodes, 0, nodes.size());
    }

    public List<Node> getTrees(List<Node> nodes, int start, int end) {
        if (nodes == null) {
            return new ArrayList<>();
        } else if (nodes.size() == 1) {
            return nodes;
        }

        List<Node> trees = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            List<Node> lefts = i > 0 ? getTrees(nodes, start, i + 1) : new ArrayList<>();
            List<Node> rights = i < nodes.size() - 1 ? getTrees(nodes, i + 1, end) : new ArrayList<>();

            for (Node left : lefts) {
                for (Node right : rights) {
                    Node root = new Node(nodes.get(i).val);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}