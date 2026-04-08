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
    private int good;

    public int goodNodes(TreeNode root) {
        good = 0;
        if (root == null) return good;
        
        dfs(root, Integer.MIN_VALUE);
        return good;
    }

    private void dfs(TreeNode root, int maxInPath) {
        // No null case
        if (root.val >= maxInPath) {
            good += 1;
            maxInPath = root.val;
        }

        if (root.left != null)  dfs(root.left, maxInPath);
        if (root.right != null) dfs(root.right, maxInPath);
    }
}

// Return the number of good nodes: A node (X) is considered GOOD if the path from the ROOT
// of the tree to node (X) contains no values greater than node X.

// Input: root = [2,1,1,3,null,1,5]
//              [2]
//            1 (2)    1 (2)
//          [3](3) n  1[5] (2)