class MapSum {
    class TrieNode {
        public int val;
        public boolean isWord;
        public char ch;
        public Map<Character, TrieNode> next;
        public TrieNode () {
            val = 0;
            isWord = false;
            ch = 0;
            next = null;
        }
        public TrieNode (char ch, boolean isWord, int val) {
            this.ch = ch;
            this.isWord = isWord;
            this.val = val;
            next = null;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        char[] chars = key.toCharArray();
        TrieNode ptr = root;
        for (int i = 0; i < chars.length; i++) {
            if (ptr.next == null) ptr.next = new HashMap<Character, TrieNode>();
            if (ptr.next.containsKey(chars[i])) {
                if (i == chars.length - 1) {
                    TrieNode temp = ptr.next.get(chars[i]);
                    temp.isWord = true;
                    temp.val = val;
                    ptr.next.put(chars[i], temp);
                }
            } else {
                if (i == chars.length - 1) ptr.next.put(chars[i], new TrieNode(chars[i], true, val)); 
                else  ptr.next.put(chars[i], new TrieNode(chars[i], false, 0));
            }
            ptr = ptr.next.get(chars[i]);
        }
    }
    
    public int sum(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode ptr = root;
        int ret = 0;
        for (int i = 0; i < chars.length; i++){
            if (ptr.next == null || !ptr.next.containsKey(chars[i])) return 0;
            ptr = ptr.next.get(chars[i]);
            if (ptr == null) return 0;
        }
        // System.out.println(ptr.ch + "\t" + ptr.val);
        return vals(ptr);
    }
    
    private int vals(TrieNode node) {
    //     System.out.println(node.ch + "\t" + node.val);
        if (node.next == null) {
            if (node.isWord) return node.val;
            else return 0;
        }
        int sum = node.val;
        for (Map.Entry<Character, TrieNode> entry: node.next.entrySet()) {
            // System.out.println(entry.getValue().ch + "\t" + entry.getValue().val);
            if (entry.getValue().next == null) sum += entry.getValue().val;
            else if (entry.getValue().isWord) sum += vals(entry.getValue());
            else sum += entry.getValue().val + vals(entry.getValue());
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */