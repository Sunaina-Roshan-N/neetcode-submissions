class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        int[] answer = new int[2];

        while(startIndex < endIndex) {
            if(target - numbers[startIndex] == numbers[endIndex]) {
                answer[0] = startIndex + 1;
                answer[1] = endIndex + 1;
                return answer;
            } else if(target - numbers[startIndex] < numbers[endIndex])
                endIndex--;
            else
                startIndex++;
        }

        return answer;
    }
}
