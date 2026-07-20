class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> temp = new Stack<>();
        int[] daysArray = new int[temperatures.length];
        int startIndex = 0;

        for(int i = 0; i < temperatures.length; i++) {
            while(!temp.isEmpty() && temperatures[temp.peek()] < temperatures[i]) {
                daysArray[temp.peek()] = i - temp.peek();
                temp.pop();
            }
            temp.push(i);
        }

        return daysArray;
    }
}
