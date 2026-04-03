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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;  // If f and s converge, there is a cycle.
        }

        return false; // If you can reach the end of the LL it's a cycle
    }
}

// We want to see if a linkedlist has a cycle in it or not.
// What makes it a cycle? If there is a node that connects to a previous element

// We 100% need some memory to store this.
// HashSet <ListNode>, if that element is already seen, we ret true, else false?
// I think that's good enough, because elements should have an object value.
