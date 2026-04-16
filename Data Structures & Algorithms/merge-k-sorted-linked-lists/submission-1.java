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
    public ListNode mergeKLists(ListNode[] lists) {
        // Initialise minheap
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            // a is before b if a is smaller (smallest at root)
            (a,b) -> Integer.compare(a.val, b.val)
        );
        // Put elements into minheap
        for (ListNode list : lists) q.add(list);

        ListNode head = new ListNode(-1);
        ListNode builder = head;
        while (!q.isEmpty()) {
            ListNode curr = q.poll();

            builder.next = curr;
            builder = builder.next;

            curr = curr.next;
            if (curr != null) q.add(curr);
        }

        return head.next;
    }
}

// Input: You're given a array of k linkedlists (lists) where eacheach list is sorted
// in ascending order. (x, x+1, x+2, ..., x+n)

// Return a sorted linkedlist that is a result of merging all the individual linkedLists.
// so head has the smallest value? That's easy, just use a minheap priority queue

// Input: lists = [[1,2,4],[1,3,5],[3,6]]   (The (min)q sorts the list based on the head val)
//                                    ^

// Output= [1,1,2,3,3,4,5,6]

// Put the LinkedLists in a MinHeap, minimum head at tip, keep popping, and keep it going.






