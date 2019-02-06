class Main {
    public static void main(String[] args) {
        Node node = new Node("root");
        node.left = new Node("left");
        node.right = new Node("right");
        node.left.left = new Node("left.left");

        System.out.println(deserialize(serialize(node)).left.left.value);
    }

    static class Node {
        String value;
        Node left, right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(String value, String left, String right) {
            this.value = value;
            this.left.value = left;
            this.right.value = right;
        }
    }

    public static String serialize(Node root) {
        if (root == null) {
            return "#,";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.value + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static Node deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        String[] str = s.split(",");

        return helper(str, 0);
    }

    private static Node helper(String[] str, int i) {
        if (i >= str.length || str[i].equals("#")) {
            return null;
        }

        Node root = new Node(str[i]);

        i++;
        root.left = helper(str, i);
        i++;
        root.right = helper(str, i);

        return root;
    }
}