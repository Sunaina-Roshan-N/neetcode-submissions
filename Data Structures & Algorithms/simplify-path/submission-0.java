class Solution {
    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        if(!pathArray[0].equals(""))
            return "";

        Stack<String> stack = new Stack<>();
        for(String part : pathArray) {
            switch(part) {
                case "":
                case ".":
                    break;
                case "..":
                    if(!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(part);
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty())
            answer.insert(0, "/").insert(1, stack.pop());

        return answer.length() > 0 ? answer.toString() : "/";
    }
}