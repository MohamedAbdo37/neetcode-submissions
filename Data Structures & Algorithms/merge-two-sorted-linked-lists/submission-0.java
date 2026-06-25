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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
            
        ListNode l;

        if (list1.val < list2.val) {
            l = list1;
            list1 = list1.next;

        } else {
            l = list2;
            list2 = list2.next;
        }
        l.next = null;
        ListNode head = l;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode nextTemp = list1.next;
                l.next = list1;
                list1 = nextTemp;
            } else {
                ListNode nextTemp = list2.next;
                l.next = list2;
                list2 = nextTemp;
            }
            l = l.next;
            l.next = null;
        }

        while (list1 != null) {
            l.next = list1;
            list1 = list1.next;
            l = l.next;
            l.next = null;
        }

        while (list2 != null) {
            l.next = list2;
            list2 = list2.next;
            l = l.next;
            l.next = null;
        }

        return head;
    }
}