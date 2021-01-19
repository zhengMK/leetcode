// Might save some memory if we use two-pointer technique to first remove duplicates in nums1 and nums2,
// but this will certainly cost us more time, because we need to sort the arrays before removing duplicates.
// Time complexity: O(N), space complexity: O(N)
class Solution {
    private Set<Integer> set1, set2;
    public int[] intersection(int[] nums1, int[] nums2) {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) set1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) set2.add(nums2[i]);
        int[] ret = new int[Math.min(set1.size(), set2.size())];
        int index = 0;
        for (int i : set1){
            if (set2.contains(i)) ret[index++] = i;
        }
        return Arrays.copyOfRange(ret, 0, index);
    }
}