// Use two pointers to traverse nums1 and nums2. Before that, use Arrays.sort to sort them.
// When one element in nums1 is smaller than the other element in nums2, go to the larger one on right and compare again.
// Stop when either one pointer reaches the end of the array it points to.
// Time complexity: O(MlogM + NlogN) for sorting algo, space complexity: O(min(M, N)) for ret array.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ret = new [Math.min(nums1.length, nums2.length)];
        for (int i = 0, j = 0, index = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) i += 1;
            else if (nums1[i] > nums2[j]) j += 1;
            else {
                ret[index++] = nums1[i++];
                j += 1;
            }
        }
        return Arrays.copyOfRange(ret, 0, index);
    }
}