// Use a stack to "recursively" check whether the string s is valid parentheses.
// Time complexity: O(N), space complexity: O(N)
class Solution {
    Stack<Character> stack = new Stack<Character>();
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.size() == 0) return false;
                if (stack.peek() == '(' && c == ')') stack.pop();
                else if (stack.peek() == '[' && c == ']') stack.pop();
                else if (stack.peek() == '{' && c == '}') stack.pop();
                else return false;
            }
        }
        return stack.size() == 0;
    }
}