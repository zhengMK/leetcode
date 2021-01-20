// There should exist a one-to-one mapping relationship between the char in s and char in t.
// So, need two maps to record this one-to-one mapping.
// Time complexity: O(N) where is the string length of both s and t, space complexity: O(N) for storing two maps
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            } else if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (map2.get(t.charAt(i)) != s.charAt(i)) return false;
            }
        }
        return true;
    }
}