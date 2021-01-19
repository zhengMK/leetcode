// Use XOR operation: for a ^ a ^ .... ^ a, if there are even number of a, result will be 0. Otherwise, result is a.
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) ret ^= num;
        return ret;
    }
}