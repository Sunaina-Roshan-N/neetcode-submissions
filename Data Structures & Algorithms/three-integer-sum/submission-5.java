class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        int startIndex, endIndex;
        for(int i = 0; i < nums.length; i++) {
            startIndex = i + 1;
            endIndex = nums.length - 1;
            // Optimization 1: If the smallest number is > 0, sum cannot be 0
            if (nums[i] > 0) 
                break;
            
            // Optimization 2: Clean duplicate check at the start of loop
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;
            
            while(startIndex < endIndex) {

                if(nums[startIndex] + nums[endIndex] == -(nums[i])) {

                    answer.add(Arrays.asList(nums[i], nums[startIndex++], nums[endIndex--]));
                    while(startIndex < endIndex && nums[startIndex] == nums[startIndex - 1])
                        startIndex++;
                    while(endIndex > startIndex && nums[endIndex] == nums[endIndex + 1])
                        endIndex--;

                } else if (nums[startIndex] + nums[endIndex] < -nums[i]) 
                    startIndex++;
                else 
                    endIndex--;
            }
        }

        return answer;
    }
}
