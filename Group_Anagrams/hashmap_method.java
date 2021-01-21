// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// The key problem is to design the key of the hashmap.
// To ensure one-to-one mapping relationship between keys and values, keys should all be unique.
// In this case, the essence is that no matter how the chars are reoordered, the sorted string will still be the same.
// Time complexity: O(N), space complexity: O(N) 
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = sortSingleString(str);
            if (map.containsKey(temp)) {
                List<String> lst = map.get(temp);
                lst.add(str);
                map.put(temp, lst);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(temp, lst);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
    
    private String sortSingleString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}