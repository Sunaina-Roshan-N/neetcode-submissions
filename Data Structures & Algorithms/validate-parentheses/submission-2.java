class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        char[] input = s.toCharArray();

        for(char c : input) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack.add(c);
                    break;
                case '}':
                    if(stack.isEmpty() || '{' != stack.removeLast())
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || '[' != stack.removeLast())
                        return false;
                    break;
                case ')':
                    if(stack.isEmpty() || '(' != stack.removeLast())
                        return false;
                    break;
            }
        }
        
        return (stack.size() == 0);
    }
}
