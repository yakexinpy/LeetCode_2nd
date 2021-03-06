class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if(stack.isEmpty()) return;
        int x = stack.pop();
        if(x == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
