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
                    int t = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = t;
                }
            } else {
                if (curr.val < curr.next.val) {
                    int t = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = t;
                }
            }

            curr = curr.next;
            flag = !flag;
        }

        return head;
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