// Only the added new char will appear once. 
// All the common chars in s and t will appear twice.
// So, can us XOR operation to find the single item. (Single number problem)
// Time complexity: O(s.lenght + t.length), space complexity: O(s.lenght + t.length)
class Solution {
    public char findTheDifference(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(t);
        char result = 0;
        for(int i = 0; i < sb.length(); i++) {
            result ^= sb.charAt(i);
        }
        return result;
    }
}