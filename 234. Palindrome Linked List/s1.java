/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode h;
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(h == null) h = head;
        boolean temp = true;
        if(head.next != null) temp &= isPalindrome(head.next);
        temp &= (head.val == h.val);
        h = h.next;
        return temp;
    }
}
// amazing recursive solution!
// O(n)
// O(lgn)
