import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Main {
    class Node {
        int left, right;

        Node(int l, int r) {
            left = l;
            right = r;
        }
    }

    public int graph(ArrayList<Node> list, String s) {
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (Node node : list) {
            map.put(node.left, node.right);
        }
        for (Node node : list) {
            int num = 0;
            while (map.get(node.right) != null) {
                num++;
                Node nd = new Node(node.right, map.get(node.right));
                node = list.get(nd.left);
            }
            result = Math.max(result, num);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}