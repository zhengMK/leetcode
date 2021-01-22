// Naturally, just traversal each account and accumulate the wealth. When the calculation of one's wealth finished, compare to max and keep the greatest.
// Time complexity: O(MN), space complexity: O(1)
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}