/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*Use BFS to cascade node in the same level togeter*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node ptr = queue.removeFirst();
                if (i == size - 1) {
                    ptr.next = null;
                } else {
                    Node temp = queue.removeFirst();
                    ptr.next = temp;
                    queue.addFirst(temp);
                }
                if (ptr.left != null) {
                    queue.addLast(ptr.left);
                }
                if (ptr.right != null) {
                    queue.addLast(ptr.right);
                }
            }
        }
        return root;
    }
}