/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Given a node, return a deep copy. Meaning essentially that it maintains the same edges
        // and also same nodes...

        // Clone nodes first, and then clone the edges second with the HashMap style... Yeah...

        // Clone Nodes with DFS
        if (node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Stack<Node> stack = new Stack<>();        
        map.put(node, new Node(node.val));          // mark and add always...
        stack.push(node);

        // Make sure node & neighbors in the stack are copied and added to map...
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            Node copy = map.get(curr);
            map.put(curr, copy);

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    stack.push(neighbor);
                }
            }
        }

        // Clone Edges with Second Pass
        HashSet<Node> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);          // In graph, always push and mark back to back
        // It's like pick and roll, if you're pushing you need to also be marking...
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            Node copy = map.get(curr);

            // For every neighbor that curr has, put it in copy...
            for (Node neighbor : curr.neighbors) {
                Node neighborCopy = map.get(neighbor);
                copy.neighbors.add(neighborCopy);

                // Only process copy if it has a empty neighbor list
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.add(neighbor);
                }
            }
        }

        return map.get(node);
    }
}
// Input: adjList = [[2],[1,3],[2]]
// Output: [[2],[1,3],[2]]

// We could traverse through the input array and we can create node and edge copies as we go?
// Yeah we could... Just try for 15, and if not you can NC vid it...