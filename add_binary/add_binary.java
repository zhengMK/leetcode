// This is certainly not the optimal solution.
// Assume N = max(a.length(), b.length()),
// Time complexity: O(N) 
// Space complexity: O(N) (for sb)
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int ai, bi;
            if (i > a.length() - 1) {
                ai = 0;
            } else {
                ai = (int) a.charAt(i) - '0';
            }
            if (i > b.length() - 1) {
                bi = 0;
            } else {
                bi = (int) b.charAt(i) - '0';
            }
            sb.append((char) ai ^ bi ^ carry);
            carry = ai&bi|bi&carry|ai&carry;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}