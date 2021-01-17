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
    public List<Integer> inorderTraversal(TreeNode root) {
     List<Integer> list = new LinkedList();
        // recursive(root, list);
        iterative(root, list);
        return list;
    }
    
    private void iterative(TreeNode ptr, List<Integer> list) {
        Stack<TreeNode> stack = new Stack();
        while (!stack.empty() || ptr != null) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            list.add(ptr.val);
            ptr = ptr.right;
        }
    }
    
    private void recursive(TreeNode ptr, List<Integer> list) {
        if (ptr == null) {
            return;
        }
        recursive(ptr.left, list);
        list.add(ptr.val);
        recursive(ptr.right, list);
    }
}