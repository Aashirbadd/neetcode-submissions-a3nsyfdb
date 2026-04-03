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
        invertNodes(root);
        return root;
    }

    private void invertNodes(TreeNode node){
        if (node == null) return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertNodes(node.right);
        invertNodes(node.left);
    }
}


// Given a binary tree's root, invert it, and return its root
// What's an inverted tree?

// Left and right child are flipped recursively.