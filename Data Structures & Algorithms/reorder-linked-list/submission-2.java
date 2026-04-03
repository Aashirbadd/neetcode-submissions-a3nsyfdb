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
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        // Find midpoint
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // MP is at slow.next;
        // Reverse the second half of the list.
        

        ListNode head2 = slow.next;
        ListNode next = head2.next;
        
        slow.next = null;
        head2.next = null;
        while (next != null) {
            ListNode next2 = next.next;
            next.next = head2;
            head2 = next;
            next = next2;
        }
        // H2 is now reversed.
        // Merge head & head2, head2 is always shorter or equal length.
        ListNode output = head;
        while (head2 != null && head != null) {
            
            ListNode nextHead = head.next;
            ListNode nextHead2 = head2.next;

            head.next = head2;
            head.next.next = nextHead;

            head = nextHead;
            head2 = nextHead2;
        }
        head = output;

    }
}
// Goal:

// [0, 1, 2, 3, 4, 5, 6] -> [0, 6, 1, 5, 2, 4, 3]
// First, last, second, secondlast, so on.
// Make a copy of a reversed list, and make it so you have all of the elements in rev order
// Or just make it a doubly linked list.

// Turtose and hare algorithm
// Slow ptr, fast ptr.

// 2 phases,
// 1. Find the midpoint of the array
// 2. Reverse the second half
// 3. Merge the two arrays

// Input: [0, 1, 2, 3, 4, 5, null]
//               s        f 
// If fast == null, then we're at a odd length array, if fast.next == null, even length
// Both cases, subarray starts at slow.next, even length