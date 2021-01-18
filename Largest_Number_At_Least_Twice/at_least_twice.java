// Very simple, no need for complicated thoughts or algorithms.
// Just go through the list twice. The first time find the maxIndex, and the second time check if any doubled element is larger than nums[maxIndex]
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) return -1;
        }
        return maxIndex;
    }
}