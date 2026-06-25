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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode n1 = head;
        ListNode n2 = n1.next;
        ListNode n3;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            ListNode temp = n2;
            n2 = n3;
            n1 = temp;
        }

        return n1;
    }

}
