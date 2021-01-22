// Time complexity: O(N), space complexity: O(N)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[nums.length];
        for (int i = 0, index = 0; i < n; i++, index+=2) {
            ret[index] = nums[i];
            ret[index + 1] = nums[i + n];
        }
        return ret;
    }
}