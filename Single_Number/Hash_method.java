// use hashmap to record the number of appearance for each element in nums.
// Time complexity: O(N), space complexity: O(N).
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int num : nums) {
            if (map.get(num) == 1) return num;
        }
        return 0;
    }
}