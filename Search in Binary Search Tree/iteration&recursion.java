// One of the baisc operations of BST.
// Time complexity: O(logN), Space complexity: O(1)
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
    public TreeNode searchBST(TreeNode root, int val) {
        return iteration(root, val);
    }
    
    private TreeNode recursion(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        else if (node.val > val) return searchBST(node.left, val);
        else return searchBST(node.right, val);
    }
    
    private TreeNode iteration(TreeNode node, int val) {
        while (node != null) {
            if (node.val == val) return node;
            else if (node.val > val) node = node.left;
            else node = node.right;
        }
        return null;
    }

}