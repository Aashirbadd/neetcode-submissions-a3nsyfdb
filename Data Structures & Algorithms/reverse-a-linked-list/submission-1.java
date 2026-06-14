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
        // Before: 1 -> 2 -> 3 -> null, After: 3 -> 2 -> 1 -> null
        return dfs(null, head);
    }

    private ListNode dfs(ListNode prev, ListNode curr) {
        // Base case
        if (curr == null) {
            return prev;
        }
        // Recursive case
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        return dfs(prev, curr);
    }
}

// Okay let's try this shit with recursion...

// Input = 1 -> 2 -> 3 -> null
// Broken it down: reversed(2 -> 3 -> null) -> 1 -> null
// General form: head -> tail
// return tail -> head -> prev
// Base case = curr = null... --> Just return what you have rn...
// Final form: 3 -> 2 -> 1 -> null