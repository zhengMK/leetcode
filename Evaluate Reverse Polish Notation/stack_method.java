class Solution {
    Stack<Integer> stack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for (String c : tokens) {
            // System.out.println(c);
            if (!c.equals("+")&&!c.equals("-")&&!c.equals("*")&&!c.equals("/")) stack.push(Integer.parseInt(c));
            else {
                int top = stack.pop(), beneth = stack.pop();
                if (c.equals("*")) stack.push(top * beneth);
                else if (c.equals("+")) stack.push(beneth + top);
                else if (c.equals("-")) stack.push(beneth - top);
                else if (c.equals("/")) stack.push(beneth / top);
            }
        }
        return stack.pop();
    }
}