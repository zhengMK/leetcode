
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        // recursive(root, list);
        iterative(root, list);
        return list;
    }
    private void recursive(TreeNode ptr, List<Integer> list) {
        if (ptr == null) {
            return;
        }
        recursive(ptr.left, list);
        recursive(ptr.right, list);
        list.add(ptr.val);
    }
    
    private void iterative(TreeNode ptr, List<Integer> list) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;
        while (!stack.empty() || ptr != null) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            if (ptr.right == null || ptr.right == prev) {
                // System.out.println(ptr.val);
                list.add(ptr.val);
                prev = ptr;
                ptr = null;
            } else {
                stack.push(ptr);
                ptr = ptr.right;
            }
        }
        return;
    }
}