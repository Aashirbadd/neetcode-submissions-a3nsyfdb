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
    // Given the heads of two sorted lists (list1) and (list2)
    // Merge the two lists into one sorted list, and return the new head.
    // Input: list1 = [1,2,4], list2 = [1,3,5]
    // Output: [1,1,2,3,4,5]
    // 1 -> 2 -> 4 -> null   1 -> 3 -> 5 -> null
    // l1                    l2
    // 
    // dummy -> 1 -> 2 -> 3 -> 4
    //               l1

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }
}