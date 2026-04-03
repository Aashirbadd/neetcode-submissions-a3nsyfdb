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
        if (head == null) return head;

        ListNode curr = head;
        ListNode next = head.next;

        curr.next = null;

        while (next != null) {
            ListNode newNext = next.next;
            next.next = curr;
            curr = next;
            next = newNext;
        }

        return curr;
    }
}

// 1 -> h -> null
// h 
// 2 -> 3 -> null
// nn

// 0 -> 1 -> 2 -> 3 -> null
// h    n    nn

// Curr:
// 3 -> 2 -> 1 -> 0 -> null

// Output:
// 3 -> 2 -> 1 -> 0 -> null