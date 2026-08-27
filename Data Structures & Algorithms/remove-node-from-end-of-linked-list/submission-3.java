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
        // Return the nth node from the end of the linkedList and then return the head...
        // First do one pass, for length, then remove on second pass
        // 1 -> 2 -> 3 -> 4 -> null
        //           c
        int len = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        int indexToRemove = len - n;
        ListNode prev = dummy;
        curr = head;
        for (int i = 0; i < indexToRemove; i++) {
            prev = curr;
            curr = curr.next;
        }
        // Prev will be the prev one, we move curr by one
        
        prev.next = prev.next.next;      // This pretty much cuts curr from the LinkedList

        return dummy.next;
    }
}
