/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet();
        for (int i : G)
            set.add(i);
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }
        return ans;
    }
}
// O(n)
// O(n)
