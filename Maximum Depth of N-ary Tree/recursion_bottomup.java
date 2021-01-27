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
        if (root.children.size() == 0) return 1;
        if (root.children.size() == 1) return maxDepth(root.children.get(0)) + 1;
        int max = 0;
        for (Node child: root.children) {
            int temp = maxDepth(child);
            max = Math.max(max, temp);
        }
        return max + 1;
    }
}