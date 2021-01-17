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
/**Bottom-up approach */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    
    private int maxDepth(TreeNode ptr, int depth) {
        if (ptr == null) return depth;
        int left = maxDepth(ptr.left, depth + 1);
        int right = maxDepth(ptr.right, depth + 1);
        return left > right ? left:right;
    }
}