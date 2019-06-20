import java.util.*;

class Main {
    class Node {
        char ch;
        int ct;
        Node lt, rt;

        public Node(char c, int count) {
            ch = c;
            ct = count;
        }
    }

    public Node buildTree(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        List<Node> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.ct - b.ct;
            }
        });

        Queue<Node> q = new LinkedList<>();
        for (Node n : nodes) {
            q.add(n);
        }

        return parseQ(q);
    }

    private Node parseQ(Queue<Node> q) {
        if (q.size() == 1) {
            return q.poll();
        }

        Node n1 = q.poll();
        Node n2 = q.poll();

        Node par = new Node('*', n1.ct + n2.ct);
        par.lt = n1;
        par.rt = n2;

        q.add(par);

        return parseQ(q);
    }
}