class Solution {
    public int calPoints(String[] operations) {
        int[] points = new int[1000];

        int top = -1;

        for(String operation : operations) {
            switch(operation) {
                case "+" :
                    points[top + 1] = points[top] + points[top - 1];
                    top++;
                    break;
                case "C" :
                    top--;
                    break;
                case "D" :
                    points[top + 1] = points[top] * 2;
                    top++;
                    break;
                default :
                    points[++top] = Integer.parseInt(operation);
                    break;
            }
        }

        int total = 0;
        for(int i = top; i > -1; i--) 
            total += points[i];

        return total;
    }
}