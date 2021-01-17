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

 /**Compare curr_sum and sum when a leaf is reached.
  * During the process of traveling from root to leaf, avoid nullpointerexception when the node is not leaf but it has either left or right child is null.
  */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSum(root, sum, 0);
    }
    
    private boolean hasPathSum (TreeNode ptr, int sum, int curr) {
        if (ptr.left == null && ptr.right == null) {
            return curr + ptr.val == sum;
        } else {
            if (ptr.left != null && ptr.right != null) {
                return hasPathSum(ptr.left, sum, curr + ptr.val) || hasPathSum(ptr.right, sum, curr + ptr.val);
            } else if (ptr.left != null) {
                return hasPathSum(ptr.left, sum, curr + ptr.val);
            } else{
                return hasPathSum(ptr.right, sum, curr + ptr.val);
            }
        }
    }
}