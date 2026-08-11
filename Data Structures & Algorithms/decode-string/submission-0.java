class Solution {
    public String decodeString(String s) {
        char[] inputString = s.toCharArray();
        Stack<String> stack = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        StringBuilder temp = new StringBuilder();
        int count = 0;

        for(char c : inputString) {
            if(Character.isDigit(c)) 
                count = (count * 10) + (c - '0');
            else if(c == '[') {
                counts.push(count);
                count = 0;
                stack.push(String.valueOf(c));
            } else if(Character.isLetter(c)) 
                stack.push(String.valueOf(c));
            else {
                while(!stack.peek().equals("["))
                    temp.insert(0, stack.pop());
                stack.pop();
                String tempString = temp.toString();
                temp.repeat(tempString, counts.pop() - 1);
                stack.push(temp.toString());
                temp = new StringBuilder();
            }
        }

        while(!stack.isEmpty())
            temp.insert(0, stack.pop());

        return temp.toString();
    }
}