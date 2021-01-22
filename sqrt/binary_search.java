class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ret = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if ((long) middle * middle <= x) {
                ret = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return ret;
    }
}