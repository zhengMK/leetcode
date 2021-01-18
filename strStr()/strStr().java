// This is the intuitive solution.
// If haystack.length() == a and needle.length() == b, time complexity if O(a*b), and space complexity is O(1).
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0; 
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}