// Use a maximum priority queue to tack the most frequent element in the array.
// Compared to the quickselect method, this is more intuitive.
// Time complexity is bouned by the construction of the pq: O(NlogN) (This might be the hint provided by LeetCode)
// Space complexity: O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else  map.put(num, 1);
        }
        Comparator<Node> comparator = new NodeComparator();
        PriorityQueue<Node> pq = new PriorityQueue<>(nums.length, comparator);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        int[] ret = new int[nums.length];
        int index = 0;
        for (int i = 0; i < k; i++) {
            ret[index++] = pq.remove().val;
        }
        return Arrays.copyOfRange(ret, 0, index);
    }
    
    private class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y){
            return y.count - x.count;
        }
    }
    
    class Node {
        int val;
        int count;
        public Node (int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
} 