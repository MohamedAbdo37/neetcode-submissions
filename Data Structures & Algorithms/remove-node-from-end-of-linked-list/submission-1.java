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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode s = head;
        while (s != null) {
            size++;
            s = s.next;
        }

        if (head == null)
            return null;

        int steps = size - n - 1;
        s = head;
        for (int i = 0; i < steps; i++){
            s = s.next;
        }

        if (steps < 0) {
            head = head.next;
        }
        
        if (s.next != null)
            s.next = s.next.next;
        else
            s.next = null;

        return head;
    }
}
