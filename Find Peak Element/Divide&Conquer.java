// This is a typical divide and conquer problem, which can also be classfied as binary search problem.
// The key idea is to halve the search range in every recursion.
// When nums[mid] > nums[mid + 1], the curve is decreasing, and the peak point is supposed to occur on the left half range.
// Similarly, when nums[mid] < nums[mid + 1], the curve has a increasing trend on the right half range, so we search in the right half.
// Note: We do not use comparison to find the peak point. Instead, we squeeze the range to a single point. This can prevent the cases when curve is monotonic.
// Time complexity: O(logN), space complexity: O(1). 
class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    private int findPeakElement(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        // System.out.println("left: " + left + "\tmid: " + mid + "\tright: " + right);
        if (nums[mid] < nums[mid + 1]) return findPeakElement(nums, mid + 1, right);
        else return findPeakElement(nums, left, mid);
    }
}