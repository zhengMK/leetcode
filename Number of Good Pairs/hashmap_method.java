// Use a hashmap to track the no. occurance of each nums[i].
// To compute the good pairs of nums[i], if its occurance not equal to 1, it's just occurance * (occurance - 1) / 2.
// Divide by 2 for the requirement that i < j.
// Time complexity: O(N), space complexity: O(N)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count != 1) {
                ret += (count * (count - 1)) / 2;
            }
        }
        return ret;
    }
}