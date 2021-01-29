// One simple and intuitive solution is BFS.
// We do level-order traversal on the tree and only add the node val to the list when we meet the rightmost node in the level.
// Time complexity: O(N) need to traverse all the nodes in the tree, Space complexity: O(N) for storing the nodes into the queue.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new LinkedList<>();
        if (root == null) return lst;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                if (i == size - 1) lst.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return lst;
    }
}