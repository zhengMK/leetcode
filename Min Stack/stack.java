// Each node in stack stores the min val among all the val beneth it.
class MinStack {
    class Node{
        int min;
        int val;
        
        public Node(int min, int val) {
            this.min = min;
            this.val = val;
        }
    }
    
    public Stack<Node> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Node>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) stack.push(new Node(x,x));
        else stack.push(new Node(Math.min(stack.peek().min, x), x));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */