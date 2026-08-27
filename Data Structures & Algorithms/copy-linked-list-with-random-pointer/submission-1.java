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
        // How to copy the random nodes?
        // HashMap! --> Node values are NOT guarenteed to be unique..
        // Input: head = [[3,null],[7,3],[4,0],[5,1]]
        //      Output:  [[3,null],[7,3],[4,0],[5,1]]


        // Copying the node is fine... But how do you copy the pointer to the random?
        // Oh by simply having a hash between the copy and the og nodes, 
        // so you can do randoms in the end!

        Node copyHead = new Node(0);
        Node curr = copyHead;
        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node original = head;
        while (original != null) {
            Node copy = new Node(original.val);
            nodeMap.put(original, copy);

            curr.next = copy;
            curr = curr.next;
            original = original.next;
        }

        // List is built, now random just needs to be built...
        curr = copyHead.next;
        original = head;
        while (original != null) {
            if (original.random != null)
                curr.random = nodeMap.get(original.random);

            curr = curr.next;
            original = original.next;
        }

        return copyHead.next;
    }
}
