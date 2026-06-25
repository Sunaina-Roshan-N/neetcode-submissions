class Solution {
    public int firstMissingPositive(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
                temp = nums[i];
                if(temp != nums[temp - 1]) {
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                } else 
                    break;
            }
        }

        int missingPositive = 0;
        while(missingPositive < nums.length && nums[missingPositive] == missingPositive + 1)
            missingPositive++;

        return missingPositive + 1;
    }
}