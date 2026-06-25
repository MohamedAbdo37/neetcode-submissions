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
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        slow = slow.next;
        while(slow != null && fast != null){
            if (fast == slow)
                return true;

            slow = slow.next;
            if (fast.next != null )
                fast = fast.next.next;
            else
                break;
        }

        return false;
    }
}
