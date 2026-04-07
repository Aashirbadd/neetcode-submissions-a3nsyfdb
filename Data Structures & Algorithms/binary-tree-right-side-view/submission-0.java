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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> output = new ArrayList<>();

        if (root == null) return output;
        q.add(root);

        while (!q.isEmpty()) {
            int nodesInLevel = q.size();

            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode node = q.poll();
                // Add rightmostNode to output
                if (i == nodesInLevel - 1)  output.add(node.val);
                // Add children to queue
                if (node.left != null)      q.add(node.left);
                if (node.right != null)     q.add(node.right);
            }
        }

        return output;
    }
}


// [1,2,3,null,4,null,5]

//              1           [1]
//          2       3       [2,3]
//         n  4    n   5    [4,5]

// Output = 1,3,5

// Makes sense, do a simple BFS, and add only right most nodes to the output
// Simple BFS with queue, and when queue size == 1, then add it.