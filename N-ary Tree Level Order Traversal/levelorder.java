// Basically the same as the level-order traversal of binary tree
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ret = new LinkedList<>();
        while (queue.size() != 0) {
            int size = queue.size();
            List<Integer> temp_lst = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                temp_lst.add(temp.val);
                for (Node child: temp.children) {
                    queue.add(child);
                }
            }
            ret.add(temp_lst);
        }
        return ret;
    }
}