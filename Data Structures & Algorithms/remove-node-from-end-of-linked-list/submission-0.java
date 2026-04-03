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
        if (head == null) return head;

        // Find Len
        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode ptr = dummy;
        while (ptr.next != null){
            len += 1;
            ptr = ptr.next;
        }

        int iBeforeN = len - n;
        ptr = dummy;

        while (iBeforeN > 0) {
            ptr = ptr.next;
            iBeforeN -= 1;
        }

        // ptr is now at idxToRemove -1, splice here
        ListNode prev = ptr;
        ListNode next = ptr.next.next;

        prev.next = next;

        return dummy.next;

        // wb edgecase of removing head, we need a dummyHead
        // dummy -> 5 -> null
        // 
    }
}

// Input: Given the beginning of linkedlist, and integer n.

// Goal, remove the nth node from the end of the list, and return the beginning of the list

// Example: 
// Input: head = [1,2,3,4], n = 2
// Output: [1,2,4] (because 3 is the second last node)

// Visualisation:

// 0  1  2  3
// 1->2->3->4->null
//          ^
// Len = 4
// n = 2, node to remove = 4-2+1 = 3rd node, then travel again and remove 3rd node

// Input: head = [5], n = 1
// Output: []
// Len=1, n=1, NTR=1, ans = []

// Input: head = [1,2], n = 2
// Output: [2]
// Len=2,n=2,NTR=1,ans=2


// We can use slow and fast pointers to find the end of the list, and with that we have a 
// midpoint, and we know how long the list is, afterwards, we go to the len - n node, and delete it.


