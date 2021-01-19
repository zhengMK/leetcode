// First sort the input array.
// Since all elements, except the target number, appear twice, nums[i] == nums[i+1], where i is an even number smaller than nums.length.
// Thus, when we see nums[i] != nums[i+1], return nums[i].
// We could still not meet this inequal case if the single number locates at the end of the array.
// So, we return nums[nums.length - 1] if we finish for-loop.
// Time complexity: O(N^2) dep on the sorting algo, Space complexity: O(1)
// For the best case, we will have time complexity Big-Theta(N).
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}