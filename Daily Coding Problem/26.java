class Main {
    public void removeLast(Node head, int n) {
        if (head == null) {
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        for (int i = 1; i <= n + 1; ++i) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Node head = new Node(1);
        m.removeLast(head, 2);
        System.out.println("Hello World!");
    }
}

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }
}