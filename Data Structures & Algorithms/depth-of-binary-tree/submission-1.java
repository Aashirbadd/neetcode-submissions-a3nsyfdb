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
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0);
    }

    private int findDepth(TreeNode root, int parentDepth) {
        if (root == null) return parentDepth;
        int leftDepth = findDepth(root.left, parentDepth + 1);
        int rightDepth = findDepth(root.right, parentDepth + 1);

        return Math.max(leftDepth, rightDepth);
    }
}

// DFS, and return maxLength;
// Keep going down the nodes and increment, return the max
