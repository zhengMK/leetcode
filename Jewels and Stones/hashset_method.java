// Use a set to realize quick find chars in jewels.
// Time complexity: O(M + N) for traversing chars in jewels and stones, space complexity: O(M) for the hashset.
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewels_set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewels_set.add(c);
        }
        int ret = 0;
        for (char c : stones.toCharArray()) {
            if (jewels_set.contains(c)) ret += 1;
        }
        return ret;
    }
}