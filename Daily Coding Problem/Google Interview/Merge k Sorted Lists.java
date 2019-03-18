import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Main {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode copy = result;
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null)
                q.offer(list);
        }
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            if (node.next != null) {
                q.offer(node.next);
                node.next = null;
            }
            copy.next = node;
            copy = copy.next;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}