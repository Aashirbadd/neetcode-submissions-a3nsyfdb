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
    // Reorder a linkedList to this order: [0, n-1, 1, n-2, 2, n-3, ...]
    // Before: 2 -> 4 -> 6 -> 8 -> nul
    //                   s         f
    // After:  2 -> 8 -> 4 -> 6
    public void reorderList(ListNode head) {
        // Find the middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // By here midpoint will be at slow
        ListNode second = slow.next;
        slow.next = null;      // Slash the old list...

        // Reverse the second half...
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        // Prev now has head of the reversed second half...
        ListNode head1 = head;
        ListNode head2 = prev;
        // Merge head1 and head2 (head1 is usually longer)
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
    }
}









