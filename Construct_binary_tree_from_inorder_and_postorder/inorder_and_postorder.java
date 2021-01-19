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
// Time complexity: O(N), space complexity: O(N)
class Solution {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder,int[] postorder,int inLeft,int inRight,int postLeft,int postRight) {
        if (inRight-inLeft != postRight-postLeft){
            throw new RuntimeException("Wrong index");
        }
        if (postLeft > postRight) return null;
        int pindex = map.get(postorder[postRight]);
        TreeNode root = new TreeNode(postorder[postRight]);
        root.left = buildTree(inorder, postorder, inLeft, pindex-1, postLeft, pindex+postLeft-1-inLeft);
        root.right = buildTree(inorder, postorder, pindex+1, inRight, pindex+postLeft-inLeft, postRight - 1);
        return root;
    }
}