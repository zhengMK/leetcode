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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // recursive(root, list);
        iterative(root, list);
        return list;
    }
    private void recursive(TreeNode ptr, List<Integer> list) {
        if (ptr == null) {
            return;
        }
        // System.out.print(ptr.val + "\t");
        list.add(ptr.val);
        recursive(ptr.left, list);
        recursive(ptr.right, list);
    }
    private void iterative(TreeNode ptr, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.empty() || ptr != null) {
            // System.out.print(ptr.val + "\t");
            while (ptr != null) {
                list.add(ptr.val);
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            ptr = ptr.right;
        
        }
        return;
    }
}