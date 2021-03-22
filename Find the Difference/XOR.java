// Only the added new char will appear once. 
// All the common chars in s and t will appear twice.
// So, can us XOR operation to find the single item. (Single number problem)
// Time complexity: O(s.lenght + t.length), space complexity: O(1)
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for(int i = 0; i < s.length(); i++) {
            result ^= s.charAt(i) ^ t.charAt(i);
        }
        return (char) (result ^ t.charAt(t.length() - 1));
    }
}