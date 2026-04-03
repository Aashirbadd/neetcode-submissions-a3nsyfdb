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
// d -> 
// o
// 1->2->3->n
// 1p
// 4->5->6->n
// 2p
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode output = head;

        int carryOver = 0;
        
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carryOver) % 10;             // 13 = 3
            carryOver = (l1.val + l2.val + carryOver) / 10;           // 13 = 1
            
            output.next = l1;
            output.next.val = sum;
            
            output = output.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remaining;
        if (l1 == null) remaining = l2;
        else remaining = l1;

        // System.out.printf("Carryover: %d\n", carryOver);
        while (carryOver != 0) {
            if (remaining == null) {
                output.next = new ListNode(carryOver);
                output = output.next;
                break;
            }

            int sum = (remaining.val + carryOver) % 10;
            carryOver = (remaining.val + carryOver) / 10;

            output.next = remaining;
            output.next.val = sum;

            output = output.next;
            remaining = remaining.next;
        }

        output.next = remaining;

        return head.next;
    }
}

// Input: l1 = [1,2,3], l2 = [4,5,6]
// Output: [5,7,9]
// Sum, carryover

// 1->2->3->5->null
//          ^
// 6->9->2->6->null
//          ^