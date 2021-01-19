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
    private Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, 
                               int preRight, int inLeft, int inRight){
        // Stop condition, the input range for either preorder or the range of the inorder is invalid
        // i.e. no element in either range -> preLeft > preRight || inLeft > inRight
        if (preLeft > preRight) return null;
        int pindex = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTree(preorder, inorder, preLeft + 1, pindex - inLeft + preLeft, inLeft, pindex - 1);
        root.right = buildTree(preorder, inorder, pindex - inLeft + preLeft + 1, preRight, pindex + 1, inRight);
        return root;
    }
}