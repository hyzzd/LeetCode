import java.util.*;

class Main {
    class Node {
        int val;
        int lev;
        Node l;
        Node r;
        Node p;
    }

    public List<Node> getCousins(Node root, Node node) {
        Map<Integer, List<Node>> map = new HashMap<>();
        populateMap(root, map, null, 0);

        List<Node> list = new ArrayList<>();
        for (Node n : map.get(node.lev)) {
            if (n.p != node.p) {
                list.add(n);
            }
        }
        return list;
    }

    private void populateMap(Node root, Map<Integer, List<Node>> map, Node parent, int level) {
        if (node == null)
            return;

        root.p = parent;
        root.lev = level;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root);

        populateMap(root.l, map, root, level + 1);
        populateMap(root.r, map, root, level + 1);
    }
}