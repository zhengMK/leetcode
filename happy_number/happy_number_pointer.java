// Sicne there will be a loop, we can convert this problem into checking whether loop exists in a linked list.
// Also, we use two pointers, one fast, which moves forward by 2 nodes, one slow, which moves forward by 1 node.
// When either fast or slow equals to 1 or fast meet slow (a loop exists), we end the while-loop.
// This does not need extra memory for storing hashset.
class Solution {
    public boolean isHappy(int n) {
       int fast = next(n);
        int slow = n;
        while (fast != slow && fast != 1 && slow != 1) {
            fast = next(next(fast));
            slow = next(slow);
        }
        return slow == 1 || fast == 1;
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