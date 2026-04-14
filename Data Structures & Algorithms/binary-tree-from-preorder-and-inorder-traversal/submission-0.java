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
    // Roots start from preorder, just where you place them comes down to inorder
    private int index = 0;                  // Index of current element (preorder)
    private HashMap<Integer, Integer> map;  // preorderNum --> inorderIndex
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);     // Inorder num, idx
        }
        return helper(preorder, inorder, 0, inorder.length);
    }
    // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // Output: [3,9,20,null,null,15,7]

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        
        int rootInorderIndex = map.get(preorder[index]);
        if (rootInorderIndex < start || rootInorderIndex >= end) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[index++]);
        TreeNode left = null;
        TreeNode right = null;
        
        if (index < inorder.length && map.get(preorder[index]) < rootInorderIndex) {
            // If preorder value is lesser...
            left = helper(preorder, inorder, start, rootInorderIndex);
            // Range 0 - root
        }
        if (index < inorder.length && map.get(preorder[index]) > rootInorderIndex) {
            // If preorder value is greater (belongs to the right)
            right = helper(preorder, inorder, rootInorderIndex + 1, end);
        }
        root.left = left;
        root.right = right;

        return root;
    }
}

// You're given both preorder & inorder traversals of a binary tree
// Both arrays are the same size and have unique values.
// Rebuild the binary from those pre, and inorder traversal, and return the root
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Output:
//              3
//          9       20
//                15  7

// The main thing is preorder, we are always placing the preorder element 
// And we're running it from index 0 to length. 
// So all we really need is the preorder index, and inorderMap
// Or the map to go from pre -> inorder (so we know if its left or right)
// 
