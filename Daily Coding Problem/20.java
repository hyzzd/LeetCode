class Main {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Node reverse(Node root) {
        Node prev = null;
        Node curr = root;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        root = prev;
        return root;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public Node intersect(Node l1, Node l2) {
        Node n1 = reverse(l1);// printList(n1);
        Node n2 = reverse(l2);// printList(n2);

        Node result = null;
        while (n1.val == n2.val) {
            result = new Node(n1.val);

            n1 = n1.next;
            n2 = n2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.head = new Node(3);
        m.head.next = new Node(7);
        m.head.next.next = new Node(8);
        m.head.next.next.next = new Node(10);
        Node l1 = m.head;
        m.head = new Node(99);
        m.head.next = new Node(1);
        m.head.next.next = new Node(8);
        m.head.next.next.next = new Node(10);
        Node l2 = m.head;

        Node node = m.intersect(l1, l2);
        System.out.println(node.val);
    }
}
/*
 * class LinkedList{ Node head;
 * 
 * public void add(int data){ Node newNode = new Node(data);
 * 
 * if(head == null){ head = new Node(data); return; }
 * 
 * newNode.next = null; Node last = head; while(last.next != null){ last =
 * last.next; }
 * 
 * last.next = newNode; return; } }
 */