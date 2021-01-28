class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Trie root = new Trie();
        for (String str : dictionary) root.insert(str);
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 1) {
                if (i == strings.length - 1) sb.append(strings[i]);
                else sb.append(strings[i] + " ");
                continue;
            }
            for (int j = 1; j < strings[i].length(); j++){
                if (root.search(strings[i].substring(0, j))){
                    if (i == strings.length - 1) sb.append(strings[i].substring(0, j));
                    else sb.append(strings[i].substring(0, j) + " ");
                    break;
                } else if (j == strings[i].length() - 1) {
                    if (i == strings.length - 1) sb.append(strings[i]);
                    else sb.append(strings[i] + " ");
                } 
            }
        }
        
        return sb.toString();
    }
}

class Trie {
    class TrieNode{
        char ch;
        boolean isWord;
        Map<Character, TrieNode> next;
        public TrieNode() {
            ch = 0;
            isWord = false;
            next = null;
        }
        public TrieNode(char ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
            next = null;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode ptr = root;
        for (int i = 0; i < chars.length; i++) {
            if (ptr.next == null) ptr.next = new HashMap<Character, TrieNode>();
            if (ptr.next.containsKey(chars[i])) {
                if (i == chars.length - 1) {
                    TrieNode temp = ptr.next.get(chars[i]);
                    temp.isWord = true;
                    ptr.next.put(chars[i], temp);
                } 
            } else {
                if (i == chars.length - 1) ptr.next.put(chars[i], new TrieNode(chars[i], true));
                else ptr.next.put(chars[i], new TrieNode(chars[i], false));
            }
            ptr = ptr.next.get(chars[i]);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode ptr = root;
        for (int i = 0; i < chars.length; i++) {
            if (ptr.next == null || !ptr.next.containsKey(chars[i])) return false;
            if (i == chars.length - 1) return ptr.next.get(chars[i]).isWord;
            ptr = ptr.next.get(chars[i]);
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode ptr = root;
        for (int i = 0; i < chars.length; i++) {
            if (ptr.next == null || !ptr.next.containsKey(chars[i])) return false;
            ptr = ptr.next.get(chars[i]);
            if (ptr == null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */