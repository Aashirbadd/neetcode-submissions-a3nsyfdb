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
        if (node == null) return null;
        // Maps old nodes to new nodes.
        HashMap<Node, Node> clones = new HashMap<>();
        return cloneNode(clones, node);
    }

    // Run DFS to recursively clone node & all neighbors.
    private Node cloneNode(HashMap<Node, Node> clones, Node node) {
        // Base Case: Clone is already created.
        if (clones.containsKey(node)) return clones.get(node);

        // Create clone of node & all neighbors
        Node copy = new Node(node.val);
        clones.put(node, copy);
        // Neighbors now
        for (Node neighbor : node.neighbors) {
            Node neighborCopy = cloneNode(clones, neighbor);
            copy.neighbors.add(neighborCopy);
        }
        return copy;
    }
}

// Given a node in a connected, undirected graph, return a deep copy of that graph.
// Each node has a val, and list of neigbors.
    // Each node is labeled from 1-n, corrosponding to its index (1 indexed, unique)
    // The index of each node within the adjacency list is the same as the node's value.
    // The input node will always be the first node and have 1 as the value

// Fuck I forgot how to work with adjacency lists. 
// Traverse node by node, and keep the values in a set
    // Since they are integer indexed.

// Input: adjList = [[2],[1,3],[2]]

// Build out the node:
    // set [[1 -> 2], [2 -> (1,3)], [3 -> 2]]

// Return [[2],[1,3],[2]]


