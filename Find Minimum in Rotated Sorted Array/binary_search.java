// Can use the find-valley method (consider the case [2,3,4,5,6,1] where we have two valley points and we are not guaranteed to find the global min point).
// Instead, use the attribute that the pivot point must satisfy nums[pivot] < nums[pivot - 1] or nums[pivot] > nums[pivot + 1] (pivot have different values for these two cases).
// So, if the sorted array is rotated, we have this pivot point.
// When it is not rotated, meaning nums[0] < nums[nums.length - 1], the min point is just nums[0].
// To check if we are on the left or right of the pivot point, we can also compare nums[0] and nums[mid] (mid = (left + right) / 2).
// If nums[0] < nums[mid], we are still on the left of the pivot point, so we update left with mid + 1;
// if nums[0] > nums[mid], we are on the right of the pivot point, so we update right with mid - 1.
// Keep comparing and updating left or right until we have the pivot point: nums[mid] > nums[mid + 1], pivot is nums[mid + 1]; nums[mid - 1] > nums[mid], pivot is nums[mid].
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[0] < nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}