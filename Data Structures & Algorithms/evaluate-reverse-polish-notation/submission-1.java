class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> calculateStack = new Stack<>();
        int a = 0;
        int b = 0;
        for(String token : tokens) {
            switch(token) {
                case "+":
                    b = calculateStack.pop();
                    a = calculateStack.pop();
                    calculateStack.push(a + b);
                    break;
                case "-":
                    b = calculateStack.pop();
                    a = calculateStack.pop();
                    calculateStack.push(a - b);
                    break;
                case "*":
                    b = calculateStack.pop();
                    a = calculateStack.pop();
                    calculateStack.push(a * b);
                    break;
                case "/":
                    b = calculateStack.pop();
                    a = calculateStack.pop();
                    calculateStack.push(a / b);
                    break;
                default:
                    calculateStack.push(Integer.parseInt(token));
            }
        }

        return calculateStack.pop();
    }
}
