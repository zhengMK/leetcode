// map stores the elements in the shorter array as keys and their no. occurances as values.
// Although it does gets and puts many times, this method is still decently fast (beats over 90%).
// So does the memory usage (beats over 60%).
// Time complexity: O(M+N) where M is the length of nums1 and N is the length of nums2,
//  space complexity: O(min(M,N)) for hashmap and linkedlist.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = nums1.length < nums2.length? nums1: nums2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        int[] longer = nums1.length < nums2.length? nums2: nums1;
        List<Integer> lst = new LinkedList<>();
        for (int i = 0; i < longer.length; i++) {
            if (map.containsKey(longer[i])) {
                int num = map.get(longer[i]);
                if (num != 0) {
                    lst.add(longer[i]);
                    map.put(longer[i], num - 1);
                }
            }
        }
        int[] ret = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ret[i] = lst.get(i);
        }
        return ret;
    }
}