// Given the condition that the guess number locates within the range [1, n].
// Time COmplexity: O(logN), space complexity: O(1) 
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println("left: " + left + "\tmid: " + mid + "\tright: " + right);
            if (guess(mid) == 0) return mid;
            else if (guess(mid) > 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}