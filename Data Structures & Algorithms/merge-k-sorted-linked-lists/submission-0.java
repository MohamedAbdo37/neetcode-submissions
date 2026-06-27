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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        ListNode l = lists[0];
        
        for (int i = 1; i < lists.length; i++) {
            l  = this.merge(l, lists[i]);
        }

        return l;
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode prev1 = null;
        ListNode prev2 = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
            head.next = list1;
        }

        prev1 = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev1 = list1;
                list1 = list1.next;
            } else {
                ListNode temp = list2.next;
                prev1.next = list2;
                list2.next = list1;
                prev1 = list2;
                list2 = temp;
            }
        }

        if (list2 != null) {
            prev1.next = list2;
        }


        return head;
    }
}
