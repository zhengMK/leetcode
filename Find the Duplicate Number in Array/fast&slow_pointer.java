// Use the fast and slow pointer method to detect the loop in the array, and then detect the starting point of the loop.
// Loop is constructed by nums[fast] and nums[slow].
// Time complexity: O(N), space complexity: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow);
        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}