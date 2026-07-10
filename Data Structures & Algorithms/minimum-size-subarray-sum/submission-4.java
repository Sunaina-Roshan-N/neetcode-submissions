class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int startIndex = 0;
        int endIndex = 0;

        int currentLength = 0;
        int minLength = nums.length + 1;
        int currentSum = 0;

        while(endIndex < nums.length) {

            //loop till you get to end Index where the sum is greater than / = to target or you reach the end
            while(currentSum < target && endIndex < nums.length) 
                currentSum += nums[endIndex++];
            
            while(currentSum >= target && startIndex != endIndex) {
                currentLength = endIndex - startIndex;
                if(currentLength < minLength)
                    minLength = currentLength;
                currentSum -= nums[startIndex++];
            }

        }

        return (minLength == nums.length + 1) ? 0 : minLength;
    }
}