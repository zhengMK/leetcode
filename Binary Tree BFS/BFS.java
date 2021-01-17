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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode ptr = queue.remove();
                temp.add(ptr.val);
                if (ptr.left != null) {
                    queue.add(ptr.left);
                }
                if (ptr.right != null) {
                    queue.add(ptr.right);
                }
            }
            list.add(temp);
        }
            
        return list;
    }
}
