class Main {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node partition(Node head, int k) {
        Node less = new Node(-1);
        Node greater = new Node(-1);
        Node lessH = less, greaterH = greater;
        while (head != null) {
            if (head.val < k) {
                less.next = new Node(head.val);
                less = less.next;
            } else if (head.val > k) {
                greater.next = new Node(head.val);
                greater = greater.next;
            }

            head = head.next;
        }

        less.next = new Node(k);
        less = less.next;
        less.next = greaterH.next;
        return lessH.next;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(8);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(3);
        Node res = partition(head, 3);
        Node cur  = res;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}