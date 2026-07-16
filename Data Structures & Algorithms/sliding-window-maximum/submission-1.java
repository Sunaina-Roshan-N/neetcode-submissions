class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = k;

        List<Integer> answersList = new ArrayList<>();

        int currentMax = getMax(nums, startIndex, k);

        answersList.add(currentMax);

        for(endIndex = k; endIndex < nums.length; endIndex++) {
            if(nums[endIndex] > currentMax) 
                currentMax = nums[endIndex];
            else if(currentMax <= nums[startIndex]) 
                currentMax = getMax(nums, startIndex + 1, k);
            startIndex++;
            answersList.add(currentMax);
        }
        return answersList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getMax(int[] nums, int startIndex, int k) {
        int currentMax = -10001;
        for(int i = startIndex; i < startIndex + k; i++) {
            if(nums[i] > currentMax)
                currentMax = nums[i];
        }
        return currentMax;
    }
    
}
