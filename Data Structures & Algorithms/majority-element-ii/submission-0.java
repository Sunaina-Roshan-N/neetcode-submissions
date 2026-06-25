class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 && nums[i] != candidate2)
                candidate1 = nums[i];
            else if(count2 == 0 && nums[i] != candidate1)
                candidate2 = nums[i];
            
            if(candidate1 == nums[i])
                count1++;
            else if(candidate2 == nums[i])
                count2++;
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> answer = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1)
                count1++;
            if(num == candidate2)
                count2++;
        }

        if(count1 > nums.length/3)
            answer.add(candidate1);
        if(count2 > nums.length/3 && candidate1 != candidate2)
            answer.add(candidate2);

        return answer;
    }
}