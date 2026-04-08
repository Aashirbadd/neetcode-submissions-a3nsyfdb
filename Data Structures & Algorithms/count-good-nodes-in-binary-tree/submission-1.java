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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int maxInPath) {
        if (root == null) return 0;

        int nodeIsGood = 0;
        // No null case
        if (root.val >= maxInPath) {
            nodeIsGood = 1;
            maxInPath = root.val;
        }

        int left = dfs(root.left, maxInPath);
        int right = dfs(root.right, maxInPath);

        return left + right + nodeIsGood;
    }
}

// Return the number of good nodes: A node (X) is considered GOOD if the path from the ROOT
// of the tree to node (X) contains no values greater than node X.

// Input: root = [2,1,1,3,null,1,5]
//              [2]
//            1 (2)    1 (2)
//          [3](3) n  1[5] (2)