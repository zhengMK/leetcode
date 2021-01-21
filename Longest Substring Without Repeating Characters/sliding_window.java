// Note that the sliding window's window size is changeable.
// When we not meet a duplicate, we increase the right by 1, and the add that char into the set. During this process, left pointer does not change its position.
// When we meet a duplicate, we will stop increasing right and start removing the leftmost element in the window.
// When duplicate does not exist in the window array, we will increase the right pointer to the right again.
// Repeat this process until we reach the end of the input array.
// Time complexity: O(N), space complexity: O(1) if we consider that s only contains ACSII code, so there will be at most 128 chars in set, which is a constant.
class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
        int length = s.length(), ret = 0;
        for (int left = 0, right = -1; left < length; left++) {
            if (left != 0) set.remove(s.charAt(left - 1));
            while (right + 1 < length && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(++right));
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}