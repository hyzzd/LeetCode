class Main{
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static Node rotateK(Node node, int k){
        if(node == null){
            return node;
        }

        Node curr = node;
        for(int i = 0; i < k - 1; i++){
            curr = curr.next;
        }

        Node head = curr;
        Node newHead = curr.next;
        if(newHead == null){
            return newHead;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        head.next = null;
        curr.next = node;
        return newHead;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node dummy = rotateK(head, 3);
        while(dummy != null){
            System.out.print(dummy.val);
            dummy = dummy.next;
        }
    }
}