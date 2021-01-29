// Use a stack to store the index of an array element, not the value!
// Everytime we meet a temperature that is higher than the top of the stack (if stack is not empty), we find the next with a higher temperature.
// Use the indicies to update the result array.
// Time complexity: O(N), space complexity: O(N)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                ret[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return ret;
    }
}