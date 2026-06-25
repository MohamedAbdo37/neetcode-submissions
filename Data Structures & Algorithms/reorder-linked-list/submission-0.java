/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        int n = 0;
        ListNode start = head;
        while (start != null) {
            n++;
            start = start.next;
        }
        start = head;
        int limit = n/2;
        if (n % 2 == 0) limit--;
        for (int i = 0; i < limit; i++) {
            start = start.next;
        }

        ListNode rev = this.reverceList(start);

        start = head;

        while (start != null) {
            ListNode next1 = start.next;
            ListNode next2 = rev.next;
            start.next = rev;
            rev.next = next1;
            rev = next2;
            start = next1;
        }

    }

    private ListNode reverceList(ListNode n) {
        if (n == null)
            return n;

        ListNode prev = null;
        ListNode curr = n;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
