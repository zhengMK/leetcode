// Instead of having time complexity of O(N^2), this only needs O(N). Also, the space complexity is of O(1).
// Keep summing nums[i] to leftSum and keep storing its value into runningSum.
// Please note that the first element of runningSum is 0, because we start storing leftSum before adding nums[i] to it, and it should not be returned.
class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length + 1];
        for (int i = 0, leftSum = 0; i < runningSum.length; i++) {
            runningSum[i] = leftSum;
            if (i < nums.length) leftSum += nums[i];
        }
        return Arrays.copyOfRange(runningSum, 1, nums.length + 1);
    }
}