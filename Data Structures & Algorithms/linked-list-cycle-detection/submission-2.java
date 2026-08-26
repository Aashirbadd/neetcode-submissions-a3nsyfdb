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
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (slow.val == fast.val) {
                return true;
            }
            else {
                slow = slow.next;

                if (fast.next == null || fast.next.next == null) {
                    return false;
                }

                fast = fast.next.next;
            }
        }
        return false;
    }
}

// Ret true if the linkedList has a cycle, false if not...
// How to do? Turtose & hare algorithm...