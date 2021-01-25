/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    if (isBadVersion(mid - 1)) right = mid - 1;
                    else return mid;
                } else {
                    if (isBadVersion(mid + 1)) return mid + 1;
                    else left = mid;
                }
            }
            return -1;
        }
    }