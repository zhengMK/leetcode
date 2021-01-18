// The pivot point satisfy this condition: nums[0] + ... + nums[i-1] == nums[0] + ... + nums[length - 1] - (nums[0] + nums[i])
// No need to store the leftSum for each nums[i] into another array.
// We can do this in the 2ed for-loop below.
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int sum = 0, leftSum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - leftSum - nums[i])) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}