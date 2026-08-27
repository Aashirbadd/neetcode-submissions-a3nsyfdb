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
        // 9 -> null
        // 9 -> null
        // 8 -> 1 -> null

        // We need to do good ol hand written math, 
        // but I feel like we might have to reverse the nums first

        //  1 -> 2 -> 3 -> null
        //  4 -> 5 -> 6 -> null
        //  5 -> 7 -> 9 -> null
        //  Ohh the digits are already stored in reverse order... Great...

        // Question: Will L1 and L2 always be the same length? Or they don't need to
        // Because they are in reverse order anyways, we can just work on them left to r.
        // Okay then we can just work on them one at a time...
        // Get the sum, then get the remainder as carryover and keep building the sol...
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int remainder = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remainder;
            remainder = sum / 10;
            int val = sum % 10;

            ListNode next = new ListNode(val);
            curr.next = next;
            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remainderNode;
        if (l1 == null && l2 == null) {
            remainderNode = null;
        } else if (l1 != null) {
            remainderNode = l1;
        } else {
            remainderNode = l2;
        }

        while (remainderNode != null) {
            int sum = remainderNode.val + remainder;
            remainder = sum / 10;
            int val = sum % 10;

            ListNode next = new ListNode(val);
            curr.next = next;
            curr = curr.next;
            remainderNode = remainderNode.next;
        }

        if (remainder != 0) {
            ListNode next = new ListNode(remainder);
            curr.next = next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
