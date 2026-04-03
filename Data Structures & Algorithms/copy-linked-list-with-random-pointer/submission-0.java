/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node head2 = new Node(0);

        Node curr = head;
        Node prev = head2;
        // 1 -> 2 -> 3 -> 4 -> null
        //                      c
    //                    p
    //  d->1->2->3->4

        while (curr != null) {
            Node copy = new Node(curr.val); // Create copy node

            prev.next = copy;               // Add it to the list
            prev = prev.next;               // Mode prev ptr

            nodeMap.put(curr,copy);         // map it
            curr = curr.next;               // move curr
        }

        // Now fill in randoms:
        curr = head;
        Node copy = head2.next;

        while (curr != null) {
            copy.random = nodeMap.get(curr.random);

            copy = copy.next;
            curr = curr.next;
        }

        return head2.next;
    }
}

// Input: Given linkedList head with random pointer
// Goal: Return a deep copy of this list (what does that mean?)
    // Each copied node should have: original val, next on new node pointer to next of which mirrors original node
        // random on new node pointing to a random that mirrors original random
    // The difficulty of this comes in because we need to map it to the random

// Example:
    // 0    1    2    3 (idx)
    // 3 -> 7 -> 4 -> 5 -> null
    // n    3    0    1 (rdm)

    // Creating the initial linkedlist is on problem, linking the random is the hard part.
    // How can we create this link between random and new node?
    // Create a map which links each new node to its old node, then reconnect them in rand.
    // We can use the object identities to create the links, and make the list a true deep copy.