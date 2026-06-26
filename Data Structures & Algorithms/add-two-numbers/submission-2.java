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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = l1;
        ListNode move1 = l1;
        ListNode move2 = l2;

        while (move2 != null) {
            int val = move1.val + move2.val;
            move1.val += move2.val;
            move2 = move2.next;

            if (move1.next != null)
                move1 = move1.next;
            else
                break;
        }

        
        if (move2 != null)
            move1.next = move2;
        
        move1 = start;
        move2 = move1.next;

        while (move2 != null) {
            if (move1.val > 9) {
                int c = (move1.val / 10);  
                move1.val %= 10;
                move2.val += c;
            }

            move1 = move2;
            move2 = move1.next;
        }

        if (move1.val > 9) {
            int c = (move1.val / 10);  
            move1.next = new ListNode(c);
            move1.val %= 10;
        }

        return start;
    }
}
