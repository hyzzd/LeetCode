class Main {
    static class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
            next = null;
        }
    }

    public static Node reArrange(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        boolean flag = true;
        while (curr != null && curr.next != null) {
            if (flag) {
                if (curr.val > curr.next.val) {
                    swap(curr, curr.next);
                }
            } else {
                if (curr.val < curr.next.val) {
                    swap(curr, curr.next);
                }
            }

            curr = curr.next;
            flag = !flag;
        }

        return head;
    }

    private static void swap(Node a, Node b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reArrange(head);
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}