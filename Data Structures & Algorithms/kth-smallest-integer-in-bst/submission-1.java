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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) return 0;
        TreeNode curr = root;
        int index = 0;

        while (curr != null || !stack.isEmpty()) {
            // Dig deep left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Now curr == null, pop up from stack
            curr = stack.pop();
            index += 1;
            // If we're at the desired index, return current value
            if (index == k) return curr.val;
            // Otherwise go right
            curr = curr.right;
        }
        return 0;
    }
}
