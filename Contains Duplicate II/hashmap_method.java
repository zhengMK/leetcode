// Always update the index stored in map, because, if the current index does not meet requirement, the later indecies won't either.
// So, should use the larger index to compare to larger index, not the smaller.
// Time complexity: O(N), Space complexity: O(N)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}