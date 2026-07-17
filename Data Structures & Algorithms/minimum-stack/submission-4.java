class MinStack {

    Stack<Integer> currentStack = new Stack<>();
    Stack<Integer> minPrefixStack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        int minValue = (minPrefixStack.isEmpty() || (minPrefixStack.peek() >= val)) 
                            ? val : minPrefixStack.peek();
        minPrefixStack.push(minValue);
        currentStack.push(val); 
    }
    
    public void pop() {
        minPrefixStack.pop();
        currentStack.pop();
    }
    
    public int top() {
        return currentStack.peek();
    }
    
    public int getMin() {
        return minPrefixStack.peek();
    }
}
