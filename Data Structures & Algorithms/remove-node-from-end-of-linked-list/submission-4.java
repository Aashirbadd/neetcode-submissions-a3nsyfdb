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
        // 1 -> 2 -> 3 -> 4 -> null, n = 2
        // 1 -> 2 -> 4 -> null
        int len = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            len += 1;
        }

        // Now let's move right to where we need to be
        int indexToRemove = len - n;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ptr = head;
        for (int i = 0; i < indexToRemove; i++) {
            prev = ptr;
            ptr = ptr.next;
        }
        // Prev is right before what we remove now...
        prev.next = prev.next.next; // This essentially removes the thing that we don't want
        
        return dummy.next;
    }
}
