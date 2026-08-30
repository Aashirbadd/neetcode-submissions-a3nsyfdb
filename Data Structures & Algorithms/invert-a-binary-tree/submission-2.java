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
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        // Base Case?
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        
        root.left = right;
        root.right = left;

        return root;
    }
}

// Given the root of a binary tree, invert the children and return the root...

// This is a DFS recursive solution...