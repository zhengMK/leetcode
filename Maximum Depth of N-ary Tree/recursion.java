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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return maxDepth(root, 0);
    }
    private int maxDepth(Node node, int depth){
        if (node.children.size() == 0) return depth + 1;
        int max = 0;
        for (Node child: node.children) {
            int childDepth = maxDepth(child, depth + 1);
            max = Math.max(max, childDepth);
        }
        return max;
    }
}