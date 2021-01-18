// The idea is similar to the sum of two linkedList problem,
// i.e. add one the digits[length - 1] and then propagate the carry till the 0 index.
// If the carry after 0 index is non-zero, resize the array.
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10) {
                carry = digits[i] / 10;
                digits[i] -= 10;
            } else {
                carry = 0;
            }
        }
        
        if (carry != 0) {
            int[] ret = new int[digits.length + 1];
            System.arraycopy(ret, 1, digits, 0, digits.length);
            ret[0] = carry;
            return ret;
        } else {
            return digits;
        } 
    }
}