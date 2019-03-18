class Main {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        // Also can cal in values and update whole list
        head = reverse(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int carry = 1;
        while (head != null) {
            int sum = head.val + carry;
            head.val = sum % 10;
            carry = sum / 10;
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = dummy.next;
            dummy.next = temp;

        }
        return dummy.next;

        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode next = null;
        // while (curr != null) {
        // next = curr.next;
        // curr.next = prev;
        // prev = curr;
        // curr = next;
        // }
        // head = prev;
        // return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}