/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize main data structures
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        // Null check root and add it to queue
        if (root == null) return output;
        q.add(root);
        // Run main algorithm till tree is empty
        while (!q.isEmpty()) {
            // Add values to the list, add children
            int nodes = q.size();   // Number of nodes, not children
            List<Integer> currLevel = new ArrayList<>();
            // Add all node.val to currLevel, add children to q.
            for (int i = 0; i < nodes; i++) {
                // Add node to currLevel
                TreeNode node = q.poll();
                currLevel.add(node.val);
                // Add children to queue
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            // After entire level is traversed, add that level to output
            output.add(currLevel);
            // Repeat for all children
        }
        // Return all levels
        return output;
    }
}

// Goal: Return nested list of all the nodes of each level
// Input: root = [1,2,3,4,5,6,7]
// Output: [[1],[2,3],[4,5,6,7]]
//              1       q[1] add to list, then add children to list for next iteration
//          2       3   q[2,3] add to list, then add children to list for next iteration
//        4   5   6   7 q[4,5,6,7] add to list, then add children to list

// Question: How to know the level? --> Counter
// How to use this counter?
// 1 (2), 2,3 (4), 4,5,6,7 (8), remember, null can also be a child..
// We will add a counter (2) for each non null node.
