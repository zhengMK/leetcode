// If n is not a happy number, it will stuck in an infinite loop.
// So, we use a set to check whether there is an infin loop.
// Note: Even for a very large number of many digits, its value will be shrunk down, so it won't diverge to an infinitely large number

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        while (!set.contains(n) && n != 1) {
            set.add(n);
            n = next(n);
        }
        if (n == 1) return true;
        return false;
    }
    
    private int next(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}