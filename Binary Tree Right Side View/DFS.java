//  Time complexity: O(N), Space complexity: O(N) will ocupy more stack because of using recursion.
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
    List<Integer> lst = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        DFS(root, 0);
        return lst;
    }
    
    public void DFS(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == lst.size()) { // if this is true, it means its our first time visiting this level, then we add the node.val into lst.
            lst.add(node.val);
        }
        DFS(node.right, depth + 1); // 1st visit the right, then the left
        DFS(node.left, depth + 1); // so, for left side view, can just reverse this.
    }
}