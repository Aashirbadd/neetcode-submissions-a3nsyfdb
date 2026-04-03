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
        HashSet<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }

        return false;
    }
}

// We want to see if a linkedlist has a cycle in it or not.
// What makes it a cycle? If there is a node that connects to a previous element

// We 100% need some memory to store this.
// HashSet <ListNode>, if that element is already seen, we ret true, else false?
// I think that's good enough, because elements should have an object value.
