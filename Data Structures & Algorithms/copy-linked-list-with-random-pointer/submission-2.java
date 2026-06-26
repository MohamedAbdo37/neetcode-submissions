/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> dict = new HashMap<>();
        Node newList = new Node(head.val);
        dict.put(head, newList);
        Node move1 = newList;
        Node move2 = head.next;
        while(move2 != null) {
            Node next = new Node(move2.val);
            dict.put(move2, next);
            move1.next = next;
            move1 = next;
            move2 = move2.next; 
        }

        move1 = newList;
        move2 = head;
        while(move1 != null) {
            Node target = move2.random;
            if (target != null) {
                target = dict.get(target);
                move1.random = target;
            }
            move1 = move1.next;
            move2 = move2.next;
        }


        return newList;
    }
}
