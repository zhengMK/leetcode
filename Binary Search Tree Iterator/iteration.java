// If you cannot do this, review the iteration method for inorder traversal.
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
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode ptr;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        ptr = root;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
    }
    
    public int next() {
        while(ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
        ptr = stack.pop();
        int temp = ptr.val;
        ptr = ptr.right;
        return temp;
    }
    
    public boolean hasNext() {
        return !stack.empty() || ptr != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */