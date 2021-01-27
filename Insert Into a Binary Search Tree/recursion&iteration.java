// Time and space complexity are the same as the search operation: O(H) and O(1) where H is the height of the BST.
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        // recursion(root, val);
        iteration(root, val);
        return root;
    }
    
    private void iteration(TreeNode node, int val) {
        while (true) {
            if (isLeaf(node)) {
                if (node.val < val) node.right = new TreeNode(val);
                else node.left = new TreeNode(val);
                break;
            } else if (node.left == null && node.val > val) {
                node.left = new TreeNode(val);
                break;
            }
            else if (node.right == null && node.val < val) {
                node.right = new TreeNode(val);
                break;
            }
            else {
                if (node.val < val) node = node.right;
                else node = node.left;
            }
        }
    }
    
    private void recursion(TreeNode node, int val) {
        // System.out.println(node.val);
        if (isLeaf(node)) {
            if (node.val < val) node.right = new TreeNode(val);
            else node.left = new TreeNode(val);
        } else if (node.left == null && node.val > val) node.left = new TreeNode(val);
        else if (node.right == null && node.val < val) node.right = new TreeNode(val);
        else {
            if (node.val < val) recursion(node.right, val);
            else recursion(node.left, val);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    
}