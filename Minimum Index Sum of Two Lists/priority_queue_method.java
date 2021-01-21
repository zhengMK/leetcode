// This priority queue method is reasonably fast and memory-efficient. (Beats over 50% in terms of both time and space complexity)
// To use the built-in priority queue in java, need to override the comparator method, supporting comparison between nodes being composed of names of common restaurant and the sum of indexes in list1 and list2.
// Time complexity: O(M+NlogN) for traversing list1 and constructing list2, space complexity: O(M) for hashmap storing strings and index of list1.
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map_lst1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map_lst1.put(list1[i], i);
        Comparator<Node> comparator = new NodeComparator();
        PriorityQueue<Node> pq = new PriorityQueue<>(list2.length, comparator);
        for (int i = 0; i < list2.length; i++){
            if (map_lst1.containsKey(list2[i])) {
                Node node = new Node(list2[i], map_lst1.get(list2[i]) + i);
                pq.add(node);
            }
        }
        List<String> lst = new LinkedList<>();
        int smallest = pq.peek().val;
        lst.add(pq.remove().str);
        for (int i = 1; pq.size() != 0; i++) {
            if (smallest == pq.peek().val){
                lst.add(pq.remove().str);
            } else {
                break;
            }
        }
        return lst.toArray(new String[0]);
    }
}

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node x, Node y) {
        return x.val - y.val;
    }
}

class Node {
    public String str;
    public int val;
    
    public Node (String str, int val) {
        this.str = str;
        this.val = val;
    }
}