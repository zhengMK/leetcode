// Unoptimized method
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int shortestIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < strs[shortestIndex].length()) shortestIndex = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[shortestIndex].length(); i++) {
            char[] chars = new char[strs.length];
            for (int j = 0; j < strs.length; j++) {
                chars[j] = strs[j].charAt(i);
            }
            Boolean flag = true;
            for (int j = 0; j < strs.length && flag; j++) {
                if (chars[j] != chars[0]) flag = false;
            }
            if (flag) sb.append(chars[0]);
            else break;
        }
        return sb.toString();
    }
}